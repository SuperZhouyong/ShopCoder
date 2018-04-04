package com.intention.sqtwin.ui.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.tool_title_left)
    TextView toolTitleLeft;
    @BindView(R.id.tool_title_right)
    TextView toolTitleRight;
    @BindView(R.id.username)
    ClearEditText iphoneNumber;
    @BindView(R.id.bt_pwd_eye)
    ImageView btPwdEye;
    @BindView(R.id.rel_eye)
    RelativeLayout relEye;
    @BindView(R.id.password)
    ClearEditText phonePassword;
    @BindView(R.id.forget_rel)
    RelativeLayout forgetRel;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.to_reset_password)
    TextView toResetPassword;
    // 默认为  false
    private boolean flag = false;
    //返回小图标


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

//    private ArrayList<LoginInfo> mlist = new ArrayList<>();

    @Override
    public void initView() {
        initTitle();
        relEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.logd("点击了眼睛");
                RelEye();
            }
        });
    }

    private void initTitle() {
//        ivBack.setVisibility(View.INVISIBLE);
//        relBack.setVisibility(View.INVISIBLE);
        toolTitleLeft.setText("登录");
        toolTitleRight.setTextColor(getResources().getColor(R.color.font_2));
//        RxView.
    }


    /*
    * 忘记密码
    * */
    @OnClick({R.id.to_reset_password, R.id.login, R.id.tool_title_right, R.id.rel_back})
    public void Login_OnClick(View v) {
        switch (v.getId()) {
            // 忘记密码
            case R.id.to_reset_password:
                startActivity(ResetPasswordActivity.class);
                break;
            // 登陆
            case R.id.login:

//                MainActivity.startAction(this);

                LoginApp();
                break;
            // 密码可见点击区域
          /*  case R.id.rel_eye:
                 LogUtils.logd("点击了眼睛");
                RelEye();
                break;*/
            //注册按钮
            case R.id.tool_title_right:
                startActivity(RegistFragActivity.class);
                break;
            case R.id.rel_back:
                finish();
                break;
        }
    }


    public void LoginApp() {

        String UserName = iphoneNumber.getText().toString().trim();
        String PassWord = phonePassword.getText().toString().trim();
        // 防止这些都为空
        if (TextUtils.isEmpty(UserName) || TextUtils.isEmpty(PassWord)) {
            showLongToast("请检查输入信息");
            return;
        }
        if (PassWord.length() < 6 || PassWord.length() > 18) {
            showLongToast("请输入合适的密码位数");
//            return;
        }
        // 用户名符合手机号和邮箱
        /*if (!PublicKetUtils.isMobileNO(UserName)) {
            showLongToast("请检查账号格式");
        } else {
            // 做登录的网络操作
        }*/
//        mPresenter.getLoginDataRequest(UserName, PassWord);
    }


    /*
    * 密码可见的选择
    * */

    public void RelEye() {
        LogUtils.logd("Edittext点击范围" + "我被点击了——眼睛可视化");
      /*  if (flag = true) {
            phonePassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            btPwdEye.setImageResource(R.mipmap.password_hide);
            flag = false;


        } else {
            phonePassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            btPwdEye.setImageResource(R.mipmap.password_show);
            flag = true;
        }*/
        // 密码输入的类型为密码
        if (phonePassword.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            phonePassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
            btPwdEye.setImageResource(R.mipmap.password_show);
            // 更改眼睛的背景
        } else {
            phonePassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            btPwdEye.setImageResource(R.mipmap.password_hide);
        }
        // 设置光标靠右
        phonePassword.setSelection(phonePassword.getText().toString().length());
    }



}
