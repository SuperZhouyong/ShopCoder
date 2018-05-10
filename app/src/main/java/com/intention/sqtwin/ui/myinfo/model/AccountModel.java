package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AccountBean;
import com.intention.sqtwin.ui.myinfo.contract.AccountContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午1:48
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AccountModel implements AccountContract.Model{
    @Override
    public Observable<AccountBean> getAccountBean(Integer accountId) {
        return Api.getDefault(HostType.Jsonpart).getAccountBeab(accountId).compose(RxSchedulers.<AccountBean>io_main());
    }
}
