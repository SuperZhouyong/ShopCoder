package com.intention.sqtwin.ui.myinfo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.base.BasePageStateAdapter;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.ui.myinfo.fragment.OrderListFragment;
import com.intention.sqtwin.widget.SlidingTabLayout;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 会员，店铺 共用的一个列表
 * Data：2018/5/10-上午12:09
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListActivity extends BaseActivity implements OnTabSelectListener {
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
    @BindView(R.id.slid_tab_layout)
    SlidingTabLayout slidTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private String[] mTitles = {"全部", "未付款", "已发货", "已收货"};
    private BasePageStateAdapter basePageStateAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_orderlist;
    }

    @Override
    public void initPresenter() {

    }

    /**
     *
     * @param activity
     * @param status 订单状态：0:已取消 10:未付款 20:已付款 30:已发货 40:已收货
     * @param type  0=商城订单；1=拍卖订单
     */
    public static void GotoOrderListActivity(BaseActivity activity, Integer status, Integer type) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.OrderListStatus, status);
        bundle.putInt(AppConstant.OrderListStatusType, type);
        activity.startActivity(OrderListActivity.class, bundle);


    }

    @Override
    public void initView() {
        int mOrderListStatus = getIntent().getExtras().getInt(AppConstant.OrderListStatus, 0);
        int mOdeerListStatusType = getIntent().getExtras().getInt(AppConstant.OrderListStatusType, 1);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("订单列表");
        relSearch.setVisibility(View.GONE);

        slidTabLayout.setOnTabSelectListener(this);
//        List<PpAllDateBean.DataBeanX.MainCategoryBean> main_category = allDateBean.getData().getMain_category();
        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(OrderListFragment.getInstance(mTitles[i], i, mOdeerListStatusType));
        }

        basePageStateAdapter = new BasePageStateAdapter(getSupportFragmentManager(), mFragments, Arrays.asList(mTitles));
        viewpager.setAdapter(basePageStateAdapter);
        slidTabLayout.setViewPager(viewpager);

        slidTabLayout.setCurrentTab(mOrderListStatus);
    }


    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
        }
    }

    @Override
    public void onTabSelect(int i) {

    }

    @Override
    public void onTabReselect(int i) {

    }
}
