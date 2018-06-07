package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.DerivativesBean;
import cn.hancang.www.ui.mall.contract.DerivativesContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:27
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesPresenter extends DerivativesContract.Presenter {
    @Override
    public void getDerivativesRequest(Integer type) {
        mRxManage.add(mModel.getDerivativesDate(type).subscribe(new RxSubscriber<DerivativesBean>(mContext) {
            @Override
            protected void _onNext(DerivativesBean derivativesBean) {
                mView.returnDerivatives(derivativesBean);
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
