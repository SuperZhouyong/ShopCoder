package cn.hancang.www.ui.Store.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.RealNamePeoTwoBean;
import cn.hancang.www.bean.UpPeoTwoBean;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.ui.Store.contract.RealnameContract;

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

    @Override
    public Observable<RealNamePeoTwoBean> UpPeoTwoInfo(UpPeoTwoBean upPeoTwoBean) {
        return Api.getDefault(HostType.Jsonpart).getPostRealNamePeoTwo(upPeoTwoBean).compose(RxSchedulers.<RealNamePeoTwoBean>io_main());
    }

//    @Override
//    public Observable<RealNamePeoTwoBean> UpEnterThreeInfo(UpEnterThreeBean upPeoTwoBean) {
//        return Api.getDefault(HostType.Jsonpart).getPostRealEnterThree(upPeoTwoBean);
//    }
}
