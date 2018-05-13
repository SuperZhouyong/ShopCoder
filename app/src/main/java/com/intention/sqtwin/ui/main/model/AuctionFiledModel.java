package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AuctionFiledAllBean;
import com.intention.sqtwin.ui.main.contract.AuctionFiledContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/25-下午10:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledModel implements AuctionFiledContract.Model {
    @Override
    public Observable<AuctionFiledAllBean> getAuctionFileDate(Integer auction_filed_id,Integer sort) {
        return Api.getDefault(HostType.Jsonpart).getAuctionFiled(auction_filed_id,sort).compose(RxSchedulers.<AuctionFiledAllBean>io_main());
    }
}
