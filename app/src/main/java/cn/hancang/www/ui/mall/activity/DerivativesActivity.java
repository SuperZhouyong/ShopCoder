package cn.hancang.www.ui.mall.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.adapter.DerivativesOneAdapter;
import cn.hancang.www.adapter.DerivativesTwoAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.DerivativesBean;
import cn.hancang.www.bean.TabEntity;
import cn.hancang.www.ui.Store.activity.StoreFocusActivity;
import cn.hancang.www.ui.main.activity.CategoryActivity;
import cn.hancang.www.ui.main.activity.SearchActivity;
import cn.hancang.www.ui.mall.contract.DerivativesContract;
import cn.hancang.www.ui.mall.model.DerivativesModel;
import cn.hancang.www.ui.mall.presenter.DerivativesPresenter;
import cn.hancang.www.ui.myinfo.activity.MessageActicity;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import ezy.ui.view.BannerView;

/**
 * Description: 衍生品
 * Data：2018/5/11 0011-下午 16:23
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesActivity extends BaseActivity<DerivativesPresenter, DerivativesModel> implements DerivativesContract.View, LoadingTip.onReloadListener, OnTabSelectListener, Action {

    @BindView(R.id.category_logo)
    ImageView categoryLogo;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private BannerView mBannerView;
    private Integer type = null;
    private String[] mTitles = {"首页", "衍生品", "商城", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal, R.mipmap.icon_specialist, R.mipmap.ic_care_normal, R.mipmap.ic_myinfo_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected, R.mipmap.icon_specialist_s, R.mipmap.ic_care_selected, R.mipmap.ic_myinfo_slect};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_derivatives;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    private DerivativesOneAdapter mDerivativesOneAdapter;
    private DerivativesTwoAdapter mDerivativesTwoAdapter;
    private CommonRecycleViewAdapter<DerivativesBean.DataBean.ShopListBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;

    @Override
    public void initView() {


        // 首部轮播图
        View headViewPager = getLayoutInflater().inflate(R.layout.item_homepage_headview, null);
        mBannerView = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);

        View homeHeadTitleOne = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) homeHeadTitleOne.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐专题");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);

        View HeadViewTwoTop = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        mDerivativesOneAdapter = new DerivativesOneAdapter(this);
        RecyclerView mRecyclerViewTop = (RecyclerView) HeadViewTwoTop.findViewById(R.id.mRecyclerView);
        View viewById = HeadViewTwoTop.findViewById(R.id.mRecy_rel_parent);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) viewById.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        viewById.setLayoutParams(layoutParams);
        mRecyclerViewTop.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTop.setAdapter(mDerivativesOneAdapter);


        View homeHeadTitleTwo = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById2 = (TextView) homeHeadTitleTwo.findViewById(R.id.yv_all_recy_head_title);
        viewById2.setText("热卖衍生品");
        setMarGinTop(viewById2, (int) getResources().getDimension(R.dimen.x22), 0);


        View HeadViewTwoBottom = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        View viewByIdTwo = HeadViewTwoBottom.findViewById(R.id.mRecy_rel_parent);
        ViewGroup.MarginLayoutParams layoutParamsTwo = (ViewGroup.MarginLayoutParams) viewByIdTwo.getLayoutParams();
        layoutParamsTwo.leftMargin = 0;
        layoutParamsTwo.rightMargin = 0;
        viewByIdTwo.setLayoutParams(layoutParamsTwo);

        mDerivativesTwoAdapter = new DerivativesTwoAdapter(this);
        RecyclerView mRecyclerViewBottom = (RecyclerView) HeadViewTwoBottom.findViewById(R.id.mRecyclerView);
        mRecyclerViewBottom.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        mRecyclerViewBottom.setAdapter(mDerivativesTwoAdapter);

        View homeHeadTitleThree = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById3 = (TextView) homeHeadTitleThree.findViewById(R.id.yv_all_recy_head_title);
        viewById3.setText("推荐店铺");
        setMarGinTop(viewById3, (int) getResources().getDimension(R.dimen.x22), 0);

        mAdapter = new CommonRecycleViewAdapter<DerivativesBean.DataBean.ShopListBean>(this, R.layout.item_homepage_headview_two_item) {
            @Override
            public void convert(ViewHolderHelper helper, DerivativesBean.DataBean.ShopListBean shopListBean, int position) {
                helper.setImageUrl(R.id.iv_headtwo, shopListBean.getStore_logo());
                helper.setText(R.id.tv_headtwo, shopListBean.getStore_name());

            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLadapter.addHeaderView(headViewPager);
        mLadapter.addHeaderView(homeHeadTitleOne);
        mLadapter.addHeaderView(HeadViewTwoTop);
        mLadapter.addHeaderView(homeHeadTitleTwo);
        mLadapter.addHeaderView(HeadViewTwoBottom);
        mLadapter.addHeaderView(homeHeadTitleThree);
        mPresenter.getDerivativesRequest(type);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(this);

        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TaoBaoStoreInfoActivity.GotoTaoBaoSTireInfoActivity((BaseActivity) mContext, mAdapter.get(position).getStore_id());
            }
        });
        // 设置衍生品
        tabLayout.setCurrentTab(1);
    }

/*    // 知道点击的哪一个
    private void SwitchTo(int position) {

    }*/

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
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnDerivatives(DerivativesBean derivativesBean) {
        if (!derivativesBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        mBannerView.setViewFactory(new BannerView.ViewFactory<DerivativesBean.DataBean.AdvBean>() {
            @Override
            public View create(DerivativesBean.DataBean.AdvBean advBean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, advBean.getImage());
                return iv;
            }
        });
        mBannerView.setDataList(derivativesBean.getData().getAdv());
        mBannerView.start();

        mDerivativesOneAdapter.addAll(derivativesBean.getData().getArticle());
        mDerivativesTwoAdapter.addAll(derivativesBean.getData().getGoods_list());
        mAdapter.addAll(derivativesBean.getData().getShop_list());

    }


    @OnClick({R.id.category_logo, R.id.iv_love, R.id.iv_readme, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_search:
                startActivity(SearchActivity.class);
                break;
            case R.id.category_logo:
                CategoryActivity.GotoCategoryActivity(this, 1, "商品分类");

                break;
            // 关注
            case R.id.iv_love:
                SingleCall.getInstance()
                        .addAction(this, AppConstant.twoMessage)
                        .addValid(new LoginValid(this))
                        .doCall();
                /*if (isLogin())
                    startActivity(StoreFocusActivity.class);
                else
                    LoginActivity.start(getActivity());*/
                break;
            // 提醒
            case R.id.iv_readme:
                SingleCall.getInstance()
                        .addAction(this, AppConstant.threeMessage)
                        .addValid(new LoginValid(this))
                        .doCall();


//                startActivity(MessageActicity.class);
                break;
        }
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getDerivativesRequest(type);
    }


    @Override
    public void onTabSelect(int position) {
        switch (position) {
            case 0:
                finish();
                break;
            case 2:
                mRxManager.post(AppConstant.SwitchToPostion, 3);
                finish();
                break;
            case 3:
                mRxManager.post(AppConstant.SwitchToPostion, 4);
                finish();
                break;

        }
    }

    @Override
    public void onTabReselect(int position) {

    }

    @Override
    public void call(String tag) {
        if (AppConstant.twoMessage.equals(tag))
            startActivity(StoreFocusActivity.class);
        if (AppConstant.threeMessage.equals(tag))
            startActivity(MessageActicity.class);
    }
}
