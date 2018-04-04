package com.intention.sqtwin.ui.main.activity.fragment;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;

/**
 * Description:
 * Data：2017/9/14 0014-下午 17:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class RegistFirstFragment extends BaseFragment  {
    // 手机号
    @BindView(R.id.username)
    ClearEditText username;
    //验证码
    @BindView(R.id.auth_code)
    ClearEditText authCod;
    //密码可见图标
    @BindView(R.id.bt_pwd_eye)
    ImageView btPwdEye;
    // 密码可点击区域
    @BindView(R.id.rel_eye)
    RelativeLayout relEye;
    //密码
    @BindView(R.id.password)
    ClearEditText password;


    @BindView(R.id.login)
    Button login;
    //验证码时间
    @BindView(R.id.auth_code_time)
    TextView authCodeTime;

    public String iphone_number;
    public String auth_code;
    public String iphone_password;
//    private PostRegistInfo postRegistInfo;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_regist_first;
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    public static RegistFirstFragment newInstance() {
        return new RegistFirstFragment();
    }

    @Override
    protected void initView() {}


}
