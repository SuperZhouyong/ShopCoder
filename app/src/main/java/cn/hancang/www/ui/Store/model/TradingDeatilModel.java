package cn.hancang.www.ui.Store.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.TradingDeatilBean;
import cn.hancang.www.ui.Store.contract.TradingDetailContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TradingDeatilModel implements TradingDetailContract.Model {
    @Override
    public Observable<TradingDeatilBean> getTradingDeatilBean() {
        return Api.getDefault(HostType.Jsonpart).getTradingDeatil().compose(RxSchedulers.<TradingDeatilBean>io_main());
    }
}
