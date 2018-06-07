package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AccountBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午1:43
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AccountContract {
    public interface Model extends BaseModel {
        Observable<AccountBean> getAccountBean(Integer accountId);
    }

    public interface View extends BaseView {
        void returnAccountBean(AccountBean accountBean);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getAccountBeanRequest(Integer accountId);
    }
}
