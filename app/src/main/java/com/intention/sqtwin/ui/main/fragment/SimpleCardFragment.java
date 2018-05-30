package com.intention.sqtwin.ui.main.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.PpAuctionAdapter;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.LazzyFragment;
import com.intention.sqtwin.base.LoginValid;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.activity.AuctionFiledActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;
import com.intention.sqtwin.ui.main.model.PpAuctionModel;
import com.intention.sqtwin.ui.main.presenter.PpAuctionPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;
import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import ezy.ui.view.BannerView;
import rx.functions.Action1;


//@SuppressLint("ValidFragment")
public class SimpleCardFragment extends LazzyFragment<PpAuctionPresenter, PpAuctionModel> implements PpAuctionContract.View, LoadingTip.onReloadListener, OnNetWorkErrorListener, OnLoadMoreListener, View.OnClickListener, OnRefreshListener, Action {
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private String mTitle;


    private Integer page_no = 0;
    private Integer category_id = 0;
    private Integer status = 0;
    private PpAuctionAdapter mAdapter;
    private LRecyclerViewAdapter mLAdapter;
    private BannerView mBannerView;
    private int pagesize = 10;
    private TextView tv_all;
    private TextView tv_ongoing;
    private TextView tv_preview;
    private TextView tv_over;
    private View vgll;
    private Integer currentPostion;
    private Integer currentFavId;

    public static SimpleCardFragment getInstance(String title, Integer category_id) {
        SimpleCardFragment sf = new SimpleCardFragment();
        sf.mTitle = title;
        sf.category_id = category_id;
        return sf;
    }


    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mAdapter = new PpAuctionAdapter(getActivity());
        mLAdapter = new LRecyclerViewAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        mRecyclerView.setAdapter(mLAdapter);
        mRecyclerView.setOnRefreshListener(this);
//        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setLoadMoreEnabled(true);
        mRecyclerView.setOnLoadMoreListener(this);

       /* View headView_pp = getActivity().getLayoutInflater().inflate(R.layout.item_ppauction_head, null);
//        sTabLayout = (SlidingTabLayout) headView_pp.findViewById(R.id.slid_tab_layout);
        mBannerView = (BannerView) headView_pp.findViewById(R.id.mLoopViewPager);
//        viewPager = (ViewPager) headView_pp.findViewById(R.id.viewpager);*/

        View headView_pp = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview, null);
        mBannerView = (BannerView) headView_pp.findViewById(R.id.mLoopViewPager);


        View homeHeadTitle = getActivity().getLayoutInflater().inflate(R.layout.item_home_head_title, null);
        vgll = homeHeadTitle.findViewById(R.id.ll_sort);
        vgll.setVisibility(View.INVISIBLE);
        tv_all = (TextView) homeHeadTitle.findViewById(R.id.tv_all);
        tv_ongoing = (TextView) homeHeadTitle.findViewById(R.id.tv_ongoing);
        tv_preview = (TextView) homeHeadTitle.findViewById(R.id.tv_preview);
        tv_over = (TextView) homeHeadTitle.findViewById(R.id.tv_over);
        tv_all.setOnClickListener(this);
        tv_ongoing.setOnClickListener(this);
        tv_preview.setOnClickListener(this);
        tv_over.setOnClickListener(this);

        mLAdapter.addHeaderView(headView_pp);
        mLAdapter.addHeaderView(homeHeadTitle);

        mLAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

//                startActivity(getActivity(), AuctionFiledActivity.class);
                LogUtils.logd("PostionId---" + position + "-----------" + mAdapter.get(position));
                AuctionFiledActivity.gotoAuctionFiledActivity((MainActivity) getActivity(), mAdapter.get(position).getId(), AppConstant.IntoWayOne);
            }
        });
        mRxManager.on(AppConstant.PpAuction, new Action1<FavBean>() {
            @Override
            public void call(FavBean favBean) {
                currentPostion = favBean.getPostion();
                currentFavId = favBean.getFavId();
                SingleCall.getInstance()
                        .addAction(SimpleCardFragment.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(getActivity()))
                        .doCall();

            }


        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_simplecard;
    }

    @Override
    protected void RequestNetWorkData() {
        mPresenter.getPpAlldate(category_id, status, page_no);
    }

    @Override
    public void StartLoading(String RequestId) {
//        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        mRecyclerView.refreshComplete(pagesize);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            } else {
                mRecyclerView.setOnNetWorkErrorListener(this);
            }
        }
    }

    @Override
    public void returnPpAllDate(PpAllDateBean allDateBean) {
        if (!allDateBean.isIs_success()) {
            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
//                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page_no == 0 && mAdapter.getDataList().size() != 0)
            mAdapter.clearData();


        if (page_no == 0) {
            mBannerView.setViewFactory(new BannerView.ViewFactory<PpAllDateBean.DataBean.AdvBean>() {

                @Override
                public View create(PpAllDateBean.DataBean.AdvBean dataBean, int position, ViewGroup container) {
                    ImageView iv = new ImageView(container.getContext());
                    ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, dataBean.getImage());
                    return iv;
                }
            });
            mBannerView.setDataList(allDateBean.getData().getAdv());
            mBannerView.start();
        }


        if (page_no >= allDateBean.getData().getTotal_page()) {
            mRecyclerView.setNoMore(true);
            return;

        }
        mAdapter.addAll(allDateBean.getData().getAuction_field_list());

       /* tv_all.setText("全部");
        tv_preview.setText("预展中");
        tv_ongoing.setText("拍卖中");
        tv_over.setText("已结拍");*/
        vgll.setVisibility(View.VISIBLE);
        ++page_no;


    }

    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        // 收藏完毕就刷新
        mAdapter.AddList(currentFavId);
        mAdapter.notifyItemChanged(currentPostion);
        showShortToast(addFavBean.getMessage());
    }


    @Override
    public void reloadLodTip() {
        mPresenter.getPpAlldate(category_id, status, page_no);
    }

    @Override
    public void reload() {
        mPresenter.getPpAlldate(category_id, status, page_no);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getPpAlldate(category_id, status, page_no);
    }

    @Override
    public void onClick(View v) {
        int intdex = status;
        switch (v.getId()) {
            case R.id.tv_all:
                intdex = 0;
                break;
            case R.id.tv_ongoing:
                intdex = 1;
                break;
            case R.id.tv_preview:
                intdex = 2;
                break;
            case R.id.tv_over:
                intdex = 3;
                break;
        }
        if (status != intdex) {
            status = intdex;
            page_no = 0;
            mPresenter.getPpAlldate(category_id, intdex, page_no);
            mAdapter.clearData();
            mLAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRefresh() {
        page_no = 0;
        mPresenter.getPpAlldate(category_id, status, page_no);
    }

    @Override
    public void call(String tag) {
        mPresenter.getAddFavBean(currentFavId, AppConstant.field);
    }
}