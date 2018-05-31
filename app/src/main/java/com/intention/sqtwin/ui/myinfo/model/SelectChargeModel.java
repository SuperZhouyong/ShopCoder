package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.OrderIdBean;
import com.intention.sqtwin.bean.TellBackBean;
import com.intention.sqtwin.ui.myinfo.contract.SelectChargeContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:07
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SelectChargeModel implements SelectChargeContract.Model{


    @Override
    public Observable<OrderIdBean> getOrderIdBeanData(Integer Num, String type,String remark) {
     return    Api.getDefault(HostType.Jsonpart).getOrderIdBean(Num,type,remark).compose(RxSchedulers.<OrderIdBean>io_main());
    }

    @Override
    public Observable<TellBackBean> getTellbackData(String orderId) {
        return Api.getDefault(HostType.Jsonpart).getTellBackBean(orderId).compose(RxSchedulers.<TellBackBean>io_main());
    }
}
