package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AllMallDateBean;
import cn.hancang.www.ui.main.contract.MallContract;

/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-下午 16:45
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallPresenter extends MallContract.Presenter {
    @Override
    public void getAllMallDateRequest() {
        mRxManage.add(mModel.getAllMallDatebean().subscribe(new RxSubscriber<AllMallDateBean>(mContext) {
            @Override
            protected void _onNext(AllMallDateBean allMallDateBean) {
                mView.returnAllMalldate(allMallDateBean);
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
