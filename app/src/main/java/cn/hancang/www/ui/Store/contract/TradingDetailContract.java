package cn.hancang.www.ui.Store.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.TradingDeatilBean;

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
