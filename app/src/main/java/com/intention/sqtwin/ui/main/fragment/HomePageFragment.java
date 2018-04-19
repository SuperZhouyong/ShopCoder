package com.intention.sqtwin.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.HeadTwoAdapter;
import com.intention.sqtwin.adapter.HomeAdapter;
import com.intention.sqtwin.base.BannerViewFactory;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.bean.RecommendField;
import com.intention.sqtwin.bean.RecommendedLots;
import com.intention.sqtwin.bean.ShufflingPictureBean;
import com.intention.sqtwin.ui.main.contract.MainContract;
import com.intention.sqtwin.ui.main.model.MainModel;
import com.intention.sqtwin.ui.main.presenter.MainPresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import ezy.ui.view.BannerView;


/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class HomePageFragment extends BaseFragment<MainPresenter, MainModel> implements MainContract.View {
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;

    private LRecyclerViewAdapter mLadapter;
    // 末尾的adapter
    private HomeAdapter homeAdapter;
    private BannerView mBannerView;
    private HeadTwoAdapter mHeadTwoAdapter;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_homepage;

    }


    // MVP 关联的一步
    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    // 初始化全部的布局
    @Override
    protected void initView() {
        mPresenter.getViewpagerPic("首页1", 1);
        homeAdapter = new HomeAdapter(getActivity(), R.layout.item_homepage);
        mLadapter = new LRecyclerViewAdapter(homeAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);
        View headViewPager = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview, null);

        mBannerView = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);
        mBannerView.setIsAuto(true);
        mPresenter.getRecommentLots("");
        mPresenter.getRecommentFILED("");

        View HeadViewTwo = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        mHeadTwoAdapter = new HeadTwoAdapter(getActivity());
        RecyclerView mRecyclerView = (RecyclerView) HeadViewTwo.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mHeadTwoAdapter);

        mLadapter.addHeaderView(headViewPager);
        mLadapter.addHeaderView(HeadViewTwo);
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
     * @param shufflingPictureBean 轮播图
     */
    @Override
    public void returnViewpagerPic(ShufflingPictureBean shufflingPictureBean) {
        mBannerView.setViewFactory(new BannerViewFactory());
        mBannerView.setDataList(shufflingPictureBean.getData());
        mBannerView.start();

    }

    /**
     *
     * @param recommendedLots 推荐拍品
     */
    @Override
    public void returnRecommendedLot(RecommendedLots recommendedLots) {

        mHeadTwoAdapter.addAll(recommendedLots.getData());
    }

    /**
     *
     * @param recommendField 推荐专场
     */
    @Override
    public void returnRecommendField(RecommendField recommendField) {
        homeAdapter.addAll(recommendField.getData());

    }


}
