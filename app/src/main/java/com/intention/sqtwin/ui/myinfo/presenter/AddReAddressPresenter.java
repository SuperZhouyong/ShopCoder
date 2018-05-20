package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.SubmitAddressBean;
import com.intention.sqtwin.bean.UpdateAddressBean;
import com.intention.sqtwin.ui.myinfo.contract.AddReAddressContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/18-上午12:42
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AddReAddressPresenter extends AddReAddressContract.Presenter {
    @Override
    public void getSubmitAddressBean(UpdateAddressBean updateAddressBean) {
        mRxManage.add(mModel.getSubmitAddressBean(updateAddressBean).subscribe(new RxSubscriber<SubmitAddressBean>(mContext) {
            @Override
            protected void _onNext(SubmitAddressBean submitAddressBean) {
                mView.returnSubmitAddressBean(submitAddressBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }

    @Override
    public void getAllRegion() {
        mRxManage.add(mModel.getAllRegion().subscribe(new RxSubscriber<AllRegion>(mContext) {
            @Override
            protected void _onNext(AllRegion allRegion) {
                mView.returnAllregion(allRegion);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));

    }
}
