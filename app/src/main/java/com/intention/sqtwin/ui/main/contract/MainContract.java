package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
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

       /* // 获取轮播图
        Observable<ShufflingPictureBean> getViewpagerPic(String page, Integer postion);

        // 获取推荐拍品
        Observable<RecommendedLots> getRecommendLots(String type);

        // 获取推荐专场
        Observable<RecommendField> getRecommendField(String type);*/

    }

    public interface View extends BaseView {

        void returnHomeAllDate(AllDateBean allDateBean);

     /*   void returnViewpagerPic(ShufflingPictureBean shufflingPictureBean);

        void returnRecommendedLot(RecommendedLots recommendedLots);

        void returnRecommendField(RecommendField recommendField);*/
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {

        public abstract void getHomeAllDate();

       /* public abstract void getViewpagerPic(String page, Integer postion);

        public abstract void getRecommentLots(String type);

        public abstract void getRecommentFILED(String type);*/

    }

}
