package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AllMallDateBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:38
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallContract {
    public interface View extends BaseView{
        void returnAllMalldate(AllMallDateBean allMallDateBean);

        void returnAddFavBean(AddFavBean addFavBean);
    }
    public interface Model extends BaseModel{
        Observable<AllMallDateBean> getAllMallDatebean();


        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);
    }
    public static abstract  class Presenter extends BasePresenter<View,Model>{
        public abstract void getAllMallDateRequest();

        public abstract void getAddFavBean(Integer fav_id, String fav_type);
    }
}
