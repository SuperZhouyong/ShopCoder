package com.intention.sqtwin.ui.myinfo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.AccountBean;
import com.intention.sqtwin.ui.myinfo.contract.AccountContract;
import com.intention.sqtwin.ui.myinfo.model.AccountModel;
import com.intention.sqtwin.ui.myinfo.presenter.AccountPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/5/10-上午1:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AccountActivity extends BaseActivity<AccountPresenter, AccountModel> implements AccountContract.View {
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
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_num_one)
    TextView tvNumOne;
    @BindView(R.id.rel_head)
    RelativeLayout relHead;
    @BindView(R.id.tv_recharge)
    TextView tvRecharge;
    @BindView(R.id.tv_withdrawal)
    TextView tvWithdrawal;
    @BindView(R.id.tv_money_desc)
    TextView tvMoneyDesc;
    @BindView(R.id.tv_money_num)
    TextView tvMoneyNum;
    @BindView(R.id.tv_bank_card_manager)
    TextView tvBankCardManager;
    @BindView(R.id.tv_Transaction_manage)
    TextView tvTransactionManage;

    @Override
    public int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

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
    public void returnAccountBean(AccountBean accountBean) {

    }


    @OnClick({R.id.rel_back, R.id.tv_bank_card_manager, R.id.tv_Transaction_manage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.tv_bank_card_manager:
                break;
            case R.id.tv_Transaction_manage:
                break;
        }
    }
}
