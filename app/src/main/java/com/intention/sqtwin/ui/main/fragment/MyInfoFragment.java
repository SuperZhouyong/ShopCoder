package com.intention.sqtwin.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.base.LazzyFragment;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.ui.myinfo.activity.AccountActivity;
import com.intention.sqtwin.ui.myinfo.activity.IdentityProveActivity;
import com.intention.sqtwin.ui.myinfo.activity.MessageActicity;
import com.intention.sqtwin.ui.myinfo.activity.MyCompeteActivity;
import com.intention.sqtwin.ui.myinfo.activity.OrderListActivity;
import com.intention.sqtwin.ui.myinfo.contract.MyCompeteContract;

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
    @BindView(R.id.rel_identit)
    RelativeLayout relIdentit;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.rel_setting)
    RelativeLayout relSetting;
    @BindView(R.id.iv_help)
    ImageView ivHelp;
    @BindView(R.id.rel_help)
    RelativeLayout relHelp;
    @BindView(R.id.iv_store_manage)
    ImageView ivStoreManage;
    @BindView(R.id.rel_store_mange)
    RelativeLayout relStoreMange;
    @BindView(R.id.iv_focus)
    ImageView ivFocus;
    @BindView(R.id.rel_focus)
    RelativeLayout relFocus;


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_myinfo;
    }

    @Override
    protected void RequestNetWorkData() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .getMyInfoBean()
                .compose(RxSchedulers.<MyInfoBean>io_main())
                .subscribe(new RxSubscriber<MyInfoBean>(getActivity()) {
                    @Override
                    protected void _onNext(MyInfoBean myInfoBean) {

                    }

                    @Override
                    protected void _onError(String message) {

                    }
                }));
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {


    }


    @OnClick({R.id.iv_shareicon, R.id.iv_head_icon, R.id.ll_one, R.id.ll_two, R.id.ll_three, R.id.rel_message, R.id.rel_acount, R.id.rel_mycompete, R.id.rel_identit, R.id.rel_setting, R.id.rel_help, R.id.rel_store_mange, R.id.rel_focus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_shareicon:
                break;
            case R.id.iv_head_icon:
                break;
            case R.id.ll_one:
                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_two:
                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_three:
                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.rel_message:
                startActivity(getActivity(), MessageActicity.class);
                break;
            case R.id.rel_acount:
                startActivity(getActivity(), AccountActivity.class);
                break;
            case R.id.rel_mycompete:
                startActivity(getActivity(), MyCompeteActivity.class);
                break;
            case R.id.rel_identit:
                startActivity(getActivity(), IdentityProveActivity.class);
                break;
            case R.id.rel_setting:

                break;
            case R.id.rel_help:
                break;
            case R.id.rel_store_mange:
                break;
            case R.id.rel_focus:
                break;
        }
    }

}
