package cn.hancang.www.ui.myinfo.presenter;

import android.widget.TextView;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.LoginBean;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.ui.myinfo.contract.LoginContract;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

/**
 * Description: 绝无Bug
 * Data：2018/5/14 0014-下午 13:35
 * Blog：Super简单
 * Author: ZhouYong
 */

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void getLoginRequest(String phone, String code) {
        mRxManage.add(mModel.getLoginBean(phone, code).subscribe(new RxSubscriber<LoginBean>(mContext) {
            @Override
            protected void _onNext(LoginBean loginBean) {
                mView.returnLoginBean(loginBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }
        }));
    }

    @Override
    public void getSmsRequest(String phone, String type) {
        mRxManage.add(mModel.getSmsInfoBean(phone, type).subscribe(new RxSubscriber<SmsInfoBean>(mContext) {
            @Override
            protected void _onNext(SmsInfoBean smsInfoBean) {
                mView.returnSmsBean(smsInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }

    @Override
    public void ShowTvRequest(final TextView tv) {
        mRxManage.add(mModel.ShowTv(tv).subscribe(new RxSubscriber<Long>(mContext) {
            @Override
            protected void _onNext(Long aLong) {
//                mView.returnShowTvOver(aLong);

                RxTextView.text(tv).call("剩余" + (120 - aLong) + "秒");
            }

            @Override
            protected void _onError(String message) {

            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                RxTextView.text(tv).call("获取验证码");
                RxView.enabled(tv).call(true);
            }

            @Override
            public void onStart() {
                super.onStart();
                RxView.enabled(tv).call(false);

            }
        }));
    }

    @Override
    public void getOtherLoginBean(String openid, String nickname, String headimgurl) {
        mRxManage.add(mModel.getOtherLoginBean(openid, nickname, headimgurl).subscribe(new RxSubscriber<OtherLoginBean>(mContext) {
            @Override
            protected void _onNext(OtherLoginBean otherLoginBean) {
                mView.returnOtherLoginBean(otherLoginBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
            }
        }));
    }
}
