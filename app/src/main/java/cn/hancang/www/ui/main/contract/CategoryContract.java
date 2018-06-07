package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.CategoryAllBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryContract {
    public interface Model extends BaseModel {
        Observable<CategoryAllBean> getCategoryDate(Integer CategoryId);
    }
    public interface View extends BaseView {
        void returnCategoryData(CategoryAllBean categoryAllBean);
    }
    public abstract static class presenter extends BasePresenter<View,Model> {
        public abstract void getCategoryBeanRequest(Integer CategoryId);
    }
}
