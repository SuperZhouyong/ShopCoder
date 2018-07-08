package cn.hancang.www.ui.main.activity;


import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.adapter.SearchAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.ChooseBean1;
import cn.hancang.www.bean.HotSearchInfoBean;
import cn.hancang.www.bean.SearchInfoBean;
import cn.hancang.www.ui.main.contract.SearchContract;
import cn.hancang.www.ui.main.model.SearchModel;
import cn.hancang.www.ui.myinfo.presenter.SearchPresenter;
import cn.hancang.www.widget.ClearEditText;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import cn.hancang.www.widget.flow.FlowTagLayout;
import cn.hancang.www.widget.flow.OnTagClickListener;
import cn.hancang.www.widget.flow.TagAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/18 0018-下午 16:24
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SearchActivity extends BaseActivity<SearchPresenter, SearchModel> implements SearchContract.View, OnTagClickListener, ClearEditText.SearchInterface, View.OnKeyListener, LoadingTip.onReloadListener, OnLoadMoreListener {
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


    @BindView(R.id.tag_flow)
    FlowTagLayout tagFlow;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.rel_search_info)
    RelativeLayout relSearchInfo;
    private TagAdapter tagAdapter;
    private SearchAdapter searchAdapter;
    private LRecyclerViewAdapter mLadapter;
    private Integer page = 0;
    private String sSerchName;
    private int pagesize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("搜索");
        relSearch.setVisibility(View.GONE);
//        ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();
//        customTabEntities.add(new TabsEntity(""))
//        tabLayout.setTabData();
        tagAdapter = new TagAdapter(this);
        tagFlow.setAdapter(tagAdapter);
        tagFlow.setOnTagClickListener(this);
        searchEt.setSearchInterface(this);
        searchEt.setOnKeyListener(this);
        searchAdapter = new SearchAdapter(this);
        mLadapter = new LRecyclerViewAdapter(searchAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setOnLoadMoreListener(this);
        mLRecyclerView.setPullRefreshEnabled(false);

        View homeHeadTitleOnew = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) homeHeadTitleOnew.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("拍品");
        viewById1.getPaint().setFlags(Paint.FAKE_BOLD_TEXT_FLAG);
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);
        mLadapter.addHeaderView(homeHeadTitleOnew);


        mPresenter.getHotSearchInfoRequest();
    }


    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        mLRecyclerView.refreshComplete(pagesize);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.twoMessage.equals(RequestId) && page == 0) {
            relSearchInfo.setVisibility(View.VISIBLE);
            tagFlow.setVisibility(View.INVISIBLE);
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }


    @Override
    public void returnSearchInfo(SearchInfoBean searchInfoBean) {
        relSearchInfo.setVisibility(View.VISIBLE);
        tagFlow.setVisibility(View.INVISIBLE);
        if (!searchInfoBean.isIs_success()) {
            showShortToast(searchInfoBean.getMessage());
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page >= searchInfoBean.getData().getPage_count()) {
            mLRecyclerView.setNoMore(true);
            return;
        }
        searchAdapter.addAll(searchInfoBean.getData().getItem_list());
        ++page;
    }

    @Override
    public void returnHotSearchInfo(HotSearchInfoBean hotSearchInfoBean) {
        if (!hotSearchInfoBean.isIs_success()) {
            showShortToast(hotSearchInfoBean.getMessage());
            return;
        }
        ArrayList<ChooseBean1> chooseBean1s = new ArrayList<>();
        for (String s : hotSearchInfoBean.getData()) {
            chooseBean1s.add(new ChooseBean1(s));
        }
        tagAdapter.onlyAddAll(chooseBean1s);
    }

    @Override
    public void onItemClick(FlowTagLayout parent, View view, int position) {
        searchEt.setText(tagAdapter.getItem(position).getName());
        searchEt.setSelection(tagAdapter.getItem(position).getName().length());
        searchEt.requestFocus();
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(
                searchEt, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public void UpdateSearchResult(String ImportText) {

    }

    @Override
    public void UpdateEmptyImpore() {
        relSearchInfo.setVisibility(View.INVISIBLE);
        tagFlow.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//            tagFlow.setVisibility(View.INVISIBLE);
//            if (searchEt.getText().)
            sSerchName = searchEt.getText().toString().trim();
            if (TextUtils.isEmpty(sSerchName)) {
                showShortToast("请输入有效内容");
                return false;
            }
            // 可以加载更多
            mLRecyclerView.setNoMore(false);
            mPresenter.getSearchInfoRequest(sSerchName, page);
        }

        return false;
    }


    @OnClick({R.id.rel_back, R.id.activity_search_return})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.activity_search_return:
                finish();
                break;

        }
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getSearchInfoRequest(sSerchName, page);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getSearchInfoRequest(sSerchName, page);
    }
}
