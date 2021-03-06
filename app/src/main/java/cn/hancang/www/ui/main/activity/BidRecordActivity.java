package cn.hancang.www.ui.main.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.adapter.BidRecordAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.BidRecordBean;
import cn.hancang.www.ui.main.contract.BidRecordContract;
import cn.hancang.www.ui.main.model.BidRecordModel;
import cn.hancang.www.ui.main.presenter.BidRecordPresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 出价列表
 * Data：2018/4/26-下午11:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordActivity extends BaseActivity<BidRecordPresenter, BidRecordModel> implements BidRecordContract.View, LoadingTip.onReloadListener {
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
    LoadingTip mLoadingTips;
    private Integer page = 0;
    private LRecyclerViewAdapter mLadapter;
    private BidRecordAdapter bidRecordAdapter;
    private Integer goodId = null;
    private int pagesize = 10;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bidrecordpage;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        goodId = getIntent().getExtras().getInt(AppConstant.BidRecordId, -1);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("出价列表");
        relSearch.setVisibility(View.GONE);
        bidRecordAdapter = new BidRecordAdapter(this);
        mLadapter = new LRecyclerViewAdapter(bidRecordAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setLoadMoreEnabled(false);
//        mRecyclerView.setOnLoadMoreListener(this);
//        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 10, 1, getResources().getColor(R.color.app_bottom_colour)));

        mPresenter.getBidRecordRequest(goodId);
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
        mLoadingTips.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
        mLoadingTips.setOnReloadListener(this);
    }

    @OnClick({R.id.rel_back})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;
        }
    }


    @Override
    public void returnBidRecord(BidRecordBean bidRecordBean) {
        if (!bidRecordBean.isIs_success()) {
            mLoadingTips.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTips.setOnReloadListener(this);
            return;
        }

        if (mLoadingTips.getVisibility() == View.VISIBLE)
            mLoadingTips.setViewGone();
        bidRecordAdapter.addAll(bidRecordBean.getData().getPrice());
    }


    @Override
    public void reloadLodTip() {
        mPresenter.getBidRecordRequest(goodId);
    }
}
