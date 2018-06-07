package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.PayPassWordBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/30-上午1:30
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface SettingPassWordContract {
    interface View extends BaseView {
        void returnPayPassWordBean(PayPassWordBean payPassWordBean);

        void returnLoginPassWordBean(PayPassWordBean payPassWordBean);

    }

    interface Model extends BaseModel {
        Observable<PayPassWordBean> getPayPasswordDate(String passWord);

        Observable<PayPassWordBean> getLoginPasswordDate(String passWord);

    }

    abstract class Presenter extends BasePresenter<View, Model>{
        public abstract void getPayRequest(String passWord);

        public abstract void getLoginRequest(String passWord);

    }
}
