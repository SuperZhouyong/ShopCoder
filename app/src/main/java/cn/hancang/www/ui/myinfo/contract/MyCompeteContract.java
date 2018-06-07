package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.MyCompeteBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:38
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteContract {
    public interface Model extends BaseModel {
        Observable<MyCompeteBean> getMyCompeteDate(Integer page);

    }
    public interface View extends BaseView{
        void returnMyCompeteBean(MyCompeteBean myCompeteBean);
    }
    public static abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void getMyCompeteRequest(Integer page);
    }
}
