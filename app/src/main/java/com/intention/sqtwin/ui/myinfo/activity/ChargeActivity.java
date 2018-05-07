package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description: 保佑无bug
 * Data：2018/5/8-上午1:26
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ChargeActivity extends BaseActivity {
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
    @BindView(R.id.tv_symbol)
    TextView tvSymbol;
    @BindView(R.id.ed_money)
    ClearEditText edMoney;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_charge;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }


}
