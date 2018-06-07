package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.StoreInfoBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:08
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EnterContract {
    public interface Model extends BaseModel {
        Observable<StoreInfoBean> getStoreInfo();
    }

    public interface View extends BaseView {
        void returnStoreInfo(StoreInfoBean storeInfoBean);
    }

    public static abstract class presenter extends BasePresenter<View, Model> {
        public abstract void getStoreInfoRequest();
    }
}
