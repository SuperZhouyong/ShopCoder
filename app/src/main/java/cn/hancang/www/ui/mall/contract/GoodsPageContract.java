package cn.hancang.www.ui.mall.contract;

import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.GoodsBuyNewBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AddCartInfoBean;
import cn.hancang.www.bean.GoosPageInfoBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:16
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface GoodsPageContract {
    interface View extends BaseView {
        void returnGoodPageInfo(GoosPageInfoBean goosPageInfoBean);

        void returnAddGoodCart(AddCartInfoBean addCartInfoBean);


        void returnBuyNew(GoodsBuyNewBean goodsBuyNewBean);

        void returnAddFavBeanStore(AddFavBean addFavBean);
    }

    interface Model extends BaseModel {
        Observable<GoosPageInfoBean> getGoodspageInfo(Integer goodsId);

        Observable<AddCartInfoBean> getAddCartInfoBean(Integer goodId,Integer count);

        Observable<GoodsBuyNewBean> getGoodsBuyNew(String goods_id,String count);

        // 收藏排场
        Observable<AddFavBean> getAddFavStore(Integer fav_id, String fav_type);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
         public abstract void getGoodsPageInfoRequest(Integer goodId);

         public abstract void getAddCartInfoBeanRequest(Integer goodid,Integer count);

         public abstract void getGoodsBuyNewRequest(String goods_id,String count);

        public abstract void getAddFavStoreBean(Integer fav_id, String fav_type);
    }
}
