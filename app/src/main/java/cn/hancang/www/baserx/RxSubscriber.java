package cn.hancang.www.baserx;

import android.app.Activity;
import android.content.Context;


import cn.hancang.www.R;

import cn.hancang.www.app.BaseApplication;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.NetWorkUtils;
import cn.hancang.www.widget.conmonWidget.LoadingDialog;

import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * des:订阅封装
 * Created by xsf
 * on 2016.09.10:16
 */

/********************使用例子********************/
/*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new RxSubscriber<User user>(mContext,false) {
@Override
public void _onNext(User user) {
        // 处理user
        }

@Override
public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
        });*/
public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog;
    private Integer RequestId;
    private static final String TAG = "RxSubscriber";

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = false;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog, Integer RequestId) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
        this.RequestId = RequestId;
    }

    public RxSubscriber(Context context) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), false);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), showDialog);
    }

    @Override
    public void onCompleted() {
        // 防止调用的时候出现  activity回收。
        try {
            if (showDialog && mContext != null) {
                LoadingDialog.cancelDialogForLoading();
            }
        } catch (Exception e) {

        }


    }


    @Override
    public void onStart() {
        LogUtils.logd(TAG + "onStart");
        super.onStart();
        if (showDialog) {


            try {
                if (LoadingDialog.getmLoadingDialog() == null) {
                    LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onNext(T t) {
        LogUtils.logd(TAG + "onNext");
        try {
            _onNext(t);
        } catch (Exception r) {
            LogUtils.logd(TAG + "--onNext" + r.getMessage());
            onError(r);
        }
    }

    @Override
    public void onError(Throwable e) {
        try {
            LogUtils.logd(TAG + "onError" + e.getMessage());
//        LoadingDialog.cancelDialogForLoading();
            if (showDialog) {
                LoadingDialog.cancelDialogForLoading();

                LogUtils.logd(TAG + "取消了加载进度条");
            }
//        e.printStackTrace();
            //网络
            if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                _onError(BaseApplication.getAppContext().getString(R.string.no_net));
//            ShowNoNet();
                LogUtils.logd(TAG + "无网络状态");
            } else if (e instanceof SocketTimeoutException) {
                _onError(BaseApplication.getAppContext().getString(R.string.net_error));
                LogUtils.logd(TAG + "无网络状态");
            } /*else if (e instanceof Exception) {
                _onError("Exception");
                LogUtils.logd("DialogForLoading" + "无网络状态");
            }*/
            //服务器
            else if (e instanceof ServerException) {
                _onError(BaseApplication.getAppContext().getString(R.string.net_error));
                LogUtils.logd("DialogForLoading" + "服务器位置错误");
            }
            //其它
            else {
                _onError(BaseApplication.getAppContext().getString(R.string.net_error));
                LogUtils.logd("DialogForLoading" + "网络访问错误" + e.getMessage());
            }

        } catch (Exception e4) {
            _onError(e4.getMessage());
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);


//    protected abstract void ShowNoNet();

}
