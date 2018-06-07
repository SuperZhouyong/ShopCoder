package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.StoreLoginNameBean;
import cn.hancang.www.bean.StorePwInfoBean;

import rx.Observable;


/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:21
 * Blog：Super简单
 * Author: ZhouYong
 */

public interface StorePassWordContract {
    interface View extends BaseView {
        void returnLoginName(StoreLoginNameBean storeLoginNameBean);

        void returnStorePwInfo(StorePwInfoBean storePwInfoBean);

    }
    interface Model extends BaseModel {
        Observable<StoreLoginNameBean> getStoreLoginName();

        Observable<StorePwInfoBean> postStorePw(String name, String pw);
    }
    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void getStoreLoginNamerequest();

        public abstract void getStorePwRequest(String name ,String pw);

    }
}
