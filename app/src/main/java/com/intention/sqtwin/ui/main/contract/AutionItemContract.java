package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.ArtistDetailBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.PriceRecordBena;
import com.intention.sqtwin.bean.WorkerListBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemContract {
    public interface Model extends BaseModel {
        //获取工作人员列表
//        Observable<WorkerListBean> getWorkListDate(Integer id, Integer type);
        // 获取拍品详情
        Observable<AutionItemDetailBean> getAutionDetaiData(Integer id);
        // 获取艺术家详情
//        Observable<ArtistDetailBean> getArtistDeatilData(Integer id);
        // 获取出价记录
//        Observable<PriceRecordBena> getPriceRecordData(Integer id);
    }

    public interface View extends BaseView {
//        void  returnWorkList(WorkerListBean workerListBean);
        void returnAutionItemDeatil(AutionItemDetailBean autionItemDetailBean);
//        void returnArtistDetail(ArtistDetailBean artistDetailBean);
//        void returnPriceRecord(PriceRecordBena priceRecordBena);
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {
//        public abstract void getWorkListRequest(Integer id, Integer type);
        public abstract void getAutionDetailRequest(Integer id);
//        public abstract void getArtistDetailRequest(Integer id);
//        public abstract void getPriceRecordRequest(Integer id);
    }
}
