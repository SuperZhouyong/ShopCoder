package com.intention.sqtwin.ui.mall.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.GoosPageInfoBean;
import com.intention.sqtwin.ui.mall.contract.GoodsPageContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:19
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoodsPageModel implements GoodsPageContract.Model{
    @Override
    public Observable<GoosPageInfoBean> getGoodspageInfo(Integer goodsId) {
        return Api.getDefault(HostType.Jsonpart).getGoodsPageInfo(goodsId).compose(RxSchedulers.<GoosPageInfoBean>io_main());
    }
}
