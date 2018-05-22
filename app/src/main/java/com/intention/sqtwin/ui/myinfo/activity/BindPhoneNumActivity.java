package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/18-上午1:15
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BindPhoneNumActivity extends BaseActivity {
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
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.ec_name)
    EditText ecName;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.ec_bank)
    EditText ecBank;
    @BindView(R.id.auth_code_time)
    TextView authCodeTime;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bindphonenum;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("绑定手机");
        relSearch.setVisibility(View.GONE);

    }


    @OnClick({R.id.rel_back, R.id.auth_code_time, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.auth_code_time:
                break;
            case R.id.tv_confirm:
                String PhoneNum = ecName.getText().toString();
                if (TextUtils.isEmpty(PhoneNum))
                    showShortToast("请输入正确的手机号");
                Intent intent = new Intent();
                intent.putExtra(AppConstant.PhoneNum, PhoneNum);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
