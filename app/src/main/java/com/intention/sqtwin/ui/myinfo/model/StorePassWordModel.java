package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.StoreLoginNameBean;
import com.intention.sqtwin.bean.StorePwInfoBean;
import com.intention.sqtwin.ui.myinfo.contract.StorePassWordContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:26
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StorePassWordModel implements StorePassWordContract.Model {
    @Override
    public Observable<StoreLoginNameBean> getStoreLoginName() {
        return Api.getDefault(HostType.Jsonpart).getStoreLoginName().compose(RxSchedulers.<StoreLoginNameBean>io_main());
    }

    @Override
    public Observable<StorePwInfoBean> postStorePw(String name, String pw) {
        return Api.getDefault(HostType.Jsonpart).PostStorePwInfo(name, pw).compose(RxSchedulers.<StorePwInfoBean>io_main());
    }
}
