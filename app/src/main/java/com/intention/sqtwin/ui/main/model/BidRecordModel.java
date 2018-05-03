package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.BidRecordBean;
import com.intention.sqtwin.ui.main.contract.BidRecordContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordModel implements BidRecordContract.Moder {
    @Override
    public Observable<BidRecordBean> getBidRecordDate(Integer id) {
        return Api.getDefault(HostType.Jsonpart).getBidRecord(id).compose(RxSchedulers.<BidRecordBean>io_main());
    }
}
