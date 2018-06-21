package cn.hancang.www.api;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.app.BaseApplication;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.NetWorkUtils;
import cn.hancang.www.utils.conmonUtil.PublicKetUtils;
import cn.hancang.www.utils.conmonUtil.UserUtil;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * des:retorfit api
 * Created by xsf
 * on 2016.06.15:47
 */
public class Api {
    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 20000;//7676
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 10000;//7676
    public Retrofit retrofit;
    public ApiService movieService;

    public static SparseArray<Api> sRetrofitManager = new SparseArray<>(HostType.Jsonpart);

    /*************************缓存设置*********************/
/*
   1. noCache 不使用缓存，全部走网络

    2. noStore 不使用缓存，也不存储缓存

    3. onlyIfCached 只使用缓存

    4. maxAge 设置最大失效时间，失效则不使用 需要服务器配合

    5. maxStale 设置最大失效时间，失效则不使用 需要服务器配合 感觉这两个类似 还没怎么弄清楚，清楚的同学欢迎留言

    6. minFresh 设置有效时间，依旧如上

    7. FORCE_NETWORK 只走网络

    8. FORCE_CACHE 只走缓存*/

    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    private static final String CACHE_CONTROL_AGE = "max-age=5";


    //构造方法私有
    private Api(final int hostType) {
        //开启Log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();

        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
        File cacheFile = new File(BaseApplication.getAppContext().getCacheDir(), "cache");
        LogUtils.logd("GliderPath-------2" + cacheFile.getAbsolutePath());


        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        //增加头部信息  头部镶嵌 token 和 这缓存的一些数据(这里只是 存入的header的格式)
        Interceptor headerInterceptor = new Interceptor() {
            // 返回拦截   只让json 数据格式通过
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                // 每次进入的时候获取tooken 在这里增加进头部 没有的话 就不增加
                /*if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
                    return chain.proceed(originalRequest);
                }*/
                // 登陆的话

//                LogUtils.logd("Retorfit" + "调用了headerInterceptor" + "-------"+UserUtil.getLoginInfo()+"---"+UserUtil.getLoginInfo().getData()+"  "+UserUtil.getLoginInfo().getData().getMember_id());
                String timestamp = PublicKetUtils.getTimestamp();
                Request build;
                if (UserUtil.getLoginInfo() != null) {
                    build = originalRequest.newBuilder()
//                        .addHeader("Content-Type", getContentType(hostType))
//                        .addHeader("timestamp", timestamp)
//                        .addHeader("publickey", PublicKetUtils.encryptMD5ToString(timestamp, AppConstant.KEY))
                            .addHeader("SESSIONID", String.valueOf(UserUtil.getLoginInfo().getMember_id()))
                            .addHeader("Cache-Control", getCacheControl())
//                        .header("Cache-Control", getCacheControl())
                            .build();
                } else {
                    build = originalRequest.newBuilder()
//                        .addHeader("Content-Type", getContentType(hostType))
//                        .addHeader("timestamp", timestamp)
//                        .addHeader("publickey", PublicKetUtils.encryptMD5ToString(timestamp, AppConstant.KEY))
                            .addHeader("Cache-Control", getCacheControl())
//                        .header("Cache-Control", getCacheControl())
                            .build();
                }

                LogUtils.logi("   timestamp  ====" + timestamp + "\n" + "     publickey   ====" + PublicKetUtils.encryptMD5ToString(timestamp, AppConstant.KEY));
                return chain.proceed(build);
            }
        };

        /*X509TrustManager trustManager = null;
        SSLSocketFactory sslSocketFactory = null;
        final InputStream inputStream;
        try {
            inputStream = BaseApplication.getAppContext().getAssets().open("srca.cer"); // 得到证书的输入流
            try {

                trustManager = trustManagerForCertificates(inputStream);//以流的方式读入证书
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[]{trustManager}, null);
                sslSocketFactory = sslContext.getSocketFactory();

            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }*/
//        由于头部的不同分为了两个不同的retrofit
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
//                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
//                添加application  respone 调用一次
                .addInterceptor(mRewriteCacheControlInterceptor)
//                添加的是网络拦截器 会在request resposne 各调用一次
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(headerInterceptor)
                .addInterceptor(logInterceptor)
                // todo 自定义证书删除以下
//                .hostnameVerifier(new HostnameVerifier() {
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                })
//                .sslSocketFactory(HTTPSUtils.getInstance().getSslSocketFactory(), HTTPSUtils.getInstance().getTrustManager())
                .cache(cache)
                .build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AppConstant.appUrl)
                .build();
        // baseUrl 为 公共常用的
        movieService = retrofit.create(ApiService.class);

      /*  File file = new File("");
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("application/otcet-stream"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("aFile", file.getName(), requestFile);

        String descriptionString = "This is a description";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);*/

    }

    /**
     * @param hostType 与下面这个只是参数一样，但是是为了多样性做的准备
     */
    public static ApiService getDefault(int hostType) {
        Api retrofitManager = sRetrofitManager.get(hostType);
        if (retrofitManager == null) {
            retrofitManager = new Api(hostType);
            sRetrofitManager.put(hostType, retrofitManager);
        }
        return retrofitManager.movieService;
    }

    private String getContentType(int hostType) {
        String contentType;
        switch (hostType) {
            case HostType.Jsonpart:
                contentType = "application/json";
                break;
            case HostType.multipart:
                contentType = "multipart/form-data";
                break;

            default:
                contentType = "";
                break;
        }
        return contentType;
    }

    /**
     * 根据网络状况获取缓存的策略
     */
    @NonNull
    public static String getCacheControl() {
        return NetWorkUtils.isNetConnected(BaseApplication.getAppContext()) ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String cacheControl = request.cacheControl().toString();
            LogUtils.logd("Retorfit调用了mRewriteCacheControlInterceptor----" + cacheControl + "----" + TextUtils.isEmpty(cacheControl) + "1111");
            if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl.FORCE_NETWORK : CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            // 如果 網絡 是鏈接的
            if (NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                // 这是对返回的数据做返回的
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public," + CACHE_CONTROL_AGE)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    /*private X509TrustManager trustManagerForCertificates(InputStream in)
            throws GeneralSecurityException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Collection<? extends Certificate> certificates = certificateFactory.generateCertificates(in);
        if (certificates.isEmpty()) {
            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
        }

        // Put the certificates a key store.
        char[] password = "password".toCharArray(); // Any password will work.
        KeyStore keyStore = newEmptyKeyStore(password);
        int index = 0;
        for (Certificate certificate : certificates) {
            String certificateAlias = Integer.toString(index++);
            keyStore.setCertificateEntry(certificateAlias, certificate);
        }

        // Use it to build an X509 trust manager.
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(
                KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:"
                    + Arrays.toString(trustManagers));
        }
        return (X509TrustManager) trustManagers[0];
    }


    *//**
     * 添加password
     *
     * @param password
     * @return
     * @throws GeneralSecurityException
     *//*
    private KeyStore newEmptyKeyStore(char[] password) throws GeneralSecurityException {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType()); // 这里添加自定义的密码，默认
            InputStream in = null; // By convention, 'null' creates an empty key store.
            keyStore.load(in, password);
            return keyStore;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }*/


}