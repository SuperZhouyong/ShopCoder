package com.intention.sqtwin.ui.Store.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.base.BasePageStateAdapter;
import com.intention.sqtwin.ui.Store.fragment.StoreReportOneFragment;
import com.intention.sqtwin.ui.Store.fragment.StoreReportTwoFragment;
import com.intention.sqtwin.widget.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/21 0021-上午 10:57
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreReportActivity extends BaseActivity implements OnTabSelectListener {
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
    @BindView(R.id.slid_tab_layout)
    SlidingTabLayout slidTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private String[] mTitles = {"资金报表", "经营报表"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BasePageStateAdapter basePageStateAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_storereport;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("资金报表");
        relSearch.setVisibility(View.GONE);

        mFragments.add(StoreReportOneFragment.getInstance(mTitles[0], 0));
        mFragments.add(StoreReportTwoFragment.getInstance(mTitles[1], 1));
        basePageStateAdapter = new BasePageStateAdapter(getSupportFragmentManager(), mFragments, Arrays.asList(mTitles));
        viewpager.setAdapter(basePageStateAdapter);
        slidTabLayout.setViewPager(viewpager);
        slidTabLayout.setOnTabSelectListener(this);
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
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }
}
