package com.intention.sqtwin.ui.Store.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.TradingDeatilBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午12:53
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TradingDetailContract {
    public interface View extends BaseView{
        void returnTradingDetail(TradingDeatilBean tradingDeatilBean);
    }
    public interface Model extends BaseModel{
        Observable<TradingDeatilBean> getTradingDeatilBean();
    }
    public static abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getTradingDeatilBeanRequest();
    }
}
