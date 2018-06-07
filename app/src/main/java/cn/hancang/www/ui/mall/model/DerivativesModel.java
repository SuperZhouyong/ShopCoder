package cn.hancang.www.ui.mall.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.DerivativesBean;
import cn.hancang.www.ui.mall.contract.DerivativesContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:28
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesModel implements DerivativesContract.Model {


    @Override
    public Observable<DerivativesBean> getDerivativesDate(Integer type) {
        return    Api.getDefault(HostType.Jsonpart).getDerivativesDate(type).compose(RxSchedulers.<DerivativesBean>io_main());
    }
}
