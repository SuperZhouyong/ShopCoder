package cn.hancang.www.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import cn.hancang.www.bean.StoreInfoOrderListBean;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
//import cn.hancang.www.bean.AuctionListBean;
import cn.hancang.www.bean.AuctionListBean;
import cn.hancang.www.ui.main.contract.AuctionListContract;
import cn.hancang.www.ui.main.model.AuctionListModel;
import cn.hancang.www.ui.main.presenter.AuctionListPresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

/**
 * Description: 保佑无bug
 * Data：2018/7/1-上午9:17
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoOrderListActivity extends BaseActivity<AuctionListPresenter, AuctionListModel> implements AuctionListContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener, OnRefreshListener {
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
    //    private Integer category = 111;
    private Integer page = 0;
    private CommonRecycleViewAdapter<StoreInfoOrderListBean.DataBean.GoodsBean> mAdapter;

    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;
    private int storeId;
    //    private int goodType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionlist;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }


/*    public static void GotoAuctionItemListActivity(BaseActivity baseActivity, int ListType, String title, Integer category_id) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.ListType, ListType);
        bundle.putString(AppConstant.ListTypeTitle, title);
        bundle.putInt(AppConstant.ListTypeCategoryId, category_id);
        baseActivity.startActivity(AuctionItemListActivity.class, bundle);
    }*/

    @Override
    public void initView() {
        centerTitle.setText(getIntent().getExtras().getString(AppConstant.storeName));
//        category = getIntent().getExtras().getInt(AppConstant.ListTypeCategoryId, -1);
//        goodType = getIntent().getExtras().getInt(AppConstant.ListType);
        storeId = getIntent().getExtras().getInt(AppConstant.StoreId);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText(getIntent().getExtras().getString(AppConstant.ListTypeTitle));
        relSearch.setVisibility(View.GONE);
       /* mAdapter = new CommonRecycleViewAdapter<AuctionListBean.DataBean.ItemListBean>(this, R.layout.item_artdetail) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionListBean.DataBean.ItemListBean auctionListBean, int position) {
                helper.setImageUrl(R.id.iv_goods_pic, auctionListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionListBean.getName());
                helper.setText(R.id.tv_price, "￥" + String.valueOf(auctionListBean.getCurrent_price()));

            }
        };*/
        mAdapter = new CommonRecycleViewAdapter<StoreInfoOrderListBean.DataBean.GoodsBean>(this, R.layout.item_artdetail) {
            @Override
            public void convert(ViewHolderHelper helper, StoreInfoOrderListBean.DataBean.GoodsBean goodsBean, int position) {
                helper.setImageUrl(R.id.iv_goods_pic, goodsBean.getImage());
                helper.setText(R.id.tv_goods_name, goodsBean.getName());
                helper.setText(R.id.tv_price, "￥" + String.valueOf(goodsBean.getCurrent_price()));
            }
        };

        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mLadapter);
//        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // 拍品
//                if (goodType == 0) {
//                    AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, mAdapter.get(position).getId());
//
//                } else if (goodType == 1) {
//                    //商品
//                }
                GoodsPageActivity.gotoGoodsPageActivity((BaseActivity) mContext, mAdapter.get(position).getId(), mAdapter.get(position).getName());
            }
        });
//        mPresenter.getRequestAuctionList(category, page, goodType);

        mPresenter.getStoreInfoList(storeId, page);
    }

    public static void gotoStoreInfoOrderListActivity(BaseActivity mContext, Integer storeId,String storeTitle) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.StoreId, storeId);
        bundle.putString(AppConstant.storeName ,storeTitle);
        mContext.startActivity(StoreInfoOrderListActivity.class, bundle);

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
        /*if (!auctionListBean.isIs_success()) {
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
*/
    }


    @Override
    public void returnStoreInfoList(StoreInfoOrderListBean storeInfoOrderListBean) {
        if (!storeInfoOrderListBean.isIs_success()) {
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }
        if (page == 0 && storeInfoOrderListBean.getData().getGoods().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (page == 0 && mAdapter.getDataList().size() != 0) {
            mAdapter.clear();
            mLadapter.notifyDataSetChanged();
        }


        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (page == storeInfoOrderListBean.getData().getTotal_page()) {
            mRecyclerView.setNoMore(true);
            return;

        }
        mAdapter.addAll(storeInfoOrderListBean.getData().getGoods());
        ++page;
    }

    @Override
    public void onLoadMore() {
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page);
    }

    @Override
    public void reloadLodTip() {
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page);
    }

    @Override
    public void reload() {
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page);
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
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page);
    }
}
