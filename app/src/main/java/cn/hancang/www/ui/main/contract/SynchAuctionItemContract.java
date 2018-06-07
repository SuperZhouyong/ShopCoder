package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.SynchronousItemBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 16:55
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchAuctionItemContract {
    public interface Model extends BaseModel {
        Observable<SynchronousItemBean> getSynchronousAuctionDate(Integer goods_id);
    }

    public interface View extends BaseView {
        void returnSynchronousAuction(SynchronousItemBean synchronousItemBean);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSynchronousAuctionRequest( Integer goods_id);
    }
}
