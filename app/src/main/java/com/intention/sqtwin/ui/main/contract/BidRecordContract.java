package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.BidRecordBean;

import rx.Observable;


/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordContract {
    public interface Moder extends BaseModel {
        Observable<BidRecordBean> getBidRecordDate(Integer id);
    }

    public interface View extends BaseView {
        void returnBidRecord(BidRecordBean bidRecordBean);
    }

    public abstract static class Presenter extends BasePresenter<View, Moder> {
        public abstract void getBidRecordRequest(Integer id);
    }

}
