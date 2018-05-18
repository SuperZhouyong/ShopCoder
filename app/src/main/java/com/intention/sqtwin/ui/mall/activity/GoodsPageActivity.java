package com.intention.sqtwin.ui.mall.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import ezy.ui.view.BannerView;

/**
 * Description: 商品详情
 * Data：2018/5/18-上午1:27
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoodsPageActivity extends BaseActivity {
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
    @BindView(R.id.mLoopViewPager)
    BannerView mLoopViewPager;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_current_price)
    TextView tvCurrentPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_brand)
    TextView tvBrand;
    @BindView(R.id.tv_beleft)
    TextView tvBeleft;
    @BindView(R.id.btnDecrease)
    Button btnDecrease;
    @BindView(R.id.etAmount)
    TextView etAmount;
    @BindView(R.id.btnIncrease)
    Button btnIncrease;
    @BindView(R.id.mLoopViewPager_two)
    BannerView mLoopViewPagerTwo;
    @BindView(R.id.iv_one)
    ImageView ivOne;
    @BindView(R.id.rel_add_shopCart)
    RelativeLayout relAddShopCart;
    @BindView(R.id.iv_two)
    ImageView ivTwo;
    @BindView(R.id.rel_immediately_buy)
    RelativeLayout relImmediatelyBuy;

    @Override
    public int getLayoutId() {
        return R.layout.activity_goodspage;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.rel_back, R.id.btnDecrease, R.id.btnIncrease, R.id.rel_add_shopCart, R.id.rel_immediately_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.btnDecrease:
                break;
            case R.id.btnIncrease:
                break;
            case R.id.rel_add_shopCart:
                break;
            case R.id.rel_immediately_buy:
                break;
        }
    }
}
