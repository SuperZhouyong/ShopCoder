package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AuctionFiledAllBean;


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
        Observable<AuctionFiledAllBean> getAuctionFileDate(Integer auction_filed_id, Integer sort);

        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);

    }

    public interface View extends BaseView {
        void returnAuctionFileData(AuctionFiledAllBean auctionFiledAllBean);

        // 机构的关注
        void returnAddFavBean(AddFavBean addFavBean);

        //排场的关注
        void returnAddFavBeanFiled(AddFavBean addFavBean);

    }

    public abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void getAuctionFiledRequest(Integer auction_filed_id, Integer sort);

        public abstract void getAddFavBean(Integer fav_id, String fav_type);
    }
}
