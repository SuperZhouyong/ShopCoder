package com.intention.sqtwin.ui.Store.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.bean.SubmitClientInfo;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateResultInfo;
import com.intention.sqtwin.ui.Store.contract.EditInfoContract;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-上午 10:52
 * Blog：Super简单
 * Author: ZhouYong
 */

public class EditInfoPresenter extends EditInfoContract.Presenter {
    @Override
    public void getEditInfoRequest() {
        mRxManage.add(mModel.getEditInfo().subscribe(new RxSubscriber<MyInfoBean>(mContext) {
            @Override
            protected void _onNext(MyInfoBean myInfoBean) {
                mView.returnEditInfoBena(myInfoBean);
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

    @Override
    public void updateAnnEditInfoRequest(SubmitClientInfo submitClientInfo) {
        mRxManage.add(mModel.updateAllEditInfo(submitClientInfo).subscribe(new RxSubscriber<UpdateResultInfo>(mContext) {
            @Override
            protected void _onNext(UpdateResultInfo updateResultInfo) {
                mView.returnUodateInfo(updateResultInfo);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.threeMessage);
            }
        }));
    }

    @Override
    public void getAllRegion() {
        mRxManage.add(mModel.getAllRegion().subscribe(new RxSubscriber<AllRegion>(mContext) {
            @Override
            protected void _onNext(AllRegion allRegion) {
                mView.returnAllregion(allRegion);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.foreMessage, message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.foreMessage);
            }
        }));
    }
}
