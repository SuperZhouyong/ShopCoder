package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemPresenter extends AutionItemContract.Presenter {

    @Override
    public void getAutionDetailRequest(Integer id) {
        mRxManage.add(mModel.getAutionDetaiData(id).subscribe(new RxSubscriber<AutionItemDetailBean>(mContext) {
            @Override
            protected void _onNext(AutionItemDetailBean autionItemDetailBean) {
                mView.returnAutionItemDeatil(autionItemDetailBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage,message);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }
        }));
    }
}
