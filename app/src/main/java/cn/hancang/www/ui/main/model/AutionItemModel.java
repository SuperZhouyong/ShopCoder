package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AgentBidBean;
import cn.hancang.www.bean.AutionItemDetailBean;
import cn.hancang.www.bean.BidBean;
import cn.hancang.www.ui.main.contract.AutionItemContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemModel implements AutionItemContract.Model {

    @Override
    public Observable<AutionItemDetailBean> getAutionDetaiData(Integer id) {
        return Api.getDefault(HostType.Jsonpart).getAuctionItemDetail(id).compose(RxSchedulers.<AutionItemDetailBean>io_main());
    }

    @Override
    public Observable<AgentBidBean> getAgentBidDate(Integer goods_id, Integer price, Integer member_id) {
        return Api.getDefault(HostType.Jsonpart).getAgenBidDate(goods_id, price, member_id).compose(RxSchedulers.<AgentBidBean>io_main());
    }

    @Override
    public Observable<BidBean> getBindDate(Integer goods_id, Integer price, Integer member_id) {
        return Api.getDefault(HostType.Jsonpart).getBidDate(goods_id, price, member_id).compose(RxSchedulers.<BidBean>io_main());
    }
    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
