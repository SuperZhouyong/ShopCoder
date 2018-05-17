package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.SubmitAddressBean;
import com.intention.sqtwin.bean.UpdateAddressBean;
import com.intention.sqtwin.ui.myinfo.activity.AddReAddressContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/18-上午12:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AddReAddressModel implements AddReAddressContract.Model {
    @Override
    public Observable<SubmitAddressBean> getSubmitAddressBean(UpdateAddressBean updateAddressBean) {
        return Api.getDefault(HostType.Jsonpart).submitAddress(updateAddressBean).compose(RxSchedulers.<SubmitAddressBean>io_main());
    }

    @Override
    public Observable<AllRegion> getAllRegion() {
        return Api.getDefault(HostType.Jsonpart).getAllRegion().compose(RxSchedulers.<AllRegion>io_main());
    }
}
