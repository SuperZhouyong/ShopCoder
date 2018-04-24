package com.intention.sqtwin.ui.main.model;

import com.intention.sqtwin.bean.ArtistDetailBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.PriceRecordBena;
import com.intention.sqtwin.bean.WorkerListBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemModel implements AutionItemContract.Model {
    @Override
    public Observable<WorkerListBean> getWorkListDate(Integer id, Integer type) {
        return null;
    }

    @Override
    public Observable<AutionItemDetailBean> getAutionDetaiData(Integer id) {
        return null;
    }

    @Override
    public Observable<ArtistDetailBean> getArtistDeatilData(Integer id) {
        return null;
    }

    @Override
    public Observable<PriceRecordBena> getPriceRecordData(Integer id) {
        return null;
    }
}
