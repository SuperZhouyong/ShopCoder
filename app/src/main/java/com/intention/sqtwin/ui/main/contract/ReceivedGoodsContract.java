package com.intention.sqtwin.ui.main.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.DeleteReceiverBean;
import com.intention.sqtwin.bean.ReceivedGoodsBean;

import rx.Observable;


/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-上午 11:09
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsContract {
    public interface View extends BaseView {
        void returnReceiverGoosBean(ReceivedGoodsBean receivedGoodsBean);

        void returnDeleteReceiver(DeleteReceiverBean deleteReceiverBean);
    }

    public interface Model extends BaseModel {
        // 获取 收获地址列表
        Observable<ReceivedGoodsBean> getReceivedGoodsBeanDate();

        // 删除收获地址
        Observable<DeleteReceiverBean> getDeleteReceiver(Integer receiverId);

    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getReceiverGoodRequest();

        public abstract void getDeleteReciverRequest(Integer receiverId);
    }
}
