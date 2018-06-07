package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.OrderListBean;
import cn.hancang.www.ui.myinfo.contract.OrderListContract;

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
    public Observable<OrderListBean> getOrderList(Integer status, Integer page_no, Integer type) {
        return Api.getDefault(HostType.Jsonpart).getOrderList(status, page_no, type).compose(RxSchedulers.<OrderListBean>io_main());
    }
}
