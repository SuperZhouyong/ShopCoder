package cn.hancang.www.ui.myinfo.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.hancang.www.R;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.LoginBean;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SQTUser;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.ui.myinfo.contract.LoginContract;
import cn.hancang.www.ui.myinfo.model.LoginModel;
import cn.hancang.www.ui.myinfo.presenter.LoginPresenter;
import cn.hancang.www.utils.conmonUtil.JsonUtils;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.PublicKetUtils;
import cn.hancang.www.utils.conmonUtil.SPUtils;
import cn.hancang.www.utils.conmonUtil.UserUtil;
import cn.hancang.www.utils.payUtils.AuthResult;
import cn.hancang.www.utils.payUtils.PayResult;
import cn.hancang.www.widget.ClearEditText;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import com.intention.sqtwin.bean.LoginAliOrderBean;
import com.jakewharton.rxbinding.view.RxView;
import com.toptechs.libaction.action.SingleCall;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import cn.sharesdk.alipay.friends.Alipay;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import rx.functions.Action1;

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
    ImageView tvLoginConfirm;
    @BindView(R.id.rel_boot)
    ImageView relBoot;
    private String TAG = "LoginActivity";
    private String iphone_number;
    private String usericon;
    private String userName;

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

    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "2018060160317416";
    /**
     * 支付宝账户登录授权业务：入参pid值
     */
    public static final String PID = "2088131106864170";
    /**
     * 支付宝账户登录授权业务：入参target_id值
     */
    public static final String TARGET_ID = "";
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    /*
      * 支付宝的处理方式
      * */
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(LoginActivity.this,
                                "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(LoginActivity.this,
                                "授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

                    }
                    break;
                }
            }
        }
    };

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

//        handler = new Handler(LoginActivity.this);

        RxView.clicks(authCodeTime).throttleFirst(5, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {

                iphone_number = username.getText().toString().trim();
                if (!TextUtils.isEmpty(iphone_number) && PublicKetUtils.isMobileNO(iphone_number)) {
                    mPresenter.getSmsRequest(iphone_number, "4");
                } else {
                    showShortToast("请检查输入的手机号");
                }
            }
        });
    }

    private void loginWx(String platName) {
        Platform plat = ShareSDK.getPlatform(platName);
//        plat.removeAccount(true); //移除授权状态和本地缓存，下次授权会重新授权
//        plat.SSOSetting(false); //SSO授权，传false默认是客户端授权，没有客户端授权或者不支持客户端授权会跳web授权
        plat.setPlatformActionListener(this);//授权回调监听，监听oncomplete，onerror，oncancel三种状态

        /*if (plat.isAuthValid()) {
           //判断是否已经存在授权状态，可以根据自己的登录逻辑设置
            showShortToast("已经授权过了");
            return;
        }*/
        //plat.authorize();	//要功能，不要数据
        plat.showUser(null);

    }

    @OnClick({R.id.auth_code_time, R.id.tv_login_confirm, R.id.iv_one_login, R.id.iv_two_login, R.id.iv_three_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 发送验证嘛
            case R.id.auth_code_time:
                break;
            case R.id.tv_login_confirm:
                String phoneNUm = username.getText().toString().trim();
                String codeNum = code.getText().toString().trim();
                if (TextUtils.isEmpty(codeNum)) {
                    showShortToast("请输入验证码");
                    return;
                }
                if (PublicKetUtils.isMobileNO(phoneNUm))
                    mPresenter.getLoginRequest(phoneNUm, codeNum);
                else
                    showShortToast("请输入正确的手机号");
                break;
            case R.id.iv_one_login:
                break;
            case R.id.iv_two_login:
                loginWx(Wechat.NAME);
                break;
            case R.id.iv_three_login:
                loginAli(null);
                break;

        }
    }

    private void loginAli(LoginAliOrderBean loginAliOrderBean) {
        Runnable authRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(LoginActivity.this);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2("", true);

                Message msg = new Message();
                msg.what = SDK_AUTH_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread authThread = new Thread(authRunnable);
        authThread.start();
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

    @Override
    public void returnSmsBean(SmsInfoBean smsInfoBean) {
        showShortToast(smsInfoBean.getMessage());
        if (!smsInfoBean.isIs_success()) {
            return;
        }
        mPresenter.ShowTvRequest(authCodeTime);
    }

    @Override
    public void returnOtherLoginBean(OtherLoginBean otherLoginBean) {


        if (!TextUtils.isEmpty(usericon))
            SPUtils.setSharedStringData(mContext, AppConstant.ImageUrl, usericon);
        if (!TextUtils.isEmpty(userName))
            SPUtils.setSharedStringData(mContext, AppConstant.UserName, userName);
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
        LogUtils.logd(TAG + "onComplete");
        if (i == Platform.ACTION_USER_INFOR) {
            Message msg = new Message();
            msg.what = MSG_AUTH_COMPLETE;
            msg.obj = new Object[]{platform.getName(), hashMap};
            handler.sendMessage(msg);
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        LogUtils.logd(TAG + "onError");
        if (i == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_ERROR);
        }
//        LogUtils.logd(TAG, "OnerrOr");
//        t.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int i) {
        LogUtils.logd(TAG + "onCancel");
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

    private Platform mPlatform;

    private void doLogined(String platform) {
        // TODO Auto-generated method stub
        mPlatform = ShareSDK.getPlatform(platform);
        //获取数平台数据DB
        String gender = "";
        if (platform != null) {
            //Sex
            gender = mPlatform.getDb().getUserGender();
            if (gender.equals("m")) {
                //  userInfo.setUserGender(UserInfo.Gender.BOY);
                gender = "男";
            } else {
                //userInfo.setUserGender(UserInfo.Gender.GIRL);
                gender = "女";
            }
            //type
            String typeName = mPlatform.getName();
            //token
            String token = mPlatform.getDb().getToken();
            //Avatar
            usericon = mPlatform.getDb().getUserIcon();
            //openid
            final String userId = mPlatform.getDb().getUserId();
            //Nickname
            userName = mPlatform.getDb().getUserName();

            mPresenter.getOtherLoginBean(userId, userName, usericon);

        }


    }
}
