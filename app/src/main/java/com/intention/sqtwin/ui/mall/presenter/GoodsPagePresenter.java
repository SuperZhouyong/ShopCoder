package com.intention.sqtwin.ui.mall.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.GoosPageInfoBean;
import com.intention.sqtwin.ui.mall.contract.GoodsPageContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:21
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoodsPagePresenter extends GoodsPageContract.Presenter {
    @Override
    public void getGoodsPageInfoRequest(Integer goodId) {
        mRxManage.add(mModel.getGoodspageInfo(goodId).subscribe(new RxSubscriber<GoosPageInfoBean>(mContext) {
            @Override
            protected void _onNext(GoosPageInfoBean goosPageInfoBean) {
                mView.returnGoodPageInfo(goosPageInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.oneMessage);
            }
        }));
    }
}
