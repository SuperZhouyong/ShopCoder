package com.intention.sqtwin.ui.mall.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.ShopCartGoodsBean;
import com.intention.sqtwin.ui.mall.contract.ShopCartContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/6/5 0005-下午 16:30
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShopCartModel implements ShopCartContract.Model {

    @Override
    public Observable<ShopCartGoodsBean> getShopCartInfo() {
        return Api.getDefault(HostType.Jsonpart).getShopCartInfo().compose(RxSchedulers.<ShopCartGoodsBean>io_main());
    }
}
