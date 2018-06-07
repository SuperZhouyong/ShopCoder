package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AllRegion;
import cn.hancang.www.bean.SubmitAddressBean;
import cn.hancang.www.bean.UpdateAddressBean;
import cn.hancang.www.ui.myinfo.contract.AddReAddressContract;

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
