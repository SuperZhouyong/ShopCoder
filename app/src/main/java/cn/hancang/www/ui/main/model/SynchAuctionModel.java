package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.SynchronousItemBean;
import cn.hancang.www.ui.main.contract.SynchAuctionItemContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 17:05
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchAuctionModel implements SynchAuctionItemContract.Model {
    @Override
    public Observable<SynchronousItemBean> getSynchronousAuctionDate(Integer goods_id) {
        return Api.getDefault(HostType.Jsonpart).getSynchronousItemBean(goods_id).compose(RxSchedulers.<SynchronousItemBean>io_main());
    }
}
