package cn.hancang.www.ui.mall.contract;

import com.intention.sqtwin.bean.AllStoreListBean;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/7/21-上午1:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface MoreStoreContract {
    interface View extends BaseView {
        void returnAllStoreList(AllStoreListBean allStoreListBean);
    }

    interface Model extends BaseModel {
        Observable<AllStoreListBean> getAllStoreListData(int page);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAllStoreListRequest(int page);
    }

}
