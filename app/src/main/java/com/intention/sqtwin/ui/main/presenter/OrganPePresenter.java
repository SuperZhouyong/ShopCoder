package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.OrganPeBean;
import com.intention.sqtwin.ui.main.contract.OrganPeContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPePresenter extends OrganPeContract.Presenter{
    @Override
    public void getRequestData(Integer staffId, Integer page) {
        mRxManage.add(mModel.getOrganPeData(staffId, page).subscribe(new RxSubscriber<OrganPeBean>(mContext) {
            @Override
            protected void _onNext(OrganPeBean organPeBean) {
                mView.returnOrganPeData(organPeBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage,message);

            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }
        }));
    }
}
