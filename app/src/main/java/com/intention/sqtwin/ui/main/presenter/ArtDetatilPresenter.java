package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.ArtDetailBean;
import com.intention.sqtwin.ui.main.contract.ArtDetatilContract;


/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午1:03
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetatilPresenter extends ArtDetatilContract.Presenter {
    @Override
    public void getArtDetailRequest(Integer artId, Integer page_no) {
        mRxManage.add(mModel.getArtDetailDate(artId, page_no).subscribe(new RxSubscriber<ArtDetailBean>(mContext) {
            @Override
            protected void _onNext(ArtDetailBean artDetailBean) {
                mView.returnArtDetail(artDetailBean);
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
    public void getAddFavArtRequest(Integer favId, String FavType) {
        mRxManage.add(mModel.getAddFavArt(favId, FavType).subscribe(new RxSubscriber<AddFavBean>(mContext) {
            @Override
            protected void _onNext(AddFavBean addFavBean) {
                mView.returnArtFavBean(addFavBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage,message);
            }
        }));
    }
}
