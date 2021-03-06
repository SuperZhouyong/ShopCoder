package cn.hancang.www.ui.main.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.flyco.tablayout.listener.OnTabSelectListener;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.BaseFragment;
import cn.hancang.www.base.BasePageStateAdapter;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.PpAllDateBean;
import cn.hancang.www.ui.Store.activity.StoreFocusActivity;
import cn.hancang.www.ui.main.activity.CategoryActivity;
import cn.hancang.www.ui.main.activity.SearchActivity;
import cn.hancang.www.ui.main.contract.PpAuctionContract;
import cn.hancang.www.ui.main.model.PpAuctionModel;
import cn.hancang.www.ui.main.presenter.PpAuctionPresenter;
import cn.hancang.www.ui.myinfo.activity.MessageActicity;
import cn.hancang.www.widget.SlidingTabLayout;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

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

public class AuctionFragment extends BaseFragment<PpAuctionPresenter, PpAuctionModel> implements PpAuctionContract.View, OnTabSelectListener, LoadingTip.onReloadListener, Action {
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
//                startActivity(CategoryActivity.class );

//            CategoryActivity.GotoCategoryActivity((BaseActivity) getActivity(), 0, "拍品分类");
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
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        // 头部
        slidTabLayout.setOnTabSelectListener(this);
        List<PpAllDateBean.DataBean.MainCategoryBean> main_category = allDateBean.getData().getMain_category();
        mTitles = new String[main_category.size()];
        for (int i = 0; i < main_category.size(); i++) {
            mTitles[i] = main_category.get(i).getName();
            mFragments.add(SimpleCardFragment.getInstance(main_category.get(i).getName(), Integer.parseInt(main_category.get(i).getCategory_id())));
        }
        basePageStateAdapter = new BasePageStateAdapter(getActivity().getSupportFragmentManager(), mFragments, Arrays.asList(mTitles));
        viewpager.setAdapter(basePageStateAdapter);
        slidTabLayout.setViewPager(viewpager);

    }

    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {

    }

    @OnClick({R.id.rel_search, R.id.iv_love, R.id.iv_readme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_search:
                startActivity(SearchActivity.class);
                break;
            // 关注
            // 关注
            case R.id.iv_love:
                SingleCall.getInstance()
                        .addAction(AuctionFragment.this, AppConstant.twoMessage)
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
                        .addAction(AuctionFragment.this, AppConstant.threeMessage)
                        .addValid(new LoginValid(getActivity()))
                        .doCall();


//                startActivity(MessageActicity.class);
                break;
        }
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

    @Override
    public void call(String tag) {
        /*if (AppConstant.oneMessage.equals(tag))
            mPresenter.getAddFavBean(currentFavId, AppConstant.field);*/
        if (AppConstant.twoMessage.equals(tag))
            startActivity(StoreFocusActivity.class);
        if (AppConstant.threeMessage.equals(tag))
            startActivity(MessageActicity.class);
    }
}
