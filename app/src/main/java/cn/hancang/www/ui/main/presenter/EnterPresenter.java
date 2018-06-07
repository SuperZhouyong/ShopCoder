package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.StoreInfoBean;
import cn.hancang.www.ui.main.contract.EnterContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午10:08
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EnterPresenter extends EnterContract.presenter {
    @Override
    public void getStoreInfoRequest() {
        mRxManage.add(mModel.getStoreInfo().subscribe(new RxSubscriber<StoreInfoBean>(mContext) {
            @Override
            protected void _onNext(StoreInfoBean storeInfoBean) {
                mView.returnStoreInfo(storeInfoBean);
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
