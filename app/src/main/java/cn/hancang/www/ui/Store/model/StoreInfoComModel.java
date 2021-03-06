package cn.hancang.www.ui.Store.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.DeleteFavBean;
import cn.hancang.www.bean.StoreInfoComBean;
import cn.hancang.www.ui.Store.contract.StoreInfoComContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午2:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoComModel implements StoreInfoComContract.Model {
    @Override
    public Observable<StoreInfoComBean> getStoreInfoComDate(Integer page, Integer type) {
        return Api.getDefault(HostType.Jsonpart).getStoreInfoComBean(page,type).compose(RxSchedulers.<StoreInfoComBean>io_main());
    }

    @Override
    public Observable<DeleteFavBean> getCancelFocus(Integer fac_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getDeleteFavBean(fac_id, fav_type).compose(RxSchedulers.<DeleteFavBean>io_main());
    }
}
