package com.intention.sqtwin.ui.myinfo.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.IdentityProveBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/17-上午12:11
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class IdentityProveContract {
    public interface View extends BaseView {
        void returnIdentityProveBean(IdentityProveBean identityProveBean);
    }

    public interface Model extends BaseModel {
        Observable<IdentityProveBean> getIdentityProveBean();
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getIdentityProveRequest();
    }
}