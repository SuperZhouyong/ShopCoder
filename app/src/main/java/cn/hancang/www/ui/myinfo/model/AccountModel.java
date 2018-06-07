package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AccountBean;
import cn.hancang.www.ui.myinfo.contract.AccountContract;

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
