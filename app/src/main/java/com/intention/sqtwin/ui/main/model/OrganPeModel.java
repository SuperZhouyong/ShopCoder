package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.OrganPeBean;
import com.intention.sqtwin.ui.main.contract.OrganPeContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeModel implements OrganPeContract.Model {
    @Override
    public Observable<OrganPeBean> getOrganPeData(Integer staffId, Integer page) {
        return Api.getDefault(HostType.Jsonpart).getOrganPeData(staffId, page).compose(RxSchedulers.<OrganPeBean>io_main());
    }
    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
