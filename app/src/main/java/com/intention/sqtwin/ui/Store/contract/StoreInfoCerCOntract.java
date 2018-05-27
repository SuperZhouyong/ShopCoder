package com.intention.sqtwin.ui.Store.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.ReanlNameStoreInfoBean;
import com.intention.sqtwin.bean.UpdateImageBean;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午12:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface StoreInfoCerCOntract {
    interface View extends BaseView {
        // 获取图片上传的信息
        void returnUpdateImage(UpdateImageBean updateImageBean);

        void returnUpdateStoreInfoCer(ReanlNameStoreInfoBean reanlNameStoreInfoBean);

    }

    interface Model extends BaseModel {
        //上传图片信息
        Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps);

        // 上传店铺信息
        Observable<ReanlNameStoreInfoBean> UpStoreInfoCer(String name, String logo, String desc);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void updateImageRequest(Map<String, RequestBody> mMaps);

        public abstract void UpdateStoreInfoCer(String name, String logo, String desc);
    }
}
