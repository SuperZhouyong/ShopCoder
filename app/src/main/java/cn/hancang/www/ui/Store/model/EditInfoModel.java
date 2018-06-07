package cn.hancang.www.ui.Store.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AllRegion;
import cn.hancang.www.bean.MyInfoBean;
import cn.hancang.www.bean.SubmitClientInfo;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.bean.UpdateResultInfo;
import cn.hancang.www.ui.Store.contract.EditInfoContract;

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
