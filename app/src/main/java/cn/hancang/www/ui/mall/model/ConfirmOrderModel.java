package cn.hancang.www.ui.mall.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ConfirmOrderModel  implements ConfirmOrderContract.Model{


    @Override
    public Observable<ConfirmOrderBean> getConfirmOrderData(String orderList) {
        return Api.getDefault(HostType.Jsonpart).getconfirmorderDetail(orderList).compose(RxSchedulers.<ConfirmOrderBean>io_main());
    }
}
