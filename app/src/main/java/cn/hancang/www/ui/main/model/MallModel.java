package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AllMallDateBean;
import cn.hancang.www.ui.main.contract.MallContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:46
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallModel implements MallContract.Model {
    @Override
    public Observable<AllMallDateBean> getAllMallDatebean() {
        return Api.getDefault(HostType.Jsonpart).getAllMallDate().compose(RxSchedulers.<AllMallDateBean>io_main());
    }
    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
