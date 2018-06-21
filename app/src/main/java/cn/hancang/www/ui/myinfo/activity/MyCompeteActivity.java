package cn.hancang.www.ui.myinfo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.MyCompeteBean;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.myinfo.contract.MyCompeteContract;
import cn.hancang.www.ui.myinfo.model.MyCompeteModel;
import cn.hancang.www.ui.myinfo.presenter.MyCompetePresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/11-上午1:38
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

/*public class MyCompeteActivity extends BaseActivity<MyCompetePresenter, MyCompeteModel> implements MyCompeteContract.View, OnRefreshListener, LoadingTip.onReloadListener {
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
    private int pagesize = 10;

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
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("参拍");
        relSearch.setVisibility(View.GONE);
//        relBack.setVisibility(View.GONE);
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
        mRecyclerView.setOnRefreshListener(this);
//        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));


        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, mAdapter.get(position).getId());
            }
        });
        mPresenter.getMyCompeteRequest(page);
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
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnMyCompeteBean(MyCompeteBean myCompeteBean) {
        if (!myCompeteBean.isIs_success() || myCompeteBean.getData().getGoods_list().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (mAdapter.getDataList().size() != 0)
            mAdapter.clear();
        mAdapter.addAll(myCompeteBean.getData().getGoods_list());
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
    public void onRefresh() {
        mPresenter.getMyCompeteRequest(null);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getMyCompeteRequest(null);
    }
}*/
