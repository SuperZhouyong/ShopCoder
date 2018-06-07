package cn.hancang.www.ui.Store.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.RealNamePeoTwoBean;
import cn.hancang.www.bean.UpPeoTwoBean;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.ui.Store.contract.RealnameContract;

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
    public void UpPeoTwoInfoRequest(UpPeoTwoBean upPeoTwoBean) {
        mRxManage.add(mModel.UpPeoTwoInfo(upPeoTwoBean).subscribe(new RxSubscriber<RealNamePeoTwoBean>(mContext) {
            @Override
            protected void _onNext(RealNamePeoTwoBean realNamePeoTwoBean) {
                mView.returnUpdatePeoTwo(realNamePeoTwoBean);
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
}
