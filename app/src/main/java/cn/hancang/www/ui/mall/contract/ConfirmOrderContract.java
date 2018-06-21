package cn.hancang.www.ui.mall.contract;

import com.intention.sqtwin.bean.SubmitOrderBean;

import cn.hancang.www.bean.ConfirmOrderBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
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
        void returnConfirmOrderBean(ConfirmOrderBean confirmOrderBean);


        void returnOrderSubmit(SubmitOrderBean submitOrderBean);
    }

    interface Model extends BaseModel {
        Observable<ConfirmOrderBean> getConfirmOrderData(String orderList);

        Observable<SubmitOrderBean> getSubmitOrderBean();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getCOnfirmOrderBeanRequest(String orderList);
    }
}
