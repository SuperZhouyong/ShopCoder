package cn.hancang.www.ui.myinfo.activity;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;

import butterknife.BindView;

/**
 * Description: 保佑无bug
 * Data：2018/5/8-上午1:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ChargeWayActivity extends BaseActivity {
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
    public int getLayoutId() {
        return R.layout.activity_chargeway;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }


}
