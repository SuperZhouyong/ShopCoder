package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.AuctionOrgBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/3-下午10:40
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionOrgContract {
    public interface Model extends BaseModel {
        Observable<AuctionOrgBean> getAuctionOrgData(Integer OrgId, Integer page,Integer status);

        Observable<AddFavBean> getAddFavArt(Integer favId, String FavType);

        Observable<AddFavBean> getAddFavArtFiled(Integer favId, String FavType);
    }

    public interface View extends BaseView {
        void returnAuctionOrg(AuctionOrgBean auctionOrgBean);
        void returnArtFavBean(AddFavBean addFavBean);
        void returnArtFavBeanFiled(AddFavBean addFavBean);
    }

    public abstract static class Presenter extends BasePresenter< View,Model> {
        public abstract void getAuctionOrgRequest(Integer OrgId, Integer page,Integer status);
        public abstract void getAddFavArtRequest(Integer favId, String FavType);
        public abstract void getAddFavArtFiledRequest(Integer favId, String FavType);
    }
}
