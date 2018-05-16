package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.SynchronousAuctionBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 15:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionContract {
    public interface Model extends BaseModel {
        Observable<SynchronousAuctionBean> getSynchronousAuctionDate( Integer page_no);
    }

    public interface View extends BaseView {
        void returnSynchronousAuction(SynchronousAuctionBean synchronousAuctionBean);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSynchronousAuctionRequest( Integer page_no);
    }
}
