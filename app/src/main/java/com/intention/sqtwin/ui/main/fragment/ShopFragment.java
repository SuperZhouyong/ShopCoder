package com.intention.sqtwin.ui.main.fragment;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class ShopFragment extends BaseFragment{

    @BindView(R.id.RecyclerView_shop)
    RecyclerView RecyclerViewShop;
    @BindView(R.id.rel_boot)
    RelativeLayout relBoot;
    @BindView(R.id.ShopMall_tips)
    LoadingTip mLoadingTip;
    @BindView(R.id.iv_check_box)
    ImageView iv_check_box;
    @BindView(R.id.Tv_total_money)
    TextView Tv_total_money;
    @BindView(R.id.ll_code)
    LinearLayout ll_code;
    @BindView(R.id.ll_more)
    LinearLayout ll_more;
    @BindView(R.id.ll_help)
    LinearLayout ll_help;

    private Boolean ShouldFreshShop = false;

    public int mount = 1;

    @Override
    protected int getLayoutResource() {
        return R.layout.message_fragment;
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {}



}
