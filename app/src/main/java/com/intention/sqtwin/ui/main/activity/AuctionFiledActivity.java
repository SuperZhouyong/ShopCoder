package com.intention.sqtwin.ui.main.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AuctionFiledAllBean;
import com.intention.sqtwin.bean.TabEntity;
import com.intention.sqtwin.ui.main.contract.AuctionFiledContract;
import com.intention.sqtwin.ui.main.model.AuctionFiledModel;
import com.intention.sqtwin.ui.main.presenter.AuctionFiledPresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Description: 拍场页
 * Data：2018/4/25-下午9:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledActivity extends BaseActivity<AuctionFiledPresenter, AuctionFiledModel> implements AuctionFiledContract.View, LoadingTip.onReloadListener, OnTabSelectListener {
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.Tv_time_one)
    TextView TvTimeOne;
    @BindView(R.id.Tv_time_two)
    TextView TvTimeTwo;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.tv_lot_name)
    TextView tvLotName;
    @BindView(R.id.tv_lost_price_desc_one)
    TextView tvLostPriceDescOne;
    @BindView(R.id.tv_num_one)
    TextView tvNumOne;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.tv_lost_price_desc_two)
    TextView tvLostPriceDescTwo;
    @BindView(R.id.tv_num_two)
    TextView tvNumTwo;
    @BindView(R.id.ll_two)
    LinearLayout llTwo;
    @BindView(R.id.tv_lost_price_desc_three)
    TextView tvLostPriceDescThree;
    @BindView(R.id.tv_num_three)
    TextView tvNumThree;
    @BindView(R.id.ll_three)
    LinearLayout llThree;
    @BindView(R.id.tv_author_desc)
    TextView tvAuthorDesc;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_ongoing)
    TextView tvOngoing;
    @BindView(R.id.tv_preview)
    TextView tvPreview;
    @BindView(R.id.ll_sort)
    LinearLayout llSort;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.tv_focus_ren)
    TextView tvFocusRen;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private Integer auctiuonFiled = 1 ;
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.AuctionItemListBean> mAdapter;
    private CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.StaffListBean> mArtAdapter;
    private CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.ArtistListBean> mAAboutAdapter;
    private String[] mTitles = {"参拍指南", "参拍提醒", "联系客服"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {
            R.mipmap.aution_guide, R.mipmap.aution_remind, R.mipmap.auction_contact};
    private int[] mIconSelectIds = {
            R.mipmap.aution_guide, R.mipmap.aution_remind, R.mipmap.auction_contact};

    @Override
    public int getLayoutId() {
        return R.layout.activity_lotsfiled;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        mAdapter = new CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.AuctionItemListBean>(this, R.layout.item_auction_file_item) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionFiledAllBean.DataBean.AuctionItemListBean auctionItemListBean, int position) {
                helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));


        mArtAdapter = new CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.StaffListBean>(this, R.layout.item_auction_one) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionFiledAllBean.DataBean.StaffListBean artistListBean, int position) {
                helper.setImageRoundUrl(R.id.iv_icon, artistListBean.getAvatar());
                helper.setText(R.id.tv_1_name, artistListBean.getName());
//                helper.setText(R.id.tv_2_name, artistListBean.getDescription());
//                helper.setText(R.id.tv_3_name, artistListBean.getGoods_count());

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mArtAdapter);
        mRecyclerView.addItemDecoration(new com.intention.sqtwin.widget.SpacesItemDecoration(5));

//        View HeadView = getLayoutInflater().inflate(R.layout.item_auction_file_header, null);

        mAAboutAdapter = new CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.ArtistListBean>(this, R.layout.item_auction_file_foot_item) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionFiledAllBean.DataBean.ArtistListBean artistListBean, int position) {
                helper.setText(R.id.tv_art_name_item_foot, artistListBean.getName());
            }
        };
        View footView = getLayoutInflater().inflate(R.layout.item_auction_file_foot, null);
        RecyclerView mRecyAbout = (RecyclerView) footView.findViewById(R.id.mRecyclerView_about);
        mRecyAbout.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyAbout.setAdapter(mAAboutAdapter);
        mLadapter.addFooterView(footView);

        mPresenter.getAuctionFiledRequest(auctiuonFiled);

        tvFocusRen.setVisibility(View.GONE);
        tvNumOne.setTextColor(getResources().getColor(R.color.font_4));
        tvNumTwo.setTextColor(getResources().getColor(R.color.font_4));
        tvNumThree.setTextColor(getResources().getColor(R.color.font_4));
        tvLostPriceDescThree.setText("围观");
        tvLostPriceDescTwo.setText("出价");
        tvLostPriceDescOne.setText("拍品");

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(this);
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
    public void returnAuctionFileData(final AuctionFiledAllBean auctionFiledAllBean) {
        if (!auctionFiledAllBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        tvLotName.setText(auctionFiledAllBean.getData().getField_info().getName());
        tvAuthorDesc.setText(auctionFiledAllBean.getData().getField_info().getDescription());

        tvNumOne.setText(auctionFiledAllBean.getData().getField_info().getItem_count());
        tvNumTwo.setText(auctionFiledAllBean.getData().getField_info().getBid_count());
        tvNumThree.setText(auctionFiledAllBean.getData().getField_info().getFans_count());

        mArtAdapter.addAll(auctionFiledAllBean.getData().getStaff_list());
        mAdapter.addAll(auctionFiledAllBean.getData().getAuction_item_list());
        mAAboutAdapter.addAll(auctionFiledAllBean.getData().getArtist_list());


    }


 /*   @Override
    public void reload() {
        mPresenter.getAuctionFiledRequest(auctiuonFiled);
    }*/

    @Override
    public void onTabSelect(int i) {
        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    @Override
    public void onTabReselect(int i) {

    }

    @Override
    public void reloadLodTip() {
        mPresenter.getAuctionFiledRequest(auctiuonFiled);
    }
}
