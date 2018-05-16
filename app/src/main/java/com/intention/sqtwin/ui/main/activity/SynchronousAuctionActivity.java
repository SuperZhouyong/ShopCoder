package com.intention.sqtwin.ui.main.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.SynchronousAuctionBean;
import com.intention.sqtwin.ui.main.contract.SynchronousAuctionContract;
import com.intention.sqtwin.ui.main.model.SynchronousAuctionModel;
import com.intention.sqtwin.ui.main.presenter.SynchronousAuctionPresenter;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.text.ParseException;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 同步拍
 * Data：2018/5/16 0016-下午 15:49
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchronousAuctionActivity extends BaseActivity<SynchronousAuctionPresenter, SynchronousAuctionModel> implements SynchronousAuctionContract.View, LoadingTip.onReloadListener, OnNetWorkErrorListener, OnLoadMoreListener {
    @BindView(R.id.category_logo)
    ImageView categoryLogo;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;

    //    private Integer category_id;
//    private Integer status;
    private Integer page_no = 0;
    private CommonRecycleViewAdapter<SynchronousAuctionBean.DataBean.SyncAuctionFieldBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;

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
            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            } else {
                mRecyclerView.setOnNetWorkErrorListener(this);
            }
        }
    }

    @Override
    public void returnSynchronousAuction(SynchronousAuctionBean synchronousAuctionBean) {
        if (!synchronousAuctionBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            showShortToast(synchronousAuctionBean.getMessage());
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        mAdapter.addAll(synchronousAuctionBean.getData().getSync_auction_field());
        ++page_no;
        if (page_no == synchronousAuctionBean.getData().getPage_count()) {
            mRecyclerView.setNoMore(true);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_synchronousauction;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        mAdapter = new CommonRecycleViewAdapter<SynchronousAuctionBean.DataBean.SyncAuctionFieldBean>(this, R.layout.item_wholegoods) {
            @Override
            public void convert(ViewHolderHelper helper, final SynchronousAuctionBean.DataBean.SyncAuctionFieldBean recommendFieldBean, int position) {
//        helper.setVisible(R.id.tv_filed_title, position == 0);
                helper.setText(R.id.tv_company_name, recommendFieldBean.getOrganization().getName());
                helper.setImageRoundUrl(R.id.iv_logo, recommendFieldBean.getOrganization().getImage());
                helper.setText(R.id.tv_fouce_num, String.valueOf(recommendFieldBean.getFans_count()));
                helper.setText(R.id.tv_lot_num, String.valueOf(recommendFieldBean.getItem_count()));
                helper.setText(R.id.tv_price_num, String.valueOf(recommendFieldBean.getBid_count()));
                helper.setText(R.id.tv_filed_name, recommendFieldBean.getName());
                helper.setImageUrl(R.id.iv_pos_goods, recommendFieldBean.getImage());
                String start_time = recommendFieldBean.getStart_time();
                String end_time = recommendFieldBean.getEnd_time();
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
                helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 点击关注
                    }
                });
                helper.setOnClickListener(R.id.tv_company_name, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AuctionOrgActivity.gotoAuctionOrg((MainActivity) mContext, recommendFieldBean.getOrganization_id());
                    }
                });
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        SynchAuctionItemActivity.gotoSynchAuctionItem((BaseActivity) mContext,recommendFieldBean.getId());
                        AuctionFiledActivity.gotoAuctionFiledActivity((BaseActivity) mContext, recommendFieldBean.getId(),AppConstant.IntoWayTwo);
                    }
                });
            }
        };

        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnLoadMoreListener(this);

        mPresenter.getSynchronousAuctionRequest(page_no);
    }


    @OnClick({R.id.category_logo, R.id.iv_love, R.id.iv_readme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.category_logo:
                startActivity(CategoryActivity.class);
                break;
            case R.id.iv_love:
                break;
            case R.id.iv_readme:
                break;
        }
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getSynchronousAuctionRequest(page_no);
    }

    @Override
    public void reload() {
        mPresenter.getSynchronousAuctionRequest(page_no);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getSynchronousAuctionRequest(page_no);
    }
}
