package com.intention.sqtwin.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.ShopCartGoodsBean;
import com.intention.sqtwin.greendao.ShopCartGoods;
import com.intention.sqtwin.utils.checkbox.SmoothCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/18 0018-上午 11:13
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ShopCartActivity extends BaseActivity implements SmoothCheckBox.OnCheckedChangeListener {
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
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<ShopCartGoodsBean> mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopcart;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("购物车");
        relSearch.setVisibility(View.GONE);
        sCheckBox.setOnCheckedChangeListener(this);
        mAdapter = new CommonRecycleViewAdapter<ShopCartGoodsBean>(this, R.layout.item_shopcart) {
            @Override
            public void convert(ViewHolderHelper helper, ShopCartGoodsBean shopCartGoodsBean, int position) {
//                    helper.getView(R.id.sCheckBox)
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);

        mAdapter.add(new ShopCartGoodsBean());
    }


    @OnClick({R.id.rel_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                break;

        }
    }

    @Override
    public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {
        if (isChecked) {
        }
    }
}
