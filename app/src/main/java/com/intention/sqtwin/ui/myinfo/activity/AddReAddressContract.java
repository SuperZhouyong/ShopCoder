package com.intention.sqtwin.ui.myinfo.activity;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.SubmitAddressBean;
import com.intention.sqtwin.bean.UpdateAddressBean;

import rx.Observable;


/**
 * Description: 保佑无bug
 * Data：2018/5/18-上午12:37
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AddReAddressContract {
    public interface View extends BaseView {
        void returnAllregion(AllRegion allRegion);

        void returnSubmitAddressBean(SubmitAddressBean submitAddressBean);
    }

    public interface Model extends BaseModel {
        Observable<SubmitAddressBean> getSubmitAddressBean(UpdateAddressBean updateAddressBean);

        Observable<AllRegion> getAllRegion();
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSubmitAddressBean(UpdateAddressBean updateAddressBean);

        public abstract void getAllRegion();
    }
}
