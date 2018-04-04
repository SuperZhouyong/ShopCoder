package com.intention.sqtwin.ui.main.fragment;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class MyInfoFragment extends BaseFragment {

    private static final int USER_INFO_CODE = 55;
    @BindView(R.id.rel_basic_info)
    RelativeLayout relBasicInfo;
    @BindView(R.id.rel_invite_bage)
    RelativeLayout relInviteBage;
    @BindView(R.id.rel_my_collect)
    LinearLayout relMyCollect;
    @BindView(R.id.rel_my_assexxment)
    LinearLayout relMyAssexxment;
    @BindView(R.id.rel_purchased)
    LinearLayout relPurchased;
    @BindView(R.id.rel_my_setting)
    RelativeLayout relMySetting;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_info)
    TextView tvUserInfo;
    @BindView(R.id.iv_user_sex)
    ImageView ivUserSex;
    //    @BindView(R.id.refresh_layout)
//    SmartRefreshLayout refreshLayout;
    @BindView(R.id.tv_bonus_num)// 红包余额
            TextView bonusNum;
    @BindView(R.id.tv_assessment_num)// 智能测评数量
            TextView assessmentNum;
    @BindView(R.id.tv_recommend_num)// 智能推荐数量
            TextView recommendNum;
    @BindView(R.id.tv_report_num)// 大数据报告数量
            TextView reportNum;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_my_new;
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {}


}
