package com.intention.sqtwin.ui.Store.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.StoreMessageBean;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午11:20
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreMessageActivity extends BaseActivity implements LoadingTip.onReloadListener, OnRefreshListener {
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
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<StoreMessageBean.DataBean> mAdapter;
    private int pagesize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_storemessage;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("消息中心");
        relSearch.setVisibility(View.GONE);

        mAdapter = new CommonRecycleViewAdapter<StoreMessageBean.DataBean>(this, R.layout.item_storemessage) {
            @Override
            public void convert(ViewHolderHelper helper, StoreMessageBean.DataBean storeMessageBean, int position) {
                helper.setImageUrl(R.id.iv_head, storeMessageBean.getStore_logo());
                helper.setText(R.id.tv_desc, storeMessageBean.getStoremsg_content());
                helper.setText(R.id.tv_time, storeMessageBean.getStoremsg_addtime());
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setOnRefreshListener(this);
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 10, 1, getResources().getColor(R.color.app_bottom_colour)));
        RequestDate();
    }

    private void RequestDate() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart).getStoreMessagebean().compose(RxSchedulers.<StoreMessageBean>io_main()).subscribe(new RxSubscriber<StoreMessageBean>(mContext) {
            @Override
            protected void _onNext(StoreMessageBean storeMessageBean) {
                showShortToast(storeMessageBean.getMessage());
                if (!storeMessageBean.isIs_success() || storeMessageBean.getData().size() == 0) {
                    mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                    return;
                }

                if (mLoadingTip.getVisibility() == View.VISIBLE)
                    mLoadingTip.setViewGone();
                if (mAdapter.getDataList().size() != 0)
                    mAdapter.clear();
                mAdapter.addAll(storeMessageBean.getData());
            }

            @Override
            protected void _onError(String message) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(StoreMessageActivity.this);

            }

            @Override
            public void onStart() {
                super.onStart();
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                mLRecyclerView.refreshComplete(pagesize);
            }
        }));
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
        RequestDate();
    }

    @Override
    public void onRefresh() {
        RequestDate();
    }
}
