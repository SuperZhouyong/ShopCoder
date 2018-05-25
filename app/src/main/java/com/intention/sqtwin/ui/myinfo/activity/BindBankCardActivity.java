package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.BindCardInfoBean;
import com.intention.sqtwin.widget.BankCardTextWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-上午 10:35
 * Blog：Super简单
 * Author: ZhouYong
 */

public class BindBankCardActivity extends BaseActivity {
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
    @BindView(R.id.tv_three)
    TextView tvThree;
    @BindView(R.id.ec_bank_num)
    EditText ecBankNum;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bindbankcard;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("绑定银行卡");
        relSearch.setVisibility(View.GONE);
        BankCardTextWatcher.bind(ecBankNum);
    }


    @OnClick({R.id.rel_back, R.id.rel_search, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
            case R.id.tv_confirm:
                String name = ecName.getText().toString().trim();
                String bankName = ecBank.getText().toString().trim();
                String bankNum = ecBankNum.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(bankName) || TextUtils.isEmpty(bankNum)) {
                    showShortToast("请检查填写的内容");
                    return;
                }
                mRxManager.add(Api.getDefault(HostType.Jsonpart)
                        .getBindCardInfo(name, bankName, bankNum)
                        .compose(RxSchedulers.<BindCardInfoBean>io_main())
                        .subscribe(new RxSubscriber<BindCardInfoBean>(mContext) {
                            @Override
                            protected void _onNext(BindCardInfoBean bindCardInfoBean) {

                            }

                            @Override
                            protected void _onError(String message) {

                            }
                        }));


                break;
        }
    }
}
