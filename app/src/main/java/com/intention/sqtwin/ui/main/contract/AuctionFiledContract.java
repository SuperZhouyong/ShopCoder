package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AuctionFiledAllBean;


import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/4/25-下午10:40
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledContract {
    public interface Model extends BaseModel {
        // 获取专场全部数据
        Observable<AuctionFiledAllBean> getAuctionFileDate(Integer auction_filed_id);
    }

    public interface View extends BaseView {
        void returnAuctionFileData(AuctionFiledAllBean auctionFiledAllBean);
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void getAuctionFiledRequest(Integer auction_filed_id);

    }
}
