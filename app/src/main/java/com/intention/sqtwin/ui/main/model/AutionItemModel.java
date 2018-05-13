package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AgentBidBean;
import com.intention.sqtwin.bean.ArtistDetailBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.BidBean;
import com.intention.sqtwin.bean.PriceRecordBena;
import com.intention.sqtwin.bean.WorkerListBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;

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
}
