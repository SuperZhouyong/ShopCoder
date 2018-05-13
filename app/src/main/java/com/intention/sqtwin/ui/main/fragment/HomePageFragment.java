package com.intention.sqtwin.ui.main.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.HeadTwoAdapter;
import com.intention.sqtwin.adapter.HomeAdapter;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.baseadapterL.commonadcpter.OnItemClickListener;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.ui.main.activity.AuctionFiledActivity;
import com.intention.sqtwin.ui.main.activity.AuctionItemActivity;
import com.intention.sqtwin.ui.main.contract.MainContract;
import com.intention.sqtwin.ui.main.model.MainModel;
import com.intention.sqtwin.ui.main.presenter.MainPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import ezy.ui.view.BannerView;


/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class HomePageFragment extends BaseFragment<MainPresenter, MainModel> implements MainContract.View, LoadingTip.onReloadListener {
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;

    private LRecyclerViewAdapter mLadapter;
    // 末尾的adapter
    private HomeAdapter homeAdapter;
    private BannerView mBannerView;
    private HeadTwoAdapter mHeadTwoAdapter;
    private BannerView mBannerViewTwo;
    private java.lang.String TAG = "HomePageFragment";

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

        homeAdapter = new HomeAdapter(getActivity());
        mLadapter = new LRecyclerViewAdapter(homeAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));
        View headViewPager = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview, null);

        mBannerView = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);
//        mBannerView.setIsAuto(true);


//        View headViewOne = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_one, null);
        View homeHeadTitleOnew = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) homeHeadTitleOnew.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐作品");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);


        View HeadViewTwo = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        mHeadTwoAdapter = new HeadTwoAdapter(getActivity());

        RecyclerView mRecyclerView = (RecyclerView) HeadViewTwo.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mHeadTwoAdapter);


        View HeadViewThree = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview, null);
        mBannerViewTwo = (BannerView) HeadViewThree.findViewById(R.id.mLoopViewPager);

//        View homeHeadTitle = getActivity().getLayoutInflater().inflate(R.layout.item_home_head_title, null);
        View home_fore = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_fore_item, null);

        View homeHeadTitle = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById = (TextView) homeHeadTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById.setText("推荐专场");
        setMarGinTop(viewById, (int) getResources().getDimension(R.dimen.x22), 0);

        mLadapter.addHeaderView(headViewPager);
        mLadapter.addHeaderView(home_fore);
        mLadapter.addHeaderView(homeHeadTitleOnew);
        mLadapter.addHeaderView(HeadViewTwo);
        mLadapter.addHeaderView(HeadViewThree);
        mLadapter.addHeaderView(homeHeadTitle);


       /* mHeadTwoAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                Intent intent = new Intent(getActivity(), AuctionItemActivity.class);
                intent.putExtra(AppConstant.auctionItemId,mHeadTwoAdapter.get(position).getId());
//                startActivity(getActivity(), AuctionItemActivity.class);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });*/
        mLadapter.setOnItemClickListener(new com.github.jdsjlzx.interfaces.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(),AuctionFiledActivity.class);
                intent.putExtra(AppConstant.aucotonFileId,homeAdapter.get(position).getId());
                LogUtils.logd(TAG+"-------"+homeAdapter.get(position).getId());
                startActivity(intent);
            }
        });
        mPresenter.getHomeAllDate();
    }


    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnHomeAllDate(AllDateBean allDateBean) {
        if (!allDateBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }

        // 取消显示页
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        // 第一个轮播图
        mBannerView.setViewFactory(new BannerView.ViewFactory<AllDateBean.DataBean.Adv1Bean>() {
            @Override
            public View create(AllDateBean.DataBean.Adv1Bean adv1Bean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, adv1Bean.getImage());
                return iv;
            }


        });

        mBannerView.setDataList(allDateBean.getData().getAdv1());
        mBannerView.start();
        //推荐作品
        mHeadTwoAdapter.addAll(allDateBean.getData().getRecommend_item());
        // 轮播图第二
        mBannerViewTwo.setViewFactory(new BannerView.ViewFactory<AllDateBean.DataBean.Adv2Bean>() {
            @Override
            public View create(AllDateBean.DataBean.Adv2Bean adv2Bean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, adv2Bean.getImage());
                return iv;
            }
        });
        mBannerViewTwo.setDataList(allDateBean.getData().getAdv2());
        mBannerViewTwo.start();
        // 推荐专场
        homeAdapter.addAll(allDateBean.getData().getRecommend_field());


    }


    @Override
    public void reloadLodTip() {
        mPresenter.getHomeAllDate();
    }
}
