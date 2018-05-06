package com.intention.sqtwin.ui.main.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;
import com.intention.sqtwin.ui.main.model.AutionItemModel;
import com.intention.sqtwin.ui.main.presenter.AutionItemPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ezy.ui.view.BannerView;

/**
 * Description: 拍品页
 * Data：2018/4/21-上午12:53
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionItemActivity extends BaseActivity<AutionItemPresenter, AutionItemModel> implements AutionItemContract.View {


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
    @BindView(R.id.mLoopViewPager)
    BannerView mLoopViewPager;
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
    private Integer auctItemId = 1;


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

    }


    @Override
    public void returnAutionItemDeatil(AutionItemDetailBean autionItemDetailBean) {
//        ImageLoaderUtils.display(this, ivIcon,autionItemDetailBean.getData().getItem_info().getImage());
//        tv1Name.setText(autionItemDetailBean.getData().getItem_info().getName());
//        tv2Name.setText(autionItemDetailBean.getData().getItem_info().getStart_time());
//        tv3Name.setText(autionItemDetailBean.getData().getItem_info().get);

    }

    @OnClick({R.id.rel_back, R.id.iv_qr_code})
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
        }
    }



}
