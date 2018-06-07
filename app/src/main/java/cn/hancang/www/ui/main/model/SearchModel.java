package cn.hancang.www.ui.main.model;

import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.bean.HotSearchInfoBean;
import cn.hancang.www.bean.SearchInfoBean;
import cn.hancang.www.ui.main.contract.SearchContract;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/6/1 0001-下午 16:06
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SearchModel implements SearchContract.Model {
    @Override
    public Observable<HotSearchInfoBean> getHotSearchInfoData() {
        return Api.getDefault(HostType.Jsonpart).getHotSearchBean().compose(RxSchedulers.<HotSearchInfoBean>io_main());
    }

    @Override
    public Observable<SearchInfoBean> getSearchDate(String password, Integer page) {
        return Api.getDefault(HostType.Jsonpart).getSearchAuctionBean(password, page).compose(RxSchedulers.<SearchInfoBean>io_main());
    }
}
