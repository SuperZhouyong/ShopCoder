package com.intention.sqtwin.ui.myinfo.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.IdentityProveBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateMySelf;
import com.intention.sqtwin.ui.myinfo.contract.IdentityProveContract;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/17-上午12:14
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class IdentityProveModel implements IdentityProveContract.Model {
    @Override
    public Observable<IdentityProveBean> getIdentityProveBean(UpdateMySelf updateMySelf) {
        return Api.getDefault(HostType.Jsonpart).getIdentityProveBean(updateMySelf).compose(RxSchedulers.<IdentityProveBean>io_main());
    }

    @Override
    public Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps) {
        return Api.getDefault(HostType.Jsonpart).PostImage(mMaps).compose(RxSchedulers.<UpdateImageBean>io_main());
    }
}
