package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.OrderListBean;
import cn.hancang.www.ui.myinfo.contract.OrderListContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListPresenter extends OrderListContract.Presenter {
    @Override
    public void getOrderListRquest(Integer status,Integer page_no,Integer type) {
        mRxManage.add(mModel.getOrderList(status, page_no, type).subscribe(new RxSubscriber<OrderListBean>(mContext) {
            @Override
            protected void _onNext(OrderListBean orderListBean) {
                mView.returnOrderList(orderListBean);
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
}
