package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.StoreInfoBean;
import com.intention.sqtwin.ui.main.contract.EnterContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:08
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EnterModel implements EnterContract.Model{
    @Override
    public Observable<StoreInfoBean> getStoreInfo() {
        return Api.getDefault(HostType.Jsonpart).getStoreInfo().compose(RxSchedulers.<StoreInfoBean>io_main());
    }
}
