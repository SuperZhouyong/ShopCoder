package cn.hancang.www.ui.mall.presenter;

import com.intention.sqtwin.bean.AllStoreListBean;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.ui.mall.contract.MoreStoreContract;

/**
 * Description: 保佑无bug
 * Data：2018/7/21-上午1:05
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MoreStorePresenter extends MoreStoreContract.Presenter {
    @Override
    public void getAllStoreListRequest(int page) {
        mRxManage.add(mModel.getAllStoreListData(page).subscribe(new RxSubscriber<AllStoreListBean>(mContext) {
            @Override
            protected void _onNext(AllStoreListBean allStoreListBean) {
                mView.returnAllStoreList(allStoreListBean);
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
