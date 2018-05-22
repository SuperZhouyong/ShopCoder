package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AllMallDateBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:38
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallContract {
    public interface View extends BaseView{
        void returnAllMalldate(AllMallDateBean allMallDateBean);
    }
    public interface Model extends BaseModel{
        Observable<AllMallDateBean> getAllMallDatebean();
    }
    public static abstract  class Presenter extends BasePresenter<View,Model>{
        public abstract void getAllMallDateRequest();
    }
}
