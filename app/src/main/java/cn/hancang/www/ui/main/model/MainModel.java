package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AllDateBean;
import cn.hancang.www.ui.main.contract.MainContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午10:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MainModel implements MainContract.Model {
    @Override
    public Observable<AllDateBean> getAllDateBean() {
        return Api.getDefault(HostType.Jsonpart).getHomeAllDate().compose(RxSchedulers.<AllDateBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
   /* @Override
    public Observable<ShufflingPictureBean> getViewpagerPic(String page, Integer postion) {
        return Api.getDefault(HostType.Jsonpart).getShufflingPicture(page, postion).compose(RxSchedulers.<ShufflingPictureBean>io_main());
    }

    @Override
    public Observable<RecommendedLots> getRecommendLots(String type) {
        return Api.getDefault(HostType.Jsonpart).getRecommendedLots(type).compose(RxSchedulers.<RecommendedLots>io_main());
    }

    @Override
    public Observable<RecommendField> getRecommendField(String type) {
        return Api.getDefault(HostType.Jsonpart).getRecommendield(type).compose(RxSchedulers.<RecommendField>io_main());
    }*/
}
