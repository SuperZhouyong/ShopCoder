package com.intention.sqtwin.ui.myinfo.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
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
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.JsonUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;
import com.intention.sqtwin.widget.ClearEditText;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 登录界面
 * Data：2018/5/12-下午6:22
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {
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
        relBoot.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.login_bg, getBitmapOption()));
//        ImageLoaderUtils.display(this,relBoot,R.mipmap.login_bg);
//        re
    }


    @OnClick({R.id.tv_login_desc, R.id.tv_regist_desc, R.id.tv_login_confirm})
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
            finish();
            // 回调执行登录
            SingleCall.getInstance().doCall();
        } else {
            showShortToast(loginBean.getMessage());
        }


    }

    // 进入登陆界面
    public static void start(BaseActivity context) {
        context.startActivity(LoginActivity.class);
    }
}
