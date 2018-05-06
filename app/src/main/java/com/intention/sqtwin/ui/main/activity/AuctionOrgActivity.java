package com.intention.sqtwin.ui.main.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AuctionOrgBean;
import com.intention.sqtwin.ui.main.contract.AuctionOrgContract;
import com.intention.sqtwin.ui.main.model.AuctionOrgModel;
import com.intention.sqtwin.ui.main.presenter.AuctionOrgPresenter;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Description: 拍卖机构主页
 * Data：2018/5/3-下午10:40
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionOrgActivity extends BaseActivity<AuctionOrgPresenter, AuctionOrgModel> implements AuctionOrgContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener, View.OnClickListener {
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
    private CommonRecycleViewAdapter<AuctionOrgBean.DataBean.AuctionFieldListBean> mcomAdapter;
    private LRecyclerViewAdapter mLadapter;
    private Integer artOrgId = 1;
    private Integer page = 0;
    private int pagesize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionorg;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);


        mcomAdapter = new CommonRecycleViewAdapter<AuctionOrgBean.DataBean.AuctionFieldListBean>(this, R.layout.item_wholegoods) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionOrgBean.DataBean.AuctionFieldListBean itemListBean, int position) {
                helper.setText(R.id.tv_company_name, itemListBean.getOrganzation().getName());
                helper.setImageRoundUrl(R.id.iv_logo, itemListBean.getOrganzation().getLogo());
//                helper.setText(R.id.tv_fouce_num, itemListBean.get);
                helper.setText(R.id.tv_lot_num, itemListBean.getItem_count());
                helper.setText(R.id.tv_price_num, itemListBean.getBid_count());
                helper.setText(R.id.tv_filed_name, itemListBean.getName());
                helper.setImageUrl(R.id.iv_pos_goods, itemListBean.getImage());
                LogUtils.logd("我是每个条目");
                helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 点击关注
                    }
                });
//                updateTextColor((TextView) helper.getView(R.id.tv_price), 0, 1);
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLadapter = new LRecyclerViewAdapter(mcomAdapter);
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnLoadMoreListener(this);
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        View artDetailHead = getLayoutInflater().inflate(R.layout.item_artdetail_head, null);
        setMarGinTop(artDetailHead.findViewById(R.id.rel_desc), (int) getResources().getDimension(R.dimen.x22),(int) getResources().getDimension(R.dimen.y30));
        setMarGinTop(artDetailHead.findViewById(R.id.rel_background), (int) getResources().getDimension(R.dimen.x22),(int) getResources().getDimension(R.dimen.y100));
        mLadapter.addHeaderView(artDetailHead);
        View homeHeadTitle = getLayoutInflater().inflate(R.layout.item_home_head_title, null);
        homeHeadTitle.findViewById(R.id.tv_all).setOnClickListener(this);
        homeHeadTitle.findViewById(R.id.tv_ongoing).setOnClickListener(this);
        homeHeadTitle.findViewById(R.id.tv_preview).setOnClickListener(this);
        homeHeadTitle.findViewById(R.id.tv_over).setOnClickListener(this);
        mLadapter.addHeaderView(homeHeadTitle);
//        View allHeadView = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
//        mLadapter.addHeaderView(allHeadView);
        mPresenter.getAuctionOrgRequest(artOrgId, page);
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

            } else {

                mRecyclerView.setOnNetWorkErrorListener(this);
            }

        }
    }

    @Override
    public void returnAuctionOrg(AuctionOrgBean auctionOrgBean) {
        // 第一页数据请求失败
        if (!auctionOrgBean.isIs_success() && page == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        // 非第一页数据请求失败 不同于网路请求，由服务器不反悔数据
        if (!auctionOrgBean.isIs_success())
            return;
        if (page == 0 && mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page == 0) {

        }
        mcomAdapter.addAll(auctionOrgBean.getData().getAuction_field_list());
        ++page;
        if (page == auctionOrgBean.getData().getTotal_page())
            mRecyclerView.setNoMore(true);
    }


    @Override
    public void onLoadMore() {
        mPresenter.getAuctionOrgRequest(artOrgId, page);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getAuctionOrgRequest(artOrgId, page);
    }

    @Override
    public void reload() {
        mPresenter.getAuctionOrgRequest(artOrgId, page);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_all:
                break;
            case R.id.tv_ongoing:
                break;
            case R.id.tv_preview:
                break;
            case R.id.tv_over:
                break;

        }
    }
}
