package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AuctionOrgBean;
import cn.hancang.www.ui.main.contract.AuctionOrgContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/3-下午10:44
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionOrgPresenter extends AuctionOrgContract.Presenter {
    @Override
    public void getAuctionOrgRequest(Integer OrgId, Integer page,Integer status) {
        mRxManage.add(mModel.getAuctionOrgData(OrgId, page,status).subscribe(new RxSubscriber<AuctionOrgBean>(mContext) {
            @Override
            protected void _onNext(AuctionOrgBean auctionOrgBean) {
                mView.returnAuctionOrg(auctionOrgBean);
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

    @Override
    public void getAddFavArtFiledRequest(Integer favId, String FavType) {
        mRxManage.add(mModel.getAddFavArtFiled(favId, FavType).subscribe(new RxSubscriber<AddFavBean>(mContext) {
            @Override
            protected void _onNext(AddFavBean addFavBean) {
//                mView.returnArtFavBean(addFavBean);
                mView.returnArtFavBeanFiled(addFavBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage,message);
            }
        }));
    }
}
