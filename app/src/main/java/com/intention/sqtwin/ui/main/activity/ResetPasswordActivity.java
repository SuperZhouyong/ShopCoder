package com.intention.sqtwin.ui.main.activity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class ResetPasswordActivity extends BaseActivity{
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.tool_title_left)
    TextView toolTitleLeft;
    @BindView(R.id.tool_title_right)
    TextView toolTitleRight;
    @BindView(R.id.username)
    ClearEditText username;
    @BindView(R.id.auth_code_time)
    TextView authCodeTime;
    @BindView(R.id.auth_code)
    ClearEditText EDauthCode;
    @BindView(R.id.bt_pwd_eye)
    ImageView btPwdEye;
    @BindView(R.id.rel_eye)
    RelativeLayout relEye;
    @BindView(R.id.password)
    ClearEditText password;
    @BindView(R.id.login)
    Button login;

    private String phone_number;
    private String phone_password;
    private String authCode;


    @Override
    public int getLayoutId() {
        return R.layout.activity_resetpassword;
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

    }

   /* private void initTitle() {
        toolTitleRight.setVisibility(View.INVISIBLE);
        toolTitleLeft.setText("找回密码");
        RxView.clicks(authCodeTime).throttleFirst(5, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                phone_number = username.getText().toString().trim();
//                phone_password = password.getText().toString().trim();
                // mPresenter.getSmsLoginDataRequest(phone_number, AppConstant.FINDPASSF);
                if (!TextUtils.isEmpty(phone_number) && PublicKetUtils.isMobileNO(phone_number)) {
                    mPresenter.getSmsLoginDataRequest(phone_number, AppConstant.FINDPASSF);
                } else {
                    showShortToast("请检查输入的手机号");
                }
            }
        });
    }
*/
 /*   @OnClick({R.id.login, R.id.rel_eye, R.id.rel_back})
    public void Reset_Onclick(View v) {
        switch (v.getId()) {
            case R.id.login:
                LoginApp();
                break;

            case R.id.rel_eye:
                RelEye();
                break;
            case R.id.rel_back:
                finish();
                break;


        }
    }
*/
 /*   public void LoginApp() {

        phone_number = username.getText().toString().trim();
        phone_password = password.getText().toString().trim();
        authCode = EDauthCode.getText().toString().trim();
        // 防止这些都为空
        if (TextUtils.isEmpty(phone_number) || TextUtils.isEmpty(phone_password) || TextUtils.isEmpty(authCode)) {
            showLongToast("请检查输入信息");
            return;
        }
        if (phone_password.length() < 6 || phone_password.length() > 18) {
            showShortToast("请检查密码输入位数");
            return;
        }
        // 用户名符合手机号和邮箱
        if (!PublicKetUtils.isMobileNO(phone_number)) {
            showLongToast("请检查账号格式");
        } else {
            // 做登录的网络操作
            mPresenter.getLoginRequest(phone_number, phone_password, AppConstant.FINDPASSF, authCode);
        }
    }
*/
      /*
    * 密码可见的选择
    * */





}
