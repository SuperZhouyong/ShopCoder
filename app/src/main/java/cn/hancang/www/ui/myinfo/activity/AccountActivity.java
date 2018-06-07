package cn.hancang.www.ui.myinfo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.AccountBean;
import cn.hancang.www.ui.Store.activity.TradingDetailActivity;
import cn.hancang.www.ui.myinfo.contract.AccountContract;
import cn.hancang.www.ui.myinfo.model.AccountModel;
import cn.hancang.www.ui.myinfo.presenter.AccountPresenter;

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
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("账户");
//        relSearch.setVisibility(View.GONE);
        ivSearch.setImageResource(R.mipmap.contact_editinfo);
        mPresenter.getAccountBeanRequest(null);
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
        if (!accountBean.isIs_success()) {
            showShortToast(accountBean.getMessage());
            return;
        }
//        tv_num_one
        tvNumOne.setText(accountBean.getData().getAvailable_predeposit());
//        tv_money_num
        tvMoneyNum.setText("￥ " + accountBean.getData().getFreeze_predeposit());

    }


    @OnClick({R.id.rel_back, R.id.tv_bank_card_manager, R.id.tv_Transaction_manage, R.id.rel_search, R.id.tv_recharge, R.id.tv_withdrawal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 提现
            case R.id.tv_withdrawal:
               ChargeActivity.gotoChargeActivity(this, AppConstant.twoMessage);
                break;
            //充值
            case R.id.tv_recharge:
                ChargeActivity.gotoChargeActivity(this, AppConstant.oneMessage);
                break;
            case R.id.rel_back:
                finish();
                break;
            // 银行卡管理
            case R.id.tv_bank_card_manager:
                startActivity(BindBankCardActivity.class);
                break;
            // 交易明细
            case R.id.tv_Transaction_manage:
                startActivity(TradingDetailActivity.class);
                break;
            case R.id.rel_search:
                showContractDialog();
                break;
        }
    }
}
