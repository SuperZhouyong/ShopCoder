package com.intention.sqtwin.ui.main.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.PpAuctionAdapter;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.activity.AuctionFiledActivity;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;
import com.intention.sqtwin.ui.main.model.PpAuctionModel;
import com.intention.sqtwin.ui.main.presenter.PpAuctionPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.SlidingTabLayout;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ezy.ui.view.BannerView;

/**
 * Description: 自营拍 ==  下表的拍卖界面
 * Data：2018/4/15-下午2:45
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AuctionFragment extends BaseFragment<PpAuctionPresenter, PpAuctionModel> implements PpAuctionContract.View, OnLoadMoreListener, OnTabSelectListener, LoadingTip.onReloadListener {
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private LRecyclerViewAdapter mLAdapter;
    private PpAuctionAdapter mAdapter;
    private SlidingTabLayout sTabLayout;
    private BannerView mBannerView;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    // 当前的页数
    private Integer page_no = 0;
    private Integer category_id = 0;
    private Integer status = 0;
    private int pagesize = 10;
    private ViewPager viewPager;
    private String[] mTitles;

    //    private MyPagerAdapter mVPAdapter;


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
        mAdapter = new PpAuctionAdapter(getActivity());
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

        mPresenter.getPpAlldate(category_id, status, page_no);

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
        mRecyclerView.refreshComplete(pagesize);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if ("one".equals(RequestId)) {
            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);

            } else {

                mRecyclerView.setOnNetWorkErrorListener(new OnNetWorkErrorListener() {
                    @Override
                    public void reload() {
                        mPresenter.getPpAlldate(category_id, status, page_no);

                    }
                });
            }

        }
    }


    /**
     * 返回所有数据
     *
     * @param allDateBean
     */
    @Override
    public void returnPpAllDate(PpAllDateBean allDateBean) {
        if (!allDateBean.isIs_success() && page_no == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (!allDateBean.isIs_success())
            return;
        if (page_no == 0 && mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        // 头部
//        sTabLayout.setOnTabSelectListener(this);
        if (page_no == 0) {
            List<PpAllDateBean.DataBeanX.MainCategoryBean> main_category = allDateBean.getData().getMain_category();
            mTitles = new String[main_category.size()];
            for (int i = 0; i < main_category.size(); i++) {
                mTitles[i] = main_category.get(i).getName();
                mFragments.add(SimpleCardFragment.getInstance(main_category.get(i).getName()));
            }
            mBannerView.setViewFactory(new BannerView.ViewFactory<PpAllDateBean.DataBeanX.AdvBean.DataBean>() {
                @Override
                public View create(PpAllDateBean.DataBeanX.AdvBean.DataBean advBean, int position, ViewGroup container) {
                    ImageView iv = new ImageView(container.getContext());
                    ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, advBean.getImage());
                    return iv;
                }
            });

            mBannerView.setDataList(allDateBean.getData().getAdv().getData());
            mBannerView.start();
            sTabLayout.setViewPager(viewPager, mTitles, getActivity().getSupportFragmentManager(), mFragments);
        }


        mAdapter.addAll(allDateBean.getData().getAuction_field_list());

        ++page_no;
        // 加载到更多了  当前是最后一页的数据
        if (allDateBean.getData().getTotal_page() == page_no)
            mRecyclerView.setNoMore(true);
    }

    /**
     * 记载更多
     */
    @Override
    public void onLoadMore() {
        mPresenter.getPpAlldate(category_id, status, page_no);

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
