package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AccountBean;
import cn.hancang.www.ui.myinfo.contract.AccountContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午1:47
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AccountPresenter extends AccountContract.Presenter {
    @Override
    public void getAccountBeanRequest(Integer accountId) {
        mRxManage.add(mModel.getAccountBean(accountId).subscribe(new RxSubscriber<AccountBean>(mContext) {
            @Override
            protected void _onNext(AccountBean accountBean) {
                mView.returnAccountBean(accountBean);
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
