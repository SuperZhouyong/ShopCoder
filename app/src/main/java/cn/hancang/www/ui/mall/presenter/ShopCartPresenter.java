package cn.hancang.www.ui.mall.presenter;

import com.intention.sqtwin.bean.DeleteAllShopCartBean;
import com.intention.sqtwin.bean.DeleteGoodsBean;

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

    @Override
    public void getDeleteGoodsRequest(int goodId) {
        mRxManage.add(mModel.getDeleteBean(goodId).subscribe(new RxSubscriber<DeleteGoodsBean>(mContext) {
            @Override
            protected void _onNext(DeleteGoodsBean deleteGoodsBean) {
                mView.returnDeleteGoodsInfo(deleteGoodsBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }

    @Override
    public void getDeleteAllGoodsRequest() {
        mRxManage.add(mModel.getDeleteAllShopCartInfo().subscribe(new RxSubscriber<DeleteAllShopCartBean>(mContext) {
            @Override
            protected void _onNext(DeleteAllShopCartBean deleteAllShopCartBean) {
                mView.returnDeleteAllGoodsInfo(deleteAllShopCartBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
            }
        }));

    }
}
