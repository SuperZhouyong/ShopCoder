package cn.hancang.www.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import cn.hancang.www.R;
import cn.hancang.www.adapter.HeadTwoAdapter;
import cn.hancang.www.adapter.HomeAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseFragment;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AllDateBean;
import cn.hancang.www.bean.FavBean;
import cn.hancang.www.ui.Store.activity.StoreFocusActivity;
import cn.hancang.www.ui.main.activity.AuctionFiledActivity;
import cn.hancang.www.ui.main.activity.MainActivity;
import cn.hancang.www.ui.main.activity.SearchActivity;
import cn.hancang.www.ui.main.activity.SynchronousAuctionActivity;
import cn.hancang.www.ui.main.contract.MainContract;
import cn.hancang.www.ui.main.model.MainModel;
import cn.hancang.www.ui.main.presenter.MainPresenter;
import cn.hancang.www.ui.mall.activity.DerivativesActivity;
import cn.hancang.www.ui.myinfo.activity.MessageActicity;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.OnClick;
import ezy.ui.view.BannerView;
import rx.functions.Action1;


/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class HomePageFragment extends BaseFragment<MainPresenter, MainModel> implements MainContract.View, LoadingTip.onReloadListener, View.OnClickListener, OnRefreshListener, Action {
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;


    private LRecyclerViewAdapter mLadapter;
    // 末尾的adapter
    private HomeAdapter homeAdapter;
    private BannerView mBannerView;
    private HeadTwoAdapter mHeadTwoAdapter;
    private BannerView mBannerViewTwo;
    private String TAG = "HomePageFragment";
    private int pagesize = 10;
    private Integer currentPostion = -1;
    private Integer currentFavId;

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
        mLRecyclerView.setPullRefreshEnabled(true);
        mLRecyclerView.setOnRefreshListener(this);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));
        View headViewPager = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview, null);

        mBannerView = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);
//        mBannerView.setIsAuto(true);


//        View headViewOne = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_headview_one, null);
        View homeHeadTitleOnew = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) homeHeadTitleOnew.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("优选甄品");
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
        home_fore.findViewById(R.id.iv_one).setOnClickListener(this);
        home_fore.findViewById(R.id.iv_two).setOnClickListener(this);
        home_fore.findViewById(R.id.iv_three).setOnClickListener(this);
        home_fore.findViewById(R.id.iv_fore).setOnClickListener(this);


        View home_two = getActivity().getLayoutInflater().inflate(R.layout.item_homepage_new_two_item, null);
        home_two.findViewById(R.id.item_new_two).setOnClickListener(this);
        home_two.findViewById(R.id.item_new_one).setOnClickListener(this);


        View homeHeadTitle = getActivity().getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById = (TextView) homeHeadTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById.setText("优选专场");
        setMarGinTop(viewById, (int) getResources().getDimension(R.dimen.x22), 0);

        mLadapter.addHeaderView(headViewPager);
//        mLadapter.addHeaderView(home_fore);
        mLadapter.addHeaderView(home_two);
        mLadapter.addHeaderView(homeHeadTitleOnew);
        mLadapter.addHeaderView(HeadViewTwo);
        mLadapter.addHeaderView(HeadViewThree);
        mLadapter.addHeaderView(homeHeadTitle);


        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtils.logd("Postion   " + position);
                AuctionFiledActivity.gotoAuctionFiledActivity((MainActivity) getActivity(), homeAdapter.get(position).getId(), AppConstant.IntoWayOne);

            }
        });
        mPresenter.getHomeAllDate();
        mRxManager.on(AppConstant.HomeFiled, new Action1<FavBean>() {
            @Override
            public void call(FavBean favBean) {
                currentPostion = favBean.getPostion();
                currentFavId = favBean.getFavId();
                SingleCall.getInstance()
                        .addAction(HomePageFragment.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(getActivity()))
                        .doCall();

            }


        });
    }


    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId) && homeAdapter.getDataList().size() == 0 && mHeadTwoAdapter.getDataList().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
        }
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
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
        // 关注遇到网络不好
        if (AppConstant.twoMessage.equals(RequestId)) {
            showShortToast(msg);
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
        if (mHeadTwoAdapter.getDataList().size() != 0)
            mHeadTwoAdapter.clear();
        if (homeAdapter.getDataList().size() != 0) {
            homeAdapter.clear();
        }


        // 第一个轮播图
        mBannerView.setViewFactory(new BannerView.ViewFactory<AllDateBean.DataBean.Adv1Bean>() {
            @Override
            public View create(final AllDateBean.DataBean.Adv1Bean adv1Bean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, adv1Bean.getImage());
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GotoOthreVp(adv1Bean.getLink_type(),adv1Bean.getLink_value(),adv1Bean.getAdv_title());
                    }
                });
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
            public View create(final AllDateBean.DataBean.Adv2Bean adv2Bean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, adv2Bean.getImage());
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GotoOthreVp(adv2Bean.getLink_type(),adv2Bean.getLink_value(),adv2Bean.getAdv_title());
                    }
                });
                return iv;
            }
        });
        mBannerViewTwo.setDataList(allDateBean.getData().getAdv2());
        mBannerViewTwo.start();
        // 推荐专场
        homeAdapter.addAll(allDateBean.getData().getRecommend_field());


    }



    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        // 收藏完毕就刷新
        homeAdapter.AddList(currentFavId);
        homeAdapter.notifyItemChanged(currentPostion);
        showShortToast(addFavBean.getMessage());
    }


    @Override
    public void reloadLodTip() {
        mPresenter.getHomeAllDate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_one:
                // 转向自营拍
                mRxManager.post(AppConstant.SwitchToPostion, 1);
                break;
            case R.id.iv_two:
                // 衍生品
                startActivity(DerivativesActivity.class);
                break;
            case R.id.iv_three:
                mRxManager.post(AppConstant.SwitchToPostion, 3);
                // 商城
                break;
            case R.id.iv_fore:
                // 同步拍
                startActivity(SynchronousAuctionActivity.class);
                break;
            case R.id.item_new_one:
                mRxManager.post(AppConstant.SwitchToPostion, 1);
                break;
            case R.id.item_new_two:
                mRxManager.post(AppConstant.SwitchToPostion, 3);
                break;

        }
    }


    @OnClick({R.id.rel_search, R.id.iv_love, R.id.iv_readme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_search:
                startActivity(SearchActivity.class);
                break;
            // 关注
            case R.id.iv_love:
                SingleCall.getInstance()
                        .addAction(HomePageFragment.this, AppConstant.twoMessage)
                        .addValid(new LoginValid(getActivity()))
                        .doCall();
                /*if (isLogin())
                    startActivity(StoreFocusActivity.class);
                else
                    LoginActivity.start(getActivity());*/
                break;
            // 提醒
            case R.id.iv_readme:
                SingleCall.getInstance()
                        .addAction(HomePageFragment.this, AppConstant.threeMessage)
                        .addValid(new LoginValid(getActivity()))
                        .doCall();


//                startActivity(MessageActicity.class);
                break;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getHomeAllDate();
    }

    @Override
    public void call(String tag) {
        if (AppConstant.oneMessage.equals(tag))
            mPresenter.getAddFavBean(currentFavId, AppConstant.field);
        if (AppConstant.twoMessage.equals(tag))
            startActivity(StoreFocusActivity.class);
        if (AppConstant.threeMessage.equals(tag))
            startActivity(MessageActicity.class);
    }
}
