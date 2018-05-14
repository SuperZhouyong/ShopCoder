package com.intention.sqtwin.ui.myinfo.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.LoginBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/14 0014-下午 13:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class LoginContract {
    public interface View extends BaseView{
    void returnLoginBean(LoginBean loginBean);
    }
    public interface  Model extends BaseModel{
        Observable<LoginBean> getLoginBean(String phone,String code);
    }
    public static abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getLoginRequest(String phone,String code);
    }
}
