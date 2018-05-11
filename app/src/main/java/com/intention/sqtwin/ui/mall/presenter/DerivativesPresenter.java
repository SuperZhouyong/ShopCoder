package com.intention.sqtwin.ui.mall.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.DerivativesBean;
import com.intention.sqtwin.ui.mall.contract.DerivativesContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:27
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesPresenter extends DerivativesContract.Presenter {
    @Override
    public void getDerivativesRequest(Integer type) {
        mRxManage.add(mModel.getDerivativesDate(type).subscribe(new RxSubscriber<DerivativesBean>(mContext) {
            @Override
            protected void _onNext(DerivativesBean derivativesBean) {
                mView.returnDerivatives(derivativesBean);
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
