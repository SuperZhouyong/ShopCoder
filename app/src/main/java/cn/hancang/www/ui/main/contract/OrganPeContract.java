package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.OrganPeBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:31
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeContract {
    public interface Model extends BaseModel{
        Observable<OrganPeBean> getOrganPeData(Integer staffId,Integer page);

        // 收藏排场
        Observable<AddFavBean> getAddFavFiled(Integer fav_id, String fav_type);
    }
    public interface  View extends BaseView{
        void returnOrganPeData(OrganPeBean organPeBean);

        void returnAddFavBean(AddFavBean addFavBean);
    }
    public abstract static class Presenter extends BasePresenter<View,Model>{
        public abstract void getRequestData(Integer staffId,Integer page);

        public abstract void getAddFavBean(Integer fav_id, String fav_type);
    }
}
