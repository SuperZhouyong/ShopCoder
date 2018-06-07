package cn.hancang.www.ui.myinfo.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.IdentityProveBean;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.bean.UpdateMySelf;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Description: 保佑无bug
 * Data：2018/5/17-上午12:11
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class IdentityProveContract {
    public interface View extends BaseView {
        void returnIdentityProveBean(IdentityProveBean identityProveBean);

        // 获取图片上传的信息
        void returnUpdateImage(UpdateImageBean updateImageBean);
    }

    public interface Model extends BaseModel {
        Observable<IdentityProveBean> getIdentityProveBean(UpdateMySelf updateMySelf);

        //上传图片信息
        Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps);

    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getIdentityProveRequest(UpdateMySelf updateMySelf);

        public abstract void updateImageRequest(Map<String, RequestBody> mMaps);
    }
}
