package com.intention.sqtwin.ui.Store.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.bean.SubmitClientInfo;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateResultInfo;
import com.intention.sqtwin.ui.Store.contract.EditInfoContract;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-上午 10:35
 * Blog：Super简单
 * Author: ZhouYong
 */

public class EditInfoModel implements EditInfoContract.Model {
    @Override
    public Observable<MyInfoBean> getEditInfo() {
        return Api.getDefault(HostType.Jsonpart).getMyInfoBean().compose(RxSchedulers.<MyInfoBean>io_main());
    }

    @Override
    public Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps) {
        return Api.getDefault(HostType.Jsonpart).PostImage(mMaps).compose(RxSchedulers.<UpdateImageBean>io_main());
    }

    @Override
    public Observable<UpdateResultInfo> updateAllEditInfo(SubmitClientInfo submitClientInfo) {
        return Api.getDefault(HostType.Jsonpart).submitInfo(submitClientInfo).compose(RxSchedulers.<UpdateResultInfo>io_main());
    }

    @Override
    public Observable<AllRegion> getAllRegion() {
        return Api.getDefault(HostType.Jsonpart).getAllRegion().compose(RxSchedulers.<AllRegion>io_main());
    }
}
