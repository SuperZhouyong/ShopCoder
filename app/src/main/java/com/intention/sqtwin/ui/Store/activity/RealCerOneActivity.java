package com.intention.sqtwin.ui.Store.activity;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.RealNameStatusBean;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
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
    ImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
//    @BindView(R.id.tv_to_cer)
//    TextView tvToCer;
    @BindView(R.id.ll_one_peo)
    LinearLayout llOnePeo;
    @BindView(R.id.ll_one_enter)
    LinearLayout llOneEnter;
    @BindView(R.id.rel_desc)
    RelativeLayout relDesc;
    @BindView(R.id.tv_reminder)
    TextView tvReminder;
    @BindView(R.id.togo_over)
    TextView tvGoto;

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
        requestData();
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

    private void requestData() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .getRealNameStatus()
                .compose(RxSchedulers.<RealNameStatusBean>io_main())
                .subscribe(new RxSubscriber<RealNameStatusBean>(mContext) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected void _onNext(RealNameStatusBean realNameStatusBean) {
                        if (!realNameStatusBean.isIs_success()) {
                            showShortToast(realNameStatusBean.getMessage());
                            return;
                        }
                        ImageLoaderUtils.displayRound(mContext, ivHead, realNameStatusBean.getData().getImage());
                        tvName.setText(TextUtils.isEmpty(realNameStatusBean.getData().getName()) ? "" : realNameStatusBean.getData().getName());
                        final int join_type = realNameStatusBean.getData().getJoin_type();
                        final int join_step = realNameStatusBean.getData().getJoin_step();
                        // 之前没有认证过
                        if (join_type == 0) {
                            relDesc.setVisibility(View.GONE);

                        } else {

                            tvReminder.setText("您上次申请" + (join_type == 1 ? "个人实名认证" : "企业实名认证") + "，已经进行到第" + join_step + "步，如果您不继续上次认证，可以点击上面的按钮，重新开始认证");
//                            tvReminder.setText("您上次申请'企业实名认证'，已经进行到第2步，如果您不继续上次认证，可以点击上面的按钮，重新开始认证");
                            tvGoto.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    switch (join_type) {
                                        // 个人认证
                                        case 1:

                                            if (join_step == 1) {
                                                startActivity(RealNamePeoTwoActivity.class);

                                            } else if (join_step == 2) {
                                                StoreInfoCerActivity.gotoTheActivity(RealCerOneActivity.this, AppConstant.RealNameTypeOne);
                                            }


                                            break;
                                        // 企业认证
                                        case 2:
                                            if (join_step == 1) {
                                                startActivity(RealNameEnterTwoActivity.class);

                                            } else if (join_step == 2) {
                                                startActivity(RealNameEnterThreeActivity.class);
                                            } else {
                                                StoreInfoCerActivity.gotoTheActivity(RealCerOneActivity.this, AppConstant.RealNameTypeOne);
                                            }
                                            break;


                                    }


                                }
                            });

                            updateTextColor(tvReminder,
                                    tvReminder.getText().toString().trim().indexOf("认证")-4,
                                    tvReminder.getText().toString().trim().indexOf("认证")+2,
                                    tvReminder.getText().toString().trim().indexOf("第")+1,
                                    tvReminder.getText().toString().trim().indexOf("第")+2,
                                    getResources().getColor(R.color.app_main));
//                            updateTextColor(tvReminder,tvReminder.getText().toString().trim().indexOf("第")+1,tvReminder.getText().toString().trim().indexOf("第")+2,getResources().getColor(R.color.app_main));
                        }

                    }

                    @Override
                    protected void _onError(String message) {

                    }
                }));

    }

    private void updateTextColor(TextView tv, int starts, int end,int start2,int eend2, int textSize) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), start2, eend2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new ForegroundColorSpan(textSize), starts, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }
}
