package cn.hancang.www.ui.mall.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.flipboard.bottomsheet.BottomSheetLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.adapter.SearchAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AddCartInfoBean;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.bean.GoosPageInfoBean;
import cn.hancang.www.ui.main.activity.auitemItemPicActivity;
import cn.hancang.www.ui.mall.contract.GoodsPageContract;
import cn.hancang.www.ui.mall.model.GoodsPageModel;
import cn.hancang.www.ui.mall.presenter.GoodsPagePresenter;
import cn.hancang.www.utils.conmonUtil.DiskUtil;
import cn.hancang.www.utils.conmonUtil.GlideRoundTransformUtil;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.utils.conmonUtil.ImageUtils;
import cn.hancang.www.utils.conmonUtil.ShareUtil;
import cn.hancang.www.widget.AmountView;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import cn.hancang.www.widget.flow.FlowTagLayout;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import ezy.ui.view.BannerView;

/**
 * Description: 商品详情
 * Data：2018/5/18-上午1:27
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class GoodsPageActivity extends BaseActivity<GoodsPagePresenter, GoodsPageModel> implements GoodsPageContract.View, LoadingTip.onReloadListener, View.OnClickListener {

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
    /* @BindView(R.id.tv_brand)
     TextView tvBrand;*/
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
    @BindView(R.id.rel_goto_store)
    RelativeLayout relGotoStore;
    @BindView(R.id.rel_store_focus)
    RelativeLayout relStoreFocus;
    @BindView(R.id.tv_add_focus)
    TextView tvAddFocus;
    @BindView(R.id.rel_qd)
    LinearLayout relQd;
    @BindView(R.id.mRecyImages)
    RecyclerView mRecyclerImages;
    @BindView(R.id.bottomSheetLayout)
    BottomSheetLayout bottomSheetLayout;
    private CommonRecycleViewAdapter<GoosPageInfoBean.DataBean.InfoBean.DescriptionImageBean> mImagesAdapter;
    //    private SearchAdapter searchAdapter;
    private int goodsId;
    private int store_id;
    private Dialog shareDialog;
    private String share_url;
    private View bottomSheet;
    //    private RecyclerView rvSelected;
    private TextView tvprice;
    private TextView tvstorage;
    private LinearLayout lldesc;
    private cn.hancang.www.widget.flow.FlowTagLayout tagflow;
//    private AmountView amountView;

    private void showBootomDialog() {//
        if (bottomSheet == null) {
            bottomSheet = createBottomSheetView();
        }
        if (bottomSheetLayout.isSheetShowing()) {
            bottomSheetLayout.dismissSheet();
        } else {
            bottomSheetLayout.showWithSheetView(bottomSheet);
        }
    }

    private View createBottomSheetView() {
        View view = LayoutInflater.from(this).inflate(R.layout.item_goods_page_dialog, (ViewGroup) getWindow().getDecorView(), false);
        this.amountView = (AmountView) view.findViewById(R.id.amount_view);
        this.tagflow = (FlowTagLayout) view.findViewById(R.id.tag_flow);
        this.lldesc = (LinearLayout) view.findViewById(R.id.ll_desc);
        this.tvstorage = (TextView) view.findViewById(R.id.tv_storage);
        this.tvprice = (TextView) view.findViewById(R.id.tv_price);
        return view;
    }

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
//        relSearch.setVisibility(View.GONE);
        goodsId = getIntent().getExtras().getInt(AppConstant.GoodsPageId, -1);
        mPresenter.getGoodsPageInfoRequest(goodsId);
        relQd.setOnClickListener(this);
//        showShortToast("功能代完善");
        mImagesAdapter = new CommonRecycleViewAdapter<GoosPageInfoBean.DataBean.InfoBean.DescriptionImageBean>(mContext, R.layout.item_images) {
            @Override
            public void convert(ViewHolderHelper helper, GoosPageInfoBean.DataBean.InfoBean.DescriptionImageBean descriptionImageBean, int position) {
                helper.setImageUrl(R.id.mImages, descriptionImageBean.getImage_url());
            }
        };
        mRecyclerImages.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerImages.setAdapter(mImagesAdapter);


    }

    // R.id.btnDecrease, R.id.btnIncrease,
    @OnClick({R.id.rel_back, R.id.rel_add_shopCart, R.id.rel_immediately_buy, R.id.rel_goto_store, R.id.rel_search, R.id.rel_select_size})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;

            case R.id.rel_search:
                if (TextUtils.isEmpty(share_url)) {
                    showShortToast("请稍后再分享");
                    return;
                }
                showShareDialog(share_url);
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
                ConfirmOrderActivity.gotoConfirmOrderActivity(this, String.valueOf(goodsId), String.valueOf(amountView.getAmount()), AppConstant.oneMessage);

                break;
            case R.id.rel_goto_store:
                TaoBaoStoreInfoActivity.GotoTaoBaoSTireInfoActivity((BaseActivity) mContext, store_id);
                break;
            // 选择规格界面
            case R.id.rel_select_size:
                showBootomDialog();
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

    private void showShareDialog(String url) {
        shareDialog = new Dialog(GoodsPageActivity.this, R.style.MyDialog);
        View shareView = getLayoutInflater().inflate(R.layout.share_dialog, null);
        ImageView ivShareCode = (ImageView) shareView.findViewById(R.id.iv_share_code);
        shareView.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareDialog.dismiss();
            }
        });
        shareView.findViewById(R.id.iv_close).setOnClickListener(this);
        shareView.findViewById(R.id.ll_wx).setOnClickListener(this);
        shareView.findViewById(R.id.ll_friends).setOnClickListener(this);
        shareView.findViewById(R.id.ll_save_pic).setOnClickListener(this);

//        shareView.findViewById(R.id.iv_close).setVisibility(View.GONE);
//        shareView.findViewById(R.id.iv_share_code).setVisibility(View.GONE);
//        shareView.findViewById(R.id.ll_save_pic).setVisibility(View.GONE);

        shareDialog.setContentView(shareView);
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        shareDialog.show();


        ImageLoaderUtils.displayRoundTwo(this, ivShareCode, url);
    }

    @Override
    public void returnGoodPageInfo(final GoosPageInfoBean goosPageInfoBean) {
        if (!goosPageInfoBean.isIs_success()) {
            showShortToast(goosPageInfoBean.getMessage());
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        GoosPageInfoBean.DataBean.InfoBean info = goosPageInfoBean.getData().getInfo();
        store_id = info.getStore_id();
        final List<GoosPageInfoBean.DataBean.InfoBean.ImagesBean> images = goosPageInfoBean.getData().getInfo().getImages();
        mLoopViewPager.setViewFactory(new BannerView.ViewFactory<GoosPageInfoBean.DataBean.InfoBean.ImagesBean>() {
            @Override
            public View create(GoosPageInfoBean.DataBean.InfoBean.ImagesBean imagesBean, final int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, imagesBean.getGoodsimage_url());

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ArrayList<String> mImage = new ArrayList<>();
                        for (GoosPageInfoBean.DataBean.InfoBean.ImagesBean ImageS : images) {
                            mImage.add(ImageS.getGoodsimage_url());
                        }
                        auitemItemPicActivity.startAction(GoodsPageActivity.this, v, mImage, position);
                    }
                });
                return iv;
            }
        });

        mLoopViewPager.setDataList(info.getImages());
        mLoopViewPager.start();
//        tv_goods_name
        tvGoodsName.setText(getIntent().getExtras().getString(AppConstant.GoodsPageTitle));
//        tv_brand
        tvBottom.setText(info.getDescription() + "");
//        tvBrand.setText(info.getBrand_id() + "");
        tvCurrentPrice.setText("￥" + info.getGoods_price());
        tvOldPrice.setText("￥" + info.getGoods_marketprice() + "");
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvBeleft.setText(info.getGoods_storage() + "");

//        share_url = goosPageInfoBean.getData().getShare_url();
        share_url = goosPageInfoBean.getData().getInfo().getGoods_qrcode_img();
        if (info.isIs_fav_store())
            tvAddFocus.setText("已收藏");
        else {
            tvAddFocus.setText("收藏店铺");
            relStoreFocus.setOnClickListener(this);
        }
        if (goosPageInfoBean.getData().getInfo().getDescription_image() != null && goosPageInfoBean.getData().getInfo().getDescription_image().size() != 0)
            mImagesAdapter.addAll(goosPageInfoBean.getData().getInfo().getDescription_image());

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
    public void returnAddFavBeanStore(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        tvAddFocus.setText("已收藏");

    }


    @Override
    public void reloadLodTip() {
        mPresenter.getGoodsPageInfoRequest(goodsId);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rel_store_focus:
                mPresenter.getAddFavStoreBean(store_id, AppConstant.store);
                break;
            case R.id.iv_close:
                shareDialog.dismiss();
                break;
            case R.id.ll_wx:
                ShareUtil.showShareURL(this, ShareSDK.getPlatform(Wechat.NAME).getName(), share_url);
                break;
            case R.id.ll_friends:
                ShareUtil.showShareURL(this, ShareSDK.getPlatform(WechatMoments.NAME).getName(), share_url);
                break;
            case R.id.ll_save_pic:
                Glide.with(GoodsPageActivity.this).load(share_url)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop().transform(new GlideRoundTransformUtil(this, 3)).
                        into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                String fileName = System.currentTimeMillis() + ".JPEG";
                                File diskCacheDir = DiskUtil.getDiskCacheDir(mContext, fileName);
                                boolean save = ImageUtils.save(resource, diskCacheDir, Bitmap.CompressFormat.JPEG);
//                                MediaStore.Images.Media.insertImage(this.getContentResolver(), file.getAbsolutePath(), bitName, null);
                                if (save) {
                                    try {
                                        MediaStore.Images.Media.insertImage(mContext.getContentResolver(), diskCacheDir.getAbsolutePath(), fileName, null);
                                        mContext.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + fileName)));
                                        showShortToast("保存成功，请在相册查看");
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                        showShortToast("保存失败");
                                    }

                                } else
                                    showShortToast("保存失败");
                            }
                        });


                break;
            case R.id.rel_qd:
                if (TextUtils.isEmpty(share_url)) {
                    showShortToast("请稍后再分享");
                    return;
                }
                showShareDialog(share_url);
                break;


        }
    }


}
