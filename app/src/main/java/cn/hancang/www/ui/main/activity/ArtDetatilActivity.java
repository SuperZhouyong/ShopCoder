package cn.hancang.www.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.ArtDetailBean;
import cn.hancang.www.ui.main.contract.ArtDetatilContract;
import cn.hancang.www.ui.main.model.ArtDetatilModel;
import cn.hancang.www.ui.main.presenter.ArtDetatilPresenter;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 艺术家主页
 * Data：2018/4/27-上午12:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ArtDetatilActivity extends BaseActivity<ArtDetatilPresenter, ArtDetatilModel> implements OnLoadMoreListener, ArtDetatilContract.View, LoadingTip.onReloadListener, OnNetWorkErrorListener, View.OnClickListener, Action {

    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private Integer page = 0;
    private Integer artId = 1;
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<ArtDetailBean.DataBean.ItemListBean> mcomAdapter;
    private int pagesize = 10;
    private ImageView iv_icon;
    private TextView tv_name;
    private TextView tv_bid_nUm;
    private TextView tv_price_num;
    private TextView tv_desc;
    private ImageView ivFocus;
    private TextView tvFocus;

    @Override
    public int getLayoutId() {
        return R.layout.activity_artdetail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("艺术家");
        relSearch.setVisibility(View.GONE);
        artId = getIntent().getExtras().getInt(AppConstant.artDetailId, -1);
        mcomAdapter = new CommonRecycleViewAdapter<ArtDetailBean.DataBean.ItemListBean>(this, R.layout.item_artdetail) {
            @Override
            public void convert(ViewHolderHelper helper, ArtDetailBean.DataBean.ItemListBean itemListBean, int position) {
                helper.setImageRoundTwoUrl(R.id.iv_goods_pic, itemListBean.getImage());
                helper.setText(R.id.tv_goods_name, itemListBean.getName());
//                helper.setText(R.id.tv_price,itemListBean.getCurrent_price());
                helper.setText(R.id.tv_price, "￥ " + itemListBean.getCurrent_price());
                updateTextColor((TextView) helper.getView(R.id.tv_price), 0, 1, (int) getResources().getDimension(R.dimen.x20));
            }
        };
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mLadapter = new LRecyclerViewAdapter(mcomAdapter);
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnLoadMoreListener(this);
        View artDetailHead = getLayoutInflater().inflate(R.layout.item_artdetail_head, null);
        mLadapter.addHeaderView(artDetailHead);
        iv_icon = (ImageView) artDetailHead.findViewById(R.id.iv_header_icon);
        tv_name = (TextView) artDetailHead.findViewById(R.id.art_name);
        ivFocus = (ImageView) artDetailHead.findViewById(R.id.iv_focus);
        tvFocus = (TextView) artDetailHead.findViewById(R.id.tv_focus);
        tv_bid_nUm = (TextView) artDetailHead.findViewById(R.id.tv_lot_num);
        artDetailHead.findViewById(R.id.rel_focus).setOnClickListener(this);

        /*TextView tv_name_price = (TextView) artDetailHead.findViewById(R.id.tv_price_name);
        tv_name_price.setText("粉丝");*/
        tv_price_num = (TextView) artDetailHead.findViewById(R.id.tv_price_num);
        tv_desc = (TextView) artDetailHead.findViewById(R.id.tv_desc);

        View allHeadView = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        mLadapter.addHeaderView(allHeadView);
        mPresenter.getArtDetailRequest(artId, page);

        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, mcomAdapter.get(position).getId());
            }
        });
    }

    private void updateTextColor(TextView tv, int starts, int end, int textSize) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan(textSize), starts, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }

    @OnClick(R.id.rel_back)
    void Onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;
        }
    }

    public static void GotoArtDetailActivity(BaseActivity baseActivity, Integer artId) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.artDetailId, artId);
        baseActivity.startActivity(ArtDetatilActivity.class, bundle);

    }

    @Override
    public void onLoadMore() {
        mPresenter.getArtDetailRequest(artId, page);
    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId) && mcomAdapter.getDataList().size() == 0)
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
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);

            } else {

                mRecyclerView.setOnNetWorkErrorListener(this);
            }

        }
        if (AppConstant.twoMessage.equals(RequestId)) {
            showShortToast(msg);
        }
    }

    @Override
    public void returnArtDetail(ArtDetailBean artDetailBean) {
        if (!artDetailBean.isIs_success()) {
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
//                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page == 0) {
//            if (artDetailBean.getData().getArtist_info().)

            ImageLoaderUtils.displayRound(this, iv_icon, artDetailBean.getData().getArtist_info().getAvatar());
            tv_name.setText(artDetailBean.getData().getArtist_info().getName());
            tv_bid_nUm.setText(artDetailBean.getData().getArtist_info().getAuction_count() + "");
            tv_price_num.setText(artDetailBean.getData().getArtist_info().getFans_count() + "");
            tv_desc.setText(artDetailBean.getData().getArtist_info().getResume());
            if (artDetailBean.getData().getArtist_info().isIs_favorite()) {
                ivFocus.setVisibility(View.GONE);
                tvFocus.setText("已关注");
            }
        }
//TODO 这里我取出来了
        if (page >= artDetailBean.getData().getTotal_page()) {
            mRecyclerView.setNoMore(true);
            return;

        }

        mcomAdapter.addAll(artDetailBean.getData().getItem_list());
        ++page;


    }

    @Override
    public void returnArtFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        ivFocus.setVisibility(View.GONE);
        tvFocus.setText("已关注");
    }


    @Override
    public void reload() {
        mPresenter.getArtDetailRequest(artId, page);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getArtDetailRequest(artId, page);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rel_focus:


                SingleCall.getInstance()
                        .addAction(ArtDetatilActivity.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(ArtDetatilActivity.this))
                        .doCall();


                // 关注
                break;
        }
    }

    @Override
    public void call(String tag) {
        if (AppConstant.oneMessage.equals(tag))
            mPresenter.getAddFavArtRequest(artId, AppConstant.artst);
    }
}
