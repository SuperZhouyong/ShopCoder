package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.ShopCartGoodsBean;
import cn.hancang.www.ui.mall.contract.ShopCartContract;

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
