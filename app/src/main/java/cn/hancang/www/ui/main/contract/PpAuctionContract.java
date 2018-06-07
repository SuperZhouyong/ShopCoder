package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.PpAllDateBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午10:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class PpAuctionContract {
    public interface Model extends BaseModel {
        //获取全部数据
        Observable<PpAllDateBean> getPpAlldate(Integer categoryId, Integer status, Integer pageNo);


        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);
    }

    public interface View extends BaseView {
        // 返回数据
        void returnPpAllDate(PpAllDateBean allDateBean);
        void returnAddFavBean(AddFavBean addFavBean);
    }

    public abstract static class Presenter extends BasePresenter<View, Model> {

        public abstract void getPpAlldate(Integer categoryId,Integer status,Integer pageN);

        public abstract void getAddFavBean(Integer fav_id, String fav_type);

    }

}
