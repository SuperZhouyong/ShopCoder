package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AgentBidBean;
import cn.hancang.www.bean.AutionItemDetailBean;
import cn.hancang.www.bean.BidBean;
import cn.hancang.www.ui.main.contract.AutionItemContract;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午1:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AutionItemPresenter extends AutionItemContract.Presenter {

    @Override
    public void getAutionDetailRequest(Integer id) {
        mRxManage.add(mModel.getAutionDetaiData(id).subscribe(new RxSubscriber<AutionItemDetailBean>(mContext, true) {
            @Override
            protected void _onNext(AutionItemDetailBean autionItemDetailBean) {
                mView.returnAutionItemDeatil(autionItemDetailBean);
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
    public void getAgentBidBeanRequest(Integer goods_id, Integer price, Integer member_id) {
        mRxManage.add(mModel.getAgentBidDate(goods_id, price, member_id).subscribe(new RxSubscriber<AgentBidBean>(mContext) {
            @Override
            protected void _onNext(AgentBidBean agentBidBean) {
                mView.returnAgentBidDate(agentBidBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }

    @Override
    public void getBidBeanRequest(Integer goods_id, Integer price, Integer member_id) {
        mRxManage.add(mModel.getBindDate(goods_id, price, member_id).subscribe(new RxSubscriber<BidBean>(mContext) {
            @Override
            protected void _onNext(BidBean bidBean) {
                mView.returnBidDate(bidBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.threeMessage, message);
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
                mView.showErrorTip(AppConstant.foreMessage, message);
            }


        }));
    }
}
