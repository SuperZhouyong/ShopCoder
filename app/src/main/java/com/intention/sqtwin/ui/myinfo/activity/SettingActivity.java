package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/29 0029-下午 18:09
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.rel_pay_pw)
    RelativeLayout relPayPw;
    @BindView(R.id.rel_login_pw)
    RelativeLayout relLoginPw;
    @BindView(R.id.tv_login_out)
    TextView tvLoginOut;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
        centerTitle.setText("设置密码");

    }


    @OnClick({R.id.iv_back, R.id.rel_back, R.id.rel_pay_pw, R.id.rel_login_pw, R.id.tv_login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_pay_pw:
                SettingPassWordActivity.gotoSettingPwActivity(this, "支付密码");

                break;
            case R.id.rel_login_pw:
                SettingPassWordActivity.gotoSettingPwActivity(this, "登录密码");

                break;
            // 退出登录
            case R.id.tv_login_out:
                if (isLogin()) {
                    UserUtil.setLoginInfo(null);
                    showShortToast("已完成退出登录");

                } else
                    showShortToast("您未登录");

                break;

        }
    }


}