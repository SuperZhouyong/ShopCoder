package com.intention.sqtwin.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.ShopCartGoodsBean;
import com.intention.sqtwin.greendao.ShopCartGoods;
import com.intention.sqtwin.ui.mall.contract.ShopCartContract;
import com.intention.sqtwin.ui.mall.model.ShopCartModel;
import com.intention.sqtwin.ui.mall.presenter.ShopCartPresenter;
import com.intention.sqtwin.utils.checkbox.SmoothCheckBox;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/18 0018-上午 11:13
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShopCartActivity extends BaseActivity<ShopCartPresenter, ShopCartModel> implements SmoothCheckBox.OnCheckedChangeListener, ShopCartContract.View, LoadingTip.onReloadListener {
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
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.sCheckBox)
    SmoothCheckBox sCheckBox;
    @BindView(R.id.tv_price_num)
    TextView tvPriceNum;
    @BindView(R.id.rel_bottom)
    RelativeLayout relBottom;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip loadingTip;
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<ShopCartGoodsBean.DataBean.CartBean> mAdapter;
    private SparseArray<Integer> mCheckItem;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopcart;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        mCheckItem = new SparseArray<>();
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("购物车");
        relSearch.setVisibility(View.GONE);
        sCheckBox.setOnCheckedChangeListener(this);
        mAdapter = new CommonRecycleViewAdapter<ShopCartGoodsBean.DataBean.CartBean>(this, R.layout.item_shopcart) {
            @Override
            public void convert(ViewHolderHelper helper, ShopCartGoodsBean.DataBean.CartBean shopCartGoodsBean, final int position) {
//                    helper.getView(R.id.sCheckBox)
                helper.setText(R.id.tv_goods_name, shopCartGoodsBean.getGoods_name());
                helper.setText(R.id.tv_goods_price, shopCartGoodsBean.getPrice());
                TextView tvPrice = helper.getView(R.id.tv_goods_price);
                helper.setImageRoundTwoUrl(R.id.iv_goods_pic, shopCartGoodsBean.getImage());
                updateTextColor(tvPrice, 0, 0);
                SmoothCheckBox smoothCheckBox = helper.getView(R.id.sCheckBox);
                smoothCheckBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
//                        if (isChecked)
//                            mCheckItem.append(position);
                    }
                });
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);

//        mAdapter.add(new ShopCartGoodsBean());
        mPresenter.getShopCartInfoRequest();
//        sCheckBox.setOnCheckedChangeListener(this);
    }


    @OnClick({R.id.rel_back, R.id.tv_confirm, R.id.sCheckBox})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                break;
            case R.id.sCheckBox:
                break;

        }
    }

    @Override
    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
        if (isChecked) {
        }
    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
        }
    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            loadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnShopCartInfo(ShopCartGoodsBean shopCartGoodsBean) {
        if (!shopCartGoodsBean.isIs_success()) {
            showShortToast(shopCartGoodsBean.getMessage());
            return;
        }
        if (shopCartGoodsBean.getData().getCart() == null || shopCartGoodsBean.getData().getCart().size() == 0) {
            loadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoShopCart);

        }
        if (loadingTip.getVisibility() == View.VISIBLE)
            loadingTip.setViewGone();

        mAdapter.addAll(shopCartGoodsBean.getData().getCart());
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getShopCartInfoRequest();
    }

    private void updateTextColor(TextView tv, int starts, int end) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan((int) mContext.getResources().getDimension(R.dimen.x20)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }
}
