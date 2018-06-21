package cn.hancang.www.ui.myinfo.model;

import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.ui.myinfo.contract.BindPhoneNumContract;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Description: 保佑无bug
 * Data：2018/6/15-上午12:07
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BindPhoneNumModel  implements BindPhoneNumContract.Model{
    @Override
    public Observable<SmsInfoBean> getSmsInfoBean(Integer memberId ,String phone, String type) {
        return Api.getDefault(HostType.Jsonpart).getSendSms(memberId,phone, type).compose(RxSchedulers.<SmsInfoBean>io_main());
    }

    @Override
    public Observable<Long> ShowTv(TextView tv) {
        RxView.enabled(tv).call(false);
        return Observable.interval(0, 1, TimeUnit.SECONDS, Schedulers.io())
                .take(120).compose(RxSchedulers.<Long>io_main());
    }

    @Override
    public Observable<OtherLoginBean> getBindPhoneNumBean(String openid, String nickname, String headimgurl) {
        return null;
    }
}
