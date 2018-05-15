package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
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
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.text.ParseException;
import java.util.Date;

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
    private TextView orgName;
    private TextView tvLostNum;
    private TextView tvFans;
    private ImageView ivIcon;
    private TextView tvDesc;

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

        artOrgId = getIntent().getExtras().getInt(AppConstant.OrgID);
        mcomAdapter = new CommonRecycleViewAdapter<AuctionOrgBean.DataBean.AuctionFieldListBean>(this, R.layout.item_wholegoods) {
            @Override
            public void convert(ViewHolderHelper helper, AuctionOrgBean.DataBean.AuctionFieldListBean itemListBean, int position) {
                helper.setText(R.id.tv_company_name, itemListBean.getOrganization().getName());
                helper.setImageRoundUrl(R.id.iv_logo, itemListBean.getOrganization().getImage());
//                helper.setText(R.id.tv_fouce_num, itemListBean.get);
                helper.setText(R.id.tv_lot_num, String.valueOf(itemListBean.getItem_count()));
                helper.setText(R.id.tv_price_num, String.valueOf(itemListBean.getBid_count()));
                helper.setText(R.id.tv_filed_name, itemListBean.getName());
                helper.setImageUrl(R.id.iv_pos_goods, itemListBean.getImage());
                LogUtils.logd("我是每个条目");
                helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 点击关注
                    }
                });
                String start_time = itemListBean.getStart_time();
                String end_time = itemListBean.getEnd_time();
                try {
                    Date startTime = PublicKetUtils.df.get().parse(start_time);
                    Date endTime = PublicKetUtils.df.get().parse(end_time);
                    Date currentTime = new Date();
                    if (currentTime.getTime() < endTime.getTime() && currentTime.getTime() > startTime.getTime()) {
                        // 拍卖中
                        long OverMin = (endTime.getTime() - currentTime.getTime()) / (1000 * 60);
                        helper.setText(R.id.tv_time_calculate, OverMin / 60 + "时" + OverMin % 60 + "分");

                    } else if (currentTime.getTime() < startTime.getTime()) {
//                未开拍
                        helper.setText(R.id.tv_time_calculate, "距开拍" + start_time);

                    } else {
                        helper.setText(R.id.tv_time_calculate, "已结束" + end_time);
                    }
//            if (new Date().getTime()<endTime.getTime()&&)
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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
        setMarGinTop(artDetailHead.findViewById(R.id.rel_desc), (int) getResources().getDimension(R.dimen.x22), (int) getResources().getDimension(R.dimen.y30));
        setMarGinTop(artDetailHead.findViewById(R.id.rel_background), (int) getResources().getDimension(R.dimen.x22), (int) getResources().getDimension(R.dimen.y100));
        ivIcon = (ImageView) artDetailHead.findViewById(R.id.iv_header_icon);
        orgName = (TextView) artDetailHead.findViewById(R.id.art_name);
        tvLostNum = (TextView) artDetailHead.findViewById(R.id.tv_lot_num);
        tvFans = (TextView) artDetailHead.findViewById(R.id.tv_price_num);
        tvDesc = (TextView) artDetailHead.findViewById(R.id.tv_desc);
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
            showShortToast(auctionOrgBean.getMessage());
            return;
        }
        AuctionOrgBean.DataBean.OrganizationInfoBean organization_info = auctionOrgBean.getData().getOrganization_info();
        orgName.setText(organization_info.getName());
        ImageLoaderUtils.displayRound(this, ivIcon, organization_info.getImage());
        tvLostNum.setText(organization_info.getGoods_count() + "件");
        tvFans.setText(organization_info.getFans_count() + "人");
        tvDesc.setText(organization_info.getDescription());
        // 非第一页数据请求失败 不同于网路请求，由服务器不反悔数据
        if (!auctionOrgBean.isIs_success())
            return;
        if (page == 0 && mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page == 0) {

        }
        mcomAdapter.addAll(auctionOrgBean.getData().getAuction_field_list());
        ++page;
        /*if (page == auctionOrgBean.getData().getTotal_page())
            mRecyclerView.setNoMore(true);*/
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
        switch (v.getId()) {
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

    public static void gotoAuctionOrg(BaseActivity mActivity, Integer artOrgId) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.OrgID, artOrgId);
        mActivity.startActivity(AuctionOrgActivity.class, bundle);

    }
}
