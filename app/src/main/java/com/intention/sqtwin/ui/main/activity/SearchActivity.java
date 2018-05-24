package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.widget.ClearEditText;
import com.intention.sqtwin.widget.flow.FlowTagLayout;
import com.intention.sqtwin.widget.flow.TagAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/18 0018-下午 16:24
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SearchActivity extends BaseActivity {
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
    @BindView(R.id.activity_search_return)
    TextView activitySearchReturn;
    @BindView(R.id.search_iv)
    ImageView searchIv;
    @BindView(R.id.search_et)
    ClearEditText searchEt;
    @BindView(R.id.activity_search_head)
    RelativeLayout activitySearchHead;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    @BindView(R.id.tag_flow)
    FlowTagLayout tagFlow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("搜索");
        relSearch.setVisibility(View.GONE);


        TagAdapter tagAdapter = new TagAdapter(this);
        tagFlow.setAdapter(tagAdapter);
    }


    @OnClick({R.id.rel_back, R.id.activity_search_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.activity_search_return:
                break;

        }
    }


}
