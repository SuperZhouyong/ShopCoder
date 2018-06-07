package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AllRegion;
import cn.hancang.www.bean.SubmitAddressBean;
import cn.hancang.www.bean.UpdateAddressBean;
import cn.hancang.www.ui.myinfo.contract.AddReAddressContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/18-上午12:42
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AddReAddressPresenter extends AddReAddressContract.Presenter {
    @Override
    public void getSubmitAddressBean(UpdateAddressBean updateAddressBean) {
        mRxManage.add(mModel.getSubmitAddressBean(updateAddressBean).subscribe(new RxSubscriber<SubmitAddressBean>(mContext) {
            @Override
            protected void _onNext(SubmitAddressBean submitAddressBean) {
                mView.returnSubmitAddressBean(submitAddressBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }

    @Override
    public void getAllRegion() {
        mRxManage.add(mModel.getAllRegion().subscribe(new RxSubscriber<AllRegion>(mContext) {
            @Override
            protected void _onNext(AllRegion allRegion) {
                mView.returnAllregion(allRegion);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));

    }
}
