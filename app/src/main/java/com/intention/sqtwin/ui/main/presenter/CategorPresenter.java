package com.intention.sqtwin.ui.main.presenter;

import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.CategoryBena;
import com.intention.sqtwin.ui.main.contract.CategoryContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/5-上午12:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategorPresenter extends CategoryContract.presenter {
    @Override
    public void getCategoryBeanRequest(Integer CategoryId) {
        mRxManage.add(mModel.getCategoryDate(CategoryId).subscribe(new RxSubscriber<CategoryBena>(mContext) {
            @Override
            protected void _onNext(CategoryBena categoryBena) {
                mView.returnCategoryData(categoryBena);
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
}
