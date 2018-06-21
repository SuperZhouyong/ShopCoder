package cn.hancang.www.ui.myinfo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LazzyFragment;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.MyCompeteBean;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.myinfo.contract.MyCompeteContract;
import cn.hancang.www.ui.myinfo.model.MyCompeteModel;
import cn.hancang.www.ui.myinfo.presenter.MyCompetePresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

/**
 * Description: 保佑无bug
 * Data：2018/6/15-下午11:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyCompeteNewFragment extends LazzyFragment<MyCompetePresenter, MyCompeteModel> implements MyCompeteContract.View, OnRefreshListener, LoadingTip.onReloadListener {

    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    Unbinder unbinder;
    private String mTitle;
    private LRecyclerViewAdapter mLadapter;
    private Integer page = null;
    private int pagesize = 10;
    private CommonRecycleViewAdapter<MyCompeteBean.DataBean.GoodsListBean> mAdapter;
    private Integer category_id = 0;

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mAdapter = new CommonRecycleViewAdapter<MyCompeteBean.DataBean.GoodsListBean>(getActivity(), R.layout.item_auction_file_item) {
            @Override
            public void convert(ViewHolderHelper helper, MyCompeteBean.DataBean.GoodsListBean auctionItemListBean, int position) {
                helper.setVisible(R.id.sCheckbox, category_id == 1);
                helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());

                helper.setText(R.id.tv_goods_price_foot, auctionItemListBean.getBid_leader());
                helper.setText(R.id.tv_goods_desc_foot, "领先者");

                helper.setText(R.id.tv_goods_price, auctionItemListBean.getCurrent_price());
                helper.setText(R.id.tv_goods_desc, "当前价");
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setOnRefreshListener(this);
//        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));


        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) getActivity(), mAdapter.get(position).getId());
            }
        });

    }

    public static MyCompeteNewFragment getInstance(String title, Integer category_id) {
        MyCompeteNewFragment sf = new MyCompeteNewFragment();
        sf.mTitle = title;
        sf.category_id = category_id;
        return sf;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_myconpetenew;
    }

    @Override
    protected void RequestNetWorkData() {

    }


    @Override
    public void onRefresh() {

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

    }

    @Override
    public void reloadLodTip() {

    }
}
