package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.OrderIdBean;
import com.intention.sqtwin.bean.TellBackBean;
import com.intention.sqtwin.ui.myinfo.contract.SelectChargeContract;
import com.intention.sqtwin.ui.myinfo.model.SelectChargeModel;
import com.intention.sqtwin.ui.myinfo.presenter.SelectChargePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SelectChargeActivity extends BaseActivity<SelectChargePresenter, SelectChargeModel> implements SelectChargeContract.View {
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
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.iv_wx_pay)
    ImageView ivWxPay;
    @BindView(R.id.rel_wx_pay)
    RelativeLayout relWxPay;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.rel_ali_pay)
    RelativeLayout relAliPay;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.cb_check)
    CheckBox cbCheck;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;

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
    public void returnOrderIdData(OrderIdBean orderIdBean) {

    }

    @Override
    public void tellBackOrderId(TellBackBean tellBackBean) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_selectcharge;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        int moneyNum = getIntent().getExtras().getInt(AppConstant.Moneynum);
    }

    public static void gotoSelectChargeActivity(Context context, int moneyNum) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.Moneynum, moneyNum);
        ((BaseActivity) context).startActivity(SelectChargeActivity.class, bundle);
    }



    @OnClick({R.id.rel_back, R.id.tv_confirm, R.id.tv_agreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.tv_confirm:
                break;
            case R.id.tv_agreement:
                break;
        }
    }
}
