package com.intention.sqtwin.ui.Store.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.widget.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 选择进入个人还是企业认证
 * Data：2018/5/18-下午9:47
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RealCerOneActivity extends BaseActivity {
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

    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_to_cer)
    TextView tvToCer;
    @BindView(R.id.ll_one_peo)
    LinearLayout llOnePeo;
    @BindView(R.id.ll_one_enter)
    LinearLayout llOneEnter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_realcerone;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("实名认证");
        relSearch.setVisibility(View.GONE);
    }


    @OnClick({R.id.rel_back, R.id.ll_one_peo, R.id.ll_one_enter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.ll_one_peo:
                startActivity(RealNamePeoOneActivity.class);
                break;
            case R.id.ll_one_enter:
                startActivity(RealNameEnterOneActivity.class);
                break;
        }
    }
}
