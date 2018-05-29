package com.intention.sqtwin.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.HeadTwoAdapter;
import com.intention.sqtwin.adapter.HomeAdapter;
import com.intention.sqtwin.adapter.MallAdapter;
import com.intention.sqtwin.adapter.MallStoreAdapter;
import com.intention.sqtwin.adapter.MallWorksAdapter;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.baseadapterL.commonadcpter.OnItemClickListener;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.AllMallDateBean;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.ui.Store.activity.StoreFocusActivity;
import com.intention.sqtwin.ui.main.activity.AuctionFiledActivity;
import com.intention.sqtwin.ui.main.activity.SearchActivity;
import com.intention.sqtwin.ui.main.contract.MallContract;
import com.intention.sqtwin.ui.main.model.MallModel;
import com.intention.sqtwin.ui.main.presenter.MallPresenter;
import com.intention.sqtwin.ui.mall.activity.TaoBaoStoreInfoActivity;
import com.intention.sqtwin.ui.myinfo.activity.MessageActicity;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import ezy.ui.view.BannerView;
import rx.functions.Action1;

/**
 * Description: 商城列表
 * Data：2018/4/15-下午2:48
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallFragment extends BaseFragment<MallPresenter, MallModel> implements MallContract.View, OnRefreshListener, LoadingTip.onReloadListener {
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
    // 整体的adapter
    private MallAdapter mallAdapter;
    // 推荐店铺
    private MallStoreAdapter mallStoreAdapter;
    //推荐作品
    private MallWorksAdapter mallWorksAdapter;

    private LRecyclerViewAdapter mLadapter;
    private BannerView mBannerView;
    //    private HeadTwoAdapter mHeadTwoAdapter;
    private int pagesize = 10;
    private Integer currentPostion;
    private Integer currentFavId;

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

        mallAdapter = new MallAdapter(getActivity());
        mLadapter = new LRecyclerViewAdapter(mallAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(true);
        mLRecyclerView.setOnRefreshListener(this);
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
//        mHeadTwoAdapter = new HeadTwoAdapter(getActivity());
        mallStoreAdapter = new MallStoreAdapter(getActivity());
        RecyclerView mRecyclerViewStore = (RecyclerView) HeadStoreView.findViewById(R.id.mRecyclerView);
        mRecyclerViewStore.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mRecyclerViewStore.setAdapter(mallStoreAdapter);


        // 推荐作品标题
        View homeHeadTitleOnew = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) homeHeadTitleOnew.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐作品");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);
        // 推荐作品的列表
        View HeadViewTwo = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
//        mHeadTwoAdapter = new HeadTwoAdapter(getActivity());
        mallWorksAdapter = new MallWorksAdapter(getActivity());
        RecyclerView mRecyclerView = (RecyclerView) HeadViewTwo.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mallWorksAdapter);

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
        mRxManager.on(AppConstant.MallFiled, new Action1<FavBean>() {
            @Override
            public void call(FavBean favBean) {
                currentPostion = favBean.getPostion();
                currentFavId = favBean.getFavId();
                mPresenter.getAddFavBean(favBean.getFavId(), AppConstant.field);
            }


        });
        mLadapter.setOnItemClickListener(new com.github.jdsjlzx.interfaces.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtils.logd("Postion   " + position);
                AuctionFiledActivity.gotoAuctionFiledActivity((BaseActivity) getActivity(), mallAdapter.get(position).getId(), AppConstant.IntoWayOne);
            }
        });
    }


    @Override
    public void StartLoading(String RequestId) {
        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLRecyclerView.refreshComplete(pagesize);
        }
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnAllMalldate(AllMallDateBean allMallDateBean) {
        if (!allMallDateBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (mallStoreAdapter.getDataList().size() != 0)
            mallStoreAdapter.clear();
        if (mallWorksAdapter.getDataList().size() != 0)
            mallWorksAdapter.clear();
        if (mallAdapter.getDataList().size() != 0)
            mallAdapter.clear();


        mBannerView.setViewFactory(new BannerView.ViewFactory<AllMallDateBean.DataBean.AdvBean>() {
            @Override
            public View create(AllMallDateBean.DataBean.AdvBean advBean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, advBean.getImage());
                return iv;
            }
        });
        mBannerView.setDataList(allMallDateBean.getData().getAdv());
        mBannerView.start();


        mallStoreAdapter.addAll(allMallDateBean.getData().getStore());

        mallWorksAdapter.addAll(allMallDateBean.getData().getItem());

        mallAdapter.addAll(allMallDateBean.getData().getField());

    }

    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        // 收藏完毕就刷新
        mallAdapter.AddList(currentFavId);
        mallAdapter.notifyItemChanged(currentPostion);
        showShortToast(addFavBean.getMessage());
    }
    @OnClick({R.id.rel_search, R.id.iv_love, R.id.iv_readme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_search:
                startActivity(SearchActivity.class);
                break;
            // 关注
            case R.id.iv_love:
                startActivity(StoreFocusActivity.class);
                break;
            // 提醒
            case R.id.iv_readme:
                startActivity(MessageActicity.class);
                break;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getAllMallDateRequest();
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getAllMallDateRequest();
    }
}
