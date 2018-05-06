package com.intention.sqtwin.ui.main.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
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
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Description: 拍品列表页
 * Data：2018/5/5-上午2:18
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionItemListActivity extends BaseActivity<AuctionListPresenter, AuctionListModel> implements AuctionListContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener {
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
    private Integer category = 111;
    private Integer page = 0;
    private CommonRecycleViewAdapter<AuctionListBean.DataBean.ListBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionlist;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("琉璃");
        relSearch.setVisibility(View.GONE);
        mAdapter = new CommonRecycleViewAdapter<AuctionListBean.DataBean.ListBean>(this, R.layout.item_artdetail) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionListBean.DataBean.ListBean auctionListBean, int position) {
                helper.setImageUrl(R.id.iv_goods_pic, auctionListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionListBean.getName());
                helper.setText(R.id.tv_price, "￥" + String.valueOf(auctionListBean.getCurrent_price()));
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnLoadMoreListener(this);

        mPresenter.getRequestAuctionList(category, page);
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

        mAdapter.addAll(auctionListBean.getData().getList());
        ++page;
        if (page == auctionListBean.getData().getPage_count())
            mRecyclerView.setNoMore(true);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getRequestAuctionList(category, page);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getRequestAuctionList(category, page);
    }

    @Override
    public void reload() {
        mPresenter.getRequestAuctionList(category, page);
    }
}
