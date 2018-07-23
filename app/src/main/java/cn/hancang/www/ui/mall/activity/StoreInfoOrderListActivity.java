package cn.hancang.www.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.SparseArray;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AuctionListBean;
import cn.hancang.www.bean.StoreInfoOrderListBean;
import cn.hancang.www.ui.main.contract.AuctionListContract;
import cn.hancang.www.ui.main.model.AuctionListModel;
import cn.hancang.www.ui.main.presenter.AuctionListPresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

//import cn.hancang.www.bean.AuctionListBean;

/**
 * Description: 保佑无bug
 * Data：2018/7/1-上午9:17
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoOrderListActivity extends BaseActivity<AuctionListPresenter, AuctionListModel> implements AuctionListContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener, OnRefreshListener {

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
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.iv_all)
    ImageView ivAll;
    @BindView(R.id.rel_all)
    RelativeLayout relAll;
    @BindView(R.id.tv_new)
    TextView tvNew;
    @BindView(R.id.iv_new_top)
    ImageView ivNewTop;
    @BindView(R.id.iv_new)
    ImageView ivNew;
    @BindView(R.id.rel_new)
    RelativeLayout relNew;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.iv_price_top)
    ImageView ivPriceTop;
    @BindView(R.id.iv_price)
    ImageView ivPrice;
    @BindView(R.id.rel_price)
    RelativeLayout relPrice;
    @BindView(R.id.tv_sales)
    TextView tvSales;
    @BindView(R.id.iv_sales_top)
    ImageView ivSalesTop;
    @BindView(R.id.iv_sales)
    ImageView ivSales;
    @BindView(R.id.rel_sales)
    RelativeLayout relSales;
    @BindView(R.id.ll_sort)
    LinearLayout llSort;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    //    private Integer category = 111;
    private Integer page = 0;
    private CommonRecycleViewAdapter<StoreInfoOrderListBean.DataBean.GoodsBean> mAdapter;

    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;
    private int storeId;
    //    limit ：参数 0=》全部； 1=》商品升序； 2=》商品降序； 3=》价格升序； 4=》价格降序； 5=》销量升序； 6=》销量降序
    private int limit = 0;
    //    private int goodType;

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
        centerTitle.setText(getIntent().getExtras().getString(AppConstant.storeName));
        storeId = getIntent().getExtras().getInt(AppConstant.StoreId);
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);

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
        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                GoodsPageActivity.gotoGoodsPageActivity((BaseActivity) mContext, mAdapter.get(position).getId(), mAdapter.get(position).getName());
            }
        });

        mPresenter.getStoreInfoList(storeId, page, limit);
    }

    public static void gotoStoreInfoOrderListActivity(BaseActivity mContext, Integer storeId, String storeTitle) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.StoreId, storeId);
        bundle.putString(AppConstant.storeName, storeTitle);
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

    }


    @Override
    public void returnStoreInfoList(StoreInfoOrderListBean storeInfoOrderListBean) {
        if (!storeInfoOrderListBean.isIs_success()) {
            if (page == 0) {
                mAdapter.clearData();
                mLadapter.notifyDataSetChanged();
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
//                mLoadingTip.setOnReloadListener(this);
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
        mPresenter.getStoreInfoList(storeId, page, limit);
    }

    @Override
    public void reloadLodTip() {
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page, limit);
    }

    @Override
    public void reload() {
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page, limit);
    }

    private SparseArray<Integer> mSparseArray = new SparseArray<>();

    //heat_slect_top   heat_select_bottom  heat_unselect
    //    limit ：参数 0=》全部； 1=》商品升序； 2=》商品降序； 3=》价格升序； 4=》价格降序； 5=》销量升序； 6=》销量降序
    @OnClick({R.id.rel_back, R.id.left_title, R.id.rel_all, R.id.rel_new, R.id.rel_price, R.id.rel_sales})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.left_title:
                break;
            // 全部 0
            case R.id.rel_all:
                limit = 0;
                page = 0;
                ivAll.setVisibility(View.VISIBLE);
                mPresenter.getStoreInfoList(storeId, page, limit);


                ivNew.setVisibility(View.GONE);
                ivPrice.setVisibility(View.GONE);
                ivSales.setVisibility(View.GONE);

                ivNewTop.setImageResource(R.mipmap.heat_unselect);
                ivPriceTop.setImageResource(R.mipmap.heat_unselect);
                ivSalesTop.setImageResource(R.mipmap.heat_unselect);
                break;
            //新品 1
            case R.id.rel_new:
                page =0 ;
                limit = limit == 1 ? 2 : 1;
                ivNew.setVisibility(View.VISIBLE);
                ivNewTop.setImageResource(limit == 1 ? R.mipmap.heat_slect_top : R.mipmap.heat_select_bottom);
                mPresenter.getStoreInfoList(storeId, page, limit);

                ivAll.setVisibility(View.GONE);

                ivPrice.setVisibility(View.GONE);
                ivPriceTop.setImageResource(R.mipmap.heat_unselect);
                ivSales.setVisibility(View.GONE);
                ivSalesTop.setImageResource(R.mipmap.heat_unselect);
                break;
            //价格 2
            case R.id.rel_price:
                page =0 ;
                limit = limit == 3 ? 4 : 3;
                ivPrice.setVisibility(View.VISIBLE);
                ivPriceTop.setImageResource(limit == 3 ? R.mipmap.heat_slect_top : R.mipmap.heat_select_bottom);
                mPresenter.getStoreInfoList(storeId, page, limit);


                ivAll.setVisibility(View.GONE);
                ivNew.setVisibility(View.GONE);
                ivNewTop.setImageResource(R.mipmap.heat_unselect);
                ivSales.setVisibility(View.GONE);
                ivSalesTop.setImageResource(R.mipmap.heat_unselect);
                break;


            //销量 3
            case R.id.rel_sales:
                page =0 ;
                limit = limit == 5 ? 6 : 5;
                ivSales.setVisibility(View.VISIBLE);
                ivSalesTop.setImageResource(limit == 5 ? R.mipmap.heat_slect_top : R.mipmap.heat_select_bottom);
                mPresenter.getStoreInfoList(storeId, page, limit);

                ivAll.setVisibility(View.GONE);
                ivNew.setVisibility(View.GONE);
                ivNewTop.setImageResource(R.mipmap.heat_unselect);
                ivPrice.setVisibility(View.GONE);
                ivPriceTop.setImageResource(R.mipmap.heat_unselect);
                break;
        }
    }


    @Override
    public void onRefresh() {
        page = 0;
//        mPresenter.getRequestAuctionList(category, page, goodType);
        mPresenter.getStoreInfoList(storeId, page, limit);
    }



}
