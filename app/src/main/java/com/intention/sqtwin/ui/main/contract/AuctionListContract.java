package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AuctionFiledAllBean;
import com.intention.sqtwin.bean.AuctionListBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/5-上午2:18
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionListContract {
    public interface Model extends BaseModel{
     Observable<AuctionListBean>    getAuctionListBean(Integer category,Integer page);
    }
    public interface View extends BaseView{
        void returnAuctionList(AuctionListBean auctionListBean);
    }
    public abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getRequestAuctionList(Integer category,Integer page);
    }
}