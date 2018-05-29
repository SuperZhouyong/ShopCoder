package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.PayPassWordBean;
import com.intention.sqtwin.ui.myinfo.contract.SettingPassWordContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/30-上午1:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SettingPassWordPresenter extends SettingPassWordContract.Presenter {
    @Override
    public void getPayRequest(String passWord) {
        mRxManage.add(mModel.getPayPasswordDate(passWord).subscribe(new RxSubscriber<PayPassWordBean>(mContext) {
            @Override
            protected void _onNext(PayPassWordBean payPassWordBean) {
                mView.returnPayPassWordBean(payPassWordBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }

    @Override
    public void getLoginRequest(String passWord) {
        mRxManage.add(mModel.getLoginPasswordDate(passWord).subscribe(new RxSubscriber<PayPassWordBean>(mContext) {
            @Override
            protected void _onNext(PayPassWordBean payPassWordBean) {
                mView.returnLoginPassWordBean(payPassWordBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }
}
