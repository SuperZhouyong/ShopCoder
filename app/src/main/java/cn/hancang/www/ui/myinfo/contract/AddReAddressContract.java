package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AllRegion;
import cn.hancang.www.bean.SubmitAddressBean;
import cn.hancang.www.bean.UpdateAddressBean;

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
