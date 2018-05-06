package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
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
import com.intention.sqtwin.bean.OrganPeBean;
import com.intention.sqtwin.ui.main.contract.OrganPeContract;
import com.intention.sqtwin.ui.main.model.OrganPeModel;
import com.intention.sqtwin.ui.main.presenter.OrganPePresenter;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description: 主理人界面没找到
 * Data：2018/5/4-上午12:24
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeoActivity extends BaseActivity<OrganPePresenter, OrganPeModel> implements OrganPeContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener {
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
    private CommonRecycleViewAdapter<OrganPeBean.DataBean.AuctionFieldListBean> mcomAdapter;
    private LRecyclerViewAdapter mLadapter;
    private Integer staffID = 1;
    private Integer page = 0;
    private int pagesize = 10;
    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;

    @Override
    public int getLayoutId() {
        return R.layout.activity_organpeo;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
        centerTitle.setText("主理人");
        mcomAdapter = new CommonRecycleViewAdapter<OrganPeBean.DataBean.AuctionFieldListBean>(this, R.layout.item_wholegoods) {
            @Override
            public void convert(ViewHolderHelper helper, OrganPeBean.DataBean.AuctionFieldListBean itemListBean, int position) {
//                helper.setText(R.id.tv_company_name, itemListBean.getOrganzation().getName());
//                helper.setImageRoundUrl(R.id.iv_logo, itemListBean.getOrganzation().getLogo());
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
//                updateTextColor((TextView) helper.gmetView(R.id.tv_price), 0, 1);
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLadapter = new LRecyclerViewAdapter(mcomAdapter);
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnLoadMoreListener(this);
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        View artDetailHead = getLayoutInflater().inflate(R.layout.item_organpeo_head, null);
        tv_one = (TextView) artDetailHead.findViewById(R.id.tv_one);
        tv_two = (TextView) artDetailHead.findViewById(R.id.tv_two);
        tv_three = (TextView) artDetailHead.findViewById(R.id.tv_three);

//        setMarGinTop(artDetailHead.findViewById(R.id.rel_desc), (int) getResources().getDimension(R.dimen.x22),(int) getResources().getDimension(R.dimen.y30));
//        setMarGinTop(artDetailHead.findViewById(R.id.rel_background), (int) getResources().getDimension(R.dimen.x22),(int) getResources().getDimension(R.dimen.y100));
        mLadapter.addHeaderView(artDetailHead);
        //item_home_head_title
        View homeHeadTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView tv_title = (TextView) homeHeadTitle.findViewById(R.id.yv_all_recy_head_title);
        tv_title.setText("参与主理的拍场");
        setMarGinTop(homeHeadTitle.findViewById(R.id.yv_all_recy_head_title), (int) getResources().getDimension(R.dimen.x22), 0);
        mLadapter.addHeaderView(homeHeadTitle);
//        View allHeadView = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
//        mLadapter.addHeaderView(allHeadView);
        mPresenter.getRequestData(staffID, page);
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
    public void returnOrganPeData(OrganPeBean organPeBean) {
        if (!organPeBean.isIs_success()) {
            // 非第一页数据请求失败 不同于网路请求，由服务器不反悔数据
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }


        if (page == 0 && mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page == 0) {
            tv_one.setText(organPeBean.getData().getStaff_info().getName());
//            tv_two.setText(organPeBean.getData().getStaff_info().get);

        }
        mcomAdapter.addAll(organPeBean.getData().getAuction_field_list());
        ++page;
        if (page == organPeBean.getData().getTotal_page())
            mRecyclerView.setNoMore(true);
    }


    @Override
    public void onLoadMore() {
        mPresenter.getRequestData(staffID, page);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getRequestData(staffID, page);
    }

    @Override
    public void reload() {
        mPresenter.getRequestData(staffID, page);
    }
}
