package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.IdentityProveBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateMySelf;
import com.intention.sqtwin.ui.myinfo.contract.IdentityProveContract;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Description: 保佑无bug
 * Data：2018/5/17-上午12:13
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class IdentityProvePresenter  extends IdentityProveContract.Presenter{
    @Override
    public void getIdentityProveRequest(UpdateMySelf updateMySelf) {
        mRxManage.add(mModel.getIdentityProveBean(updateMySelf).subscribe(new RxSubscriber<IdentityProveBean>(mContext) {
            @Override
            protected void _onNext(IdentityProveBean identityProveBean) {
                mView.returnIdentityProveBean(identityProveBean);
            }

            @Override
            protected void _onError(String message) {
            mView.showErrorTip(AppConstant.twoMessage,message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.twoMessage);
            }
        }));
    }

    @Override
    public void updateImageRequest(Map<String, RequestBody> mMaps) {
        mRxManage.add(mModel.updateImage(mMaps).subscribe(new RxSubscriber<UpdateImageBean>(mContext,true) {
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
