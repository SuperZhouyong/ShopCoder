package com.intention.sqtwin.ui.myinfo.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.LazzyFragment;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.OrderListBean;
import com.intention.sqtwin.ui.main.activity.AuctionFiledActivity;
import com.intention.sqtwin.ui.myinfo.contract.OrderListContract;
import com.intention.sqtwin.ui.myinfo.model.OrderListModer;
import com.intention.sqtwin.ui.myinfo.presenter.OrderListPresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Description: 订单列表
 * Data：2018/5/10-上午12:18
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListFragment extends LazzyFragment<OrderListPresenter, OrderListModer> implements OrderListContract.View, OnRefreshListener, LoadingTip.onReloadListener {
    public String mTitle;
    public Integer category_id;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private CommonRecycleViewAdapter<OrderListBean> mAdapter;
    private LRecyclerViewAdapter mLAdapter;
    private int pagesize = 10;

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mAdapter = new CommonRecycleViewAdapter<OrderListBean>(getActivity(), R.layout.item_orderlist) {
            @Override
            public void convert(ViewHolderHelper helper, OrderListBean orderListBean, int position) {

            }
        };
        mLAdapter = new LRecyclerViewAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        mRecyclerView.setAdapter(mLAdapter);
//        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnRefreshListener(this);
        mRecyclerView.setLoadMoreEnabled(true);
//        mRecyclerView.setOnLoadMoreListener(this);

        mLAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(getActivity(), AuctionFiledActivity.class);
            }
        });


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_orderlist;
    }

    @Override
    protected void RequestNetWorkData() {
        mPresenter.getOrderListRquest(category_id);

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
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);

        }
    }

    @Override
    public void returnOrderList(OrderListBean orderListBean) {
        if (mAdapter.getDataList().size() != 0) {
            mAdapter.clearData();
            mLAdapter.notifyDataSetChanged();
        }
        //测试未写完毕
        mAdapter.add(orderListBean);
    }



   /* @Override
    public void onLoadMore() {
      mPresenter.getOrderListRquest(category_id);
    }*/

    @Override
    public void onRefresh() {

        mPresenter.getOrderListRquest(category_id);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getOrderListRquest(category_id);
    }
}
