package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 充值界面
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
        relSearch.setVisibility(View.GONE);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("充值");
        relSearch.setVisibility(View.GONE);
    }




    @OnClick({R.id.rel_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                String MoneyNum = edMoney.getText().toString().trim();
                SelectChargeActivity.gotoSelectChargeActivity(this,Integer.parseInt(MoneyNum));
                break;
        }
    }
}
