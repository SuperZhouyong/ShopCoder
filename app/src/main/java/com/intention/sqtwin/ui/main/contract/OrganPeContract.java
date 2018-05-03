package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.OrganPeBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:31
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeContract {
    public interface Model extends BaseModel{
        Observable<OrganPeBean> getOrganPeData(Integer staffId,Integer page);
    }
    public interface  View extends BaseView{
        void returnOrganPeData(OrganPeBean organPeBean);
    }
    public abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getRequestData(Integer staffId,Integer page);
    }
}
