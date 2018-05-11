package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.MyCompeteBean;
import com.intention.sqtwin.ui.myinfo.contract.MyCompeteContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompetePresenter extends MyCompeteContract.Presenter{
    @Override
    public void getMyCompeteRequest(Integer page) {
        mRxManage.add(mModel.getMyCompeteDate(page).subscribe(new RxSubscriber<MyCompeteBean>(mContext) {
            @Override
            protected void _onNext(MyCompeteBean myCompeteBean) {
                mView.returnMyCompeteBean(myCompeteBean);
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
