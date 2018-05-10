package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
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
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.fragment.SimpleCardFragment;
import com.intention.sqtwin.ui.myinfo.fragment.OrderListFragment;
import com.intention.sqtwin.widget.SlidingTabLayout;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
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
    private String[] mTitles = {"全部","未付款","已发货","已收货"};
    private BasePageStateAdapter basePageStateAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_orderlist;
    }

    @Override
    public void initPresenter() {

    }
    public static OrderListFragment getInstance(String title, Integer category_id) {
        OrderListFragment sf = new OrderListFragment();
        sf.mTitle = title;
        sf.category_id = category_id;
        return sf;
    }
    @Override
    public void initView() {
        slidTabLayout.setOnTabSelectListener(this);
//        List<PpAllDateBean.DataBeanX.MainCategoryBean> main_category = allDateBean.getData().getMain_category();
        for (String s:mTitles){

        }

        basePageStateAdapter = new BasePageStateAdapter(getSupportFragmentManager(), mFragments, Arrays.asList(mTitles));
        viewpager.setAdapter(basePageStateAdapter);
        slidTabLayout.setViewPager(viewpager);
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
