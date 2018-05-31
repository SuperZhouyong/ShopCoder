package com.intention.sqtwin.ui.myinfo.activity;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.OrderIdBean;
import com.intention.sqtwin.bean.TellBackBean;
import com.intention.sqtwin.ui.myinfo.contract.SelectChargeContract;
import com.intention.sqtwin.ui.myinfo.model.SelectChargeModel;
import com.intention.sqtwin.ui.myinfo.presenter.SelectChargePresenter;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SelectChargeActivity extends BaseActivity<SelectChargePresenter, SelectChargeModel> implements SelectChargeContract.View {
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
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

    }
}
