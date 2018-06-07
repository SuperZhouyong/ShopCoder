package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AuctionListBean;

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
     Observable<AuctionListBean>    getAuctionListBean(Integer category, Integer page, Integer goods_type);
    }
    public interface View extends BaseView{
        void returnAuctionList(AuctionListBean auctionListBean);
    }
    public abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getRequestAuctionList(Integer category,Integer page,Integer goods_type);
    }
}
