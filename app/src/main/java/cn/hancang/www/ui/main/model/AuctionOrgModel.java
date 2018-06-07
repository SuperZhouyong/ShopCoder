package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AuctionOrgBean;
import cn.hancang.www.ui.main.contract.AuctionOrgContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/3-下午10:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionOrgModel implements AuctionOrgContract.Model {
    @Override
    public Observable<AuctionOrgBean> getAuctionOrgData(Integer OrgId, Integer page,Integer status) {
        return Api.getDefault(HostType.Jsonpart).getArtIst(OrgId,page,status).compose(RxSchedulers.<AuctionOrgBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavArt(Integer favId, String FavType) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(favId, FavType).compose(RxSchedulers.<AddFavBean>io_main());
    }

    @Override
    public Observable<AddFavBean> getAddFavArtFiled(Integer favId, String FavType) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(favId, FavType).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
