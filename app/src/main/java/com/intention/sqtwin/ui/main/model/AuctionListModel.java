package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AuctionListBean;
import com.intention.sqtwin.ui.main.contract.AuctionListContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/5-上午2:23
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionListModel implements AuctionListContract.Model {
    @Override
    public Observable<AuctionListBean> getAuctionListBean(Integer category, Integer page) {
        return Api.getDefault(HostType.Jsonpart).getAuctionList(category,page).compose(RxSchedulers.<AuctionListBean>io_main());
    }
}
