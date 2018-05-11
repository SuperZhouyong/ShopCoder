package com.intention.sqtwin.ui.mall.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.DerivativesBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:24
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesContract {
    public interface Model extends BaseModel{
        Observable<DerivativesBean> getDerivativesDate(Integer type);
    }
    public interface View extends BaseView{
        void  returnDerivatives(DerivativesBean derivativesBean );
    }
    public static abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getDerivativesRequest(Integer type);
    }
}
