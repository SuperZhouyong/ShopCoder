package com.intention.sqtwin.ui.main.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.base.BasePageStateAdapter;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.activity.CategoryActivity;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;
import com.intention.sqtwin.ui.main.model.PpAuctionModel;
import com.intention.sqtwin.ui.main.presenter.PpAuctionPresenter;
import com.intention.sqtwin.widget.SlidingTabLayout;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 自营拍 ==  下表的拍卖界面
 * Data：2018/4/15-下午2:45
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AuctionFragment extends BaseFragment<PpAuctionPresenter, PpAuctionModel> implements PpAuctionContract.View, OnTabSelectListener, LoadingTip.onReloadListener {
    /* @BindView(R.id.mRecyclerView)
     LRecyclerView mRecyclerView;*/
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;
    @BindView(R.id.slid_tab_layout)
    SlidingTabLayout slidTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.category_logo)
    ImageView ivCategory;

    /* private LRecyclerViewAdapter mLAdapter;
     private PpAuctionAdapter mAdapter;
     private SlidingTabLayout sTabLayout;
     private BannerView mBannerView;*/
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    // 当前的页数
    private Integer page_no = 0;
    private Integer category_id = 0;
    private Integer status = 0;
    private int pagesize = 10;
    /* private ViewPager viewPager;*/
    private String[] mTitles;

    private BasePageStateAdapter basePageStateAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_ppauction;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        mPresenter.getPpAlldate(category_id, status, page_no);


//        sTabLayout.setViewPager(viewPager, mTitles, getActivity().getSupportFragmentManager(), mFragments);


       /* mAdapter = new PpAuctionAdapter(getActivity());
        mLAdapter = new LRecyclerViewAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        mRecyclerView.setAdapter(mLAdapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setLoadMoreEnabled(true);
        mRecyclerView.setOnLoadMoreListener(this);

        View headView_pp = getActivity().getLayoutInflater().inflate(R.layout.item_ppauction_head, null);
        sTabLayout = (SlidingTabLayout) headView_pp.findViewById(R.id.slid_tab_layout);
        mBannerView = (BannerView) headView_pp.findViewById(R.id.mLoopViewPager);
        viewPager = (ViewPager) headView_pp.findViewById(R.id.viewpager);

        View homeHeadTitle = getActivity().getLayoutInflater().inflate(R.layout.item_home_head_title, null);

//        mBannerView.setAspectRatio((float) 0.5555555);
        mLAdapter.addHeaderView(headView_pp);
        mLAdapter.addHeaderView(homeHeadTitle);

        mLAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(getActivity(), AuctionFiledActivity.class);
            }
        });

        mPresenter.getPpAlldate(category_id, status, page_no);*/

    }


    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    /**
     * 加载完毕每次加载完毕都回调一次没毛病
     *
     * @param RequestId
     */
    @Override
    public void stopLoading(String RequestId) {
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if ("one".equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;


        }
    }

    @OnClick({R.id.category_logo})
    void onCLick(View v) {
        switch (v.getId()) {
            case R.id.category_logo:
                startActivity(CategoryActivity.class );
                break;

        }
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
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility()==View.VISIBLE)
            mLoadingTip.setViewGone();

        // 头部
        slidTabLayout.setOnTabSelectListener(this);
        List<PpAllDateBean.DataBeanX.MainCategoryBean> main_category = allDateBean.getData().getMain_category();
        mTitles = new String[main_category.size()];
        for (int i = 0; i < main_category.size(); i++) {
            mTitles[i] = main_category.get(i).getName();
            mFragments.add(SimpleCardFragment.getInstance(main_category.get(i).getName(), main_category.get(i).getCategory_id()));
        }
        basePageStateAdapter = new BasePageStateAdapter(getActivity().getSupportFragmentManager(), mFragments, Arrays.asList(mTitles));
        viewpager.setAdapter(basePageStateAdapter);
        slidTabLayout.setViewPager(viewpager);

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

    @Override
    public void reloadLodTip() {
        mPresenter.getPpAlldate(category_id, status, page_no);
    }


}
