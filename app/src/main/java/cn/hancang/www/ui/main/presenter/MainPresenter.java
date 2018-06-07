package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AllDateBean;
import cn.hancang.www.ui.main.contract.MainContract;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午10:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MainPresenter extends MainContract.Presenter {
    @Override
    public void getHomeAllDate() {
        mRxManage.add(mModel.getAllDateBean().subscribe(new RxSubscriber<AllDateBean>(mContext) {
            @Override
            protected void _onNext(AllDateBean allDateBean) {
                mView.returnHomeAllDate(allDateBean);
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
