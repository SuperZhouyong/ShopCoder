package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.bean.ArtDetailBean;
import com.intention.sqtwin.ui.main.contract.ArtDetatilContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午1:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetatilModel implements ArtDetatilContract.Model {
    @Override
    public Observable<ArtDetailBean> getArtDetailDate(Integer artId, Integer page_no) {
        return Api.getDefault(HostType.Jsonpart).getArtDetail(artId, page_no).compose(RxSchedulers.<ArtDetailBean>io_main());
    }
}
