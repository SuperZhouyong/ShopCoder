package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.AllMallDateBean;
import com.intention.sqtwin.ui.main.contract.MallContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:46
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallModel implements MallContract.Model {
    @Override
    public Observable<AllMallDateBean> getAllMallDatebean() {
        return Api.getDefault(HostType.Jsonpart).getAllMallDate().compose(RxSchedulers.<AllMallDateBean>io_main());
    }
    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
