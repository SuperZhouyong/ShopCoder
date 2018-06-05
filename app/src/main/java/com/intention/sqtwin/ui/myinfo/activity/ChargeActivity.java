package com.intention.sqtwin.ui.myinfo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
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
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    private float fMoneyNum;

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
        relSearch.setVisibility(View.GONE);
        if (AppConstant.oneMessage.equals(getIntent().getExtras().getString(AppConstant.ChargeType))) {
            centerTitle.setText("充值");
            tvDesc.setText("请输入充值金额");
        } else {
            centerTitle.setText("提现");
            tvDesc.setText("请输入提现金额");
        }
    }


    @OnClick({R.id.rel_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                if (AppConstant.oneMessage.equals(getIntent().getExtras().getString(AppConstant.ChargeType))) {
                    String MoneyNum = edMoney.getText().toString().trim();
                    try {
                        fMoneyNum = Float.parseFloat(MoneyNum);
                    } catch (Exception e) {
                        showShortToast("请输入正确的金额");
                        return;
                    }
                    SelectChargeActivity.gotoSelectChargeActivity(this, fMoneyNum);

                } else {
                    // 进入提现的操作
                }
                break;
        }
    }

    public static void gotoChargeActivity(Activity activity, String Type) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.ChargeType, Type);
        ((BaseActivity) activity).startActivity(ChargeActivity.class, bundle);
    }
}
