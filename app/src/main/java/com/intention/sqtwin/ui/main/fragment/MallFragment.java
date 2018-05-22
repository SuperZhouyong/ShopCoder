package com.intention.sqtwin.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.HeadTwoAdapter;
import com.intention.sqtwin.adapter.HomeAdapter;
import com.intention.sqtwin.adapter.MallAdapter;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.bean.AllMallDateBean;
import com.intention.sqtwin.ui.main.contract.MallContract;
import com.intention.sqtwin.ui.main.model.MallModel;
import com.intention.sqtwin.ui.main.presenter.MallPresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.Unbinder;
import ezy.ui.view.BannerView;

/**
 * Description: 商城列表
 * Data：2018/4/15-下午2:48
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallFragment extends BaseFragment<MallPresenter, MallModel> implements MallContract.View {
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
//    private HomeAdapter homeAdapter;

    private MallAdapter mallAdapter ;
    private LRecyclerViewAdapter mLadapter;
    private BannerView mBannerView;
    private HeadTwoAdapter mHeadTwoAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mall;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
//        homeAdapter = new HomeAdapter(getActivity());
        mallAdapter = new MallAdapter(getActivity());
        mLadapter = new LRecyclerViewAdapter(mallAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));
        // 第一个轮播图
        View headViewPager = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview, null);
        mBannerView = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);
        // 推荐店铺标题
        View homeStoreTitle = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewByIdStore = (TextView) homeStoreTitle.findViewById(R.id.yv_all_recy_head_title);
        viewByIdStore.setText("推荐店铺");
        setMarGinTop(viewByIdStore, (int) getResources().getDimension(R.dimen.x22), 0);

        View HeadStoreView = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        mHeadTwoAdapter = new HeadTwoAdapter(getActivity());
        RecyclerView mRecyclerViewStore = (RecyclerView) HeadStoreView.findViewById(R.id.mRecyclerView);
        mRecyclerViewStore.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mRecyclerViewStore.setAdapter(mHeadTwoAdapter);


        // 推荐作品标题
        View homeHeadTitleOnew = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) homeHeadTitleOnew.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐作品");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);
        // 推荐作品的列表
        View HeadViewTwo = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        mHeadTwoAdapter = new HeadTwoAdapter(getActivity());
        RecyclerView mRecyclerView = (RecyclerView) HeadViewTwo.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mHeadTwoAdapter);

        // 推荐专场
        View homeHeadTitle = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById = (TextView) homeHeadTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById.setText("推荐专场");
        setMarGinTop(viewById, (int) getResources().getDimension(R.dimen.x22), 0);

        mLadapter.addHeaderView(headViewPager);
        mLadapter.addHeaderView(homeStoreTitle);
        mLadapter.addHeaderView(HeadStoreView);
        mLadapter.addHeaderView(homeHeadTitleOnew);
        mLadapter.addHeaderView(HeadViewTwo);
        mLadapter.addHeaderView(homeHeadTitle);
        mPresenter.getAllMallDateRequest();

    }


    @Override
    public void StartLoading(String RequestId) {

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

    @Override
    public void returnAllMalldate(AllMallDateBean allMallDateBean) {

    }
}
