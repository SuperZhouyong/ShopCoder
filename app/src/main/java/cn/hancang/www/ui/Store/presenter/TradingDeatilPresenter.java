package cn.hancang.www.ui.Store.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.TradingDeatilBean;
import cn.hancang.www.ui.Store.contract.TradingDetailContract;

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
