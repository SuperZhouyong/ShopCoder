package cn.hancang.www.ui.mall.contract;

import com.intention.sqtwin.bean.DeleteAllShopCartBean;
import com.intention.sqtwin.bean.DeleteGoodsBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.ShopCartGoodsBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/6/5 0005-下午 16:27
 * Blog：Super简单
 * Author: ZhouYong
 */

public interface ShopCartContract {
    interface View extends BaseView {

        void returnShopCartInfo(ShopCartGoodsBean shopCartGoodsBean);

        void returnDeleteGoodsInfo(DeleteGoodsBean deleteGoodsBean);

        void returnDeleteAllGoodsInfo(DeleteAllShopCartBean deleteAllShopCartBean);

    }

    interface Model extends BaseModel {

        Observable<ShopCartGoodsBean> getShopCartInfo();

        Observable<DeleteGoodsBean> getDeleteBean(int goodsId);

        Observable<DeleteAllShopCartBean> getDeleteAllShopCartInfo();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //获取购物车
        public abstract  void getShopCartInfoRequest();

        //删除购物车某一个商品
        public abstract void getDeleteGoodsRequest(int goodId);
        // 删除购物车全部的商品
        public abstract void getDeleteAllGoodsRequest();
    }
}
