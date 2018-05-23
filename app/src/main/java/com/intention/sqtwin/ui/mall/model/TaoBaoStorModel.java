package com.intention.sqtwin.ui.mall.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.TaobaoStoreInfoBean;
import com.intention.sqtwin.ui.mall.contract.TaoBaoStoreContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/24-上午12:25
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TaoBaoStorModel implements TaoBaoStoreContract.Model{
    @Override
    public Observable<TaobaoStoreInfoBean> getTaoBaoStorInfoData(Integer store_id) {
        return Api.getDefault(HostType.Jsonpart).getTaoBaoStoreInfo(store_id).compose(RxSchedulers.<TaobaoStoreInfoBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
