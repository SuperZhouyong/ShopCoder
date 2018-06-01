package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxManager;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.HotSearchInfoBean;
import com.intention.sqtwin.bean.SearchInfoBean;
import com.intention.sqtwin.ui.main.contract.SearchContract;

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
