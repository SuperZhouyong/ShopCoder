package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.LoginBean;
import com.intention.sqtwin.bean.SQTUser;
import com.intention.sqtwin.ui.myinfo.contract.LoginContract;
import com.intention.sqtwin.ui.myinfo.model.LoginModel;
import com.intention.sqtwin.ui.myinfo.presenter.LoginPresenter;
import com.intention.sqtwin.utils.conmonUtil.JsonUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;
import com.intention.sqtwin.widget.ClearEditText;
import com.toptechs.libaction.action.SingleCall;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.sharesdk.alipay.friends.Alipay;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * Description: 登录界面
 * Data：2018/5/12-下午6:22
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, PlatformActionListener, Handler.Callback {
    @BindView(R.id.username)
    ClearEditText username;
    @BindView(R.id.username_layout)
    RelativeLayout usernameLayout;
    @BindView(R.id.code)
    ClearEditText code;
    @BindView(R.id.auth_code_time)
    TextView authCodeTime;
    @BindView(R.id.code_layout)
    RelativeLayout codeLayout;
    @BindView(R.id.rel_bottom)
    RelativeLayout relBottom;
    @BindView(R.id.tv_login_desc)
    TextView tvLoginDesc;
    @BindView(R.id.tv_regist_desc)
    TextView tvRegistDesc;
    @BindView(R.id.tv_login_confirm)
    TextView tvLoginConfirm;
    @BindView(R.id.rel_boot)
    ImageView relBoot;
    private String TAG = "LoginActivity";

    private BitmapFactory.Options getBitmapOption() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = 2;
        return options;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
     /*   this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        relBoot.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.login_bg, getBitmapOption()));*/
        handler = new Handler(LoginActivity.this);
    }

    private void loginWx(String platName) {
        Platform plat = ShareSDK.getPlatform(platName);
        plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
        plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
        plat.setPlatformActionListener(this);//授权回调监听，监听oncomplete，onerror，oncancel三种状态

        /*if (plat.isAuthValid()) {
           //判断是否已经存在授权状态，可以根据自己的登录逻辑设置
            showShortToast("已经授权过了");
            return;
        }*/
        //plat.authorize();	//要功能，不要数据
        plat.showUser(null);

    }

    @OnClick({R.id.tv_login_desc, R.id.tv_regist_desc, R.id.tv_login_confirm, R.id.iv_one_login, R.id.iv_two_login, R.id.iv_three_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_login_desc:
                break;
            case R.id.tv_regist_desc:
                break;
            case R.id.tv_login_confirm:
                String phoneNUm = username.getText().toString().trim();
                String codeNum = code.getText().toString().trim();
                if (PublicKetUtils.isMobileNO(phoneNUm))
                    mPresenter.getLoginRequest(phoneNUm, null);
                else
                    showShortToast("请输入正确的手机号");
                break;
            case R.id.iv_one_login:
                break;
            case R.id.iv_two_login:
                loginWx(Wechat.NAME);
                break;
            case R.id.iv_three_login:
                loginWx(Alipay.NAME);
                break;

        }
    }

    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {

    }

    @Override
    public void returnLoginBean(LoginBean loginBean) {
        if (loginBean.isIs_success()) {
            UserUtil.setLoginInfo((SQTUser) JsonUtils.fromJson(JsonUtils.toJson(loginBean.getData()), SQTUser.class));
            // 目前登录为当前关闭 就好
            // 回调执行登录
            finish();
            SingleCall.getInstance().doCall();
        } else {
            showShortToast(loginBean.getMessage());
        }


    }

    private static final int MSG_AUTH_CANCEL = 2;
    private static final int MSG_AUTH_ERROR = 3;
    private static final int MSG_AUTH_COMPLETE = 4;
    private Handler handler;

    // 进入登陆界面
    public static void start(Context context) {
        ((BaseActivity) context).startActivity(LoginActivity.class);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (i == Platform.ACTION_USER_INFOR) {
            Message msg = new Message();
            msg.what = MSG_AUTH_COMPLETE;
            msg.obj = new Object[]{platform.getName(), hashMap};
            handler.sendMessage(msg);
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        if (i == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_ERROR);
        }
//        LogUtils.logd(TAG, "OnerrOr");
//        t.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        if (i == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_CANCEL);
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_AUTH_CANCEL: {
                //取消授权
                showShortToast(R.string.auth_cancel);
            }
            break;
            case MSG_AUTH_ERROR: {
                //授权失败
                showShortToast(R.string.auth_error);
            }
            break;
            case MSG_AUTH_COMPLETE: {
                //授权成功
                showShortToast(R.string.auth_complete);
                Object[] objs = (Object[]) msg.obj;
                String platform = (String) objs[0];
                HashMap<String, Object> res = (HashMap<String, Object>) objs[1];
                doLogined(platform);
            }
            break;

        }
        return false;
    }

    private void doLogined(String platform) {

    }
}
