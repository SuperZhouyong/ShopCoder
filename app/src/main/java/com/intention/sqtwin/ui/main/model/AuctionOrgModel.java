package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.AuctionOrgBean;
import com.intention.sqtwin.ui.main.contract.AuctionOrgContract;

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
    public Observable<AuctionOrgBean> getAuctionOrgData(Integer OrgId, Integer page) {
        return Api.getDefault(HostType.Jsonpart).getArtIst(OrgId,page).compose(RxSchedulers.<AuctionOrgBean>io_main());
    }
}
