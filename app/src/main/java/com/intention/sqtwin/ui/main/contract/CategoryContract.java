package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.CategoryAllBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryContract {
    public interface Model extends BaseModel{
        Observable<CategoryAllBean> getCategoryDate(Integer CategoryId);
    }
    public interface View extends BaseView{
        void returnCategoryData(CategoryAllBean categoryAllBean);
    }
    public abstract static class presenter extends BasePresenter<View,Model>{
        public abstract void getCategoryBeanRequest(Integer CategoryId);
    }
}
