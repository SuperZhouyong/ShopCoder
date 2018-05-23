package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.RecommendField;
import com.intention.sqtwin.bean.RecommendedLots;
import com.intention.sqtwin.bean.ShufflingPictureBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午10:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MainContract {
    public interface Model extends BaseModel {
        //获取全部数据
        Observable<AllDateBean> getAllDateBean();

        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);

    }

    public interface View extends BaseView {

        void returnHomeAllDate(AllDateBean allDateBean);

        void returnAddFavBean(AddFavBean addFavBean);
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {

        public abstract void getHomeAllDate();


        public abstract void getAddFavBean(Integer fav_id, String fav_type);
    }

}
