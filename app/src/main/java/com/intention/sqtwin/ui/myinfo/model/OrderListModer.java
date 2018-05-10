package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.OrderListBean;
import com.intention.sqtwin.ui.myinfo.contract.OrderListContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:33
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListModer implements OrderListContract.Model {
    @Override
    public Observable<OrderListBean> getOrderList(Integer status) {
        return Api.getDefault(HostType.Jsonpart).getOrderList(status).compose(RxSchedulers.<OrderListBean>io_main());
    }
}
