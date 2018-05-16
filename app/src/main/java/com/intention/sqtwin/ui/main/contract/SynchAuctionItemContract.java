package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.SynchronousAuctionBean;
import com.intention.sqtwin.bean.SynchronousItemBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 16:55
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchAuctionItemContract {
    public interface Model extends BaseModel {
        Observable<SynchronousItemBean> getSynchronousAuctionDate(Integer goods_id);
    }

    public interface View extends BaseView {
        void returnSynchronousAuction(SynchronousItemBean synchronousItemBean);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSynchronousAuctionRequest( Integer goods_id);
    }
}
