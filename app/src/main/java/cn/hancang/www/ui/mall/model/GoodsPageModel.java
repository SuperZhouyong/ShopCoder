package cn.hancang.www.ui.mall.model;

import cn.hancang.www.bean.GoodsBuyNewBean;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddCartInfoBean;
import cn.hancang.www.bean.GoosPageInfoBean;
import cn.hancang.www.ui.mall.contract.GoodsPageContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:19
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoodsPageModel implements GoodsPageContract.Model {
    @Override
    public Observable<GoosPageInfoBean> getGoodspageInfo(Integer goodsId) {
        return Api.getDefault(HostType.Jsonpart).getGoodsPageInfo(goodsId).compose(RxSchedulers.<GoosPageInfoBean>io_main());
    }

    @Override
    public Observable<AddCartInfoBean> getAddCartInfoBean(Integer goodId, Integer count) {
        return Api.getDefault(HostType.Jsonpart).getAddGoodCart(goodId, count).compose(RxSchedulers.<AddCartInfoBean>io_main());
    }

    @Override
    public Observable<GoodsBuyNewBean> getGoodsBuyNew(String goods_id, String count) {
        return Api.getDefault(HostType.Jsonpart).getGoodsBuyNew(goods_id,count).compose(RxSchedulers.<GoodsBuyNewBean>io_main());
    }


}
