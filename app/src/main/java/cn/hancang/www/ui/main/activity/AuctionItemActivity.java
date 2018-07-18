package cn.hancang.www.ui.main.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
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
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AgentBidBean;
import cn.hancang.www.bean.AutionItemDetailBean;
import cn.hancang.www.bean.BidBean;
import cn.hancang.www.bean.NullBean;
import cn.hancang.www.ui.main.contract.AutionItemContract;
import cn.hancang.www.ui.main.model.AutionItemModel;
import cn.hancang.www.ui.main.presenter.AutionItemPresenter;
import cn.hancang.www.ui.myinfo.activity.ChargeActivity;
import cn.hancang.www.utils.conmonUtil.DiskUtil;
import cn.hancang.www.utils.conmonUtil.GlideRoundTransformUtil;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.utils.conmonUtil.ImageUtils;
import cn.hancang.www.utils.conmonUtil.PublicKetUtils;
import cn.hancang.www.utils.conmonUtil.ShareUtil;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import ezy.ui.view.BannerView;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;

/**
 * Description: 拍品页
 * Data：2018/4/21-上午12:53
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionItemActivity extends BaseActivity<AutionItemPresenter, AutionItemModel> implements AutionItemContract.View, LoadingTip.onReloadListener, BottomDialog.ViewListener, Action, View.OnClickListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.Tv_time_two)
    TextView TvTimeTwo;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.ll_one_bottom)
    LinearLayout llOneBottom;
    @BindView(R.id.ll_two_bottom)
    LinearLayout llTwoBottom;
    @BindView(R.id.tv_agent_price)
    TextView tvAgentPrice;
    @BindView(R.id.tv_noagent_price)
    TextView tvNoagentPrice;
    @BindView(R.id.iv_fav_status)
    ImageView iv_fav_status;


    private TextView tv1Name;
    private TextView tv2Name;
    private TextView tv3Name;
    private ImageView ivIcon;


    private BannerView mLoopViewPager;

    private Integer auctItemId = 1;

    private CommonRecycleViewAdapter<AutionItemDetailBean.DataBean.PriceListBean> mAdapter;
    private BaseBottomDialog bottomDialog;
    private TextView tvNum;
    private String current_price;
    private String increment_value;
    private TextView tvTwo;
    private TextView tvOne;
    // 信誉额度
    private String credit_line;
    private String deposit;
    private int goods_id;
    private LRecyclerViewAdapter mLadapter;
    private TextView tvLotsName;
    private TextView tvLotsOne;
    private TextView tvLotsTwo;
    private TextView tvLotsThree;
    private TextView tvLotsfocus;
    //    private TextView tvDisclaimer;
    private TextView tvNumOneCom;
    private TextView tvNumTwoCom;
    private TextView tvNumThreeCom;
    private TextView tvNumForeCom;
    private TextView tvAutherDesc;
    //    private ImageView ivQrcode;
    private TextView tvPriceNum;
    private TextView priceTitle;
    private TextView OtherTitle;
    private TextView auctionGuide;
    private View price_title;
    private View other_item;
    private View auction_guide;

    private CommonRecycleViewAdapter<NullBean> mComAdapter;
    private View auctionItem_one;
    private View headViewPager;
    private View auction_three;
    private View auther_desc;
    private View iv_qrcode;
    private View headViewTwo;
    private RecyclerView mRecyclerView;
    private boolean isAgentBid;
    private boolean isBid;
    private LinearLayout rel_qr;
    private Dialog shareDialog;
    private String wx_code;
    private View viewSpace1;
    private View viewSpace2;
    private ImageView ivDelver;
    private TextView tvLotsOneDesc;
    //    private SmoothCheckBox sCheckBox;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionitem;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {


        // 获取拍品Id
        auctItemId = getIntent().getExtras().getInt(AppConstant.auctionItemId, -1);
        relSearch.setVisibility(View.GONE);
        mAdapter = new CommonRecycleViewAdapter<AutionItemDetailBean.DataBean.PriceListBean>(this, R.layout.item_price_list) {
            @Override
            public void convert(ViewHolderHelper helper, AutionItemDetailBean.DataBean.PriceListBean priceListBean, int position) {
                helper.setImageRoundUrl(R.id.iv_price_icon, priceListBean.getAvatar());
                helper.setText(R.id.tv_price_name, priceListBean.getNickname());
                helper.setText(R.id.tv_price_num, priceListBean.getPrice() + "元");
            }
        };


        mComAdapter = new CommonRecycleViewAdapter<NullBean>(this, R.layout.item_price_list) {

            @Override
            public void convert(ViewHolderHelper helper, NullBean nullBean, int position) {

            }
        };
        mLadapter = new LRecyclerViewAdapter(mComAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setPullRefreshEnabled(false);

        // 职位人
        auctionItem_one = getLayoutInflater().inflate(R.layout.item_auction_one, null);
        ivIcon = (ImageView) auctionItem_one.findViewById(R.id.iv_icon);
        tv1Name = (TextView) auctionItem_one.findViewById(R.id.tv_1_name);
        tv2Name = (TextView) auctionItem_one.findViewById(R.id.tv_2_name);
        tv3Name = (TextView) auctionItem_one.findViewById(R.id.tv_3_name);

        // 轮播图
       /* headViewPager = getLayoutInflater().inflate(R.layout.item_homepage_headview, null);
        mLoopViewPager = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);*/

        headViewPager = getLayoutInflater().inflate(R.layout.item_auitem_viewpager, null);
        mLoopViewPager = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);


        //瓷器当前价 起拍价
        auction_three = getLayoutInflater().inflate(R.layout.item_auction_two, null);
        tvLotsOneDesc = (TextView) auction_three.findViewById(R.id.tv_lost_price_desc_one);
        tvLotsName = (TextView) auction_three.findViewById(R.id.tv_lot_name);
        tvLotsOne = (TextView) auction_three.findViewById(R.id.tv_num_one);
        tvLotsTwo = (TextView) auction_three.findViewById(R.id.tv_num_two);
        tvLotsThree = (TextView) auction_three.findViewById(R.id.tv_num_three);
        tvLotsfocus = (TextView) auction_three.findViewById(R.id.tv_focus_ren);

        //
//        tvDisclaimer = (TextView) auction_three.findViewById(R.id.tv_disclaimer);
        tvNumOneCom = (TextView) auction_three.findViewById(R.id.tv_num_one_com);
        tvNumTwoCom = (TextView) auction_three.findViewById(R.id.tv_num_two_com);
        tvNumThreeCom = (TextView) auction_three.findViewById(R.id.tv_num_three_com);
        tvNumForeCom = (TextView) auction_three.findViewById(R.id.tv_num_fore_com);


        //作何介绍
        auther_desc = getLayoutInflater().inflate(R.layout.auctionitem_auther_desc, null);
        tvAutherDesc = (TextView) auther_desc.findViewById(R.id.tv_desc);


        //二维码图片
        iv_qrcode = getLayoutInflater().inflate(R.layout.auctionitem_qrcode, null);
//        ivQrcode = (ImageView) iv_qrcode.findViewById(R.id.iv_qr_code);
        rel_qr = (LinearLayout) iv_qrcode.findViewById(R.id.rel_qd);

        //出价记录
        price_title = getLayoutInflater().inflate(R.layout.item_auction_three, null);
        priceTitle = (TextView) price_title.findViewById(R.id.tv_recoed_one);
        tvPriceNum = (TextView) price_title.findViewById(R.id.tv_recoed_two);
        ivDelver = (ImageView) price_title.findViewById(R.id.iv_bottom_delvier);
        ivDelver.setVisibility(View.VISIBLE);

        headViewTwo = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        View viewById = headViewTwo.findViewById(R.id.mRecy_rel_parent);
        mRecyclerView = (RecyclerView) headViewTwo.findViewById(R.id.mRecyclerView);
        setMarGinTop(viewById, 0, 0);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        viewSpace1 = getLayoutInflater().inflate(R.layout.item_space, null);

        //foot  其他拍品
        other_item = getLayoutInflater().inflate(R.layout.item_auction_three, null);

        OtherTitle = (TextView) other_item.findViewById(R.id.tv_recoed_one);
        setMarGinTop(other_item, 0, (int) getResources().getDimension(R.dimen.y20));
        viewSpace2 = getLayoutInflater().inflate(R.layout.item_space, null);
        // 参拍指南
        auction_guide = getLayoutInflater().inflate(R.layout.item_auction_three, null);
        auctionGuide = (TextView) auction_guide.findViewById(R.id.tv_recoed_one);
        setMarGinTop(auction_guide, 0, (int) getResources().getDimension(R.dimen.y20));
//        View viewSpace3 = getLayoutInflater().inflate(R.layout.item_space, null);
        mLadapter.getHeaderViews().clear();
        mLadapter.getmHeaderTypes().clear();


//        mLRecyclerView.set
        mPresenter.getAutionDetailRequest(auctItemId);

//

//        mLadapter.addHeaderView(viewSpace3);
    }

    @Override
    public void StartLoading(String RequestId) {
        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    public void setMarGinTop(View v, int marGTop, int top) {
        if (v.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);

        } else if (v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);

        } else if (v.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);
        }


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


    @SuppressLint("SetTextI18n")
    @Override
    public void returnAutionItemDeatil(final AutionItemDetailBean autionItemDetailBean) {


        if (!autionItemDetailBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        final AutionItemDetailBean.DataBean.ItemInfoBean item_info = autionItemDetailBean.getData().getItem_info();
        // 出价的话只是刷新这个地方
        if (isAgentBid || isBid) {

            tvNumOneCom.setText(item_info.getStart_price() + "");
            tvNumTwoCom.setText(item_info.getIncrement_value() + "");
            tvNumThreeCom.setText(item_info.getCommission());
            tvNumForeCom.setText(item_info.getDeposit());


            tvPriceNum.setVisibility(View.VISIBLE);
            tvPriceNum.setText(autionItemDetailBean.getData().getPrice_count() + "次");


            // 出价列表
            price_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(AppConstant.BidRecordId, goods_id);
                    startActivity(BidRecordActivity.class, bundle);
                }
            });
            if (mAdapter.getDataList().size() != 0) {
                mAdapter.clear();
            }
            if (autionItemDetailBean.getData().getPrice_list().size() > 4) {
                autionItemDetailBean.getData().setPrice_list(autionItemDetailBean.getData().getPrice_list().subList(0, 4));
            }
            mAdapter.addAll(autionItemDetailBean.getData().getPrice_list());

            isBid = false;
            isAgentBid = false;
            return;

        }
        // 关注状态
        iv_fav_status.setImageResource(autionItemDetailBean.getData().isIs_fav() ? R.mipmap.aution_remind_select : R.mipmap.aution_remind);

        tvLotsfocus.setText(autionItemDetailBean.getData().getItem_info().getFans_count() + "人关注");


//        AutionItemDetailBean.DataBean.StaffListBean staffListBean = autionItemDetailBean.getData().getStaff_list().get(0);
        //title


        String start_time = item_info.getStart_time().replace("-", ".");
        String end_time = item_info.getEnd_time().replace("-", ".");
        String s = start_time.substring(start_time.indexOf(".") + 1) + "-" + end_time.substring(end_time.indexOf(".") + 1);
        TvTimeTwo.setText(s);
        // 拍卖人详情

        if (autionItemDetailBean.getData().getStaff_list() == null || autionItemDetailBean.getData().getStaff_list().size() == 0) {
        } else {
            mLadapter.addHeaderView(auctionItem_one);
            AutionItemDetailBean.DataBean.StaffListBean staffListBean = autionItemDetailBean.getData().getStaff_list().get(0);
            ImageLoaderUtils.displayRound(this, ivIcon, autionItemDetailBean.getData().getStaff_list().get(0).getAvatar());
            tv1Name.setText(staffListBean.getName());
            tv2Name.setText(staffListBean.getType() == 0 ? "主理人" : "专家");
            tv3Name.setText(staffListBean.getRun_count() + "场拍卖");
            //item_info.getAuthor_id()
            auctionItem_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 主理人
                    OrganPeoActivity.gotoActivity(AuctionItemActivity.this, autionItemDetailBean.getData().getStaff_list().get(0).getId());
                }
            });
        }


        final List<AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean> images = autionItemDetailBean.getData().getItem_info().getImages();
        // 第二部分录播图
        mLoopViewPager.setViewFactory(new BannerView.ViewFactory<AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean>() {


            @Override
            public View create(AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean imagesBean, final int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, imagesBean.getGoodsimage_url());
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<String> mImage = new ArrayList<>();
                        for (AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean ImageS : images) {
                            mImage.add(ImageS.getGoodsimage_url());
                        }
                        auitemItemPicActivity.startAction(AuctionItemActivity.this, v, mImage, position);
                    }
                });

                return iv;
            }
        });
        mLoopViewPager.setDataList(images);
        mLoopViewPager.start();

        // 第三部分 详情

        current_price = item_info.getCurrent_price();
        increment_value = item_info.getIncrement_value();
        credit_line = autionItemDetailBean.getData().getCredit_line();
        goods_id = item_info.getGoods_id();

        deposit = item_info.getDeposit();

        tvLotsName.setText(item_info.getName());
        tvLotsOne.setText(item_info.getCurrent_price() + "");
        tvLotsTwo.setText(item_info.getStart_price() + "");
        tvLotsThree.setText(autionItemDetailBean.getData().getPrice_count() + "");
        tvNumForeCom.setText(item_info.getFans_count() + "人关注");

        // 第四部分 com
        tvNumOneCom.setText(item_info.getStart_price() + "");
        tvNumTwoCom.setText(item_info.getIncrement_value() + "");
        tvNumThreeCom.setText(item_info.getCommission());
        tvNumForeCom.setText(item_info.getDeposit());
        // 作者描述 tv_recoed_two
        tvAutherDesc.setText(autionItemDetailBean.getData().getItem_info().getDescription());


        // 出价记录
        priceTitle.setText("出价列表");
        tvPriceNum.setVisibility(View.VISIBLE);
        tvPriceNum.setText(autionItemDetailBean.getData().getPrice_count() + "次");


        // 出价列表
        price_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstant.BidRecordId, goods_id);
                startActivity(BidRecordActivity.class, bundle);
            }
        });
        if (mAdapter.getDataList().size() != 0) {
            mAdapter.clear();
        }
        if (autionItemDetailBean.getData().getPrice_list().size() > 4) {
            autionItemDetailBean.getData().setPrice_list(autionItemDetailBean.getData().getPrice_list().subList(0, 4));
        }

        mAdapter.addAll(autionItemDetailBean.getData().getPrice_list());
        ivDelver.setVisibility(mAdapter.getDataList().size() != 0 ? View.VISIBLE : View.GONE);
        // 其他拍场
        OtherTitle.setText("本场其他拍品");
        auctionGuide.setText("参拍指南");
        other_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auction_field_id = autionItemDetailBean.getData().getItem_info().getAuction_field_id();
                if (TextUtils.isEmpty(auction_field_id)) {
                    showShortToast("暂无其他拍场");
                    return;
                }
                AuctionFiledActivity.gotoAuctionFiledActivity(AuctionItemActivity.this, Integer.parseInt(auction_field_id), AppConstant.IntoWayOne);
            }
        });

        showAuctionTime(item_info.getStart_time(), item_info.getEnd_time(), item_info.isBe_sold());
        // 免责申明
      /*  tvDisclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWebviewActivity.GotoActiviy(AuctionItemActivity.this, autionItemDetailBean.getData().getArticle(), "免责申明");
            }
        });*/
        //todo 微信分享
        rel_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ShareDialog shareDialog = new ShareDialog(this);
                shareDialog = new Dialog(AuctionItemActivity.this, R.style.MyDialog);
                View shareView = getLayoutInflater().inflate(R.layout.share_dialog, null);
                ImageView ivShareCode = (ImageView) shareView.findViewById(R.id.iv_share_code);
                shareView.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareDialog.dismiss();
                    }
                });
                shareView.findViewById(R.id.iv_close).setOnClickListener(AuctionItemActivity.this);
                shareView.findViewById(R.id.ll_wx).setOnClickListener(AuctionItemActivity.this);
                shareView.findViewById(R.id.ll_friends).setOnClickListener(AuctionItemActivity.this);
                shareView.findViewById(R.id.ll_save_pic).setOnClickListener(AuctionItemActivity.this);
                shareDialog.setContentView(shareView);
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                shareDialog.show();


                ImageLoaderUtils.displayRoundTwo(AuctionItemActivity.this, ivShareCode, autionItemDetailBean.getData().getItem_info().getGoods_qrcode_img());

                wx_code = autionItemDetailBean.getData().getItem_info().getGoods_qrcode_img();
            }
        });

        mLadapter.addHeaderView(headViewPager);
        mLadapter.addHeaderView(auction_three);
        mLadapter.addHeaderView(auther_desc);
        if (!TextUtils.isEmpty(autionItemDetailBean.getData().getItem_info().getGoods_qrcode_img()))
            mLadapter.addHeaderView(iv_qrcode);
        mLadapter.addHeaderView(price_title);
        mLadapter.addHeaderView(headViewTwo);
        mLadapter.addHeaderView(viewSpace1);
        mLadapter.addHeaderView(other_item);
        mLadapter.addHeaderView(viewSpace2);
//        mLadapter.addHeaderView(auction_guide);

        mComAdapter.notifyDataSetChanged();
    }

    private void showAuctionTime(String start_time, String end_time, boolean isBeSold) {
        try {
            Date startTime = PublicKetUtils.df.get().parse(start_time);
            Date endTime = PublicKetUtils.df.get().parse(end_time);
            Date currentTime = new Date();
            if (currentTime.getTime() < endTime.getTime() && currentTime.getTime() > startTime.getTime()) {

            } else {
                tvNoagentPrice.setEnabled(false);
                tvNoagentPrice.setBackgroundResource(R.drawable.tv_no_click);
                // 街拍了
                if (currentTime.getTime() > endTime.getTime()) {
                    if (isBeSold) {
                        tvLotsOneDesc.setText("落槌价");

                    } else {
                        tvLotsOneDesc.setText("未成交");
                        tvLotsOne.setText("");
                    }

                } else if (currentTime.getTime() < startTime.getTime()) {
                    // 预展中
                    tvLotsOne.setText("");
                }

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void returnAgentBidDate(AgentBidBean agentBidBean) {
        if (agentBidBean.isIs_success()) {
            bottomDialog.dismiss();
            isAgentBid = true;
            mPresenter.getAutionDetailRequest(auctItemId);
        } else {
            showShortToast(agentBidBean.getMessage());
        }
    }

    @Override
    public void returnBidDate(BidBean bidBean) {
        if (bidBean.isIs_success()) {
            bottomDialog.dismiss();
            isBid = true;
            mPresenter.getAutionDetailRequest(auctItemId);
        } else {
            showShortToast(bidBean.getMessage());
        }
    }

    // 加入关注
    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());

        if (!addFavBean.isIs_success()) {
            return;
        }
        iv_fav_status.setImageResource(R.mipmap.aution_remind_select);
    }


    @OnClick({R.id.rel_back, R.id.tv_agent_price, R.id.tv_noagent_price, R.id.ll_one_bottom, R.id.ll_two_bottom, R.id.rel_search})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;


            // 代理出价
            case R.id.tv_agent_price:
               /* SingleCall.getInstance()
                        .addAction(AuctionItemActivity.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(AuctionItemActivity.this))
                        .doCall();*/

                bottomDialog = BottomDialog
                        .create(getSupportFragmentManager())
                        .setLayoutRes(R.layout.price_dialog)
                        .setCancelOutside(true)
                        .setViewListener(this)
                        .setTag(AppConstant.oneMessage)
                        .show();
                break;
            // 出价
            case R.id.tv_noagent_price:
//                if (!isLogin()) {
              /*  SingleCall.getInstance()
                        .addAction(AuctionItemActivity.this, AppConstant.twoMessage)
                        .addValid(new LoginValid(AuctionItemActivity.this))
                        .doCall();*/

                bottomDialog = BottomDialog
                        .create(getSupportFragmentManager())
                        .setLayoutRes(R.layout.price_dialog)
                        .setCancelOutside(true)
                        .setViewListener(this)
                        .setTag(AppConstant.twoMessage)
                        .show();
//                }

                break;
            // 参拍提醒  加入关注
            case R.id.ll_one_bottom:

                SingleCall.getInstance()
                        .addAction(AuctionItemActivity.this, AppConstant.threeMessage)
                        .addValid(new LoginValid(AuctionItemActivity.this))
                        .doCall();


                break;
            case R.id.ll_two_bottom:
                showContractDialog();
                break;
            // 分享
            case R.id.rel_search:

//                ShareUtil.showShareURL(this,);
                break;
        }
    }


    @Override
    public void reloadLodTip() {
        mPresenter.getAutionDetailRequest(auctItemId);
    }

    private void updateTextColor(TextView tv, int starts, int end, int textSize) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan(textSize), starts, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spannedString);
    }

    @Override
    public void bindView(View view) {
        TextView mTextConfirm = (TextView) view.findViewById(R.id.tv_confirm_price);
        if (bottomDialog.getFragmentTag().equals(AppConstant.oneMessage))
            mTextConfirm.setText("代理出价");
        else
            mTextConfirm.setText("确认出价");

//        sCheckBox = (SmoothCheckBox) view.findViewById(R.id.sCheckbox);
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        view.findViewById(R.id.tv_confirm_price).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (bottomDialog.getFragmentTag().equals(AppConstant.oneMessage)) {
                    SingleCall.getInstance()
                            .addAction(AuctionItemActivity.this, AppConstant.oneMessage)
                            .addValid(new LoginValid(AuctionItemActivity.this))
                            .doCall();


                } else {
                    SingleCall.getInstance()
                            .addAction(AuctionItemActivity.this, AppConstant.twoMessage)
                            .addValid(new LoginValid(AuctionItemActivity.this))
                            .doCall();


                }


            }
        });
        view.findViewById(R.id.tv_up_money).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showShortToast("提升额度,去充值界面");

                ChargeActivity.gotoChargeActivity(AuctionItemActivity.this, AppConstant.oneMessage);

            }
        });
        tvNum = (TextView) view.findViewById(R.id.etAmount);
        String currentPrice = tvLotsOne.getText().toString();
        String startPrcie = tvLotsTwo.getText().toString();
        if (TextUtils.isEmpty(currentPrice)||Float.parseFloat(currentPrice) - Float.parseFloat(startPrcie) == 0) {
            tvNum.setText("￥" + (Float.parseFloat(startPrcie)));
        } else
            tvNum.setText("￥" + (Float.parseFloat(current_price) + Float.parseFloat(increment_value)));


        tvOne = (TextView) view.findViewById(R.id.tv_one);
        tvOne.setText("此次出价冻结保证金￥" + deposit + "，被超后立即返回");
        tvTwo = (TextView) view.findViewById(R.id.tv_two);
        tvTwo.setText("当前信誉额度：" + credit_line + "元");
        updateTextColor(tvNum, 0, 1, (int) getResources().getDimension(R.dimen.x30));

        //-
        view.findViewById(R.id.btnDecrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String substring = tvNum.getText().toString().substring(1);
                if (Float.parseFloat(substring) > Float.parseFloat(current_price)) {
                    tvNum.setText("￥" + (Float.parseFloat(substring) - Float.parseFloat(increment_value)));
                    updateTextColor(tvNum, 0, 1, (int) getResources().getDimension(R.dimen.x30));
                } else {
                    showShortToast("代理出价需大于当前价格");
                }
            }
        });
        //+
        view.findViewById(R.id.btnIncrease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String substring = tvNum.getText().toString().substring(1);
                tvNum.setText("￥" + (Float.parseFloat(substring) + Float.parseFloat(increment_value)));
                updateTextColor(tvNum, 0, 1, (int) getResources().getDimension(R.dimen.x30));
            }
        });
    }


    public static void gotoAuctionItemActivity(BaseActivity mContext, int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.auctionItemId, id);
        mContext.startActivity(AuctionItemActivity.class, bundle);
    }

    // 登录验证执行操作
    @Override
    public void call(String tag) {
        //todo 不能在 onresume 中执行Commit
        if (AppConstant.oneMessage.equals(tag)) {
            mPresenter.getAgentBidBeanRequest(goods_id, (int) Float.parseFloat(tvNum.getText().toString().substring(1)), null);
        }
        if (AppConstant.twoMessage.equals(tag)) {
            mPresenter.getBidBeanRequest(goods_id, (int) Float.parseFloat(tvNum.getText().toString().substring(1)), null);
        }
        if (AppConstant.threeMessage.equals(tag)) {
            mPresenter.getAddFavBean(auctItemId, AppConstant.goods);
        }
    }

    /*    shareView.findViewById(R.id.iv_close).setOnClickListener(AuctionItemActivity.this);
                    shareView.findViewById(R.id.ll_wx).setOnClickListener(AuctionItemActivity.this);
                    shareView.findViewById(R.id.ll_friends).setOnClickListener(AuctionItemActivity.this);
                    shareView.findViewById(R.id.ll_save_pic).setOnClickListener(AuctionItemActivity.this);*/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close:
                shareDialog.dismiss();
                break;
            case R.id.ll_wx:
                ShareUtil.showShareURL(this, ShareSDK.getPlatform(Wechat.NAME).getName(), wx_code);
                break;
            case R.id.ll_friends:
                ShareUtil.showShareURL(this, ShareSDK.getPlatform(WechatMoments.NAME).getName(), wx_code);
                break;
            case R.id.ll_save_pic:
                Glide.with(AuctionItemActivity.this).load(wx_code)
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop().transform(new GlideRoundTransformUtil(AuctionItemActivity.this, 3)).
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


        }
    }
}
