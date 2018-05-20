package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.MyCompeteBean;
import com.intention.sqtwin.ui.myinfo.contract.MyCompeteContract;
import com.intention.sqtwin.ui.myinfo.model.MyCompeteModel;
import com.intention.sqtwin.ui.myinfo.presenter.MyCompetePresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:38
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteActivity extends BaseActivity<MyCompetePresenter, MyCompeteModel> implements MyCompeteContract.View {
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
    private CommonRecycleViewAdapter<MyCompeteBean.DataBean.GoodsListBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private Integer page = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mycompete;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        centerTitle.setText("参拍");
        relBack.setVisibility(View.GONE);
        mAdapter = new CommonRecycleViewAdapter<MyCompeteBean.DataBean.GoodsListBean>(this, R.layout.item_auction_file_item) {
            @Override
            public void convert(ViewHolderHelper helper, MyCompeteBean.DataBean.GoodsListBean auctionItemListBean, int position) {
                helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());

                helper.setText(R.id.tv_goods_price_foot, auctionItemListBean.getBid_leader());
                helper.setText(R.id.tv_goods_desc_foot, "领先者");

                helper.setText(R.id.tv_goods_price, auctionItemListBean.getCurrent_price());
                helper.setText(R.id.tv_goods_desc, "当前价");
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setPullRefreshEnabled(false);

        mPresenter.getMyCompeteRequest(page);

        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

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
    public void returnMyCompeteBean(MyCompeteBean myCompeteBean) {
        mAdapter.addAll(myCompeteBean.getData().getGoods_list());
    }


    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.rel_search:
                break;
        }
    }
}
