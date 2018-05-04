package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AuctionOrgBean;
import com.intention.sqtwin.ui.main.contract.AuctionOrgContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/3-下午10:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionOrgPresenter extends AuctionOrgContract.Presenter {
    @Override
    public void getAuctionOrgRequest(Integer OrgId, Integer page) {
        mRxManage.add(mModel.getAuctionOrgData(OrgId, page).subscribe(new RxSubscriber<AuctionOrgBean>(mContext) {
            @Override
            protected void _onNext(AuctionOrgBean auctionOrgBean) {
                mView.returnAuctionOrg(auctionOrgBean);
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