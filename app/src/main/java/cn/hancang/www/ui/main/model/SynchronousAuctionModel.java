package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.SynchronousAuctionBean;
import cn.hancang.www.ui.main.contract.SynchronousAuctionContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 15:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionModel implements SynchronousAuctionContract.Model {
    @Override
    public Observable<SynchronousAuctionBean> getSynchronousAuctionDate(Integer page_no) {
        return Api.getDefault(HostType.Jsonpart).getSynchronousAuction(page_no).compose(RxSchedulers.<SynchronousAuctionBean>io_main());
    }
}
