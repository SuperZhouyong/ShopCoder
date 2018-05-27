package com.intention.sqtwin.ui.Store.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.RealNamePeoTwoBean;
import com.intention.sqtwin.bean.UpComPanyTwoBean;
import com.intention.sqtwin.bean.UpPeoTwoBean;
import com.intention.sqtwin.bean.UpdateImageBean;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/26-下午1:29
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface RealNameEnterTwoContract {
    interface View extends BaseView {
        // 获取图片上传的信息
        void returnUpdateImage(UpdateImageBean updateImageBean);

        //企业信息第二部上传接口 返回
        void returnUpdateEnterTwo(RealNamePeoTwoBean realNamePeoTwoBean);
    }

    interface Model extends BaseModel {
//        Observable<IdentityProveBean> getIdentityProveBean(UpdateMySelf updateMySelf);

        //上传图片信息
        Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps);


        // 企业信息第二部上传接口 上传第二部接口
        Observable<RealNamePeoTwoBean> UpEnterTwoInfo(UpComPanyTwoBean upPeoTwoBean);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //    上传照片
        public abstract void updateImageRequest(Map<String, RequestBody> mMaps);

        // 企业信息第二部上传接口 上传第二部接口
        public abstract void UpPeoEnterInfoRequest(UpComPanyTwoBean upPeoTwoBean);
    }
}
