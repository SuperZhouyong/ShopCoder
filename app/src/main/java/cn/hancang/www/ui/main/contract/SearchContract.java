package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.HotSearchInfoBean;
import cn.hancang.www.bean.SearchInfoBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/30 0030-上午 10:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public interface SearchContract {
    interface View extends BaseView {
        void returnSearchInfo(SearchInfoBean searchInfoBean);

        void returnHotSearchInfo(HotSearchInfoBean hotSearchInfoBean);
    }

    interface Model extends BaseModel {
        Observable<HotSearchInfoBean> getHotSearchInfoData();

        Observable<SearchInfoBean> getSearchDate(String password,Integer page);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getHotSearchInfoRequest();

        public abstract void getSearchInfoRequest(String password,Integer page);
    }
}
