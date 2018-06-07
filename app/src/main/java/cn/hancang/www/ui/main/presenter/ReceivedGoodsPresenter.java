package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.DeleteReceiverBean;
import cn.hancang.www.bean.ReceivedGoodsBean;
import cn.hancang.www.bean.SetDefaultAddressBean;
import cn.hancang.www.ui.main.contract.ReceivedGoodsContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-上午 11:14
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsPresenter extends ReceivedGoodsContract.Presenter {
    @Override
    public void getReceiverGoodRequest() {
        mRxManage.add(mModel.getReceivedGoodsBeanDate().subscribe(new RxSubscriber<ReceivedGoodsBean>(mContext) {
            @Override
            protected void _onNext(ReceivedGoodsBean receivedGoodsBean) {
                mView.returnReceiverGoosBean(receivedGoodsBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.oneMessage);
            }
        }));
    }

    @Override
    public void getDeleteReciverRequest(Integer receiverId) {
        mRxManage.add(mModel.getDeleteReceiver(receiverId).subscribe(new RxSubscriber<DeleteReceiverBean>(mContext, true) {
            @Override
            protected void _onNext(DeleteReceiverBean deleteReceiverBean) {
                mView.returnDeleteReceiver(deleteReceiverBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.twoMessage);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.twoMessage);
            }
        }));
    }

    @Override
    public void getSetDefaultAddressRequest(Integer addressId) {
        mRxManage.add(mModel.getSetDefaultAddress(addressId).subscribe(new RxSubscriber<SetDefaultAddressBean>(mContext) {
            @Override
            protected void _onNext(SetDefaultAddressBean setDefaultAddressBean) {
                mView.returnSetDefultAddress(setDefaultAddressBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage,message);
            }
        }));
    }
}
