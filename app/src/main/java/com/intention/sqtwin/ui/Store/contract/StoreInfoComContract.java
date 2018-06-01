package com.intention.sqtwin.ui.Store.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.CancelFocusBean;
import com.intention.sqtwin.bean.DeleteFavBean;
import com.intention.sqtwin.bean.StoreInfoComBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午1:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoComContract {
    public interface View extends BaseView {
        void returnStoreInfoCom(StoreInfoComBean storeInfoComBean);


        void returnCancelFocus(DeleteFavBean deleteFavBean);
    }

    public interface Model extends BaseModel {

        Observable<StoreInfoComBean> getStoreInfoComDate(Integer page, Integer type);


        Observable<DeleteFavBean> getCancelFocus(Integer fac_id, String fav_type);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getStoreInfoComRequest(Integer page, Integer type);

        public abstract void getCancelFocuRequest(Integer fac_id, String fav_type);
    }
}
