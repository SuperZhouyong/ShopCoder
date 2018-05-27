package com.intention.sqtwin.ui.Store.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.RealNamePeoTwoBean;
import com.intention.sqtwin.bean.UpComPanyTwoBean;
import com.intention.sqtwin.bean.UpPeoTwoBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.ui.Store.contract.RealNameEnterTwoContract;
import com.intention.sqtwin.ui.Store.contract.RealnameContract;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午1:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RealNameEnterTwoPresenter extends RealNameEnterTwoContract.Presenter {
    @Override
    public void updateImageRequest(Map<String, RequestBody> mMaps) {
        mRxManage.add(mModel.updateImage(mMaps).subscribe(new RxSubscriber<UpdateImageBean>(mContext) {
            @Override
            protected void _onNext(UpdateImageBean updateImageBean) {
                mView.returnUpdateImage(updateImageBean);
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
    public void UpPeoEnterInfoRequest(UpComPanyTwoBean upPeoTwoBean) {
        mRxManage.add(mModel.UpEnterTwoInfo(upPeoTwoBean).subscribe(new RxSubscriber<RealNamePeoTwoBean>(mContext) {
            @Override
            protected void _onNext(RealNamePeoTwoBean realNamePeoTwoBean) {
                mView.returnUpdateEnterTwo(realNamePeoTwoBean);
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
