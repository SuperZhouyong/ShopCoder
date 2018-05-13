package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AuctionFiledAllBean;
import com.intention.sqtwin.ui.main.contract.AuctionFiledContract;

/**
 * Description: 保佑无bug
 * Data：2018/4/25-下午10:47
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledPresenter extends AuctionFiledContract.Presenter {
    @Override
    public void getAuctionFiledRequest(Integer auction_filed_id, Integer sort) {
        mRxManage.add(mModel.getAuctionFileDate(auction_filed_id, sort).subscribe(new RxSubscriber<AuctionFiledAllBean>(mContext, true) {
            @Override
            protected void _onNext(AuctionFiledAllBean auctionFiledAllBean) {
                mView.returnAuctionFileData(auctionFiledAllBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip("one", message);
            }
        }));
    }
}
