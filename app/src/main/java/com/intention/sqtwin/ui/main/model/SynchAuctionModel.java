package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.SynchronousItemBean;
import com.intention.sqtwin.ui.main.contract.SynchAuctionItemContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 17:05
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchAuctionModel implements SynchAuctionItemContract.Model {
    @Override
    public Observable<SynchronousItemBean> getSynchronousAuctionDate(Integer goods_id) {
        return Api.getDefault(HostType.Jsonpart).getSynchronousItemBean(goods_id).compose(RxSchedulers.<SynchronousItemBean>io_main());
    }
}
