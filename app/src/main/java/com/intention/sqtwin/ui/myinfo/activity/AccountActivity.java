package com.intention.sqtwin.ui.myinfo.activity;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.AccountBean;
import com.intention.sqtwin.ui.myinfo.contract.AccountContract;
import com.intention.sqtwin.ui.myinfo.model.AccountModel;
import com.intention.sqtwin.ui.myinfo.presenter.AccountPresenter;

/**
 * Description: 保佑无bug
 * Data：2018/5/10-上午1:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AccountActivity extends BaseActivity<AccountPresenter,AccountModel> implements AccountContract.View {
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
}
