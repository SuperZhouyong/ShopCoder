package com.intention.sqtwin.ui.Store.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.StoreInfoComBean;
import com.intention.sqtwin.ui.Store.contract.StoreInfoComContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午2:03
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoComPresenter extends StoreInfoComContract.Presenter {
    @Override
    public void getStoreInfoComRequest(Integer page,Integer type) {
        mRxManage.add(mModel.getStoreInfoComDate(page,type).subscribe(new RxSubscriber<StoreInfoComBean>(mContext) {
            @Override
            protected void _onNext(StoreInfoComBean storeInfoComBean) {
                mView.returnStoreInfoCom(storeInfoComBean);
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

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }
        }));
    }
}
