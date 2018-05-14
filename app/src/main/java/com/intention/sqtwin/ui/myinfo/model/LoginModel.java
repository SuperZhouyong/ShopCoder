package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.LoginBean;
import com.intention.sqtwin.ui.myinfo.contract.LoginContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/14 0014-下午 13:36
 * Blog：Super简单
 * Author: ZhouYong
 */

public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<LoginBean> getLoginBean(String phone, String code) {
        return Api.getDefault(HostType.Jsonpart).getLoginBean(phone, code).compose(RxSchedulers.<LoginBean>io_main());
    }
}
