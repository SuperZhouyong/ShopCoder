package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.LoginBean;
import com.intention.sqtwin.ui.myinfo.contract.LoginContract;

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
}
