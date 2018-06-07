package cn.hancang.www.ui.mall.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.TaobaoStoreInfoBean;
import cn.hancang.www.ui.mall.contract.TaoBaoStoreContract;

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
