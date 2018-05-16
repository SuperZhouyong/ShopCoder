package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.SynchronousAuctionBean;
import com.intention.sqtwin.ui.main.contract.SynchronousAuctionContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 15:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionModel implements SynchronousAuctionContract.Model{
    @Override
    public Observable<SynchronousAuctionBean> getSynchronousAuctionDate(Integer page_no) {
        return Api.getDefault(HostType.Jsonpart).getSynchronousAuction(page_no).compose(RxSchedulers.<SynchronousAuctionBean>io_main());
    }
}
