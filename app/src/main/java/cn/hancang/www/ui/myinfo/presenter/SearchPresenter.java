package cn.hancang.www.ui.myinfo.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.HotSearchInfoBean;
import cn.hancang.www.bean.SearchInfoBean;
import cn.hancang.www.ui.main.contract.SearchContract;

/**
 * Description: 绝无Bug
 * Data：2018/6/1 0001-下午 16:11
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SearchPresenter extends SearchContract.Presenter {
    @Override
    public void getHotSearchInfoRequest() {
        mRxManage.add(mModel.getHotSearchInfoData().subscribe(new RxSubscriber<HotSearchInfoBean>(mContext) {
            @Override
            protected void _onNext(HotSearchInfoBean hotSearchInfoBean) {
                mView.returnHotSearchInfo(hotSearchInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.oneMessage, message);
            }
        }));
    }

    @Override
    public void getSearchInfoRequest(String password, Integer page) {
        mRxManage.add(mModel.getSearchDate(password, page).subscribe(new RxSubscriber<SearchInfoBean>(mContext) {
            @Override
            protected void _onNext(SearchInfoBean searchInfoBean) {
                mView.returnSearchInfo(searchInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.twoMessage);
            }
        }));
    }
}
