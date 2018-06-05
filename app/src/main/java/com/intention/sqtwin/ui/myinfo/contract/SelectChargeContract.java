package com.intention.sqtwin.ui.myinfo.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.OrderIdBean;
import com.intention.sqtwin.bean.OrderIdDetailBean;
import com.intention.sqtwin.bean.TellBackBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface SelectChargeContract {
    interface View extends BaseView {
        void returnOrderIdData(OrderIdBean orderIdBean);

        void tellBackOrderId(TellBackBean tellBackBean);


        void returnOderIdDetail(OrderIdDetailBean orderIdDetailBean);

    }

    interface Model extends BaseModel {
        Observable<OrderIdBean> getOrderIdBeanData(Float Num, String type, String remark);

        Observable<TellBackBean> getTellbackData(String orderId);


        Observable<OrderIdDetailBean> getOrderIdDetaleData(String orderid, String type);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getOrderIdBeanRequest(Float Num, String type, String remark);

        public abstract void getTellBackDateRequest(String orderId);

        public abstract void getOrderIdDetailRequest(String orderid, String type);
    }

}
