package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.StoreLoginNameBean;
import com.intention.sqtwin.bean.StorePwInfoBean;
import com.intention.sqtwin.ui.myinfo.contract.StorePassWordContract;
import com.intention.sqtwin.utils.conmonUtil.AppUtil;

/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:27
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StorePassWordPresenter extends StorePassWordContract.Presenter {
    @Override
    public void getStoreLoginNamerequest() {
        mRxManage.add(mModel.getStoreLoginName().subscribe(new RxSubscriber<StoreLoginNameBean>(mContext) {
            @Override
            protected void _onNext(StoreLoginNameBean storeLoginNameBean) {
                mView.returnLoginName(storeLoginNameBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }

    @Override
    public void getStorePwRequest(String name, String pw) {
        mRxManage.add(mModel.postStorePw(name, pw).subscribe(new RxSubscriber<StorePwInfoBean>(mContext) {
            @Override
            protected void _onNext(StorePwInfoBean storePwInfoBean) {
                mView.returnStorePwInfo(storePwInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }
}
