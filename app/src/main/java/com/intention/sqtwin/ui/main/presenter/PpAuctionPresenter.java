package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:50
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionPresenter extends PpAuctionContract.Presenter {
    @Override
    public void getPpAlldate(Integer categoryId, Integer status, Integer pageN) {
        mRxManage.add(mModel.getPpAlldate(categoryId, status, pageN).subscribe(new RxSubscriber<PpAllDateBean>(mContext) {
            @Override
            protected void _onNext(PpAllDateBean ppAllDateBean) {
                mView.returnPpAllDate(ppAllDateBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip("one",message);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading("one");
            }
        }));
    }
}