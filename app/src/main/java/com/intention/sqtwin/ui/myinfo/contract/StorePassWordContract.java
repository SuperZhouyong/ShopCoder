package com.intention.sqtwin.ui.myinfo.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.StoreLoginNameBean;
import com.intention.sqtwin.bean.StorePwInfoBean;

import rx.Observable;


/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:21
 * Blog：Super简单
 * Author: ZhouYong
 */

public interface StorePassWordContract {
    interface View extends BaseView {
        void returnLoginName(StoreLoginNameBean storeLoginNameBean);

        void returnStorePwInfo(StorePwInfoBean storePwInfoBean);

    }
    interface Model extends BaseModel {
        Observable<StoreLoginNameBean> getStoreLoginName();

        Observable<StorePwInfoBean> postStorePw(String name, String pw);
    }
    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void getStoreLoginNamerequest();

        public abstract void getStorePwRequest(String name ,String pw);

    }
}
