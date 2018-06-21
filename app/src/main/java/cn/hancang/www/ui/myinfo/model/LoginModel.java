package cn.hancang.www.ui.myinfo.model;

import android.widget.TextView;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AliLoginAfterBean;
import cn.hancang.www.bean.AliLoginBean;
import cn.hancang.www.bean.LoginBean;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.ui.myinfo.contract.LoginContract;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

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

    @Override
    public Observable<SmsInfoBean> getSmsInfoBean(String phone, String type) {
        return Api.getDefault(HostType.Jsonpart).getSendSms(null,phone, type).compose(RxSchedulers.<SmsInfoBean>io_main());
    }

    @Override
    public Observable<Long> ShowTv(TextView tv) {
        RxView.enabled(tv).call(false);
        return Observable.interval(0, 1, TimeUnit.SECONDS, Schedulers.io())
                .take(120).compose(RxSchedulers.<Long>io_main());
    }

    @Override
    public Observable<AliLoginBean> getAliLoginBean() {
        return Api.getDefault(HostType.Jsonpart).getAliLoginBean().compose(RxSchedulers.<AliLoginBean>io_main());
    }

    @Override
    public Observable<OtherLoginBean> getOtherLoginBean(String openid,String nickname ,String headimgurl) {
        return Api.getDefault(HostType.Jsonpart).getOtherLoginBean(openid, nickname, headimgurl).compose(RxSchedulers.<OtherLoginBean>io_main());
    }

    @Override
    public Observable<AliLoginAfterBean> getAliLoginAfterBean(String auth_code) {
        return Api.getDefault(HostType.Jsonpart).getAliLoginAfterBean(auth_code).compose(RxSchedulers.<AliLoginAfterBean>io_main());
    }
}
