package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.StoreLoginNameBean;
import cn.hancang.www.bean.StorePwInfoBean;
import cn.hancang.www.ui.myinfo.contract.StorePassWordContract;

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
    public void getStorePwRequest(String name, String pw, String oldPw) {
        mRxManage.add(mModel.postStorePw(name, pw, oldPw).subscribe(new RxSubscriber<StorePwInfoBean>(mContext) {
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
