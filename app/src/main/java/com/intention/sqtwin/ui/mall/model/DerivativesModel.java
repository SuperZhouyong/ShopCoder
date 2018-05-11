package com.intention.sqtwin.ui.mall.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.DerivativesBean;
import com.intention.sqtwin.ui.mall.contract.DerivativesContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:28
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesModel implements DerivativesContract.Model{


    @Override
    public Observable<DerivativesBean> getDerivativesDate(Integer type) {
        return    Api.getDefault(HostType.Jsonpart).getDerivativesDate(type).compose(RxSchedulers.<DerivativesBean>io_main());
    }
}
