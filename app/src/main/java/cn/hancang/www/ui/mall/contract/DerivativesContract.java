package cn.hancang.www.ui.mall.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.DerivativesBean;

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
