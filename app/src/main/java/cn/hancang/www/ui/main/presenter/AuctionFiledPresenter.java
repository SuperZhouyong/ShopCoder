package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AuctionFiledAllBean;
import cn.hancang.www.ui.main.contract.AuctionFiledContract;

/**
 * Description: 保佑无bug
 * Data：2018/4/25-下午10:47
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledPresenter extends AuctionFiledContract.Presenter {
    @Override
    public void getAuctionFiledRequest(Integer auction_filed_id, Integer sort) {
        mRxManage.add(mModel.getAuctionFileDate(auction_filed_id, sort).subscribe(new RxSubscriber<AuctionFiledAllBean>(mContext, true) {
            @Override
            protected void _onNext(AuctionFiledAllBean auctionFiledAllBean) {
                mView.returnAuctionFileData(auctionFiledAllBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.StartLoading(AppConstant.oneMessage);
            }
        }));
    }

    @Override
    public void getAddFavBean(Integer fav_id, final String fav_type) {
        mRxManage.add(mModel.getAddFavFiled(fav_id, fav_type).subscribe(new RxSubscriber<AddFavBean>(mContext) {
            @Override
            protected void _onNext(AddFavBean addFavBean) {
                if (AppConstant.field.equals(fav_type))
                    mView.returnAddFavBeanFiled(addFavBean);
                else
                    mView.returnAddFavBean(addFavBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }


        }));
    }
}
