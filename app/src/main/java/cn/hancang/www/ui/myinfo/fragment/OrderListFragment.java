package cn.hancang.www.ui.myinfo.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.LazzyFragment;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.OrderListBean;
import cn.hancang.www.ui.main.activity.AuctionFiledActivity;
import cn.hancang.www.ui.myinfo.contract.OrderListContract;
import cn.hancang.www.ui.myinfo.model.OrderListModer;
import cn.hancang.www.ui.myinfo.presenter.OrderListPresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Description: 订单列表
 * Data：2018/5/10-上午12:18
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrderListFragment extends LazzyFragment<OrderListPresenter, OrderListModer> implements OrderListContract.View, OnRefreshListener, LoadingTip.onReloadListener, OnNetWorkErrorListener {
    private String mTitle;

    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private CommonRecycleViewAdapter<OrderListBean.DataBean> mAdapter;
    private LRecyclerViewAdapter mLAdapter;
    private int pagesize = 10;
    //yema
    private Integer page = 0;
    //status
    private Integer category_id;
    //type
    private Integer type;

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    /**
     * @param title
     * @param category_id 订单状态：0:已取消 10:未付款 20:已付款 30:已发货 40:已收货
     * @param type        0=商城订单；1=拍卖订单
     * @return
     */
    public static OrderListFragment getInstance(String title, Integer category_id, Integer type) {
        OrderListFragment sf = new OrderListFragment();
        sf.mTitle = title;
        if (category_id == 0)
            category_id = 0;
        if (category_id == 1)
            category_id = 10;
        if (category_id == 2)
            category_id = 30;
        if (category_id == 3)
            category_id = 40;
        sf.category_id = category_id;
        sf.type = type;
        return sf;
    }

    @Override
    protected void initView() {
        mAdapter = new CommonRecycleViewAdapter<OrderListBean.DataBean>(getActivity(), R.layout.item_orderlist) {
            @Override
            public void convert(ViewHolderHelper helper, OrderListBean.DataBean orderListBean, int position) {
                //todo type 可以换成内置的type
                helper.setText(R.id.tv_order_name, type == 0 ? "商城订单" : "拍卖订单");
                helper.setImageUrl(R.id.iv_goods_pic, orderListBean.getMain_goods_image());
                helper.setText(R.id.tv_goods_name, orderListBean.getMain_goods_name());
                helper.setText(R.id.tv_goods_time, orderListBean.getOrder_time());

            }
        };
        mLAdapter = new LRecyclerViewAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        mRecyclerView.setAdapter(mLAdapter);
        mRecyclerView.setPullRefreshEnabled(true);
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
        mPresenter.getOrderListRquest(category_id == 0 ? null : category_id, page, type);

    }

    @Override
    public void StartLoading(String RequestId) {
        if (page == 0 && mAdapter.getDataList().size() == 0)
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
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
        if (!orderListBean.isIs_success()) {
            if (page == 0)
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            else
                mRecyclerView.setOnNetWorkErrorListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page == 0 && mAdapter.getDataList().size() != 0) {
            mAdapter.clear();
            mLAdapter.notifyDataSetChanged();
        }
        if (page == 0 && orderListBean.getData().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        //Todo 这里单独处理数据？？
        if (page != 0 && orderListBean.getData().size() == 0) {

            mRecyclerView.setNoMore(true);
            return;
        }

        mAdapter.addAll(orderListBean.getData());
        ++page;
    }



   /* @Override
    public void onLoadMore() {
      mPresenter.getOrderListRquest(category_id);
    }*/

    @Override
    public void onRefresh() {

        mPresenter.getOrderListRquest(category_id == 0 ? null : category_id, page, type);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getOrderListRquest(category_id == 0 ? null : category_id, page, type);
    }

    @Override
    public void reload() {
        mPresenter.getOrderListRquest(category_id == 0 ? null : category_id, page, type);
    }
}
