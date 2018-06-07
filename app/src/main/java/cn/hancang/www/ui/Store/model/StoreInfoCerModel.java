package cn.hancang.www.ui.Store.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.ReanlNameStoreInfoBean;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.ui.Store.contract.StoreInfoCerCOntract;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午1:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoCerModel implements StoreInfoCerCOntract.Model {
    @Override
    public Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps) {
        return Api.getDefault(HostType.Jsonpart).PostImage(mMaps).compose(RxSchedulers.<UpdateImageBean>io_main());
    }

    @Override
    public Observable<ReanlNameStoreInfoBean> UpStoreInfoCer(String name, String logo, String desc) {
        return Api.getDefault(HostType.Jsonpart).getPostRealNameStoreInfo(name, logo, desc).compose(RxSchedulers.<ReanlNameStoreInfoBean>io_main());
    }
}
