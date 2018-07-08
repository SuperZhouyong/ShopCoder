package cn.hancang.www.ui.mall.contract;


import cn.hancang.www.bean.ConfirmOrderBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.SubmitOrderBean;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:20
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface ConfirmOrderContract {
    interface View extends BaseView {
        void returnConfirmOrderBean(GoodsBuyNewBean confirmOrderBean);

        void returnOrderIdData(OrderIdBean orderIdBean);

        void returnOrderSubmit(SubmitOrderBean submitOrderBean);

        void returnCreateOrderByWinner(GoodsBuyNewBean  goodsBuyNewBean);
    }

    interface Model extends BaseModel {
        Observable<GoodsBuyNewBean> getConfirmOrderData(String goodsId, String count);

        Observable<SubmitOrderBean> getSubmitOrderBean(String goods_id , String count,Integer address_id,Integer pay_type,String remark);

        Observable<OrderIdBean> getOrderIdBeanData(Double Num, String type, String remark);

        Observable<GoodsBuyNewBean> getCreateOrderByWinner(String goods_id_list);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCOnfirmOrderBeanRequest(String goodsId,String count);

        public abstract void getOrderIdBeanRequest(Double Num, String type, String remark);

        public abstract void getSubmitOrderBean(String goods_id , String count,Integer address_id,Integer pay_type,String remark);


        public abstract void getCreateOrderByWinner(String goods_id_list);


    }
}
