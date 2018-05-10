package com.intention.sqtwin.ui.myinfo.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.MessageBean;
import com.intention.sqtwin.ui.myinfo.contract.MessageContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午12:55
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MessagePresenter extends MessageContract.Presenter {
    @Override
    public void getMessageBeanRequest(Integer page_no) {
        mRxManage.add(mModel.getMessagebean(page_no).subscribe(new RxSubscriber<MessageBean>(mContext) {
            @Override
            protected void _onNext(MessageBean messageBean) {
                mView.returnMessage(messageBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }
        }));
    }
}
