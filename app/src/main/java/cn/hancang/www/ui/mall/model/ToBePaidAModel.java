package cn.hancang.www.ui.mall.model;

import cn.hancang.www.bean.ToBenPaidBean;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.ui.mall.contract.ToBePaidAContract;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/7/1-下午7:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ToBePaidAModel  implements ToBePaidAContract.Model{
    @Override
    public Observable<ToBenPaidBean> getToBePaidData(Integer order_id, Integer pay_type) {
        return Api.getDefault(HostType.Jsonpart).getToBePaid(order_id,pay_type).compose(RxSchedulers.<ToBenPaidBean>io_main());
    }


}
