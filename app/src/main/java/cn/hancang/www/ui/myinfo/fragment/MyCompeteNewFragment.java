package cn.hancang.www.ui.myinfo.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LazzyFragment;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.MyCompeteBean;
import cn.hancang.www.bean.OrderCreatBean;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.myinfo.activity.ChargeActivity;
import cn.hancang.www.ui.myinfo.contract.MyCompeteContract;
import cn.hancang.www.ui.myinfo.model.MyCompeteModel;
import cn.hancang.www.ui.myinfo.presenter.MyCompetePresenter;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;
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
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.tv_three)
    TextView tvThree;
    Unbinder unbinder1;
    Unbinder unbinder2;
    Unbinder unbinder3;
    private String mTitle;
    private LRecyclerViewAdapter mLadapter;
    private Integer page = null;
    private int pagesize = 10;
    private CommonRecycleViewAdapter<MyCompeteBean.DataBean.GoodsListBean> mAdapter;
    private Integer category_id = 0;
    private List<Integer> mCheckList;

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        tvOne.setText("");
        tvTwo.setText("");

        mCheckList = new ArrayList<>();
        mAdapter = new CommonRecycleViewAdapter<MyCompeteBean.DataBean.GoodsListBean>(getActivity(), R.layout.item_auction_file_item) {
            @Override
            public void convert(ViewHolderHelper helper, final MyCompeteBean.DataBean.GoodsListBean auctionItemListBean, int position) {
                helper.setVisible(R.id.sCheckbox, category_id == 1);
                helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());

                helper.setText(R.id.tv_goods_price_foot, auctionItemListBean.getBid_leader());
                helper.setText(R.id.tv_goods_desc_foot, "领先者");

                helper.setText(R.id.tv_goods_price, auctionItemListBean.getCurrent_price());
                helper.setText(R.id.tv_goods_desc, "当前价");

                if (helper.getView(R.id.sCheckbox).getVisibility() == View.VISIBLE) {
                    final SmoothCheckBox mCheckBox = helper.getView(R.id.sCheckbox);
                    mCheckBox.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mCheckBox.setChecked(!mCheckBox.isChecked());
                            if (mCheckBox.isChecked() && !mCheckList.contains(auctionItemListBean.getId()))
                                mCheckList.add(auctionItemListBean.getId());
                            else if (!mCheckBox.isChecked() && mCheckList.contains(auctionItemListBean.getId()))
                                mCheckList.remove(auctionItemListBean.getId());

                        }
                    });
                }
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
        mPresenter.getMyCompeteRequest(null, category_id == 0 ? 1 : 3);
    }


    @Override
    public void onRefresh() {
        mPresenter.getMyCompeteRequest(null, category_id == 0 ? 1 : 3);
    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId) && mAdapter.getDataList().size() == 0)
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

    @SuppressLint("SetTextI18n")
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
        if (category_id == 0) {
            tvOne.setText("账户余额 ￥" + myCompeteBean.getData().getBalance().getAvailable_predeposit());
            tvTwo.setText("冻结余额 ￥" + myCompeteBean.getData().getBalance().getFreeze_predeposit());
        } else {
            tvOne.setText("");
            tvTwo.setText("");
        }
        tvThree.setText(category_id == 0 ? "充值" : "生成订单");
    }

    @Override
    public void returnOrderCreatBean(OrderCreatBean orderCreatBean) {

    }

    @Override
    public void reloadLodTip() {
        mPresenter.getMyCompeteRequest(null, category_id == 0 ? 1 : 3);
    }

    @OnClick({R.id.tv_one, R.id.tv_two, R.id.tv_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_one:
                break;
            case R.id.tv_two:
                break;
            // 进行充值
            case R.id.tv_three:
                if (category_id == 0)
                    ChargeActivity.gotoChargeActivity(getActivity(), AppConstant.oneMessage);
                else {
                    if (mCheckList.size() == 0) {
                        showShortToast("请选择结算拍品");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < mCheckList.size(); i++) {
                        if (i != mCheckList.size() - 1)
                            stringBuilder.append(mCheckList.get(i)).append(",");
                        else
                            stringBuilder.append(mCheckList.get(i));
                    }
                    mPresenter.getOrderCreatBeanRequest(stringBuilder.toString());
                }
                break;
        }
    }
}
