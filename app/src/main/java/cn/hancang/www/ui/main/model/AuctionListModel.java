package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.AuctionListBean;
import cn.hancang.www.ui.main.contract.AuctionListContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/5-上午2:23
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionListModel implements AuctionListContract.Model {
    @Override
    public Observable<AuctionListBean> getAuctionListBean(Integer category, Integer page, Integer goods_type) {
        return Api.getDefault(HostType.Jsonpart).getAuctionList(category,page,goods_type).compose(RxSchedulers.<AuctionListBean>io_main());
    }
}
