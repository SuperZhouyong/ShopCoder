package cn.hancang.www.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.bean.AllStoreListBean;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.ui.mall.contract.MoreStoreContract;
import cn.hancang.www.ui.mall.model.MoreStoreModel;
import cn.hancang.www.ui.mall.presenter.MoreStorePresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

/**
 * Description: 保佑无bug
 * Data：2018/7/21-上午12:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MoreStoreActivity extends BaseActivity<MoreStorePresenter, MoreStoreModel> implements MoreStoreContract.View, OnRefreshListener, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.ll_sort)
    LinearLayout llSort;
    private CommonRecycleViewAdapter<AllStoreListBean.DataBean.StoreListBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;

    private Integer page = 0;

    @Override
    public int getLayoutId() {
        // 这里与 全部商品公用的一套布局
        return R.layout.activity_auctionlist;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        centerTitle.setText("全部店铺");
        relSearch.setVisibility(View.GONE);
        llSort.setVisibility(View.GONE);
        mAdapter = new CommonRecycleViewAdapter<AllStoreListBean.DataBean.StoreListBean>(this, R.layout.item_artdetail) {

            @Override
            public void convert(ViewHolderHelper helper, AllStoreListBean.DataBean.StoreListBean storeListBean, int position) {
                helper.setImageRoundTwoUrl(R.id.iv_goods_pic, storeListBean.getStore_logo());
                helper.setText(R.id.tv_goods_name, storeListBean.getStore_name());

                helper.setVisible(R.id.tv_price, false);
            }
        };

        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TaoBaoStoreInfoActivity.GotoTaoBaoSTireInfoActivity((BaseActivity) mContext, mAdapter.get(position).getStore_id());
//                GoodsPageActivity.gotoGoodsPageActivity((BaseActivity) mContext, mAdapter.get(position).getId(), mAdapter.get(position).getName());
            }
        });

        mPresenter.getAllStoreListRequest(page);
    }

    public static void gotoMoreStoreActivity(BaseActivity mContext) {
        Bundle bundle = new Bundle();
        /*bundle.putInt(AppConstant.StoreId, storeId);
        bundle.putString(AppConstant.storeName ,storeTitle);*/
        mContext.startActivity(MoreStoreActivity.class, bundle);

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
    public void returnAllStoreList(AllStoreListBean allStoreListBean) {
        if (!allStoreListBean.isIs_success()) {
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }
        if (page == 0 && allStoreListBean.getData().getStore_list().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (page == 0 && mAdapter.getDataList().size() != 0) {
            mAdapter.clear();
            mLadapter.notifyDataSetChanged();
        }


        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (page == allStoreListBean.getData().getTotal_page()) {
            mRecyclerView.setNoMore(true);
            return;

        }
        mAdapter.addAll(allStoreListBean.getData().getStore_list());
        ++page;
    }


    @Override
    public void onRefresh() {
        page = 0;
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getAllStoreListRequest(page);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getAllStoreListRequest(page);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getAllStoreListRequest(page);
    }

    @Override
    public void reload() {
        mPresenter.getAllStoreListRequest(page);
    }
}
