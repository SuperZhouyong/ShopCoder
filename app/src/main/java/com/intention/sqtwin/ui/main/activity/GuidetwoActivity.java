package com.intention.sqtwin.ui.main.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.base.BaseFragmentAdapter;
import com.intention.sqtwin.ui.main.activity.fragment.FragmentOne;
import com.intention.sqtwin.ui.main.activity.fragment.FragmentThree;
import com.intention.sqtwin.ui.main.activity.fragment.FragmentTwo;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/2/28-下午3:03
 * Blog：Super简单
 * Author: ZhouYong
 */

public class GuidetwoActivity extends BaseActivity {
    @BindView(R.id.vp_guide)
    ViewPager vpGuide;
    private BaseFragmentAdapter baseFragmentAdapter;
    private ArrayList fragments;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guidetwo;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        fragments = new ArrayList<Fragment>();
        FragmentOne one = new FragmentOne();
        FragmentTwo two = new FragmentTwo();
        FragmentThree three = new FragmentThree();
        fragments.add(one);
        fragments.add(two);
        fragments.add(three);
        baseFragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager(),fragments);
        vpGuide.setAdapter(baseFragmentAdapter);
    }

    @OnClick(R.id.tv_next)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                SPUtils.setSharedBooleanData(this, AppConstant.isFirstStart, true);

                startActivity(new Intent(this, MainActivity.class));

                finish();
                break;
        }
    }

}
