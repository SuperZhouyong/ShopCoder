package com.intention.sqtwin.ui.main.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AgentBidBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.BidBean;
import com.intention.sqtwin.bean.NullBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;
import com.intention.sqtwin.ui.main.model.AutionItemModel;
import com.intention.sqtwin.ui.main.presenter.AutionItemPresenter;
import com.intention.sqtwin.ui.myinfo.activity.LoginActivity;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
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

public class AuctionItemActivity extends BaseActivity<AutionItemPresenter, AutionItemModel> implements AutionItemContract.View, LoadingTip.onReloadListener, BottomDialog.ViewListener {
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
    /*@BindView(R.id.iv_back)
        ImageView ivBack;
        @BindView(R.id.rel_back)
        RelativeLayout relBack;
        @BindView(R.id.Tv_time_one)
        TextView TvTimeOne;
        @BindView(R.id.Tv_time_two)
        TextView TvTimeTwo;
        @BindView(R.id.iv_search)
        ImageView ivSearch;
        @BindView(R.id.rel_search)
        RelativeLayout relSearch;
        @BindView(R.id.iv_icon)

        @BindView(R.id.tv_1)
        TextView tv1;
        @BindView(R.id.tv_1_name)

        @BindView(R.id.tv_2)
        TextView tv2;
        @BindView(R.id.tv_2_name)

        @BindView(R.id.tv_3)
        TextView tv3;
        @BindView(R.id.tv_3_name)
        TextView tv3Name;
        @BindView(R.id.mLoopViewPager)

        @BindView(R.id.tv_lot_name)
        TextView tvLotName;
        @BindView(R.id.tv_lost_price_desc_one)
        TextView tvLostPriceDescOne;
        @BindView(R.id.tv_num_one)
        TextView tvNumOne;
        @BindView(R.id.ll_one)
        LinearLayout llOne;
        @BindView(R.id.tv_lost_price_desc_two)
        TextView tvLostPriceDescTwo;
        @BindView(R.id.tv_num_two)
        TextView tvNumTwo;
        @BindView(R.id.ll_two)
        LinearLayout llTwo;
        @BindView(R.id.tv_lost_price_desc_three)
        TextView tvLostPriceDescThree;
        @BindView(R.id.tv_num_three)
        TextView tvNumThree;
        @BindView(R.id.ll_three)
        LinearLayout llThree;
        @BindView(R.id.tv_focus_ren)
        TextView tvFocusRen;
        @BindView(R.id.iv_select_one)
        ImageView ivSelectOne;
        @BindView(R.id.iv_select_two)
        ImageView ivSelectTwo;
        @BindView(R.id.iv_select_three)
        ImageView ivSelectThree;
        @BindView(R.id.tv_disclaimer)
        TextView tvDisclaimer;
        @BindView(R.id.tv_num_one_com)
        TextView tvNumOneCom;
        @BindView(R.id.tv_num_two_com)
        TextView tvNumTwoCom;
        @BindView(R.id.tv_num_three_com)
        TextView tvNumThreeCom;
        @BindView(R.id.tv_num_fore_com)
        TextView tvNumForeCom;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.iv_qr_code)
        ImageView ivQrCode;
        @BindView(R.id.tv_recoed_one)
        TextView tvRecoedOne;
        @BindView(R.id.tv_recoed_two)
        TextView tvRecoedTwo;
        @BindView(R.id.mRecyclerView)
        RecyclerView mRecyclerView;
        @BindView(R.id.tv_other_lots)
        TextView tvOtherLots;
        @BindView(R.id.tv_aution_guide)
        TextView tvAutionGuide;
        @BindView(R.id.ll_one_bottom)
        LinearLayout llOneBottom;
        @BindView(R.id.ll_two_bottom)
        LinearLayout llTwoBottom;
        @BindView(R.id.tv_agent_price)
        TextView tvAgentPrice;
        @BindView(R.id.tv_noagent_price)
        TextView tvNoagentPrice;
        @BindView(R.id.mLoadingTip)
        LoadingTip mLoadingTip;
        @BindView(R.id.rel_other_lots)
        RelativeLayout relOtherLots;
        @BindView(R.id.rel_bid_record)
        RelativeLayout relBidRecord;*/

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
    private String credit_line;
    private String deposit;
    private int goods_id;
    private LRecyclerViewAdapter mLadapter;
    private TextView tvLotsName;
    private TextView tvLotsOne;
    private TextView tvLotsTwo;
    private TextView tvLotsThree;
    private TextView tvLotsfocus;
    private TextView tvDisclaimer;
    private TextView tvNumOneCom;
    private TextView tvNumTwoCom;
    private TextView tvNumThreeCom;
    private TextView tvNumForeCom;
    private TextView tvAutherDesc;
    private ImageView ivQrcode;
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
        auctItemId = getIntent().getIntExtra(AppConstant.auctionItemId, -1);
//        relSearch.setVisibility(View.GONE);

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
        headViewPager = getLayoutInflater().inflate(R.layout.item_homepage_headview, null);
        mLoopViewPager = (BannerView) headViewPager.findViewById(R.id.mLoopViewPager);


        //瓷器当前价 起拍价
        auction_three = getLayoutInflater().inflate(R.layout.item_auction_two, null);
        tvLotsName = (TextView) auction_three.findViewById(R.id.tv_lot_name);
        tvLotsOne = (TextView) auction_three.findViewById(R.id.tv_num_one);
        tvLotsTwo = (TextView) auction_three.findViewById(R.id.tv_num_two);
        tvLotsThree = (TextView) auction_three.findViewById(R.id.tv_num_three);
        tvLotsfocus = (TextView) auction_three.findViewById(R.id.tv_focus_ren);

        //
        tvDisclaimer = (TextView) auction_three.findViewById(R.id.tv_disclaimer);
        tvNumOneCom = (TextView) auction_three.findViewById(R.id.tv_num_one_com);
        tvNumTwoCom = (TextView) auction_three.findViewById(R.id.tv_num_two_com);
        tvNumThreeCom = (TextView) auction_three.findViewById(R.id.tv_num_three_com);
        tvNumForeCom = (TextView) auction_three.findViewById(R.id.tv_num_fore_com);


        //作何介绍
        auther_desc = getLayoutInflater().inflate(R.layout.auctionitem_auther_desc, null);
        tvAutherDesc = (TextView) auther_desc .findViewById(R.id.tv_desc);


        //二维码图片
        iv_qrcode = getLayoutInflater().inflate(R.layout.auctionitem_qrcode, null);
        ivQrcode = (ImageView) iv_qrcode.findViewById(R.id.iv_qr_code);

        //出价记录
        price_title = getLayoutInflater().inflate(R.layout.item_auction_three, null);
        priceTitle = (TextView) price_title.findViewById(R.id.tv_recoed_one);
        tvPriceNum = (TextView) price_title.findViewById(R.id.tv_recoed_two);

        headViewTwo = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        View viewById = headViewTwo.findViewById(R.id.mRecy_rel_parent);
        mRecyclerView = (RecyclerView) headViewTwo.findViewById(R.id.mRecyclerView);
        setMarGinTop(viewById,0,0);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);


        //foot  其他拍品
        other_item = getLayoutInflater().inflate(R.layout.item_auction_three, null);

        OtherTitle = (TextView) other_item.findViewById(R.id.tv_recoed_one);
        setMarGinTop(OtherTitle,0, (int) getResources().getDimension(R.dimen.y20));
        // 参拍指南
        auction_guide = getLayoutInflater().inflate(R.layout.item_auction_three, null);
        auctionGuide = (TextView) auction_guide.findViewById(R.id.tv_recoed_one);
        setMarGinTop(auctionGuide,0, (int) getResources().getDimension(R.dimen.y20));
        mLadapter.getHeaderViews().clear();
        mLadapter.getmHeaderTypes().clear();


//        mLRecyclerView.set
        mPresenter.getAutionDetailRequest(auctItemId);


        mLadapter.addHeaderView(auctionItem_one);
        mLadapter.addHeaderView(headViewPager);
        mLadapter.addHeaderView(auction_three);
        mLadapter.addHeaderView(auther_desc);
        mLadapter.addHeaderView(iv_qrcode);
        mLadapter.addHeaderView(price_title);
        mLadapter.addHeaderView(headViewTwo);
        mLadapter.addHeaderView(other_item);
        mLadapter.addHeaderView(auction_guide);
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
            layoutParams.setMargins(marGTop,top,marGTop,0);
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


    @Override
    public void returnAutionItemDeatil(final AutionItemDetailBean autionItemDetailBean) {


        if (!autionItemDetailBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();


        AutionItemDetailBean.DataBean.ItemInfoBean item_info = autionItemDetailBean.getData().getItem_info();
        AutionItemDetailBean.DataBean.StaffListBean staffListBean = autionItemDetailBean.getData().getStaff_list().get(0);
        //title
        TvTimeTwo.setText(item_info.getStart_time() + "-" + item_info.getEnd_time());
        // 拍卖人详情
        ImageLoaderUtils.displayRound(this, ivIcon, autionItemDetailBean.getData().getStaff_list().get(0).getAvatar());
        tv1Name.setText(staffListBean.getName());
        tv1Name.setText(staffListBean.getName());
        tv2Name.setText(staffListBean.getType() == 0 ? "主理人" : "专家");
        tv3Name.setText(staffListBean.getRun_count() + "场拍卖");

        List<AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean> images = autionItemDetailBean.getData().getItem_info().getImages();
        // 第二部分录播图
        mLoopViewPager.setViewFactory(new BannerView.ViewFactory<AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean>() {


            @Override
            public View create(AutionItemDetailBean.DataBean.ItemInfoBean.ImagesBean imagesBean, int position, ViewGroup container) {
                ImageView iv = new ImageView(container.getContext());
                ImageLoaderUtils.display(container.getContext().getApplicationContext(), iv, imagesBean.getGoodsimage_url());
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

        OtherTitle.setText("本场其他拍品");
        auctionGuide.setText("参拍指南");
        // 出价列表
        price_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstant.BidRecordId, goods_id);
                startActivity(BidRecordActivity.class, bundle);
            }
        });
        /*if (mAdapter.getDataList().size() != 0) {
            mAdapter.clear();
        }*/
        if (autionItemDetailBean.getData().getPrice_list().size() > 4) {
            autionItemDetailBean.getData().setPrice_list(autionItemDetailBean.getData().getPrice_list().subList(0, 4));
        }
        mAdapter.addAll(autionItemDetailBean.getData().getPrice_list());
        // 其他拍场
        other_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int auction_field_id = autionItemDetailBean.getData().getItem_info().getAuction_field_id();

                AuctionFiledActivity.gotoAuctionFiledActivity(AuctionItemActivity.this, auction_field_id);
            }
        });
        // 免责申明
        tvDisclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ivQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ShareDialog shareDialog = new ShareDialog(this);
                Dialog shareDialog = new Dialog(AuctionItemActivity.this, R.style.MyDialog);
                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog, null));
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                shareDialog.show();
            }
        });


    }

    @Override
    public void returnAgentBidDate(AgentBidBean agentBidBean) {
        if (agentBidBean.isIs_success()) {

            bottomDialog.dismiss();

            mPresenter.getAutionDetailRequest(auctItemId);
        } else {
            showShortToast(agentBidBean.getMessage());
        }
    }

    @Override
    public void returnBidDate(BidBean bidBean) {
        if (bidBean.isIs_success()) {
            bottomDialog.dismiss();
            mPresenter.getAutionDetailRequest(auctItemId);
        } else {
            showShortToast(bidBean.getMessage());
        }
    }


    @OnClick({R.id.rel_back, R.id.tv_agent_price, R.id.tv_noagent_price})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;

//                ShareDialog shareDialog = new ShareDialog(this,R.layout.share_dialog,false);
//                ShareDialog shareDialog = new ShareDialog(this);
//                Dialog shareDialog = new Dialog(this, R.style.MyDialog);
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog, null));
////                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//                shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                shareDialog.show();
//                break;
            // 免责

            // 代理出价
            case R.id.tv_agent_price:
                bottomDialog = BottomDialog
                        .create(getSupportFragmentManager())
                        .setLayoutRes(R.layout.price_dialog)
                        .setCancelOutside(true)
                        .setViewListener(this)
                        .setTag("One")
                        .show();


                break;
            // 出价
            case R.id.tv_noagent_price:
                bottomDialog = BottomDialog
                        .create(getSupportFragmentManager())
                        .setLayoutRes(R.layout.price_dialog)
                        .setCancelOutside(true)
                        .setViewListener(this)
                        .setTag("Two")
                        .show();
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
        if (bottomDialog.getTag().equals("One"))
            mTextConfirm.setText("代理出价");
        else
            mTextConfirm.setText("确认出价");


        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });
        view.findViewById(R.id.tv_confirm_price).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLogin()) {
                    if (bottomDialog.getTag().equals("one")) {
                        mPresenter.getAgentBidBeanRequest(goods_id, (int) Float.parseFloat(tvNum.getText().toString().substring(1)), getSqtUser().getMember_id());
                    } else {
                        mPresenter.getBidBeanRequest(goods_id, (int) Float.parseFloat(tvNum.getText().toString().substring(1)), getSqtUser().getMember_id());
                    }


                } else {
                    startActivity(LoginActivity.class);
                }
            }
        });
        tvNum = (TextView) view.findViewById(R.id.etAmount);
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


    @OnClick({R.id.rel_back, R.id.rel_search, R.id.ll_one_bottom, R.id.ll_two_bottom, R.id.tv_agent_price, R.id.tv_noagent_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.rel_search:
                break;
            case R.id.ll_one_bottom:
                break;
            case R.id.ll_two_bottom:
                break;
            case R.id.tv_agent_price:
                break;
            case R.id.tv_noagent_price:
                break;
        }
    }
}
