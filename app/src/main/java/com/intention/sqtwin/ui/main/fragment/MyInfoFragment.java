package com.intention.sqtwin.ui.main.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.base.LazzyFragment;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.ui.Store.activity.StoreFocusActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.ui.myinfo.activity.AccountActivity;
import com.intention.sqtwin.ui.myinfo.activity.EditInfoActivity;
import com.intention.sqtwin.ui.myinfo.activity.IdentityProveActivity;
import com.intention.sqtwin.ui.myinfo.activity.LoginActivity;
import com.intention.sqtwin.ui.myinfo.activity.MessageActicity;
import com.intention.sqtwin.ui.myinfo.activity.MyCompeteActivity;
import com.intention.sqtwin.ui.myinfo.activity.OrderListActivity;
import com.intention.sqtwin.ui.myinfo.activity.SettingActivity;
import com.intention.sqtwin.ui.myinfo.contract.MyCompeteContract;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;
import com.intention.sqtwin.widget.CircleImageView;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class MyInfoFragment extends LazzyFragment {


    @BindView(R.id.iv_shareicon)
    ImageView ivShareicon;
    @BindView(R.id.iv_head_icon)
    ImageView ivHeadIcon;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.ll_two)
    LinearLayout llTwo;
    @BindView(R.id.ll_three)
    LinearLayout llThree;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.rel_message)
    RelativeLayout relMessage;
    @BindView(R.id.iv_account)
    ImageView ivAccount;
    @BindView(R.id.rel_acount)
    RelativeLayout relAcount;
    @BindView(R.id.iv_mycompete)
    ImageView ivMycompete;
    @BindView(R.id.rel_mycompete)
    RelativeLayout relMycompete;
    @BindView(R.id.iv_identity)
    ImageView ivIdentity;
    /* @BindView(R.id.rel_identit)
     RelativeLayout relIdentit;*/
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.rel_setting)
    RelativeLayout relSetting;
    @BindView(R.id.iv_help)
    ImageView ivHelp;
    /* @BindView(R.id.rel_help)
     RelativeLayout relHelp;*/
    @BindView(R.id.iv_store_manage)
    ImageView ivStoreManage;
    @BindView(R.id.rel_store_mange)
    RelativeLayout relStoreMange;
    @BindView(R.id.iv_focus)
    ImageView ivFocus;
    @BindView(R.id.rel_focus)
    RelativeLayout relFocus;
    @BindView(R.id.tv_name)
    TextView tvname;
    private java.lang.String TAG = "MyInfoFragment";

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_myinfo;
    }

    @Override
    protected void RequestNetWorkData() {

    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {


//        if (!TextUtils.isEmpty(SPUtils.getSharedStringData(getActivity(), AppConstant.ImageUrl)))


    }

    @Override
    public void onResume() {
        super.onResume();
        ImageLoaderUtils.displayRound(getActivity(), ivHeadIcon, SPUtils.getSharedStringData(getActivity(), AppConstant.ImageUrl));
        LogUtils.logd(TAG + "-------------" + SPUtils.getSharedStringData(getActivity(), AppConstant.ImageUrl));
//        if (!TextUtils.isEmpty(SPUtils.getSharedStringData(getActivity(), AppConstant.UserName)))
        tvname.setText(SPUtils.getSharedStringData(getActivity(), AppConstant.UserName));

    }

    // R.id.rel_identit,  R.id.rel_help,
    @OnClick({R.id.iv_shareicon, R.id.ll_one, R.id.ll_two, R.id.ll_three, R.id.rel_message, R.id.rel_acount, R.id.rel_mycompete, R.id.rel_setting, R.id.rel_store_mange, R.id.rel_focus})
    public void onViewClicked(View view) {

        if (!isLogin()) {
            SingleCall.getInstance().clear();
            LoginActivity.start(getActivity());
            return;
        }

        switch (view.getId()) {
            case R.id.iv_shareicon:
                startActivity(getActivity(), EditInfoActivity.class);
                break;

            case R.id.ll_one:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 1, 1);
//                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_two:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 3, 1);
//                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_three:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 0, 1);
//                startActivity(getActivity(), OrderListActivity.class);
                break;
            // 消息
            case R.id.rel_message:
                startActivity(getActivity(), MessageActicity.class);
                break;
            // 资金账户
            case R.id.rel_acount:
                startActivity(getActivity(), AccountActivity.class);
                break;
            // 我的竞拍
            case R.id.rel_mycompete:
                startActivity(getActivity(), MyCompeteActivity.class);
                break;
            // 身份认证
          /*  case R.id.rel_identit:
                startActivity(getActivity(), IdentityProveActivity.class);
                break;*/
            // 设置
            case R.id.rel_setting:
                startActivity(getActivity(), SettingActivity.class);

                break;
         /*   // 帮助中心
            case R.id.rel_help:
                break;*/
            // 店铺管理
            case R.id.rel_store_mange:
                ((MainActivity) getActivity()).setCurrentPostion(2);
                break;
            case R.id.rel_focus:
                // 关注列表
                startActivity(getActivity(), StoreFocusActivity.class);
                break;
        }
    }

}
