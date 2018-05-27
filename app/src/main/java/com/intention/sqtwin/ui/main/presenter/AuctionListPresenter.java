package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AuctionListBean;
import com.intention.sqtwin.ui.main.contract.AuctionListContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/5-上午2:24
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionListPresenter extends AuctionListContract.Presenter {
    @Override
    public void getRequestAuctionList(Integer category, Integer page, Integer goods_type) {
        mRxManage.add(mModel.getAuctionListBean(category, page, goods_type).subscribe(new RxSubscriber<AuctionListBean>(mContext) {
            @Override
            protected void _onNext(AuctionListBean auctionListBean) {
                mView.returnAuctionList(auctionListBean);
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

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.oneMessage);
            }
        }));
    }
}
