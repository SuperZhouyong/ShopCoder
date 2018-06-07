package cn.hancang.www.ui.Store.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.listener.OnTabSelectListener;
import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.BasePageStateAdapter;
import cn.hancang.www.ui.Store.fragment.StoreInfoComFragement;
import cn.hancang.www.widget.SlidingTabLayout;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午1:22
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreFocusActivity extends BaseActivity implements OnTabSelectListener {

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
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles = {"拍品", "拍场", "拍卖机构", "艺术家", "店铺"};

    private BasePageStateAdapter basePageStateAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_storefocus;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("关注中心");
        relSearch.setVisibility(View.GONE);
        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(StoreInfoComFragement.getInstance(mTitles[i], i + 1));
        }
        slidTabLayout.setOnTabSelectListener(this);
        basePageStateAdapter = new BasePageStateAdapter(getSupportFragmentManager(), mFragments, Arrays.asList(mTitles));
        viewpager.setAdapter(basePageStateAdapter);
        slidTabLayout.setViewPager(viewpager);
    }


    @Override
    public void onTabSelect(int i) {

    }

    @Override
    public void onTabReselect(int i) {

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
}
