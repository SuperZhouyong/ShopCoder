package cn.hancang.www.ui.Store.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.DeleteFavBean;
import cn.hancang.www.bean.StoreInfoComBean;
import cn.hancang.www.ui.Store.contract.StoreInfoComContract;

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

    @Override
    public void getCancelFocuRequest(Integer fac_id, String fav_type) {
        mRxManage.add(mModel.getCancelFocus(fac_id, fav_type).subscribe(new RxSubscriber<DeleteFavBean>(mContext) {
            @Override
            protected void _onNext(DeleteFavBean deleteFavBean) {
                mView.returnCancelFocus(deleteFavBean);
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
