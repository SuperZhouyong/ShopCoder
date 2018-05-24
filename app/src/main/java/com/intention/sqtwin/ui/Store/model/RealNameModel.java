package com.intention.sqtwin.ui.Store.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.ui.Store.contract.RealnameContract;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/25-上午1:13
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RealNameModel implements RealnameContract.Model {
    @Override
    public Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps) {
        return Api.getDefault(HostType.Jsonpart).PostImage(mMaps).compose(RxSchedulers.<UpdateImageBean>io_main());
    }
}
