package com.intention.sqtwin.ui.mall.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.ShopCartGoodsBean;
import com.intention.sqtwin.ui.mall.contract.ShopCartContract;

/**
 * Description: 绝无Bug
 * Data：2018/6/5 0005-下午 16:31
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShopCartPresenter extends ShopCartContract.Presenter {
    @Override
    public void getShopCartInfoRequest() {
        mRxManage.add(mModel.getShopCartInfo().subscribe(new RxSubscriber<ShopCartGoodsBean>(mContext) {
            @Override
            protected void _onNext(ShopCartGoodsBean shopCartGoodsBean) {
                mView.returnShopCartInfo(shopCartGoodsBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }
}
