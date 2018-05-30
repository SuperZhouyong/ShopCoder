package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.SearchInfoBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/30 0030-上午 10:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public interface SearchContract {
    interface View extends BaseView {
        void returnSearchInfo();


    }

    interface Model extends BaseModel {
        Observable<SearchInfoBean> getSearchInfoData();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSearchInfoRequest();
    }
}
