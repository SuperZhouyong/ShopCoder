package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.MessageBean;

import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:55
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MessageContract {
    public interface Model extends BaseModel{
        Observable<MessageBean> getMessagebean(Integer page_no);
    }
    public interface View extends BaseView{
        void returnMessage(MessageBean messageBean);
    }
    public static abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getMessageBeanRequest(Integer page_no);
    }
}
