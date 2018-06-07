package cn.hancang.www.ui.Store.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.TradingDeatilBean;
import cn.hancang.www.ui.Store.contract.TradingDetailContract;
import cn.hancang.www.ui.Store.model.TradingDeatilModel;
import cn.hancang.www.ui.Store.presenter.TradingDeatilPresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午2:46
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TradingDetailActivity extends BaseActivity<TradingDeatilPresenter, TradingDeatilModel> implements OnRefreshListener, TradingDetailContract.View, LoadingTip.onReloadListener {
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
    private CommonRecycleViewAdapter<TradingDeatilBean.DataBean> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tradingdetail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("交易明细");
        relSearch.setVisibility(View.GONE);

        mAdapter = new CommonRecycleViewAdapter<TradingDeatilBean.DataBean>(this, R.layout.item_tradingdeatil) {
            @Override
            public void convert(ViewHolderHelper helper, TradingDeatilBean.DataBean tradingDeatilBean, int position) {
                helper.setText(R.id.tv_one, tradingDeatilBean.getDate());
                helper.setText(R.id.tv_two, tradingDeatilBean.getType() == 1 ? "提现" : "充值");
                helper.setText(R.id.tv_three, tradingDeatilBean.getAmount());

            }
        };

        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(true);
        mLRecyclerView.setOnRefreshListener(this);
        mLRecyclerView.setLoadMoreEnabled(false);


        mPresenter.getTradingDeatilBeanRequest();

    }


    @OnClick({R.id.rel_back, R.id.left_title, R.id.center_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.left_title:
                break;
            case R.id.center_title:
                break;
        }
    }


    @Override
    public void onRefresh() {
        mPresenter.getTradingDeatilBeanRequest();

    }


    @Override
    public void StartLoading(String RequestId) {
        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)){
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnTradingDetail(TradingDeatilBean tradingDeatilBean) {
        if (!tradingDeatilBean.isIs_success()||tradingDeatilBean.getData().size()==0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (mAdapter.getDataList().size() != 0)
            mAdapter.clear();
        mAdapter.addAll(tradingDeatilBean.getData());
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getTradingDeatilBeanRequest();
    }
}
