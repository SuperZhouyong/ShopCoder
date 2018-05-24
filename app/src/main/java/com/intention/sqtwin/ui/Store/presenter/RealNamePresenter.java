package com.intention.sqtwin.ui.Store.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.ui.Store.contract.RealnameContract;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Description: 保佑无bug
 * Data：2018/5/25-上午1:13
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RealNamePresenter extends RealnameContract.Presenter {
    @Override
    public void updateImageRequest(Map<String, RequestBody> mMaps) {
        mRxManage.add(mModel.updateImage(mMaps).subscribe(new RxSubscriber<UpdateImageBean>(mContext, true) {
            @Override
            protected void _onNext(UpdateImageBean updateImageBean) {
                mView.returnUpdateImage(updateImageBean);
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
}