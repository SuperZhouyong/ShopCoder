package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.OrganPeBean;
import cn.hancang.www.ui.main.contract.OrganPeContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-上午12:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPePresenter extends OrganPeContract.Presenter {
    @Override
    public void getRequestData(Integer staffId, Integer page) {
        mRxManage.add(mModel.getOrganPeData(staffId, page).subscribe(new RxSubscriber<OrganPeBean>(mContext) {
            @Override
            protected void _onNext(OrganPeBean organPeBean) {
                mView.returnOrganPeData(organPeBean);
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
    @Override
    public void getAddFavBean(Integer fav_id, String fav_type) {
        mRxManage.add(mModel.getAddFavFiled(fav_id, fav_type).subscribe(new RxSubscriber<AddFavBean>(mContext) {
            @Override
            protected void _onNext(AddFavBean addFavBean) {
                mView.returnAddFavBean(addFavBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage,message);
            }


        }));
    }
}
