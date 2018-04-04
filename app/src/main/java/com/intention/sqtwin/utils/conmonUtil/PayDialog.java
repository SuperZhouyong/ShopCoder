/*
package com.intention.sqtwin.utils.conmonUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxManager;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.PayInfo;
import com.intention.sqtwin.bean.TellBackGrounInfo;
import com.intention.sqtwin.utils.PayResult;
import com.unionpay.UPPayAssistEx;
import com.unionpay.uppay.PayActivity;

import java.util.Map;

import hugo.weaving.DebugLog;


*/
/**
 * Created by Administrator
 * on 2017/1/9.
 * <p>
 * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
 * <p>
 * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
 *//*


public class PayDialog {
    private Activity mContext;
    private static final int SDK_PAY_FLAG = 1;
    private static final String TAG = "PayDialog";
    private RxManager mRxmanger = new RxManager();
    private final String mMode = "01";

    private PayDialog mPayDialog ;
 */
/*   private Un
    interface UnAppCallBack  {
       void UnPayCallaback();
    }*//*

    public PayDialog(Activity mContext, RxManager mRxmanger) {
        this.mContext = mContext;
        this.mRxmanger = mRxmanger;
        mPayDialog = this ;
    }

    @DebugLog
    public PayDialog PayUnion() {
        mRxmanger.add(Api.getDefault(HostType.Jsonpart).Pay(Api.getCacheControl()).compose(RxSchedulers.<PayInfo>io_main()).subscribe(new RxSubscriber<PayInfo>(mContext) {
            @Override
            public void onStart() {
                super.onStart();
                LogUtils.logd("银联" + "开始调用");
                UPPayAssistEx.startPayByJAR(mContext, PayActivity.class, null, null, "607508185483962097201", mMode);
            }

            @Override
            protected void _onNext(PayInfo payInfo) {
//                获取得到订单了

            }

            @Override
            protected void _onError(String message) {
                UPPayAssistEx.startPayByJAR(mContext, PayActivity.class, null, null, "607508185483962097201", mMode);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                LogUtils.logd("银联" + "停止调用");
            }
        }));

            return mPayDialog ;
    }


    */
/*
       * 支付宝的处理方式
       * *//*

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    LogUtils.logd("resultStatus" + payResult.toString());
                    */
/**
 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
 *//*

                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                       */
/* mRxmanger.add(Api.getDefault(HostType.Jsonpart).Tellbackground().compose(RxSchedulers.<TellBackGrounInfo>io_main()).subscribe(new RxSubscriber<TellBackGrounInfo>(mContext) {
                            @Override
                            public void onStart() {
                                super.onStart();
                            }

                            @Override
                            protected void _onNext(TellBackGrounInfo tellBackGrounInfo) {
                                //   这里告诉服务器 我支付成功的状态

                            }

                            @Override
                            protected void _onError(String message) {

                            }

                            @Override
                            public void onCompleted() {
                                super.onCompleted();
                                *//*
*/
/*mRxmanger.clear();
                                mRxmanger = null;*//*
*/
/*
                            }
                        }));*//*

                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(mContext, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    };

    public void ALIPAY() {

        mRxmanger.add(Api.getDefault(HostType.Jsonpart).Pay(Api.getCacheControl()).compose(RxSchedulers.<PayInfo>io_main()).subscribe(new RxSubscriber<PayInfo>(mContext) {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            protected void _onNext(PayInfo payInfo) {
                Runnable payRunnable = new Runnable() {
                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(mContext);
                        Map<String, String> result = alipay.payV2("", true);
                        LogUtils.logd("msp" + result.toString());
                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                Thread payThread = new Thread(payRunnable);
                payThread.start();
            }

            @Override
            protected void _onError(String message) {

            }
        }));


    }

    private void ALIPay() {
      */
/*  OkGo.post(Urls.URL_CONSTANT + Urls.URL_aliPay)
                .cacheMode(CacheMode.NO_CACHE)
                .params("user_id", KooReaderApplication.myuserinfo.getUserId())
                .params("book_id", book_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        LogUtils.i("alipay------", "alipay" + s);
                        PayBeanalI mPayBean = GsonUtil.GsonToBean(s, PayBeanalI.class);
                        final String orderInfo = mPayBean.getList().get(0).getResult();
                        if (orderInfo != null) {
                            Runnable payRunnable = new Runnable() {
                                @Override
                                public void run() {
                                    PayTask alipay = new PayTask(mContext);
                                    Map<String, String> result = alipay.payV2(orderInfo, true);
                                    Log.i("msp", result.toString());
                                    Message msg = new Message();
                                    msg.what = SDK_PAY_FLAG;
                                    msg.obj = result;
                                    mHandler.sendMessage(msg);
                                }
                            };
                            Thread payThread = new Thread(payRunnable);
                            payThread.start();
                            LogUtils.i(TAG, orderInfo);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        LogUtils.i("alipay------", "alipay_shibai");
                    }
                });*//*

    }


    */
/*
      * 支付宝的处理方式
      * *//*

  */
/*  @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    LogUtils.logd("resultStatus"+ payResult.toString());
                    *//*
*/
/**
 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
 *//*
*/
/*
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        OkGo.post(Urls.URL_CONSTANT + Urls.URL_aLiServer)
                                .params("resultStatus", resultStatus)
                                .params("resultDict", resultInfo)
                                .cacheMode(CacheMode.NO_CACHE)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(String s, Call call, Response response) {
//                                        DownEpubAfterPay();
                                    }
                                });
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(mContext, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    };*//*

*/
/*

    // 根据链接执行下载的方法 并且插入数据
    public void DownEpubAfterPay() {
        // 发送广播。。。高速  界面   数据请求成功了

        if (TextUtils.isEmpty(Url_mDownload)) {
            OkGo.post(Urls.URL_CONSTANT + Urls.URL_NNEWBOOK_DESCRIPTION)
                    .tag(this)
                    .params("user_id", KooReaderApplication.myuserinfo.getUserId())
                    .params("book_id", book_id)
                    .cacheMode(CacheMode.NO_CACHE)
                    .cacheKey(Urls.URL_CONSTANT + Urls.URL_NNEWBOOK_DESCRIPTION + "id/" + book_id)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            newBookdetil mbookdetil = GsonUtil.GsonToBean(s, newBookdetil.class);
                            mbookdetilbean = mbookdetil.getList();
                            Url_mDownload = mbookdetilbean.getBook_epub_money();
                            InsertDataDown();
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                        }
                    });
        } else {
            InsertDataDown();
        }
        // 下载 完成之后 加入书架
        AddStack();
        SendBorad();
    }
*//*


  */
/*  // 开启下载
    public void InsertDataDown() {
        LogUtils.i("resultStatus", "自己的服务器-------");
        // 开启 服务 直接下载 就是了
        GetRequest request = OkGo.get(Urls.URL_CONSTANT + Url_mDownload);
        downloadManager.addTask(Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1), Urls.URL_CONSTANT + Url_mDownload, request, mMoneyDownloadListener);
        downloadManager.getDownloadInfo(Urls.URL_CONSTANT + Url_mDownload).getTargetPath();
        LogUtils.i("BuyBook", "插入数据库表成功----" + downloadManager.getDownloadInfo(Urls.URL_CONSTANT + Url_mDownload).getTargetPath());
       *//*
*/
/* BuyBook mBuybook = new BuyBook(null, mbookdetilbean.getBook_id(), mbookdetilbean.getBook_name(), mbookdetilbean.getBook_pic()
                , mbookdetilbean.getBook_author(), mbookdetilbean.getBook_description(), mbookdetilbean.getBook_read(), mbookdetilbean.getBook_new_price()
                , mbookdetilbean.getBook_epub_free(), mbookdetilbean.getBook_pdf_free(), mbookdetilbean.getBook_pdf_money()
                , mbookdetilbean.getBook_epub_money(), mbookdetilbean.getPay(), mbookdetilbean.getBookcase(), mFilea.getAbsolutePath() + "/" + Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1)
                , mbookdetilbean.getSize1());
        long insert = mBuyBookDao.insert(mBuybook);*//*
*/
/*
        InsertData();

    }*//*


    */
/*public void AddStack() {
        OkGo.post(Urls.URL_CONSTANT + Urls.URL_AddBookrack)
                .params("user_id", KooReaderApplication.myuserinfo.getUserId())
                .params("book_id", book_id)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //加入书架
                    }
                });
    }
*//*

    // 带有去重功能的加入数据库
    //  支付成功加入的数据库
 */
/*   public void InsertData() {

        List<BuyBook> list = mBuyBookDao.queryBuilder()
                .where(BuyBookDao.Properties.Book_id.eq(mbookdetilbean.getBook_id()))
                .list();
//        LogUtils.i(TAG,"试读的文件下载成功 并且加入数据种"+mfile.getAbsolutePath()+"------"+(mFilea.getAbsolutePath() + "/" + Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1)));
        LogUtils.i(TAG, "试读的文件下载成功 并且加入数据种" + list.size() + "------" + list.toString());
        // 没有查找到这本书的信息 就将这本书加入到数据库   有的话 就不在加入数据库了
        if (list.size() == 0) {
            BuyBook mBuybook = new BuyBook(null, mbookdetilbean.getBook_id(), mbookdetilbean.getBook_name(), mbookdetilbean.getBook_pic()
                    , mbookdetilbean.getBook_author(), mbookdetilbean.getBook_description(), mbookdetilbean.getBook_read(), mbookdetilbean.getBook_new_price()
                    , mbookdetilbean.getBook_epub_free(), mbookdetilbean.getBook_pdf_free(), mbookdetilbean.getBook_pdf_money()
                    , mbookdetilbean.getBook_epub_money(), "1", mbookdetilbean.getBookcase(), mFilea.getAbsolutePath() + "/" + Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1)
                    , mbookdetilbean.getSize1(), mbookdetilbean.getLimit());
            long insert = mBuyBookDao.insert(mBuybook);
            LogUtils.i("BuyBook", "插入数据库表成功----" + insert + "---" + mFilea.getAbsolutePath() + Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1));
        } else {
            for (BuyBook mBuyBook : list) {
                mBuyBookDao.delete(mBuyBook);
                LogUtils.i("BuyBook", "里面已经有数据了，正在删除里面的数据----");
            }
            BuyBook mBuybook = new BuyBook(null, mbookdetilbean.getBook_id(), mbookdetilbean.getBook_name(), mbookdetilbean.getBook_pic()
                    , mbookdetilbean.getBook_author(), mbookdetilbean.getBook_description(), mbookdetilbean.getBook_read(), mbookdetilbean.getBook_new_price()
                    , mbookdetilbean.getBook_epub_free(), mbookdetilbean.getBook_pdf_free(), mbookdetilbean.getBook_pdf_money()
                    , mbookdetilbean.getBook_epub_money(), "1", mbookdetilbean.getBookcase(), mFilea.getAbsolutePath() + "/" + Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1)
                    , mbookdetilbean.getSize1(), mbookdetilbean.getLimit());
            long insert = mBuyBookDao.insert(mBuybook);

        }
        // 数据库改变的话 给这个成员变量赋值
//        Constants.IsPayData = mbookdetilbean.getPay() ;
        //数据库 新插入的话那就发送一个广播

    }*//*


   */
/* //微信支付
    private void WXPay() {
        api.registerApp(Constants.APP_ID);
        OkGo.post(Urls.URL_CONSTANT + Urls.URL_WX_PAY)
                .cacheMode(CacheMode.NO_CACHE)
                .params("user_id", KooReaderApplication.myuserinfo.getUserId())
                .params("book_id", book_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        WxBean wxBean = GsonUtil.GsonToBean(s, WxBean.class);
                        LogUtils.i("WX", wxBean.getDataBean().get(0).getAppid());
                        List<WxBean.ListBean> list = wxBean.getDataBean();
                        LogUtils.i("WX", list.get(0).getPartnerid() + "");
                        PayReq req = new PayReq();
                        req.appId = list.get(0).getAppid();
                        req.partnerId = list.get(0).getPartnerid();
                        req.prepayId = list.get(0).getPrepayid();
                        req.nonceStr = list.get(0).getNoncestr();
                        req.timeStamp = list.get(0).getTimestamp();
                        req.packageValue = list.get(0).getPackageX();
                        req.sign = list.get(0).getSign();
                        req.extData = "app data"; // optional
                        api.sendReq(req);


                    }
                });

    }
*//*

  */
/*  private void SendBorad() {
        Intent intent = new Intent();
        //设置intent的动作为com.example.broadcast，可以任意定义
        intent.setAction("com.example.lxj.addbook");
        //发送无序广播
        mContext.sendBroadcast(intent);
        LogUtils.i("MyboradRecever", "广播发出来了");

    }
*//*

   */
/* // 收费下载的监听
    private DownloadListener mMoneyDownloadListener = new DownloadListener() {
        @Override
        public void onProgress(DownloadInfo downloadInfo) {
            LogUtils.i("DownLoad", "下载中................." + downloadInfo.getProgress());

        }*//*


     */
/*   @Override
        public void onFinish(DownloadInfo downloadInfo) {
            LogUtils.i("DownLoad", "下载成功................." + downloadInfo.getProgress());
            // 下载 成功
            if (materialDialog != null && materialDialog.isShowing()) {
                materialDialog.dismiss();
            }
//            downloadManager.removeTask(Urls.URL_CONSTANT + url_Download);
        }*//*


     */
/*   @Override
        public void onError(DownloadInfo downloadInfo, String errorMsg, Exception e) {
            //
            Toast.makeText(mContext, "下载失败", Toast.LENGTH_SHORT);
            downloadManager.removeTask(Urls.URL_CONSTANT + Url_mDownload);
            GetRequest request = OkGo.get(Urls.URL_CONSTANT + Url_mDownload);
            downloadManager.addTask(Url_mDownload.substring(Url_mDownload.lastIndexOf("/") + 1), Urls.URL_CONSTANT + Url_mDownload, request, mMoneyDownloadListener);
        }
    };*//*

}
*/
