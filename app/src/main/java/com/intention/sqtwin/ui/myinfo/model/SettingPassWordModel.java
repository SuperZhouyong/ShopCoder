package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.PayPassWordBean;
import com.intention.sqtwin.ui.myinfo.contract.SettingPassWordContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/30-上午1:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SettingPassWordModel implements SettingPassWordContract.Model{
    @Override
    public Observable<PayPassWordBean> getPayPasswordDate(String passWord) {
        return Api.getDefault(HostType.Jsonpart).getResetPayPassword(passWord).compose(RxSchedulers.<PayPassWordBean>io_main());
    }

    @Override
    public Observable<PayPassWordBean> getLoginPasswordDate(String passWord) {
        return Api.getDefault(HostType.Jsonpart).getResetLoginPassword(passWord).compose(RxSchedulers.<PayPassWordBean>io_main());
    }
}
