package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ConfirmOrderPresenter extends ConfirmOrderContract.Presenter {


    @Override
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
    }
}
