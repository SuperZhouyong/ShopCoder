package cn.hancang.www.ui.myinfo.presenter;

import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.ui.myinfo.contract.BindPhoneNumContract;

/**
 * Description: 保佑无bug
 * Data：2018/6/15-上午12:08
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BindPhoneNumPresenter extends BindPhoneNumContract.Presenter {
    @Override
    public void getSmsRequest(Integer memberId ,String phone, String type) {
        mRxManage.add(mModel.getSmsInfoBean(memberId,phone, type).subscribe(new RxSubscriber<SmsInfoBean>(mContext) {
            @Override
            protected void _onNext(SmsInfoBean smsInfoBean) {
                mView.returnSmsBean(smsInfoBean);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(AppConstant.twoMessage, message);
            }
        }));
    }

    @Override
    public void ShowTvRequest(final TextView tv) {
        mRxManage.add(mModel.ShowTv(tv).subscribe(new RxSubscriber<Long>(mContext) {
            @Override
            protected void _onNext(Long aLong) {
//                mView.returnShowTvOver(aLong);

                RxTextView.text(tv).call("剩余" + (120 - aLong) + "秒");
            }

            @Override
            protected void _onError(String message) {

            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                RxTextView.text(tv).call("获取验证码");
                RxView.enabled(tv).call(true);
            }

            @Override
            public void onStart() {
                super.onStart();
                RxView.enabled(tv).call(false);

            }
        }));
    }

    @Override
    public void getBindPhonNumBean(String openid, String nickname, String headimgurl) {

    }
}
