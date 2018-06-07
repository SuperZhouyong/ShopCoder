package cn.hancang.www.ui.Store.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.RealNamePeoTwoBean;
import cn.hancang.www.bean.UpPeoTwoBean;
import cn.hancang.www.bean.UpdateImageBean;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/25-上午1:11
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface RealnameContract {
    interface View extends BaseView {
        // 获取图片上传的信息
        void returnUpdateImage(UpdateImageBean updateImageBean);

        //个人信息第二部上传接口 返回
        void returnUpdatePeoTwo(RealNamePeoTwoBean realNamePeoTwoBean);

        // 企业信息 法人信息上传
//        void returnUpdatEnterThree(RealNamePeoTwoBean realNamePeoTwoBean);
    }

    interface Model extends BaseModel {
//        Observable<IdentityProveBean> getIdentityProveBean(UpdateMySelf updateMySelf);

        //上传图片信息
        Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps);


        // 个人信息 上传第二部接口
        Observable<RealNamePeoTwoBean> UpPeoTwoInfo(UpPeoTwoBean upPeoTwoBean);

//        Observable<RealNamePeoTwoBean> UpEnterThreeInfo(UpEnterThreeBean upPeoTwoBean);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //    上传照片
        public abstract void updateImageRequest(Map<String, RequestBody> mMaps);

        // 个人信息 上传第二部接口
        public abstract void UpPeoTwoInfoRequest(UpPeoTwoBean upPeoTwoBean);


        //企业信息 第三部 上传

//        public abstract void UpEnterThreeInfoRequest(UpEnterThreeBean upEnterThreeBean);
    }

}
