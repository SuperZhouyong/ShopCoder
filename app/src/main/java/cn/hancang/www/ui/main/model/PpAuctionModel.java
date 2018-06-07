package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.PpAllDateBean;
import cn.hancang.www.ui.main.contract.PpAuctionContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:42
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionModel implements PpAuctionContract.Model {


    @Override
    public Observable<PpAllDateBean> getPpAlldate(Integer categoryId, Integer status, Integer pageNo) {
        return Api.getDefault(HostType.Jsonpart).getPlAllDate(categoryId, status, pageNo).compose(RxSchedulers.<PpAllDateBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
