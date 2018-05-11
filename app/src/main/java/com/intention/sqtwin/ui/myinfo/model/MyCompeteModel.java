package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.MyCompeteBean;
import com.intention.sqtwin.ui.myinfo.contract.MyCompeteContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:42
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteModel implements MyCompeteContract.Model {
    @Override
    public Observable<MyCompeteBean> getMyCompeteDate(Integer page) {
        return Api.getDefault(HostType.Jsonpart).getMyCompeteBean(page).compose(RxSchedulers.<MyCompeteBean>io_main());
    }
}
