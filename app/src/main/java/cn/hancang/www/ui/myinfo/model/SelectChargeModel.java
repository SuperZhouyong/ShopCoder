package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.OrderIdDetailBean;
import cn.hancang.www.bean.TellBackBean;
import cn.hancang.www.ui.myinfo.contract.SelectChargeContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:07
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SelectChargeModel implements SelectChargeContract.Model {


    @Override
    public Observable<OrderIdBean> getOrderIdBeanData(Float Num, String type, String remark) {
        return Api.getDefault(HostType.Jsonpart).getOrderIdBean(Num, type, remark).compose(RxSchedulers.<OrderIdBean>io_main());
    }

    @Override
    public Observable<TellBackBean> getTellbackData(String orderId) {
        return Api.getDefault(HostType.Jsonpart).getTellBackBean(orderId).compose(RxSchedulers.<TellBackBean>io_main());
    }

    @Override
    public Observable<OrderIdDetailBean> getOrderIdDetaleData(String orderid, String type) {
        return Api.getDefault(HostType.Jsonpart).getOrderIdDeatil(orderid, type).compose(RxSchedulers.<OrderIdDetailBean>io_main());
    }
}
