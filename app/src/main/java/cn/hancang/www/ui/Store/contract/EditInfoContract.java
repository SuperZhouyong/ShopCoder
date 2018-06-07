package cn.hancang.www.ui.Store.contract;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AllRegion;
import cn.hancang.www.bean.MyInfoBean;
import cn.hancang.www.bean.SubmitClientInfo;
import cn.hancang.www.bean.UpdateImageBean;
import cn.hancang.www.bean.UpdateResultInfo;

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
