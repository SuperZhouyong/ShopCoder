package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.RecommendField;
import com.intention.sqtwin.bean.RecommendedLots;
import com.intention.sqtwin.bean.ShufflingPictureBean;
import com.intention.sqtwin.ui.main.contract.MainContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午10:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MainModel implements MainContract.Model {
    @Override
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
    }
}
