package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.DeleteReceiverBean;
import com.intention.sqtwin.bean.ReceivedGoodsBean;
import com.intention.sqtwin.ui.main.contract.ReceivedGoodsContract;
import com.intention.sqtwin.ui.main.model.ReceivedGoodsModel;
import com.intention.sqtwin.ui.main.presenter.ReceivedGoodsPresenter;
import com.intention.sqtwin.utils.checkbox.SmoothCheckBox;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-上午 11:24
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsActivity extends BaseActivity<ReceivedGoodsPresenter, ReceivedGoodsModel> implements LoadingTip.onReloadListener, OnRefreshListener, ReceivedGoodsContract.View {
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
    private CommonRecycleViewAdapter<ReceivedGoodsBean.DataBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_receivedgoods;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("收货地址");
        relSearch.setVisibility(View.GONE);
        mAdapter = new CommonRecycleViewAdapter<ReceivedGoodsBean.DataBean>(this, R.layout.item_receivedgoods) {
            @Override
            public void convert(ViewHolderHelper helper, final ReceivedGoodsBean.DataBean receivedGoodsBean, int position) {
                helper.setText(R.id.tv_name, receivedGoodsBean.getName());
                helper.setText(R.id.tv_phone_num, receivedGoodsBean.getPhone());
                helper.setText(R.id.tv_address_deatil, receivedGoodsBean.getAddress());
                SmoothCheckBox sCheckBox = helper.getView(R.id.sCheckbox);
                sCheckBox.setChecked("1".equals(receivedGoodsBean.getAddress_is_default()));
                // 删除地址
                helper.getView(R.id.ll_delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getDeleteReciverRequest(receivedGoodsBean.getId());
                    }
                });
                helper.getView(R.id.ll_edit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddReAddressActivity.GotoAddReAddressActivity((ReceivedGoodsActivity) mContext, receivedGoodsBean.getId(), receivedGoodsBean);
                    }
                });
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(true);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setOnRefreshListener(this);
//        RequestDateInfo();
        mPresenter.getReceiverGoodRequest();
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
//        startActivity(AddReAddressActivity.class);
        AddReAddressActivity.GotoAddReAddressActivity(this, -1, null);
    }

    @Override
    public void onRefresh() {
        mPresenter.getReceiverGoodRequest();
//        RequestDateInfo();
    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId))
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
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
            mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
                @Override
                public void reloadLodTip() {
                    mPresenter.getReceiverGoodRequest();
                }
            });
        }
    }

    @Override
    public void returnReceiverGoosBean(ReceivedGoodsBean receivedGoodsBean) {
        if (!receivedGoodsBean.isIs_success() || receivedGoodsBean.getData().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoReceivedAdress);
            mLoadingTip.setOnReloadListener(ReceivedGoodsActivity.this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (mAdapter.getDataList().size() != 0)
            mAdapter.clear();
        mAdapter.addAll(receivedGoodsBean.getData());
    }

    @Override
    public void returnDeleteReceiver(DeleteReceiverBean deleteReceiverBean) {
        if (!deleteReceiverBean.isIs_success()) {
            showShortToast(deleteReceiverBean.getMessage());
            return;
        }
//        mLRecyclerView.refresh();
        mLRecyclerView.forceToRefresh();
    }
}
