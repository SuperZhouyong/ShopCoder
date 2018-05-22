package com.intention.sqtwin.ui.Store.contract;

import com.intention.sqtwin.base.BaseModel;
import com.intention.sqtwin.base.BasePresenter;
import com.intention.sqtwin.base.BaseView;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.bean.SubmitClientInfo;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateResultInfo;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;


/**
 * Description: 绝无Bug
 * Data：2018/5/22 0022-上午 10:24
 * Blog：Super简单
 * Author: ZhouYong
 */

public class EditInfoContract {
    public interface View extends BaseView {
        // 获取个人信息
        void returnEditInfoBena(MyInfoBean myInfoBean);

        // 获取图片上传的信息
        void returnUpdateImage(UpdateImageBean updateImageBean);

        //上传整个编辑修改信息
        void returnUodateInfo(UpdateResultInfo updateResultInfo);

        //获取全省
        void returnAllregion(AllRegion allRegion);
    }

    public interface Model extends BaseModel {
        // 获取个人信息
        Observable<MyInfoBean> getEditInfo();

        //上传图片信息
        Observable<UpdateImageBean> updateImage(Map<String, RequestBody> mMaps);

        // 上传修改的个人信息
        Observable<UpdateResultInfo> updateAllEditInfo(SubmitClientInfo submitClientInfo);
        // 获取全身
        Observable<AllRegion> getAllRegion();
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getEditInfoRequest();

        public abstract void updateImageRequest(Map<String, RequestBody> mMaps);

        public abstract void updateAnnEditInfoRequest(SubmitClientInfo submitClientInfo);

        public abstract void getAllRegion();
    }
}
