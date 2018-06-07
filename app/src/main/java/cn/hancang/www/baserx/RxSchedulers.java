package cn.hancang.www.baserx;


import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * RxJava调度管理
 * Created by xsf
 * on 2016.08.14:50
 */
public class RxSchedulers {
    public static <T> Observable.Transformer<T, T> io_main() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
//                        .map(observable,observable)

                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread());
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer<ResponseBody, String> handleResult() {
        return new Observable.Transformer<ResponseBody, String>() {


            @Override
            public Observable<String> call(Observable<ResponseBody> responseBodyObservable) {
                return responseBodyObservable.map(new Func1<ResponseBody, String>() {

                    @Override
                    public String call(ResponseBody responseBody) {
                        String string = null;
                        try {
                            string = responseBody.string();
                           /* JSONObject jsonObject = new JSONObject(string);
                            int key = jsonObject.getInt("key");
                            String data = jsonObject.getString("data");

                            String decrypt = AesUtil.decrypt(data, AppConstant.EcryptArray[key]);
                            LogUtils.logd("加密测试---------" + "------" + decrypt);
                            return decrypt;*/
                            return string;
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                        return null;

                    }
                });
            }
        }

                ;

    }
    public static <T> Observable.Transformer<ResponseBody, String> handleCeshiResult() {
        return new Observable.Transformer<ResponseBody, String>() {


            @Override
            public Observable<String> call(Observable<ResponseBody> responseBodyObservable) {
                return responseBodyObservable.map(new Func1<ResponseBody, String>() {

                    @Override
                    public String call(ResponseBody responseBody) {
                        String string = null;
                        try {
                            string = responseBody.string();
//                            JSONObject jsonObject = new JSONObject(string);
//                            int key = jsonObject.getInt("key");
//                            String data = jsonObject.getString("data");
//
//                            String decrypt = AesUtil.decrypt(data, AppConstant.EcryptArray[key]);
//                            LogUtils.logd("加密测试---------" + "------" + decrypt);
//                            return decrypt;
                            return string;
                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                        return null;

                    }
                });
            }
        }

                ;

    }


   /* public static <T> Observable.Transformer<ResponseBody, T> handleResult() {
        return new Observable.Transformer<ResponseBody, T>() {

            @Override
            public Observable<T> call(Observable<ResponseBody> responseBodyObservable) {
                return responseBodyObservable.map(new Func1<ResponseBody, T>() {

                    @Override
                    public T call(ResponseBody responseBody) {
                        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
                        LogUtils.logd("我是加密的秘闻----我是泛型咯--t"+"开始调用"+this.getClass().getGenericSuperclass());
                       try {
                           ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
                       }catch (Exception e){
                           LogUtils.logd("我是加密的秘闻----我是泛型咯--t"+"开始调用"+"转换异常错误");
                       }

                        String string = returnResult(responseBody);
//                       ((ParameterizedType) this.get).getActualTypeArguments()[1];
                        Type[] actualTypeArguments = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
                        LogUtils.logd("我是加密的秘闻----我是泛型咯--t"+string+"-------"+actualTypeArguments);

                        LogUtils.logd("我是加密的秘闻----我是泛型咯--t"+  ((  this.getClass().getGenericSuperclass())instanceof Func1)+"----"+(this instanceof  Func1));
//                        LogUtils.logd("我是加密的秘闻----我是泛型咯--t"+t.toString());
                        T o = gson.fromJson(string, ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
                        LogUtils.logd("我是加密的秘闻----我是泛型咯--o"+o.toString());
                        T o1 = gson.fromJson(string, ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
                        LogUtils.logd("我是加密的秘闻----我是泛型咯--o1"+o1.toString());
                        return o;
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };

    }*/

    /*  public static <T> Observable.Transformer<ResponseBody, T> io_maindecrypt() {
          return new Observable.Transformer<ResponseBody, T>() {
              @Override
              public Observable<T> call(Observable<ResponseBody> observable) {
                  return observable
                          .map(new Func1<ResponseBody, T>() {
                              @Override
                              public T call(ResponseBody responseBody) {
                                  Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
                                  String s = returnResult(responseBody);
                                  LogUtils.logd("我是加密的秘闻"+s);


                                  return T;
                              }
                          })
  //                        .map(observable,observable)
                          .subscribeOn(Schedulers.io())
  //                        .observeOn(AndroidSchedulers.mainThread());
                          .observeOn(AndroidSchedulers.mainThread());
              }
          };
      }*/
    private static String returnResult(ResponseBody responseBody) {
        String string = null;
        try {
            string = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
            string = null;
        }

        return string;
    }
 /*  public static <T> ObservableTransformer<T, T> io_main() {
       return new ObservableTransformer<T, T>() {

           @Override
           public ObservableSource<T> apply(io.reactivex.Observable<T> upstream) {
               return upstream.subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread());
           }
       };
   }*/
}
