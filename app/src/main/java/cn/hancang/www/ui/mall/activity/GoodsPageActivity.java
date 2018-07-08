package cn.hancang.www.ui.mall.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.bean.GoodsBuyNewBean;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.AddCartInfoBean;
import cn.hancang.www.bean.GoosPageInfoBean;
import cn.hancang.www.ui.mall.contract.GoodsPageContract;
import cn.hancang.www.ui.mall.model.GoodsPageModel;
import cn.hancang.www.ui.mall.presenter.GoodsPagePresenter;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.widget.AmountView;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

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

public class GoodsPageActivity extends BaseActivity<GoodsPagePresenter, GoodsPageModel> implements GoodsPageContract.View, LoadingTip.onReloadListener {

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
    @BindView(R.id.amount_view)
    AmountView amountView;
    /* @BindView(R.id.mLoopViewPager_two)
     BannerView mLoopViewPagerTwo;*/
    @BindView(R.id.iv_one)
    ImageView ivOne;
    @BindView(R.id.rel_add_shopCart)
    RelativeLayout relAddShopCart;
    @BindView(R.id.iv_two)
    ImageView ivTwo;
    @BindView(R.id.rel_immediately_buy)
    RelativeLayout relImmediatelyBuy;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.tv_bottom)
    TextView tvBottom;
    private int goodsId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_goodspage;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        centerTitle.setText(getIntent().getExtras().getString(AppConstant.GoodsPageTitle));
        relSearch.setVisibility(View.GONE);
        goodsId = getIntent().getExtras().getInt(AppConstant.GoodsPageId, -1);
        mPresenter.getGoodsPageInfoRequest(goodsId);

//        showShortToast("功能代完善");
    }

    // R.id.btnDecrease, R.id.btnIncrease,
    @OnClick({R.id.rel_back, R.id.rel_add_shopCart, R.id.rel_immediately_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
          /*  case R.id.btnDecrease:
                break;
            case R.id.btnIncrease:
                break;*/
            //加入购物车
            case R.id.rel_add_shopCart:

                mPresenter.getAddCartInfoBeanRequest(goodsId, amountView.getAmount());
//                startActivity(ShopCartActivity.class);
                break;
            //立即购买
            case R.id.rel_immediately_buy:
//                mPresenter.getGoodsBuyNewRequest(goodsId,amountView.getAmount());
                ConfirmOrderActivity.gotoConfirmOrderActivity(this,String.valueOf(goodsId),String.valueOf(amountView.getAmount()),AppConstant.oneMessage);

                break;
        }
    }

    public static void gotoGoodsPageActivity(BaseActivity mContext, int id, String GoodsPageTitle) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.GoodsPageId, id);
        bundle.putString(AppConstant.GoodsPageTitle, GoodsPageTitle);
        mContext.startActivity(GoodsPageActivity.class, bundle);

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
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }

    }

    @Override
    public void returnGoodPageInfo(GoosPageInfoBean goosPageInfoBean) {
        if (!goosPageInfoBean.isIs_success()) {
            showShortToast(goosPageInfoBean.getMessage());
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        GoosPageInfoBean.DataBean.InfoBean info = goosPageInfoBean.getData().getInfo();
        mLoopViewPager.setViewFactory(new BannerView.ViewFactory<GoosPageInfoBean.DataBean.InfoBean.ImagesBean>() {
            @Override
            public View create(GoosPageInfoBean.DataBean.InfoBean.ImagesBean imagesBean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, imagesBean.getGoodsimage_url());
                return iv;
            }
        });

        mLoopViewPager.setDataList(info.getImages());
        mLoopViewPager.start();
//        tv_goods_name
        tvGoodsName.setText(getIntent().getExtras().getString(AppConstant.GoodsPageTitle));
//        tv_brand
        tvBottom.setText(info.getDescription() + "");
        tvBrand.setText(info.getBrand_id() + "");
        tvCurrentPrice.setText("￥"+info.getGoods_price());
        tvOldPrice.setText("￥"+info.getGoods_marketprice() + "");
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvBeleft.setText(info.getGoods_storage() + "");


    }

    @Override
    public void returnAddGoodCart(AddCartInfoBean addCartInfoBean) {
        if (!addCartInfoBean.isIs_success()) {
            showShortToast(addCartInfoBean.getMessage());
            return;
        }
        startActivity(ShopCartActivity.class);
    }

    @Override
    public void returnBuyNew(GoodsBuyNewBean goodsBuyNewBean) {

    }


    @Override
    public void reloadLodTip() {
        mPresenter.getGoodsPageInfoRequest(goodsId);
    }


}
