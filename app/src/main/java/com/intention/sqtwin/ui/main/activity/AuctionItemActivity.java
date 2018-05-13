package com.intention.sqtwin.ui.main.activity;

import android.app.Dialog;
import android.content.Intent;
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

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;
import com.intention.sqtwin.ui.main.model.AutionItemModel;
import com.intention.sqtwin.ui.main.presenter.AutionItemPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

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
    @BindView(R.id.Tv_time_one)
    TextView TvTimeOne;
    @BindView(R.id.Tv_time_two)
    TextView TvTimeTwo;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_1_name)
    TextView tv1Name;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_2_name)
    TextView tv2Name;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_3_name)
    TextView tv3Name;
    @BindView(R.id.mLoopViewPager)
    BannerView mLoopViewPager;
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


        mAdapter = new CommonRecycleViewAdapter<AutionItemDetailBean.DataBean.PriceListBean>(this, R.layout.item_price_list) {
            @Override
            public void convert(ViewHolderHelper helper, AutionItemDetailBean.DataBean.PriceListBean priceListBean, int position) {
                helper.setImageRoundUrl(R.id.iv_price_icon, priceListBean.getAvatar());
                helper.setText(R.id.tv_price_name, priceListBean.getNickname());
                helper.setText(R.id.tv_price_num, priceListBean.getPrice() + "元");
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.getAutionDetailRequest(auctItemId);
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
        ImageLoaderUtils.display(this, ivIcon, autionItemDetailBean.getData().getStaff_list().get(0).getAvatar());
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
//        tv_lost_price_desc_two
        current_price = item_info.getCurrent_price();
        increment_value = item_info.getIncrement_value();
        credit_line = autionItemDetailBean.getData().getCredit_line();
        deposit = item_info.getDeposit();
        tvLostPriceDescOne.setText("当前价");
        tvLostPriceDescTwo.setText("起拍价");
        tvLostPriceDescThree.setText("竞拍次数");
        tvLotName.setText(item_info.getName());
        tvNumOne.setText(item_info.getCurrent_price() + "");
        tvNumTwo.setText(item_info.getStart_price() + "");
        tvNumThree.setText(autionItemDetailBean.getData().getPrice_count() + "");
        tvFocusRen.setText(item_info.getFans_count() + "人关注");

        // 第四部分 com
        tvNumOneCom.setText(item_info.getStart_price() + "");
        tvNumTwoCom.setText(item_info.getIncrement_value() + "");
        tvNumThreeCom.setText(item_info.getCommission());
        tvNumForeCom.setText(item_info.getDeposit());
        // 作者描述 tv_recoed_two
        tvDesc.setText(autionItemDetailBean.getData().getItem_info().getDescription());
        // 出价记录
        tvRecoedTwo.setText(autionItemDetailBean.getData().getPrice_count() + "次");


        mAdapter.addAll(autionItemDetailBean.getData().getPrice_list());

        relOtherLots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int auction_field_id = autionItemDetailBean.getData().getItem_info().getAuction_field_id();
                Intent intent = new Intent(AuctionItemActivity.this, AuctionFiledActivity.class);
                intent.putExtra(AppConstant.aucotonFileId, auction_field_id);
                startActivity(intent);
            }
        });

    }

    @Override
    public void returnAgentBidDate(Integer goods_id, Integer price, Integer member_id) {

    }

    @Override
    public void returnBidDate(Integer goods_id, Integer price, Integer member_id) {

    }

    @OnClick({R.id.rel_back, R.id.iv_qr_code, R.id.tv_disclaimer, R.id.tv_agent_price})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.iv_qr_code:
//                ShareDialog shareDialog = new ShareDialog(this,R.layout.share_dialog,false);
//                ShareDialog shareDialog = new ShareDialog(this);
                Dialog shareDialog = new Dialog(this, R.style.MyDialog);
                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog, null));
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                shareDialog.show();
                break;
            // 免责
            case R.id.tv_disclaimer:
                break;
            // 代理出价
            case R.id.tv_agent_price:
//                View priveView = getLayoutInflater().inflate(R.layout.price_dialog, null);
                bottomDialog = BottomDialog
                        .create(getSupportFragmentManager())
                        .setLayoutRes(R.layout.price_dialog)
                        .setCancelOutside(true)
                        .setViewListener(this)
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
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
            }
        });

        tvNum = (TextView) view.findViewById(R.id.etAmount);
        tvNum.setText("￥" + Float.parseFloat(current_price));


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
}
