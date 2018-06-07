package cn.hancang.www.ui.Store.activity;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.api.Api;
import cn.hancang.www.api.HostType;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baserx.RxSchedulers;
import cn.hancang.www.baserx.RxSubscriber;
import cn.hancang.www.bean.StoreMoneyBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/20-上午12:06
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreRemainingMoneyActivity extends BaseActivity {
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
    @BindView(R.id.tv_num_one)
    TextView tvNumOne;
    @BindView(R.id.tv_num_one_com)
    TextView tvNumOneCom;
    @BindView(R.id.tv_num_two_com)
    TextView tvNumTwoCom;
    @BindView(R.id.tv_num_three_com)
    TextView tvNumThreeCom;
    @BindView(R.id.iv_charge)
    ImageView ivCharge;
    @BindView(R.id.rel_charge)
    RelativeLayout relCharge;
    @BindView(R.id.iv_cash)
    ImageView ivCash;
    @BindView(R.id.rel_cash)
    RelativeLayout relCash;
    @BindView(R.id.iv_management_bank)
    ImageView ivManagementBank;
    @BindView(R.id.rel_management_bank)
    RelativeLayout relManagementBank;
    @BindView(R.id.title)
    RelativeLayout relHeadTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_storeremainingmoney;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        relHeadTitle.setBackgroundColor(getResources().getColor(R.color.transparent));
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("店铺余额");
        relSearch.setVisibility(View.GONE);
        RequestStoreMoney();
    }


    @OnClick({R.id.rel_back, R.id.rel_charge, R.id.rel_cash, R.id.rel_management_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            // 充值
            case R.id.rel_charge:
                break;
            // 取现
            case R.id.rel_cash:
                break;
            // 银行卡管理
            case R.id.rel_management_bank:
                break;
        }
    }

    private void RequestStoreMoney() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .get_store_balance()
                .compose(RxSchedulers.<StoreMoneyBean>io_main())
                .subscribe(new RxSubscriber<StoreMoneyBean>(mContext) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected void _onNext(StoreMoneyBean storeMoneyBean) {
                        if (!storeMoneyBean.isIs_success()) {
                            showShortToast(storeMoneyBean.getMessage());
                            return;
                        }
                        StoreMoneyBean.DataBean data = storeMoneyBean.getData();
                        tvNumOne.setText("￥"+data.getBalance() + "");
                        tvNumOneCom.setText(data.getWait_pay() + "");
                        tvNumTwoCom.setText(data.getWait_send() + "");
                        tvNumThreeCom.setText(data.getWait_receive() + "");
                        updateTextColor(tvNumOne,0,1, (int) getResources().getDimension(R.dimen.x25));
                    }

                    @Override
                    protected void _onError(String message) {
                        showShortToast(message);

                    }
                }));
    }
    private void updateTextColor(TextView tv, int starts, int end, int textSize) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan(textSize), starts, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spannedString);
    }
}
