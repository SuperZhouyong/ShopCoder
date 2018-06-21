package cn.hancang.www.ui.myinfo.contract;

import android.widget.TextView;

import cn.hancang.www.base.BaseModel;
import cn.hancang.www.base.BasePresenter;
import cn.hancang.www.base.BaseView;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SmsInfoBean;
import rx.Observable;

//import cn.hancang.www.ui.myinfo.contract.LoginContract;

/**
 * Description: 保佑无bug
 * Data：2018/6/15-上午12:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public interface BindPhoneNumContract {
     interface View extends BaseView {


        void returnSmsBean(SmsInfoBean smsInfoBean);




        void returnBindPhoneNUm(OtherLoginBean otherLoginBean);
    }
     interface  Model extends BaseModel {


        Observable<SmsInfoBean> getSmsInfoBean(Integer memberId ,String phone, String type);

        Observable<Long> ShowTv(TextView tv);


        Observable<OtherLoginBean> getBindPhoneNumBean(String openid, String nickname, String headimgurl);
    }
   abstract class Presenter extends BasePresenter<View,Model> {


        public abstract void getSmsRequest(Integer memberId ,String phone,String type);

        // 计时请求
        public abstract void ShowTvRequest(TextView tv);

        // 发起信息保存

        public abstract void getBindPhonNumBean(String openid,String nickname ,String headimgurl);
    }
}
