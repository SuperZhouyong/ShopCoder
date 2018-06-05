package com.intention.sqtwin.ui.mall.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.ShopCartGoodsBean;

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

    }

    interface Model extends BaseModel {

        Observable<ShopCartGoodsBean> getShopCartInfo();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract  void getShopCartInfoRequest();
    }
}
