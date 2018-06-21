package cn.hancang.www.ui.main.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.AuctionFiledAllBean;
import cn.hancang.www.bean.TabEntity;
import cn.hancang.www.ui.main.contract.AuctionFiledContract;
import cn.hancang.www.ui.main.fragment.HomePageFragment;
import cn.hancang.www.ui.main.model.AuctionFiledModel;
import cn.hancang.www.ui.main.presenter.AuctionFiledPresenter;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 拍场页
 * Data：2018/4/25-下午9:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionFiledActivity extends BaseActivity<AuctionFiledPresenter, AuctionFiledModel> implements AuctionFiledContract.View, LoadingTip.onReloadListener, OnTabSelectListener, View.OnClickListener, Action {


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
    @BindView(R.id.tv_author_desc)
    TextView tvAuthorDesc;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.iv_all)
    ImageView ivAll;
    @BindView(R.id.rel_all)
    RelativeLayout relAll;
    @BindView(R.id.tv_ongoing)
    TextView tvOngoing;
    @BindView(R.id.iv_on_top)
    ImageView ivOnTop;
    @BindView(R.id.iv_onging)
    ImageView ivOnging;
    @BindView(R.id.rel_onging)
    RelativeLayout relOnging;
    @BindView(R.id.tv_preview)
    TextView tvPreview;
    @BindView(R.id.iv_preview)
    ImageView ivPreview;
    @BindView(R.id.rel_preview)
    RelativeLayout relPreview;
    @BindView(R.id.ll_sort)
    LinearLayout llSort;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private Integer auctiuonFiled = -1;
    private Integer sort = 0;
    private LRecyclerViewAdapter mLadapter;
    private CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.AuctionItemListBean> mAdapter;
    private CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.StaffListBean> mArtAdapter;
    private CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.ArtistListBean> mAAboutAdapter;
    //    private String[] mTitles = {"参拍指南", "参拍提醒", "联系客服"};
    private String[] mTitles = {"参拍提醒", "联系客服"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectIds = {R.mipmap.aution_guide_unselect, R.mipmap.aution_remind, R.mipmap.auction_contact};
    //    private int[] mIconSelectIds = {R.mipmap.aution_guide, R.mipmap.aution_remind_select, R.mipmap.contact_peo};
    private int[] mIconSelectIds = {R.mipmap.aution_guide_unselect, R.mipmap.aution_remind_select, R.mipmap.auction_contact};
    private ImageView iv_com_icon;
    private TextView tv_com_name;
    private ImageView iv_add_focus;
    private TextView tv_focus;
    private RelativeLayout rel_focus;
    private boolean isLoadHead;
    // 进入排场的方式
    private String intoWay;
    //    private AuctionFiledAllBean.DataBean.FieldInfoBean.OrganizationBean organization;
    private AuctionFiledAllBean.DataBean.FieldInfoBean field_info;
    //    private RelativeLayout rel_com_focus;
//    private TextView tv_com_focus;
    //    private int organization_id;

    public static void gotoAuctionFiledActivity(BaseActivity mActivity, Integer auctiuonFiled, String IntoTheWay) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.aucotonFileId, auctiuonFiled);
        bundle.putString(AppConstant.IntoTheWay, IntoTheWay);
        mActivity.startActivity(AuctionFiledActivity.class, bundle);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_lotsfiled;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        relSearch.setVisibility(View.GONE);
        auctiuonFiled = getIntent().getExtras().getInt(AppConstant.aucotonFileId, -1);
        intoWay = getIntent().getExtras().getString(AppConstant.IntoTheWay, "");
        mAdapter = new CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.AuctionItemListBean>(this, R.layout.item_auction_file_item) {
            @Override
            public void convert(ViewHolderHelper helper, final AuctionFiledAllBean.DataBean.AuctionItemListBean auctionItemListBean, int position) {
                helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
                helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());

                helper.setText(R.id.tv_goods_price_foot, auctionItemListBean.getBid_leader());
                helper.setText(R.id.tv_goods_desc_foot, "领先者");

                helper.setText(R.id.tv_goods_price, auctionItemListBean.getCurrent_price());
                helper.setText(R.id.tv_goods_desc, "当前价");

                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (TextUtils.isEmpty(intoWay) || AppConstant.IntoWayOne.equals(intoWay))
                            AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, auctionItemListBean.getId());
                        else
                            SynchAuctionItemActivity.gotoSynchAuctionItem((BaseActivity) mContext, auctionItemListBean.getId());
                    }
                });
            }
        };
        mLadapter = new LRecyclerViewAdapter(mAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));

        // 主理人
        mArtAdapter = new CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.StaffListBean>(this, R.layout.item_auction_one) {
            @Override
            public void convert(ViewHolderHelper helper, final AuctionFiledAllBean.DataBean.StaffListBean artistListBean, int position) {
                helper.setImageRoundUrl(R.id.iv_icon, artistListBean.getAvatar());
                helper.setText(R.id.tv_1_name, artistListBean.getName());
                helper.setText(R.id.tv_2_name, artistListBean.getType() == 0 ? "主理人" : "专家");
                helper.setText(R.id.tv_3_name, artistListBean.getRun_count() + "场拍卖");
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OrganPeoActivity.gotoActivity(AuctionFiledActivity.this, artistListBean.getId());
                    }
                });
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mArtAdapter);
        mRecyclerView.addItemDecoration(new cn.hancang.www.widget.SpacesItemDecoration(5));

//        View HeadView = getLayoutInflater().inflate(R.layout.item_auction_file_header, null);
        // 相关作者
        mAAboutAdapter = new CommonRecycleViewAdapter<AuctionFiledAllBean.DataBean.ArtistListBean>(this, R.layout.item_auction_file_foot_item) {
            @Override
            public void convert(ViewHolderHelper helper, final AuctionFiledAllBean.DataBean.ArtistListBean artistListBean, int position) {
                helper.setText(R.id.tv_art_name_item_foot, artistListBean.getName());
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArtDetatilActivity.GotoArtDetailActivity(AuctionFiledActivity.this, artistListBean.getId());
                    }
                });
            }
        };
        View footView = getLayoutInflater().inflate(R.layout.item_auction_file_foot, null);

        iv_com_icon = (ImageView) footView.findViewById(R.id.iv_logo);
        tv_com_name = (TextView) footView.findViewById(R.id.tv_company_name);
        iv_add_focus = (ImageView) footView.findViewById(R.id.iv_focus);
       /* rel_com_focus = (RelativeLayout) footView.findViewById(R.id.rel_focus);
        tv_com_focus = (TextView) footView.findViewById(R.id.tv_focus);*/
        tv_focus = (TextView) footView.findViewById(R.id.tv_focus);
        rel_focus = (RelativeLayout) footView.findViewById(R.id.rel_focus);
        rel_focus.setOnClickListener(this);
        iv_com_icon.setOnClickListener(this);
        tv_com_name.setOnClickListener(this);


        RecyclerView mRecyAbout = (RecyclerView) footView.findViewById(R.id.mRecyclerView_about);
        mRecyAbout.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyAbout.setAdapter(mAAboutAdapter);
        mLadapter.addFooterView(footView);


        tvFocusRen.setVisibility(View.GONE);
        tvNumOne.setTextColor(getResources().getColor(R.color.font_4));
        tvNumTwo.setTextColor(getResources().getColor(R.color.font_4));
        tvNumThree.setTextColor(getResources().getColor(R.color.font_4));
        tvLostPriceDescThree.setText("围观");
        tvLostPriceDescTwo.setText("出价");
        tvLostPriceDescOne.setText("拍品");

        for (int i = 0; i < mTitles.length; i++) {
//            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            mTabEntities.add(new TabEntity(mTitles[i], mIconUnselectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(this);

        mPresenter.getAuctionFiledRequest(auctiuonFiled, sort);

    }

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
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
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);

        }

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void returnAuctionFileData(final AuctionFiledAllBean auctionFiledAllBean) {
        if (!auctionFiledAllBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (isLoadHead) {
            mAdapter.clear();
            mLadapter.notifyDataSetChanged();
            mAdapter.addAll(auctionFiledAllBean.getData().getAuction_item_list());
            mLadapter.notifyDataSetChanged();
            return;
        }
//        organization = auctionFiledAllBean.getData().getField_info().getOrganization();

        field_info = auctionFiledAllBean.getData().getField_info();
//        iv_add_focus
        //机构的关注
        if (auctionFiledAllBean.getData().getField_info().getOrganization() != null && auctionFiledAllBean.getData().getField_info().getOrganization().isIs_favorite()) {
            iv_add_focus.setVisibility(View.GONE);
            tv_focus.setText("已关注");
        }
        //排场的关注
        if (auctionFiledAllBean.getData().getField_info().isIs_favorite()) {
            mTabEntities.clear();
            for (int i = 0; i < mTitles.length; i++) {
                mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconSelectIds[i]));
            }
            tabLayout.setTabData(mTabEntities);
        }
        String start_time = null;
        String end_time = null;
        if (!TextUtils.isEmpty(field_info.getStart_time()))
            start_time = field_info.getStart_time().replace("-", ".");
        if (!TextUtils.isEmpty(field_info.getEnd_time()))
            end_time = field_info.getEnd_time().replace("-", ".");
        String s;
        if (start_time == null && end_time == null) {
            s = "拍卖时间暂未确定";
        } else
            s = start_time.substring(start_time.indexOf(".") + 1) + "-" + end_time.substring(end_time.indexOf(".") + 1);
        TvTimeTwo.setText(s);
//        TvTimeTwo.setText(auctionFiledAllBean.getData().getField_info().getStart_time() + "-" + auctionFiledAllBean.getData().getField_info().getEnd_time());

        ImageLoaderUtils.displayRound(this, iv_com_icon, auctionFiledAllBean.getData().getField_info().getOrganization().getLogo());
        tv_com_name.setText(auctionFiledAllBean.getData().getField_info().getOrganization().getName());

        tvLotName.setText(auctionFiledAllBean.getData().getField_info().getName());
        tvAuthorDesc.setText(auctionFiledAllBean.getData().getField_info().getDescription());

        tvNumOne.setText(auctionFiledAllBean.getData().getField_info().getItem_count() + "件");
        tvNumTwo.setText(auctionFiledAllBean.getData().getField_info().getBid_count() + "次");
        tvNumThree.setText(auctionFiledAllBean.getData().getField_info().getFans_count() + "人");

        mArtAdapter.addAll(auctionFiledAllBean.getData().getStaff_list());
        mAAboutAdapter.addAll(auctionFiledAllBean.getData().getArtist_list());
//        mAAboutAdapter.addAll(auctionFiledAllBean.getData().getArtist_list());


        mAdapter.addAll(auctionFiledAllBean.getData().getAuction_item_list());
//        setViewVG(current, Three);
        isLoadHead = true;
    }

    //机构的关注
    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        iv_add_focus.setVisibility(View.GONE);
        tv_focus.setText("已关注");
    }

    // 排场的关注 成功
    @Override
    public void returnAddFavBeanFiled(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        mTabEntities.clear();
        for (int i = 0; i < mTitles.length; i++) {
//            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconSelectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
//        iv_add_focus.setVisibility(View.GONE);
//        tv_focus.setText("已关注");
    }


    @Override
    public void onTabSelect(int i) {
        switch (i) {
           /* // 参拍指南
            case 0:
                break;*/
            case 0:
                // 排场关注
                SingleCall.getInstance()
                        .addAction(this, AppConstant.twoMessage)
                        .addValid(new LoginValid(this))
                        .doCall();

                break;
            case 1:
                showContractDialog();
                break;
        }
    }

    @Override
    public void onTabReselect(int i) {

    }

    @Override
    public void reloadLodTip() {
        mPresenter.getAuctionFiledRequest(auctiuonFiled, sort);
    }


    @OnClick({R.id.rel_back, R.id.rel_search, R.id.rel_all, R.id.rel_onging, R.id.rel_preview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                // 分享
                break;
            case R.id.rel_all:
                current = 1;
                Three = 0;
                setViewVG(current, Three);
                break;
            case R.id.rel_onging:
                current = 2;
                setViewVG(current, Three++);
                break;
            case R.id.rel_preview:
                current = 3;
                Three = 0;
                setViewVG(current, Three);
                break;
        }
    }

    private Integer current = 0;
    private Integer Three = 0;

    private void setViewVG(Integer current, Integer Three) {
        if (sort == 0 && current == 1) {
            return;
        }
        if (sort == 3 && current == 3) {
            return;
        }

        switch (current) {
            case 1:
                ivAll.setVisibility(View.VISIBLE);
                ivOnging.setVisibility(View.GONE);
                ivPreview.setVisibility(View.GONE);
                ivOnTop.setImageResource(R.mipmap.heat_unselect);
                sort = 0;
                break;
            case 2:
                ivAll.setVisibility(View.GONE);
                ivOnging.setVisibility(View.VISIBLE);
                ivPreview.setVisibility(View.GONE);
                switch (Three % 2) {
                    case 0:
                        ivOnTop.setImageResource(R.mipmap.heat_slect_top);
                        sort = 1;
                        break;
                    case 1:
                        ivOnTop.setImageResource(R.mipmap.heat_select_bottom);
                        sort = 2;
                        break;

                }

                break;
            case 3:
                sort = 3;
                ivOnTop.setImageResource(R.mipmap.heat_unselect);
                ivAll.setVisibility(View.GONE);
                ivOnging.setVisibility(View.GONE);
                ivPreview.setVisibility(View.VISIBLE);
                break;
        }
        mPresenter.getAuctionFiledRequest(auctiuonFiled, sort);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 进入机构
            case R.id.iv_logo:
            case R.id.tv_company_name:
                AuctionOrgActivity.gotoAuctionOrg((AuctionFiledActivity) mContext, field_info.getOrganization() != null ? field_info.getOrganization().getId() : -1);
                break;
            // 机构加入关注
            case R.id.rel_focus:
                SingleCall.getInstance()
                        .addAction(AuctionFiledActivity.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(AuctionFiledActivity.this))
                        .doCall();

                break;
        }
    }

    @Override
    public void call(String tag) {
        if (AppConstant.oneMessage.equals(tag)) {
            if (field_info.getOrganization() != null)
                mPresenter.getAddFavBean(field_info.getOrganization().getId(), AppConstant.organ);
            else
                showShortToast("此机构暂不支持关注");
        }
        if (AppConstant.twoMessage.equals(tag))
            mPresenter.getAddFavBean(field_info.getId(), AppConstant.field);
    }
}
