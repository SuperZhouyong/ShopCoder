package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.SynchronousAuctionBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 15:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionContract {
    public interface Model extends BaseModel {
        Observable<SynchronousAuctionBean> getSynchronousAuctionDate( Integer page_no);
    }

    public interface View extends BaseView {
        void returnSynchronousAuction(SynchronousAuctionBean synchronousAuctionBean);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getSynchronousAuctionRequest( Integer page_no);
    }
}
