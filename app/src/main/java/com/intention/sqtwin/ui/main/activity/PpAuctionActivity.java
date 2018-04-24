package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.PpAuctionAdapter;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;
import com.intention.sqtwin.ui.main.model.PpAuctionModel;
import com.intention.sqtwin.ui.main.presenter.PpAuctionPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ezy.ui.view.BannerView;

/**
 * Description: 保佑无bug
 * Data：2018/4/23-下午11:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionActivity extends BaseActivity<PpAuctionPresenter, PpAuctionModel> implements PpAuctionContract.View, OnLoadMoreListener, OnTabSelectListener {
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private LRecyclerViewAdapter mLAdapter;
    private PpAuctionAdapter mAdapter;
    private SlidingTabLayout sTabLayout;
    private BannerView mBannerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ppauction;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        mAdapter = new PpAuctionAdapter(this);
        mLAdapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLAdapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setLoadMoreEnabled(true);
        mRecyclerView.setOnLoadMoreListener(this);

        View headView_pp = getLayoutInflater().inflate(R.layout.item_ppauction_head, null);
        sTabLayout = (SlidingTabLayout) headView_pp.findViewById(R.id.slid_tab_layout);
        mBannerView = (BannerView) headView_pp.findViewById(R.id.mLoopViewPager);

        mLAdapter.addHeaderView(headView_pp);

        mPresenter.getPpAlldate(0, 0, 0);

    }


    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {

    }

    /**
     * 返回所有数据
     *
     * @param allDateBean
     */
    @Override
    public void returnPpAllDate(PpAllDateBean allDateBean) {
        if (!allDateBean.isIs_success()) {

            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
                @Override
                public void reload() {
                    mPresenter.getPpAlldate(0, 0, 0);
                }
            });
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        // 头部
        sTabLayout.setOnTabSelectListener(this);
        List<PpAllDateBean.DataBean.MainCategoryBean> main_category = allDateBean.getData().getMain_category();
        String[] mTitles = new String[main_category.size()];
        for (int i = 0; i < main_category.size(); i++) {
            mTitles[i] = main_category.get(i).getName();
        }
        mBannerView.setViewFactory(new BannerView.ViewFactory<PpAllDateBean.DataBean.AdvBean>() {
            @Override
            public View create(PpAllDateBean.DataBean.AdvBean advBean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, advBean.getImage());
                return iv;
            }
        });
        mBannerView.setDataList(allDateBean.getData().getAdv());
        mBannerView.start();

        sTabLayout.setViewPager(mBannerView.getViewPager());
//        sTabLayout.setViewPager(mBannerView.getViewPager(),mTitles);
//        sTabLayout.addTouchables();





        mAdapter.addAll(allDateBean.getData().getAuction_field_list());
    }

    /**
     * 记载更多
     */
    @Override
    public void onLoadMore() {

    }

    /**
     * 选择某一个条目
     *
     * @param i
     */
    @Override
    public void onTabSelect(int i) {

    }

    @Override
    public void onTabReselect(int i) {

    }
}
