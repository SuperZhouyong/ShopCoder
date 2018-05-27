package com.intention.sqtwin.ui.mall.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.GoosPageInfoBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午5:16
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface GoodsPageContract {
    interface View extends BaseView {
        void returnGoodPageInfo(GoosPageInfoBean goosPageInfoBean);
    }

    interface Model extends BaseModel {
        Observable<GoosPageInfoBean> getGoodspageInfo(Integer goodsId);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
         public abstract void getGoodsPageInfoRequest(Integer goodId);
    }
}
