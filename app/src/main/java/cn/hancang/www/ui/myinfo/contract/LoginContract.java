package cn.hancang.www.ui.myinfo.contract;

import android.widget.TextView;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.AliLoginAfterBean;
import cn.hancang.www.bean.AliLoginBean;
import cn.hancang.www.bean.LoginBean;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SmsInfoBean;

import rx.Observable;

/**
 * Description: 绝无Bug
 * Data：2018/5/14 0014-下午 13:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class LoginContract {
    public interface View extends BaseView {
        void returnLoginBean(LoginBean loginBean);

        void returnSmsBean(SmsInfoBean smsInfoBean);

//    void returnShowTvOver(Long mLong);

        void returnAliBean(AliLoginBean aliLoginBean);

        void returnOtherLoginBean(OtherLoginBean otherLoginBean);

        void returnAliLoginAfter(AliLoginAfterBean aliLoginAfterBean);
    }

    public interface Model extends BaseModel {
        Observable<LoginBean> getLoginBean(String phone, String code);

        Observable<SmsInfoBean> getSmsInfoBean(String phone, String type);

        Observable<Long> ShowTv(TextView tv);

        Observable<AliLoginBean> getAliLoginBean();

        Observable<OtherLoginBean> getOtherLoginBean(String openid, String nickname, String headimgurl);

        Observable<AliLoginAfterBean> getAliLoginAfterBean(String auth_code);
    }

    public static abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getLoginRequest(String phone, String code);

        public abstract void getSmsRequest(String phone, String type);

        // 计时请求
        public abstract void ShowTvRequest(TextView tv);

        // 发起信息保存

        public abstract void getOtherLoginBean(String openid, String nickname, String headimgurl);

        // 获取支付宝登录信息

        public abstract void getaLiLoginBean();

        public abstract void getAliLoginAfterBeanRequest(String auth_code);
    }
}
