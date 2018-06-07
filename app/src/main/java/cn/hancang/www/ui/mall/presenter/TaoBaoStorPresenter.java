package cn.hancang.www.ui.mall.presenter;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.TaobaoStoreInfoBean;
import cn.hancang.www.ui.mall.contract.TaoBaoStoreContract;

/**
 * Description: 保佑无bug
 * Data：2018/5/24-上午12:27
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TaoBaoStorPresenter extends TaoBaoStoreContract.Presenter {
    @Override
    public void getTaoBaoStoreInfoRequest(Integer store_id) {
        mRxManage.add(mModel.getTaoBaoStorInfoData(store_id).subscribe(new RxSubscriber<TaobaoStoreInfoBean>(mContext) {
            @Override
            protected void _onNext(TaobaoStoreInfoBean taobaoStoreInfoBean) {
                mView.returnTaobaoSToreInfo(taobaoStoreInfoBean);
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

            @Override
            public void onCompleted() {
                super.onCompleted();
                mView.stopLoading(AppConstant.oneMessage);
            }
        }));
    }

    @Override
    public void getAddFavBean(Integer fav_id, final String fav_type) {
        mRxManage.add(mModel.getAddFavFiled(fav_id, fav_type).subscribe(new RxSubscriber<AddFavBean>(mContext) {
            @Override
            protected void _onNext(AddFavBean addFavBean) {
                if (AppConstant.field.equals(fav_type))

                    mView.returnAddFavBean(addFavBean);
                else
                    mView.returnAddFavBeanStore(addFavBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }


        }));
    }
}
