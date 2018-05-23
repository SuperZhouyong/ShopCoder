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
import com.intention.sqtwin.baserx.RxBus;
import com.intention.sqtwin.bean.AddFavBean;
import com.intention.sqtwin.bean.AuctionOrgBean;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.ui.main.contract.AuctionOrgContract;
import com.intention.sqtwin.ui.main.model.AuctionOrgModel;
import com.intention.sqtwin.ui.main.presenter.AuctionOrgPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    private Integer status = 0;
    private ImageView ivFocus;
    private TextView tvFocus;
    private List<Integer> mList;
    private int currentPostion = -1;
    private int currentFavId = -1;

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
        mList = new ArrayList<>();
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
        centerTitle.setText("拍卖机构");
        artOrgId = getIntent().getExtras().getInt(AppConstant.OrgID);
        mcomAdapter = new CommonRecycleViewAdapter<AuctionOrgBean.DataBean.AuctionFieldListBean>(this, R.layout.item_wholegoods) {
            @Override
            public void convert(ViewHolderHelper helper, final AuctionOrgBean.DataBean.AuctionFieldListBean itemListBean, final int position) {
                if ("true".equals(itemListBean.getIs_favorite()) || mList.contains(itemListBean.getId())) {
                    helper.setVisible(R.id.iv_focus, false);
                    helper.setText(R.id.tv_focus, "已关注");
                } else {
                    helper.setVisible(R.id.iv_focus, true);
                    helper.setText(R.id.tv_focus, "关注");
                    helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // 关注拍场

                            currentPostion = position;
                            currentFavId = itemListBean.getId();
                            mPresenter.getAddFavArtFiledRequest(itemListBean.getId(), AppConstant.field);
                        }
                    });
                }

                helper.setText(R.id.tv_company_name, itemListBean.getOrganization().getName());
                helper.setImageRoundUrl(R.id.iv_logo, itemListBean.getOrganization().getImage());
//                helper.setText(R.id.tv_fouce_num, itemListBean.get);
                helper.setText(R.id.tv_lot_num, String.valueOf(itemListBean.getItem_count()));
                helper.setText(R.id.tv_price_num, String.valueOf(itemListBean.getBid_count()));
                helper.setText(R.id.tv_filed_name, itemListBean.getName());
                helper.setImageUrl(R.id.iv_pos_goods, itemListBean.getImage());
                LogUtils.logd("我是每个条目");

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
        ivFocus = (ImageView) artDetailHead.findViewById(R.id.iv_focus);
        tvFocus = (TextView) artDetailHead.findViewById(R.id.tv_focus);
        artDetailHead.findViewById(R.id.rel_focus).setOnClickListener(this);
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
        mPresenter.getAuctionOrgRequest(artOrgId, page, status);
    }

    @Override
    public void StartLoading(String RequestId) {

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
        if (AppConstant.twoMessage.equals(RequestId)) {
            showShortToast(msg);
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
    // 机构的关注
    @Override
    public void returnArtFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }

        ivFocus.setVisibility(View.GONE);
        tvFocus.setText("已关注");
    }
    // 拍场机构的关注
    @Override
    public void returnArtFavBeanFiled(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success())
            return;
        if (currentFavId != -1 && currentPostion != -1){

            mList.add(currentFavId);
            mcomAdapter.notifyItemChanged(currentPostion);
        }
    }


    @Override
    public void onLoadMore() {
        mPresenter.getAuctionOrgRequest(artOrgId, page, status);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getAuctionOrgRequest(artOrgId, page, status);
    }

    @Override
    public void reload() {
        mPresenter.getAuctionOrgRequest(artOrgId, page, status);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                if (status == 0)
                    return;
                page = 0;
                status = 0;
                mPresenter.getAuctionOrgRequest(artOrgId, page, status);
                break;
            case R.id.tv_ongoing:
                if (status == 1)
                    return;
                page = 0;
                status = 1;
                mPresenter.getAuctionOrgRequest(artOrgId, page, status);
                break;
            case R.id.tv_preview:
                if (status == 2)
                    return;
                page = 0;
                status = 2;
                mPresenter.getAuctionOrgRequest(artOrgId, page, status);
                break;
            case R.id.tv_over:
                if (status == 3)
                    return;
                page = 0;
                status = 3;
                mPresenter.getAuctionOrgRequest(artOrgId, page, status);
                break;
            // 拍卖机构的关注
            case R.id.rel_focus:
                mPresenter.getAddFavArtRequest(artOrgId, AppConstant.organ);
                break;


        }
    }

    public static void gotoAuctionOrg(BaseActivity mActivity, Integer artOrgId) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.OrgID, artOrgId);
        mActivity.startActivity(AuctionOrgActivity.class, bundle);

    }


    @OnClick(R.id.rel_back)
    public void onViewClicked() {
        finish();
    }
}
