package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:42
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionModel implements PpAuctionContract.Model {


    @Override
    public Observable<PpAllDateBean> getPpAlldate(Integer categoryId, Integer status, Integer pageNo) {
        return Api.getDefault(HostType.Jsonpart).getPlAllDate(categoryId, status, pageNo).compose(RxSchedulers.<PpAllDateBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
