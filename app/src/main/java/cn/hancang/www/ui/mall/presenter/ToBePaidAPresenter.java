package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.bean.ToBenPaidBean;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.ui.mall.contract.ToBePaidAContract;

/**
 * Description: 保佑无bug
 * Data：2018/7/1-下午7:46
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ToBePaidAPresenter extends ToBePaidAContract.Presenter {
    @Override
    public void getToBePaidRequest(Integer order_id, Integer pay_type) {
        mRxManage.add(mModel.getToBePaidData(order_id, pay_type).subscribe(new RxSubscriber<ToBenPaidBean>(mContext) {
            @Override
            protected void _onNext(ToBenPaidBean toBenPaidBean) {
                mView.returnToBePaidBean(toBenPaidBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }
}
