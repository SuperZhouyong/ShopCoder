package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.BidRecordBean;
import cn.hancang.www.ui.main.contract.BidRecordContract;

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
