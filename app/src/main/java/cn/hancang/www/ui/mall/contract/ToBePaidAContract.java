package cn.hancang.www.ui.mall.contract;

import cn.hancang.www.bean.ToBenPaidBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/7/1-下午7:38
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface ToBePaidAContract {
    interface View extends BaseView {
        void returnToBePaidBean(ToBenPaidBean toBenPaidBean);
    }

    interface Model extends BaseModel {
        Observable<ToBenPaidBean> getToBePaidData(Integer order_id, Integer pay_type);
    }

     abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void getToBePaidRequest(Integer order_id, Integer pay_type);
    }
}
