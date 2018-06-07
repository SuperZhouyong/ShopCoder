package cn.hancang.www.ui.myinfo.activity;

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
import cn.hancang.www.bean.DeleteReceiverBean;
import cn.hancang.www.bean.ReceivedGoodsBean;
import cn.hancang.www.bean.SetDefaultAddressBean;
import cn.hancang.www.ui.main.contract.ReceivedGoodsContract;
import cn.hancang.www.ui.main.model.ReceivedGoodsModel;
import cn.hancang.www.ui.main.presenter.ReceivedGoodsPresenter;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-上午 11:24
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ReceivedGoodsActivity extends BaseActivity<ReceivedGoodsPresenter, ReceivedGoodsModel> implements LoadingTip.onReloadListener, OnRefreshListener, ReceivedGoodsContract.View, View.OnClickListener {
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
    private CommonRecycleViewAdapter<ReceivedGoodsBean.DataBean> mAdapter;
    private LRecyclerViewAdapter mLadapter;
    private int pagesize = 10;
    private List<Integer> mAddressIdList;
    private Integer currentDefultAddressId;


    @Override
    public int getLayoutId() {
        return R.layout.activity_receivedgoods;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("收货地址");
        relSearch.setVisibility(View.GONE);
        mAddressIdList = new ArrayList<>();
        mAdapter = new CommonRecycleViewAdapter<ReceivedGoodsBean.DataBean>(this, R.layout.item_receivedgoods) {
            @Override
            public void convert(ViewHolderHelper helper, final ReceivedGoodsBean.DataBean receivedGoodsBean, int position) {
                helper.setText(R.id.tv_name, receivedGoodsBean.getName());
                helper.setText(R.id.tv_phone_num, receivedGoodsBean.getPhone());
                helper.setText(R.id.tv_address_deatil, receivedGoodsBean.getAddress());
                final SmoothCheckBox sCheckBox = helper.getView(R.id.sCheckbox);
               /* if (mAddressIdList.size() == 0)
                    sCheckBox.setChecked("1".equals(receivedGoodsBean.getAddress_is_default()), true);
                else
                    sCheckBox.setChecked(mAddressIdList.add(receivedGoodsBean.getId()), true);*/

                sCheckBox.setChecked(mAddressIdList.size() == 0?"1".equals(receivedGoodsBean.getAddress_is_default()):mAddressIdList.contains(receivedGoodsBean.getId()));
                // 删除地址
                helper.getView(R.id.ll_delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getDeleteReciverRequest(receivedGoodsBean.getId());
                    }
                });
                helper.getView(R.id.ll_edit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AddReAddressActivity.GotoAddReAddressActivity((ReceivedGoodsActivity) mContext, receivedGoodsBean.getId(), receivedGoodsBean);
                    }
                });
                helper.setOnClickListener(R.id.sCheckbox, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sCheckBox.setChecked(!sCheckBox.isChecked(), true);
                        if (sCheckBox.isChecked())
                            mPresenter.getSetDefaultAddressRequest(receivedGoodsBean.getId());
                        currentDefultAddressId = receivedGoodsBean.getId();
                    }
                });
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(true);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setOnRefreshListener(this);

        View foot = getLayoutInflater().inflate(R.layout.item_address_bottom, null);
        foot.findViewById(R.id.add_address).setOnClickListener(this);
        mLadapter.addFooterView(foot);
//        RequestDateInfo();
        mPresenter.getReceiverGoodRequest();
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
//        startActivity(AddReAddressActivity.class);
        AddReAddressActivity.GotoAddReAddressActivity(this, -1, null);
    }

    @Override
    public void onRefresh() {
        mPresenter.getReceiverGoodRequest();
//        RequestDateInfo();
    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId))
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId))
            mLRecyclerView.refreshComplete(pagesize);

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(new LoadingTip.onReloadListener() {
                @Override
                public void reloadLodTip() {
                    mPresenter.getReceiverGoodRequest();
                }
            });
        }
    }

    @Override
    public void returnReceiverGoosBean(ReceivedGoodsBean receivedGoodsBean) {
        if (!receivedGoodsBean.isIs_success() || receivedGoodsBean.getData().size() == 0) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoReceivedAdress);
            mLoadingTip.setOnReloadListener(ReceivedGoodsActivity.this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (mAdapter.getDataList().size() != 0)
            mAdapter.clear();
        mAdapter.addAll(receivedGoodsBean.getData());
    }

    @Override
    public void returnDeleteReceiver(DeleteReceiverBean deleteReceiverBean) {
        if (!deleteReceiverBean.isIs_success()) {
            showShortToast(deleteReceiverBean.getMessage());
            return;
        }
//        mLRecyclerView.refresh();
        mLRecyclerView.forceToRefresh();
    }

    @Override
    public void returnSetDefultAddress(SetDefaultAddressBean setDefaultAddressBean) {
        showShortToast(setDefaultAddressBean.getMessage());
        if (!setDefaultAddressBean.isIs_success()) {
            return;
        }
        mAddressIdList.clear();
        mAddressIdList.add(currentDefultAddressId);
        mAdapter.notifyDataSetChanged();
        mLadapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_address:
                AddReAddressActivity.GotoAddReAddressActivity(this, -1, null);
                break;
        }
    }
}
