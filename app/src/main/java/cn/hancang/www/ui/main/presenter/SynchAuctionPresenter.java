package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.SynchronousItemBean;
import cn.hancang.www.ui.main.contract.SynchAuctionItemContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 16:57
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchAuctionPresenter extends SynchAuctionItemContract.Presenter {
    @Override
    public void getSynchronousAuctionRequest(Integer goods_id) {
        mRxManage.add(mModel.getSynchronousAuctionDate(goods_id).subscribe(new RxSubscriber<SynchronousItemBean>(mContext) {
            @Override
            protected void _onNext(SynchronousItemBean synchronousItemBean) {
                mView.returnSynchronousAuction(synchronousItemBean);
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
