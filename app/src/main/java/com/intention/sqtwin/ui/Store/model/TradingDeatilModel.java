package com.intention.sqtwin.ui.Store.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.TradingDeatilBean;
import com.intention.sqtwin.ui.Store.contract.TradingDetailContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TradingDeatilModel implements TradingDetailContract.Model {
    @Override
    public Observable<TradingDeatilBean> getTradingDeatilBean() {
        return Api.getDefault(HostType.Jsonpart).getTradingDeatil().compose(RxSchedulers.<TradingDeatilBean>io_main());
    }
}
