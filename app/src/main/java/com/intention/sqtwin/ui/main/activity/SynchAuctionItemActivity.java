package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.SynchronousItemBean;
import com.intention.sqtwin.ui.main.contract.SynchAuctionItemContract;
import com.intention.sqtwin.ui.main.model.SynchAuctionModel;
import com.intention.sqtwin.ui.main.presenter.SynchAuctionPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ezy.ui.view.BannerView;

/**
 * Description: 绝无Bug
 * Data：2018/5/16 0016-下午 16:54
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SynchAuctionItemActivity extends BaseActivity<SynchAuctionPresenter, SynchAuctionModel> implements SynchAuctionItemContract.View, LoadingTip.onReloadListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.Tv_time_one)
    TextView TvTimeOne;
    @BindView(R.id.Tv_time_two)
    TextView TvTimeTwo;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private CommonRecycleViewAdapter<SynchronousItemBean.DataBean.SyncAuctionFieldBean> mAdapter;
    private int SynchItemId;

    public static void gotoSynchAuctionItem(BaseActivity mActivity, int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.SynchItemId, id);
        mActivity.startActivity(SynchAuctionItemActivity.class, bundle);
    }

    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {

    }

    @Override
    public void returnSynchronousAuction(SynchronousItemBean synchronousItemBean) {
        if (!synchronousItemBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            showShortToast(synchronousItemBean.getMessage());
            return;
        }
        TvTimeTwo.setText(synchronousItemBean.getData().getSync_auction_field().getAuction_start_time() + "-" + synchronousItemBean.getData().getSync_auction_field().getAuction_end_time());
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        mAdapter.add(synchronousItemBean.getData().getSync_auction_field());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_synchauctionitem;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        SynchItemId = getIntent().getExtras().getInt(AppConstant.SynchItemId, -1);

        mAdapter = new CommonRecycleViewAdapter<SynchronousItemBean.DataBean.SyncAuctionFieldBean>(this, R.layout.item_synchronousauction) {
            @Override
            public void convert(ViewHolderHelper helper, SynchronousItemBean.DataBean.SyncAuctionFieldBean syncAuctionFieldBean, int position) {
                BannerView mBannerView = helper.getView(R.id.mLoopViewPager);
                helper.setText(R.id.tv_name, syncAuctionFieldBean.getGoods_name());
                helper.setText(R.id.tv_num_one, syncAuctionFieldBean.getCurent_price() + "");

                mBannerView.setViewFactory(new BannerView.ViewFactory<SynchronousItemBean.DataBean.SyncAuctionFieldBean.ImagesBean>() {
                    @Override
                    public View create(SynchronousItemBean.DataBean.SyncAuctionFieldBean.ImagesBean syncAuctionFieldBean, int position, ViewGroup container) {
                        ImageView iv = new ImageView(container.getContext());
                        ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, syncAuctionFieldBean.getGoodsimage_url());
                        return iv;
                    }


                });
                mBannerView.setDataList(syncAuctionFieldBean.getImages());
                mBannerView.start();
            }
        };
        mPresenter.getSynchronousAuctionRequest(SynchItemId);
    }


    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
        }
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getSynchronousAuctionRequest(SynchItemId);
    }
}
