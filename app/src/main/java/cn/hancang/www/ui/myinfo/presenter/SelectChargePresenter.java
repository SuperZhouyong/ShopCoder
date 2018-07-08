package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.OrderIdDetailBean;
import cn.hancang.www.bean.TellBackBean;
import cn.hancang.www.ui.myinfo.contract.SelectChargeContract;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:16
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SelectChargePresenter extends SelectChargeContract.Presenter {
    @Override
    public void getOrderIdBeanRequest(Double Num, String type, String remark) {
        mRxManage.add(mModel.getOrderIdBeanData(Num, type, remark).subscribe(new RxSubscriber<OrderIdBean>(mContext) {
            @Override
            protected void _onNext(OrderIdBean orderIdBean) {
                mView.returnOrderIdData(orderIdBean);

            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.oneMessage);
            }
        }));
    }

    @Override
    public void getTellBackDateRequest(String orderId) {
        mRxManage.add(mModel.getTellbackData(orderId).subscribe(new RxSubscriber<TellBackBean>(mContext) {
            @Override
            protected void _onNext(TellBackBean tellBackBean) {
                mView.tellBackOrderId(tellBackBean);
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
        }));
    }

    @Override
    public void getOrderIdDetailRequest(String orderid, String type) {
        mRxManage.add(mModel.getOrderIdDetaleData(orderid, type).subscribe(new RxSubscriber<OrderIdDetailBean>(mContext) {
            @Override
            protected void _onNext(OrderIdDetailBean orderIdDetailBean) {
                mView.returnOderIdDetail(orderIdDetailBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
            }
        }));
    }
}
