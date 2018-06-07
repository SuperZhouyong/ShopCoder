package cn.hancang.www.ui.main.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.DeleteReceiverBean;
import cn.hancang.www.bean.ReceivedGoodsBean;
import cn.hancang.www.bean.SetDefaultAddressBean;

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


        void returnSetDefultAddress(SetDefaultAddressBean setDefaultAddressBean);
    }

    public interface Model extends BaseModel {
        // 获取 收获地址列表
        Observable<ReceivedGoodsBean> getReceivedGoodsBeanDate();

        // 删除收获地址
        Observable<DeleteReceiverBean> getDeleteReceiver(Integer receiverId);

        Observable<SetDefaultAddressBean> getSetDefaultAddress(Integer addressId);

    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getReceiverGoodRequest();

        public abstract void getDeleteReciverRequest(Integer receiverId);

        public abstract void getSetDefaultAddressRequest(Integer addressId);
    }
}
