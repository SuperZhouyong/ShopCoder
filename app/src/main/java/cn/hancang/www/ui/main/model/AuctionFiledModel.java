package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AuctionFiledAllBean;
import cn.hancang.www.ui.main.contract.AuctionFiledContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/25-下午10:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledModel implements AuctionFiledContract.Model {
    @Override
    public Observable<AuctionFiledAllBean> getAuctionFileDate(Integer auction_filed_id,Integer sort) {
        return Api.getDefault(HostType.Jsonpart).getAuctionFiled(auction_filed_id,sort).compose(RxSchedulers.<AuctionFiledAllBean>io_main());
    }
    @Override
    public Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type) {
        return Api.getDefault(HostType.Jsonpart).getAddFavbean(fav_id, fav_type).compose(RxSchedulers.<AddFavBean>io_main());
    }
}
