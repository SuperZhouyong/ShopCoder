package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.BidRecordBean;
import com.intention.sqtwin.ui.main.contract.BidRecordContract;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordPresenter extends BidRecordContract.Presenter {
    @Override
    public void getBidRecordRequest(Integer id) {
        mRxManage.add(mModel.getBidRecordDate(id).subscribe(new RxSubscriber<BidRecordBean>(mContext) {
            @Override
            protected void _onNext(BidRecordBean bidRecordBean) {
                mView.returnBidRecord(bidRecordBean);
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
