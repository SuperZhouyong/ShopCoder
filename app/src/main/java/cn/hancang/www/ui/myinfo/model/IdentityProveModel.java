package cn.hancang.www.ui.myinfo.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.IdentityProveBean;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.bean.UpdateMySelf;
import cn.hancang.www.ui.myinfo.contract.IdentityProveContract;

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
