package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.SubmitOrderBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ConfirmOrderPresenter extends ConfirmOrderContract.Presenter {


  /*  @Override
    public void getCOnfirmOrderBeanRequest(String orderList) {
        mRxManage.add(mModel.getConfirmOrderData(orderList).subscribe(new RxSubscriber<ConfirmOrderBean>(mContext) {
            @Override
            protected void _onNext(ConfirmOrderBean confirmOrderBean) {
                mView.returnConfirmOrderBean(confirmOrderBean);
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
    }*/

    @Override
    public void getCOnfirmOrderBeanRequest(String goodsId, String count) {
        mRxManage.add(mModel.getConfirmOrderData(goodsId, count).subscribe(new RxSubscriber<GoodsBuyNewBean>(mContext) {
            @Override
            protected void _onNext(GoodsBuyNewBean goodsBuyNewBean) {
                mView.returnConfirmOrderBean(goodsBuyNewBean);
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
    public void getOrderIdBeanRequest(Double Num, String type, String remark) {
        mRxManage.add(mModel.getOrderIdBeanData(Num, type, remark).subscribe(new RxSubscriber<OrderIdBean>(mContext) {
            @Override
            protected void _onNext(OrderIdBean orderIdBean) {
                mView.returnOrderIdData(orderIdBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }

    @Override
    public void getSubmitOrderBean(String goods_id, String count, Integer address_id, Integer pay_type, String remark) {
        mRxManage.add(mModel.getSubmitOrderBean(goods_id, count, address_id, pay_type, remark).subscribe(new RxSubscriber<SubmitOrderBean>(mContext) {
            @Override
            protected void _onNext(SubmitOrderBean submitOrderBean) {
                mView.returnOrderSubmit(submitOrderBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
            }
        }));
    }

    @Override
    public void getCreateOrderByWinner(String goods_id_list) {
        mRxManage.add(mModel.getCreateOrderByWinner(goods_id_list).subscribe(new RxSubscriber<GoodsBuyNewBean>(mContext) {
            @Override
            protected void _onNext(GoodsBuyNewBean goodsBuyNewBean) {
                mView.returnCreateOrderByWinner(goodsBuyNewBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.foreMessage,message);
            }
        }));
    }
}
