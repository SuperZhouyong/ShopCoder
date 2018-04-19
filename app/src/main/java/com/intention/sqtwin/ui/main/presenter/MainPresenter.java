package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.RecommendField;
import com.intention.sqtwin.bean.RecommendedLots;
import com.intention.sqtwin.bean.ShufflingPictureBean;
import com.intention.sqtwin.ui.main.contract.MainContract;

/**
 * Description: 绝无Bug
 * Data：2018/4/18-下午10:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MainPresenter extends MainContract.Presenter {
    @Override
    public void getViewpagerPic(String page, Integer postion) {
        mRxManage.add(mModel.getViewpagerPic(page, postion).subscribe(new RxSubscriber<ShufflingPictureBean>(mContext) {
            @Override
            protected void _onNext(ShufflingPictureBean shufflingPictureBean) {
                mView.returnViewpagerPic(shufflingPictureBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip("Viewpager", message);
            }
        }));
    }

    @Override
    public void getRecommentLots(String type) {
        mRxManage.add(mModel.getRecommendLots(type).subscribe(new RxSubscriber<RecommendedLots>(mContext) {
            @Override
            protected void _onNext(RecommendedLots recommendedLots) {
                mView.returnRecommendedLot(recommendedLots);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip("recommendLots", message);
            }
        }));
    }

    @Override
    public void getRecommentFILED(String type) {
        mRxManage.add(mModel.getRecommendField(type).subscribe(new RxSubscriber<RecommendField>(mContext) {
            @Override
            protected void _onNext(RecommendField recommendField) {
                mView.returnRecommendField(recommendField);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip("recommendFiled", message);
            }
        }));
    }
}
