package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.BidRecordBean;
import cn.hancang.www.ui.main.contract.BidRecordContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordModel implements BidRecordContract.Moder {
    @Override
    public Observable<BidRecordBean> getBidRecordDate(Integer id) {
        return Api.getDefault(HostType.Jsonpart).getBidRecord(id).compose(RxSchedulers.<BidRecordBean>io_main());
    }
}
