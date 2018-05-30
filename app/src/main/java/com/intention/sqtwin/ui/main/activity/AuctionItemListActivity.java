package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AuctionListBean;
import com.intention.sqtwin.ui.main.contract.AuctionListContract;
import com.intention.sqtwin.ui.main.model.AuctionListModel;
import com.intention.sqtwin.ui.main.presenter.AuctionListPresenter;
import com.intention.sqtwin.ui.mall.activity.GoodsPageActivity;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 拍品列表页
 * Data：2018/5/5-上午2:18
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionItemListActivity extends BaseActivity<AuctionListPresenter, AuctionListModel> implements AuctionListContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener, OnRefreshListener {
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    private Integer category = 111;
    private Integer page = 0;
    private CommonRecycleViewAdapter<AuctionListBean.DataBean.ItemListBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;
    private int goodType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionlist;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


    public static void GotoAuctionItemListActivity(BaseActivity baseActivity, int ListType, String title, Integer category_id) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.ListType, ListType);
        bundle.putString(AppConstant.ListTypeTitle, title);
        bundle.putInt(AppConstant.ListTypeCategoryId, category_id);
        baseActivity.startActivity(AuctionItemListActivity.class, bundle);
    }

    @Override
    public void initView() {
        centerTitle.setText(getIntent().getExtras().getString(AppConstant.ListTypeTitle));
        category = getIntent().getExtras().getInt(AppConstant.ListTypeCategoryId, -1);
        goodType = getIntent().getExtras().getInt(AppConstant.ListType);

        leftTitle.setVisibility(View.GONE);
        centerTitle.setText(getIntent().getExtras().getString(AppConstant.ListTypeTitle));
        relSearch.setVisibility(View.GONE);
        mAdapter = new CommonRecycleViewAdapter<AuctionListBean.DataBean.ItemListBean>(this, R.layout.item_artdetail) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionListBean.DataBean.ItemListBean auctionListBean, int position) {
                helper.setImageUrl(R.id.iv_goods_pic, auctionListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionListBean.getName());
                helper.setText(R.id.tv_price, "￥" + String.valueOf(auctionListBean.getCurrent_price()));

            }
        };

        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLadapter);
//        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 拍品
                if (goodType == 0) {
                    AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, mAdapter.get(position).getId());

                } else if (goodType == 1) {
                    //商品
                    GoodsPageActivity.gotoGoodsPageActivity((BaseActivity) mContext, mAdapter.get(position).getId(), mAdapter.get(position).getName());
                }
            }
        });
        mPresenter.getRequestAuctionList(category, page, goodType);
    }


    @Override
    public void StartLoading(String RequestId) {
        if (mAdapter.getDataList().size() == 0)
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
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
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
                return;
            }
            mRecyclerView.setOnNetWorkErrorListener(this);
        }
    }

    @Override
    public void returnAuctionList(AuctionListBean auctionListBean) {
        if (!auctionListBean.isIs_success()) {
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }
        if (page == 0 && auctionListBean.getData().getItem_list().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (page == 0 && mAdapter.getDataList().size() != 0) {
            mAdapter.clear();
            mLadapter.notifyDataSetChanged();
        }


        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (page == auctionListBean.getData().getPage_count()) {
            mRecyclerView.setNoMore(true);
            return;

        }
        mAdapter.addAll(auctionListBean.getData().getItem_list());
        ++page;

    }

    @Override
    public void onLoadMore() {
        mPresenter.getRequestAuctionList(category, page, goodType);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getRequestAuctionList(category, page, goodType);
    }

    @Override
    public void reload() {
        mPresenter.getRequestAuctionList(category, page, goodType);
    }


    @OnClick({R.id.rel_back, R.id.left_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.left_title:
                break;
        }
    }


    @Override
    public void onRefresh() {
        page = 0;
        mPresenter.getRequestAuctionList(category, page, goodType);
    }
}
