package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.ArtDetailBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetatilContract {
    public interface Model extends BaseModel {
        Observable<ArtDetailBean> getArtDetailDate(Integer artId, Integer page_no);

        Observable<AddFavBean> getAddFavArt(Integer favId, String FavType);
    }

    public interface View extends BaseView {
        void returnArtDetail(ArtDetailBean artDetailBean);

        void returnArtFavBean(AddFavBean addFavBean);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getArtDetailRequest(Integer artId, Integer page_no);

        public abstract void getAddFavArtRequest(Integer favId, String FavType);
    }
}
