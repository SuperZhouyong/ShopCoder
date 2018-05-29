package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.PayPassWordBean;
import com.intention.sqtwin.ui.myinfo.contract.SettingPassWordContract;
import com.intention.sqtwin.ui.myinfo.model.SettingPassWordModel;
import com.intention.sqtwin.ui.myinfo.presenter.SettingPassWordPresenter;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/30-上午12:40
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SettingPassWordActivity extends BaseActivity<SettingPassWordPresenter, SettingPassWordModel> implements SettingPassWordContract.View {
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
    @BindView(R.id.ed_one)
    ClearEditText edOne;
    @BindView(R.id.ed_two)
    ClearEditText edTwo;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    private String mTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_settingpw;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
        mTitle = getIntent().getExtras().getString(AppConstant.SettingPw);
        centerTitle.setText(mTitle);
        if (mTitle.equals("支付密码")) {
            edOne.setHint("请输入6位数字密码");
            edTwo.setHint("请再次输入6位数字密码");
        } else {
            edOne.setHint("请输入密码");
            edTwo.setHint("请再次输入密码");
        }

    }

    public static void gotoSettingPwActivity(BaseActivity baseActivity, String SettingPwType) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.SettingPw, SettingPwType);
        baseActivity.startActivity(SettingPassWordActivity.class, bundle);
    }

    @OnClick({R.id.rel_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                String oldPw = edOne.getText().toString().trim();
                String newPw = edTwo.getText().toString().trim();
                if (TextUtils.isEmpty(oldPw) || TextUtils.isEmpty(newPw)) {
                    showShortToast("请检查填写的密码");
                    return;
                }
                if (!oldPw.equals(newPw)) {
                    showShortToast("两次密码填写不一致，请修改");
                    return;
                }
                if (mTitle.equals("支付密码")) {
                    mPresenter.getPayRequest(oldPw);
                } else {
                    mPresenter.getLoginRequest(oldPw);
                }

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
    public void returnPayPassWordBean(PayPassWordBean payPassWordBean) {
        showShortToast(payPassWordBean.getMessage());
        if (payPassWordBean.isIs_success())
            finish();
    }

    @Override
    public void returnLoginPassWordBean(PayPassWordBean payPassWordBean) {
        showShortToast(payPassWordBean.getMessage());
        if (payPassWordBean.isIs_success())
            finish();
    }
}
