package cn.hancang.www.ui.myinfo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.BasePageStateAdapter;
import cn.hancang.www.ui.main.fragment.SimpleCardFragment;
import cn.hancang.www.ui.myinfo.fragment.MyCompeteNewFragment;
import cn.hancang.www.widget.SlidingTabLayout;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

/**
 * Description: 保佑无bug
 * Data：2018/6/15-下午10:58
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteNewActivity extends BaseActivity {
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
    private String[] mTitles = {"拍卖中", "已成交"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private BasePageStateAdapter basePageStateAdapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mycompetenew;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        centerTitle.setText("我的参拍");
        relSearch.setVisibility(View.GONE);
        for (int i = 0; i < mTitles.length; i++) {
            mFragments.add(MyCompeteNewFragment.getInstance(mTitles[i], i));
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
}
