package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.PayPassWordBean;
import cn.hancang.www.ui.myinfo.contract.SettingPassWordContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/30-上午1:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SettingPassWordModel implements SettingPassWordContract.Model {
    @Override
    public Observable<PayPassWordBean> getPayPasswordDate(String passWord) {
        return Api.getDefault(HostType.Jsonpart).getResetPayPassword(passWord).compose(RxSchedulers.<PayPassWordBean>io_main());
    }

    @Override
    public Observable<PayPassWordBean> getLoginPasswordDate(String passWord) {
        return Api.getDefault(HostType.Jsonpart).getResetLoginPassword(passWord).compose(RxSchedulers.<PayPassWordBean>io_main());
    }
}
