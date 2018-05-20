package com.intention.sqtwin.ui.Store.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.TradingDeatilBean;
import com.intention.sqtwin.ui.Store.contract.TradingDetailContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午12:57
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TradingDeatilPresenter extends TradingDetailContract.Presenter {
    @Override
    public void getTradingDeatilBeanRequest() {
        mRxManage.add(mModel.getTradingDeatilBean().subscribe(new RxSubscriber<TradingDeatilBean>(mContext) {
            @Override
            protected void _onNext(TradingDeatilBean tradingDeatilBean) {
                mView.returnTradingDetail(tradingDeatilBean);
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
