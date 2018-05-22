package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AllMallDateBean;
import com.intention.sqtwin.ui.main.contract.MallContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:45
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallPresenter extends MallContract.Presenter {
    @Override
    public void getAllMallDateRequest() {
        mRxManage.add(mModel.getAllMallDatebean().subscribe(new RxSubscriber<AllMallDateBean>(mContext) {
            @Override
            protected void _onNext(AllMallDateBean allMallDateBean) {
                mView.returnAllMalldate(allMallDateBean);
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
        }));
    }
}
