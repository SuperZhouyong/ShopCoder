package com.intention.sqtwin.ui.myinfo.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.OrderListBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:30
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListContract  {
    public interface Model extends BaseModel{
        Observable<OrderListBean> getOrderList(Integer status,Integer page_no,Integer type);
    }
    public interface View extends BaseView{
        void returnOrderList(OrderListBean orderListBean);
    };
    public abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getOrderListRquest(Integer status,Integer page_no,Integer type);
    }
}
