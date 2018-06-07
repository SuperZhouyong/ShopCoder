package cn.hancang.www.ui.mall.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.ShopCartGoodsBean;
import cn.hancang.www.ui.mall.contract.ShopCartContract;

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
