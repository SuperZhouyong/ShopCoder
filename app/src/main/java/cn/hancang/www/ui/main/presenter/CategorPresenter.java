package cn.hancang.www.ui.main.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.CategoryAllBean;
import cn.hancang.www.ui.main.contract.CategoryContract;

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
        mRxManage.add(mModel.getCategoryDate(CategoryId).subscribe(new RxSubscriber<CategoryAllBean>(mContext) {
            @Override
            protected void _onNext(CategoryAllBean categoryAllBean) {
                mView.returnCategoryData(categoryAllBean);
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
