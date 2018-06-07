package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.SynchronousAuctionBean;
import cn.hancang.www.ui.main.contract.SynchronousAuctionContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 15:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionPresenter extends SynchronousAuctionContract.Presenter {
    @Override
    public void getSynchronousAuctionRequest(Integer page_no) {
        mRxManage.add(mModel.getSynchronousAuctionDate(page_no).subscribe(new RxSubscriber<SynchronousAuctionBean>(mContext) {
            @Override
            protected void _onNext(SynchronousAuctionBean synchronousAuctionBean) {
                mView.returnSynchronousAuction(synchronousAuctionBean);
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
