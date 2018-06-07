package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.MessageBean;
import cn.hancang.www.ui.myinfo.contract.MessageContract;

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

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.oneMessage);
            }
        }));
    }
}
