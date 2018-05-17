package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import com.intention.sqtwin.bean.ReceivedGoodsBean;
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

public class ReceivedGoodsActivity extends BaseActivity {
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
    private CommonRecycleViewAdapter<ReceivedGoodsBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_receivedgoods;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mAdapter = new CommonRecycleViewAdapter<ReceivedGoodsBean>(this, R.layout.item_receivedgoods) {
            @Override
            public void convert(ViewHolderHelper helper, ReceivedGoodsBean receivedGoodsBean, int position) {

            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);

        mRxManager.add(Api.getDefault(HostType.Jsonpart).getReceivedGoods()
                .compose(RxSchedulers.<ReceivedGoodsBean>io_main())
                .subscribe(new RxSubscriber<ReceivedGoodsBean>(mContext) {
                    @Override
                    protected void _onNext(ReceivedGoodsBean receivedGoodsBean) {
                        if (!receivedGoodsBean.isIs_success()||receivedGoodsBean.getData().size()==0){
                            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                        }
                    }

                    @Override
                    protected void _onError(String message) {

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
}
