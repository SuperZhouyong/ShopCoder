package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.GoodsBuyNewBean;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddCartInfoBean;
import cn.hancang.www.bean.GoosPageInfoBean;
import cn.hancang.www.ui.mall.contract.GoodsPageContract;

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

    @Override
    public void getAddCartInfoBeanRequest(Integer goodid, Integer count) {
        mRxManage.add(mModel.getAddCartInfoBean(goodid, count).subscribe(new RxSubscriber<AddCartInfoBean>(mContext) {
            @Override
            protected void _onNext(AddCartInfoBean addCartInfoBean) {
                mView.returnAddGoodCart(addCartInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }

    @Override
    public void getGoodsBuyNewRequest(String goods_id, String count) {
        mRxManage.add(mModel.getGoodsBuyNew(goods_id, count).subscribe(new RxSubscriber<GoodsBuyNewBean>(mContext) {
            @Override
            protected void _onNext(GoodsBuyNewBean goodsBuyNewBean) {
                mView.returnBuyNew(goodsBuyNewBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
            }
        }));
    }

    @Override
    public void getAddFavStoreBean(Integer fav_id, String fav_type) {
        mRxManage.add(mModel.getAddFavStore(fav_id, fav_type).subscribe(new RxSubscriber<AddFavBean>(mContext) {
            @Override
            protected void _onNext(AddFavBean addFavBean) {
                mView.returnAddFavBeanStore(addFavBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.foreMessage, message);
            }
        }));
    }
}
