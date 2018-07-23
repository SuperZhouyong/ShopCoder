package cn.hancang.www.ui.mall.model;

import com.intention.sqtwin.bean.DeleteAllShopCartBean;
import com.intention.sqtwin.bean.DeleteGoodsBean;

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

    @Override
    public Observable<DeleteGoodsBean> getDeleteBean(int goodsId) {
        return Api.getDefault(HostType.Jsonpart).getDeleteGoodsBean(goodsId).compose(RxSchedulers.<DeleteGoodsBean>io_main());
    }

    @Override
    public Observable<DeleteAllShopCartBean> getDeleteAllShopCartInfo() {
        return Api.getDefault(HostType.Jsonpart).getDeleteAllShopCartBean().compose(RxSchedulers.<DeleteAllShopCartBean>io_main());
    }
}
