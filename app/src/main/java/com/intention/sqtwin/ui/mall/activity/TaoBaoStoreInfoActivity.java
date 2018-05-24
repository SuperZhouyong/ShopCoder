package com.intention.sqtwin.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.HotAuctionItemAdapter;
import com.intention.sqtwin.adapter.TaoBaoAdapter;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.bean.TaobaoStoreInfoBean;
import com.intention.sqtwin.ui.main.activity.AuctionFiledActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.ui.mall.contract.TaoBaoStoreContract;
import com.intention.sqtwin.ui.mall.model.TaoBaoStorModel;
import com.intention.sqtwin.ui.mall.presenter.TaoBaoStorPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Description: 保佑无bug
 * Data：2018/5/23-下午11:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TaoBaoStoreInfoActivity extends BaseActivity<TaoBaoStorPresenter, TaoBaoStorModel> implements TaoBaoStoreContract.View, OnRefreshListener, LoadingTip.onReloadListener, View.OnClickListener {
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
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    // 主要的adapter
    private TaoBaoAdapter taoBaoAdapter;
    private Integer currentPostion;
    private Integer currentFavId;
    private LRecyclerViewAdapter mLadapter;
    private ImageView iv_store_log;
    private TextView tv_store_name;
    private TextView tv_store_desc;
    //热门拍品的界面
    private HotAuctionItemAdapter hotAuctionItemAdapter;
    private ImageView ivBanner;
    private Integer store_id;
    private int pagesize = 10;
    private RelativeLayout rel_focus;
    private ImageView iv_focus;
    private TextView tv_focus;


    @Override
    public int getLayoutId() {
        return R.layout.activity_taobaostoreinfo;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    public static void GotoTaoBaoSTireInfoActivity(BaseActivity baseActivity, Integer store_id) {

        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.StoreId, store_id);
        baseActivity.startActivity(TaoBaoStoreInfoActivity.class, bundle);
    }

    @Override
    public void initView() {
        store_id = getIntent().getExtras().getInt(AppConstant.StoreId, -1);

        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("店铺");
        relSearch.setVisibility(View.GONE);


        taoBaoAdapter = new TaoBaoAdapter(this);
        mLadapter = new LRecyclerViewAdapter(taoBaoAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
//        mLRecyclerView.setPullRefreshEnabled(true);
        mLRecyclerView.setOnRefreshListener(this);
        mLRecyclerView.setLoadMoreEnabled(false);

        //头布局
        View tabobaoHeader = getLayoutInflater().inflate(R.layout.item_taobao_header, null);
        iv_store_log = (ImageView) tabobaoHeader.findViewById(R.id.iv_icon);
        tv_store_name = (TextView) tabobaoHeader.findViewById(R.id.tv_store_name);
        tv_store_desc = (TextView) tabobaoHeader.findViewById(R.id.tv_store_desc);
        ivBanner = (ImageView) tabobaoHeader.findViewById(R.id.iv_banner);

        rel_focus = (RelativeLayout) tabobaoHeader.findViewById(R.id.rel_focus);
        iv_focus = (ImageView) tabobaoHeader.findViewById(R.id.iv_focus);
        tv_focus = (TextView) tabobaoHeader.findViewById(R.id.tv_focus);

        rel_focus.setOnClickListener(this);

        View taoBaoOneTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) taoBaoOneTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐作品");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);


        View HeadViewTwo = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
//        mHeadTwoAdapter = new HeadTwoAdapter();
        hotAuctionItemAdapter = new HotAuctionItemAdapter(this);

        RecyclerView mRecyclerView = (RecyclerView) HeadViewTwo.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(hotAuctionItemAdapter);


        mLadapter.addHeaderView(tabobaoHeader);
        mLadapter.addHeaderView(taoBaoOneTitle);
        mLadapter.addHeaderView(HeadViewTwo);

        mRxManager.on(AppConstant.TaoBaoFiled, new Action1<FavBean>() {
            @Override
            public void call(FavBean favBean) {
                currentPostion = favBean.getPostion();
                currentFavId = favBean.getFavId();
                mPresenter.getAddFavBean(favBean.getFavId(), AppConstant.field);
            }


        });
        mPresenter.getTaoBaoStoreInfoRequest(store_id);
        // 进入拍场页
        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtils.logd("Postion   " + position);
                AuctionFiledActivity.gotoAuctionFiledActivity(TaoBaoStoreInfoActivity.this, taoBaoAdapter.get(position).getId(), AppConstant.IntoWayOne);

            }
        });
    }


    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId))
            mLRecyclerView.refreshComplete(pagesize);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }

    }

    @Override
    public void returnTaobaoSToreInfo(TaobaoStoreInfoBean taobaoStoreInfoBean) {
        if (!taobaoStoreInfoBean.isIs_success()) {
            showShortToast(taobaoStoreInfoBean.getMessage());
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
//            mLoadingTip.setOnReloadListener(this);
        }
        if (hotAuctionItemAdapter.getDataList().size() != 0)
            hotAuctionItemAdapter.clear();
        if (taoBaoAdapter.getDataList().size() != 0)
            taoBaoAdapter.clear();

        TaobaoStoreInfoBean.DataBean.StoreInfoBean store_info = taobaoStoreInfoBean.getData().getStore_info();
        ImageLoaderUtils.displayRound(this, iv_store_log, store_info.getStore_logo());
        tv_store_name.setText(store_info.getStore_name());
        tv_store_desc.setText(store_info.getStore_description());
        ImageLoaderUtils.displayBigPhoto(this, ivBanner, store_info.getStore_banner());

        hotAuctionItemAdapter.addAll(taobaoStoreInfoBean.getData().getItem_list());
        taoBaoAdapter.addAll(taobaoStoreInfoBean.getData().getAuction_field_list());
    }

    // 关注拍场
    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        // 收藏完毕就刷新
        taoBaoAdapter.AddList(currentFavId);
        taoBaoAdapter.notifyItemChanged(currentPostion);
        showShortToast(addFavBean.getMessage());
    }

    @Override
    public void onRefresh() {
        mPresenter.getTaoBaoStoreInfoRequest(store_id);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getTaoBaoStoreInfoRequest(store_id);
    }


    @OnClick({R.id.rel_back, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.iv_search:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rel_focus:

                break;

        }
    }
}