package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.MessageBean;
import com.intention.sqtwin.bean.OrderListBean;
import com.intention.sqtwin.ui.myinfo.contract.MessageContract;
import com.intention.sqtwin.ui.myinfo.model.MessageModel;
import com.intention.sqtwin.ui.myinfo.presenter.MessagePresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 消息提示页
 * Data：2018/5/10-上午12:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MessageActicity extends BaseActivity<MessagePresenter, MessageModel> implements MessageContract.View, OnRefreshListener, LoadingTip.onReloadListener {
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
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;

    private CommonRecycleViewAdapter<MessageBean> mAdapter;
    private LRecyclerViewAdapter mLAdapter;
    private int pagesize = 10;
    private Integer page_no = 0;

    @Override
    public int getLayoutId() {

        return R.layout.activity_message;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("消息");
        relSearch.setVisibility(View.GONE);

        mAdapter = new CommonRecycleViewAdapter<MessageBean>(this, R.layout.item_message) {
            @Override
            public void convert(ViewHolderHelper helper, MessageBean messageBean, int position) {

            }
        };
        mLAdapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(mLAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setOnRefreshListener(this);

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

            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            } else {
                // 并不提示，直接关闭
            }

        }
    }

    @Override
    public void returnMessage(MessageBean messageBean) {
        if (!messageBean.isIs_success()) {
            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }
        ++page_no;
        mAdapter.add(messageBean);
    }


    @OnClick({R.id.rel_back, R.id.left_title, R.id.center_title, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.left_title:
                break;
            case R.id.center_title:
                break;
            case R.id.rel_search:
                break;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getMessageBeanRequest(page_no);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getMessageBeanRequest(page_no);
    }
}
