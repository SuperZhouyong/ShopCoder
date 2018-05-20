package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.StoreInfoBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:08
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EnterContract {
    public interface Model extends BaseModel {
        Observable<StoreInfoBean> getStoreInfo();
    }

    public interface View extends BaseView {
        void returnStoreInfo(StoreInfoBean storeInfoBean);
    }

    public static abstract class presenter extends BasePresenter<View, Model> {
        public abstract void getStoreInfoRequest();
    }
}
