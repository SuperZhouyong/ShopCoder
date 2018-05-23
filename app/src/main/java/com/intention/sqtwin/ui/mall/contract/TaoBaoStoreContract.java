package com.intention.sqtwin.ui.mall.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.TaobaoStoreInfoBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/24-上午12:21
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface TaoBaoStoreContract {
    interface View extends BaseView {
        void returnTaobaoSToreInfo(TaobaoStoreInfoBean taobaoStoreInfoBean);

        void returnAddFavBean(AddFavBean addFavBean);

    }

    interface Model extends BaseModel {
        Observable<TaobaoStoreInfoBean> getTaoBaoStorInfoData(Integer store_id);

        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getTaoBaoStoreInfoRequest(Integer store_id);

        public abstract void getAddFavBean(Integer fav_id, String fav_type);
    }
}
