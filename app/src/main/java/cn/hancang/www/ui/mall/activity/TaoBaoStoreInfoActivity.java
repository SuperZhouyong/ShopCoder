package cn.hancang.www.ui.mall.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.adapter.HotAuctionItemAdapter;
import cn.hancang.www.adapter.TaoBaoStoreAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.FavBean;
import cn.hancang.www.bean.TaobaoStoreInfoBean;
import cn.hancang.www.ui.Store.activity.StoreFocusActivity;
import cn.hancang.www.ui.main.activity.AuctionFiledActivity;
import cn.hancang.www.ui.main.activity.SearchActivity;
import cn.hancang.www.ui.mall.contract.TaoBaoStoreContract;
import cn.hancang.www.ui.mall.model.TaoBaoStorModel;
import cn.hancang.www.ui.mall.presenter.TaoBaoStorPresenter;
import cn.hancang.www.ui.myinfo.activity.MessageActicity;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.ShareUtil;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import rx.functions.Action1;

/**
 * Description: 保佑无bug
 * Data：2018/5/23-下午11:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TaoBaoStoreInfoActivity extends BaseActivity<TaoBaoStorPresenter, TaoBaoStorModel>
        implements TaoBaoStoreContract.View,
        OnRefreshListener,
        LoadingTip.onReloadListener,
        Action,
        View.OnClickListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    //    @BindView(R.id.iv_love)
//    ImageView ivLove;
//    @BindView(R.id.iv_readme)
//    ImageView ivReadme;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_fouce_num)
    TextView tvFouceNum;
    @BindView(R.id.tv_store_desc)
    TextView tvStoreDesc;
    @BindView(R.id.iv_focus)
    ImageView ivFocus;
    @BindView(R.id.tv_focus)
    TextView tvFocus;
    @BindView(R.id.rel_focus)
    RelativeLayout relFocus;
    @BindView(R.id.rel_head)
    RelativeLayout relHead;
    //    @BindView(R.id.iv_banner)
//    ImageView ivBanner;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    // 主要的adapter
//    private TaoBaoAdapter taoBaoAdapter;
    private Integer currentPostion;
    private Integer currentFavId;
    private LRecyclerViewAdapter mLadapter;
    //    private ImageView iv_store_log;
//    private TextView tv_store_name;
//    private TextView tv_store_desc;
    //热门拍品的界面
    private HotAuctionItemAdapter hotAuctionItemAdapter;
    //    private ImageView ivBanner;
    private Integer store_id;
    private int pagesize = 10;
//    private RelativeLayout rel_focus;
//    private ImageView iv_focus;
//    private TextView tv_focus;
    // 关注的人数
//    private TextView tvFouceNum;

    private TaoBaoStoreAdapter taoBaoStoreAdapter;
    private ImageView ivBanner;
    private String store_name;
    private View image;
    private View taobaoFiledHear;
    private View headViewTwo;
    private String share_url;
    private Dialog shareDialog;


    @Override
    public int getLayoutId() {
        return R.layout.activity_taobaostoreinfo;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    public static void GotoTaoBaoSTireInfoActivity(BaseActivity baseActivity, Integer store_id) {

        Bundle bundle = new Bundle();
//        store_id = 1;
        bundle.putInt(AppConstant.StoreId, store_id);
        baseActivity.startActivity(TaoBaoStoreInfoActivity.class, bundle);
    }

    @Override
    public void initView() {
        store_id = getIntent().getExtras().getInt(AppConstant.StoreId, -1);
//        leftTitle.setVisibility(View.GONE);
//        centerTitle.setText("店铺");
//        relSearch.setVisibility(View.GONE);


        /*taoBaoAdapter = new TaoBaoAdapter(this);
        mLadapter = new LRecyclerViewAdapter(taoBaoAdapter);
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setPullRefreshEnabled(false);
        mLRecyclerView.setLoadMoreEnabled(false);*/
//        mLRecyclerView.setPullRefreshEnabled(true);
//        mLRecyclerView.setOnRefreshListener(this);
//        mLRecyclerView.setLoadMoreEnabled(false);

        //头布局
        /*View tabobaoHeader = getLayoutInflater().inflate(R.layout.item_taobao_header, null);
        iv_store_log = (ImageView) tabobaoHeader.findViewById(R.id.iv_icon);
        tv_store_name = (TextView) tabobaoHeader.findViewById(R.id.tv_store_name);
        tv_store_desc = (TextView) tabobaoHeader.findViewById(R.id.tv_store_desc);
        ivBanner = (ImageView) tabobaoHeader.findViewById(R.id.iv_banner);
        tvFouceNum = (TextView) tabobaoHeader.findViewById(R.id.tv_fouce_num);


        rel_focus = (RelativeLayout) tabobaoHeader.findViewById(R.id.rel_focus);
        iv_focus = (ImageView) tabobaoHeader.findViewById(R.id.iv_focus);
        tv_focus = (TextView) tabobaoHeader.findViewById(R.id.tv_focus);


        rel_focus.setOnClickListener(this);*/

        image = getLayoutInflater().inflate(R.layout.item_taobao_header_image, null);
        ivBanner = (ImageView) image.findViewById(R.id.iv_banner);

        // 推荐专场
        taobaoFiledHear = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById = (TextView) taobaoFiledHear.findViewById(R.id.yv_all_recy_head_title);
        viewById.setText("优选专场");
        setMarGinTop(viewById, (int) getResources().getDimension(R.dimen.x22), 0);
        /*View taobaoFiled = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        RecyclerView mFiledRecyclerview = (RecyclerView) taobaoFiled.findViewById(R.id.mRecyclerView);
        mFiledRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        taoBaoStoreAdapter = new TaoBaoStoreAdapter(this);
        mFiledRecyclerview.setAdapter(taoBaoStoreAdapter);*/

        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taoBaoStoreAdapter = new TaoBaoStoreAdapter(this);
        mLadapter = new LRecyclerViewAdapter(taoBaoStoreAdapter);
        mLRecyclerView.setAdapter(mLadapter);
        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setPullRefreshEnabled(false);


        View taoBaoOneTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) taoBaoOneTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐作品");
        viewById1.setGravity(Gravity.CENTER_HORIZONTAL);
        viewById1.setTextColor(getResources().getColor(R.color.white));
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);

        headViewTwo = getLayoutInflater().inflate(R.layout.item_store_auitem, null);
//        View HeadViewTwo = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
//        mHeadTwoAdapter = new HeadTwoAdapter();

        headViewTwo.findViewById(R.id.tv_all_goods).setOnClickListener(this);
        hotAuctionItemAdapter = new HotAuctionItemAdapter(this);

        RecyclerView mRecyclerView = (RecyclerView) headViewTwo.findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(hotAuctionItemAdapter);

        mLadapter.getHeaderViews().clear();
        mLadapter.getmHeaderTypes().clear();
//        mLadapter.addHeaderView(tabobaoHeader);


//        mLadapter.addHeaderView(taoBaoOneTitle);
//        mLadapter.addHeaderView(HeadViewTwo);

        mRxManager.on(AppConstant.TaoBaoFiled, new Action1<FavBean>() {
            @Override
            public void call(FavBean favBean) {
                currentPostion = favBean.getPostion();
                currentFavId = favBean.getFavId();
                SingleCall.getInstance()
                        .addAction(TaoBaoStoreInfoActivity.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(TaoBaoStoreInfoActivity.this))
                        .doCall();

            }


        });
        mPresenter.getTaoBaoStoreInfoRequest(store_id);
        // 进入拍场页
        mLadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LogUtils.logd("Postion   " + position);
                AuctionFiledActivity.gotoAuctionFiledActivity(TaoBaoStoreInfoActivity.this, taoBaoStoreAdapter.get(position).getId(), AppConstant.IntoWayOne);

            }
        });
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
        if (AppConstant.oneMessage.equals(RequestId))
            mLRecyclerView.refreshComplete(pagesize);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }

    }

    @Override
    public void returnTaobaoSToreInfo(TaobaoStoreInfoBean taobaoStoreInfoBean) {
        if (!taobaoStoreInfoBean.isIs_success()) {
            showShortToast(taobaoStoreInfoBean.getMessage());
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
//            mLoadingTip.setOnReloadListener(this);
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (hotAuctionItemAdapter.getDataList().size() != 0)
            hotAuctionItemAdapter.clear();
//        if (taoBaoAdapter.getDataList().size() != 0)
//            taoBaoAdapter.clear();


        TaobaoStoreInfoBean.DataBean.StoreInfoBean store_info = taobaoStoreInfoBean.getData().getStore_info();
        if (store_info.isIs_fav()) {
            ivFocus.setVisibility(View.GONE);
            tvFocus.setText("已关注");
        }

        ImageLoaderUtils.displayRound(this, ivIcon, store_info.getStore_logo());
        tvStoreName.setText(store_info.getStore_name());
        store_name = store_info.getStore_name();
        tvStoreDesc.setText(store_info.getStore_description());
        ImageLoaderUtils.displayBigPhoto(this, ivBanner, store_info.getStore_banner());
        tvFouceNum.setText("粉丝   " + store_info.getFans_count());


        mLadapter.addHeaderView(image);
        if (taobaoStoreInfoBean.getData().getAuction_field_list() != null && taobaoStoreInfoBean.getData().getAuction_field_list().size() != 0) {
            mLadapter.addHeaderView(taobaoFiledHear);
        }
//        mLadapter.addHeaderView(taobaoFiled);
        mLadapter.addFooterView(headViewTwo);

        if (taobaoStoreInfoBean.getData().getStore_goods().size() > 6)
            hotAuctionItemAdapter.addAll(taobaoStoreInfoBean.getData().getStore_goods().subList(0, 6));
        else
            hotAuctionItemAdapter.addAll(taobaoStoreInfoBean.getData().getStore_goods());
//        hotAuctionItemAdapter.addAll(taobaoStoreInfoBean.getData().getStore_goods());
        taoBaoStoreAdapter.addAll(taobaoStoreInfoBean.getData().getAuction_field_list());
//        taoBaoAdapter.addAll(new ArrayList<TaobaoStoreInfoBean.DataBean.AuctionFieldListBean>());

//        if (!TextUtils.isEmpty(taobaoStoreInfoBean.getData().getStore_info().getShare_url())) {
        share_url = taobaoStoreInfoBean.getData().getStore_info().getShare_url();
//        }
    }

    // 关注拍场
    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        // 收藏完毕就刷新
//        hotAuctionItemAdapter.

        taoBaoStoreAdapter.AddList(currentFavId);
        taoBaoStoreAdapter.notifyItemChanged(currentPostion);
//        taoBaoAdapter.AddList(currentFavId);
//        taoBaoAdapter.notifyItemChanged(currentPostion);
        showShortToast(addFavBean.getMessage());
    }

    // 店铺关注
    @Override
    public void returnAddFavBeanStore(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        ivFocus.setVisibility(View.GONE);
        tvFocus.setText("已关注");
    }

    @Override
    public void onRefresh() {
        mPresenter.getTaoBaoStoreInfoRequest(store_id);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getTaoBaoStoreInfoRequest(store_id);
    }

/*

    @OnClick({R.id.rel_back, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.iv_search:
                break;
        }
    }
*/

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.rel_focus:
//                SingleCall.getInstance()
//                        .addAction(TaoBaoStoreInfoActivity.this, AppConstant.twoMessage)
//                        .addValid(new LoginValid(TaoBaoStoreInfoActivity.this))
//                        .doCall();
////                mPresenter.getAddFavBean(,AppConstant.store);
//                break;
//
//        }
//    }

    @Override
    public void call(String tag) {
        if (AppConstant.oneMessage.equals(tag))
            mPresenter.getAddFavBean(currentFavId, AppConstant.field);
        if (AppConstant.twoMessage.equals(tag))
            mPresenter.getAddFavBean(store_id, AppConstant.store);
        if (AppConstant.threeMessage.equals(tag))
            startActivity(StoreFocusActivity.class);
        if (AppConstant.foreMessage.equals(tag))
            startActivity(MessageActicity.class);
    }

    private void showShareDialog(String url) {
        shareDialog = new Dialog(this, R.style.MyDialog);
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

        shareView.findViewById(R.id.iv_close).setVisibility(View.GONE);
        shareView.findViewById(R.id.iv_share_code).setVisibility(View.GONE);
        shareView.findViewById(R.id.ll_save_pic).setVisibility(View.GONE);
        View viewById = shareView.findViewById(R.id.rel_content);
        viewById.setOnClickListener(this);
        shareDialog.setContentView(shareView);
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        shareDialog.show();


//        ImageLoaderUtils.displayRoundTwo(this, ivShareCode, url);
    }

    @OnClick({R.id.rel_back, R.id.rel_focus,R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_focus:
                SingleCall.getInstance()
                        .addAction(TaoBaoStoreInfoActivity.this, AppConstant.twoMessage)
                        .addValid(new LoginValid(TaoBaoStoreInfoActivity.this))
                        .doCall();
                break;
            case R.id.rel_back:
                finish();
                break;
//                开始分享
            case R.id.rel_search:
                if (TextUtils.isEmpty(share_url)) {
                    showShortToast("请稍后再试...");
                    return;
                }
                showShareDialog(share_url);
//                startActivity(SearchActivity.class);
                break;
            // 关注
           /* case R.id.iv_love:
                SingleCall.getInstance()
                        .addAction(this, AppConstant.threeMessage)
                        .addValid(new LoginValid(this))
                        .doCall();

                break;*/
            // 提醒
           /* case R.id.iv_readme:
                SingleCall.getInstance()
                        .addAction(this, AppConstant.foreMessage)
                        .addValid(new LoginValid(this))
                        .doCall();


//                startActivity(MessageActicity.class);
                break;*/
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all_goods:
                StoreInfoOrderListActivity.gotoStoreInfoOrderListActivity(this, store_id, store_name);
                break;
            case R.id.ll_wx:
                ShareUtil.showShareWxURL(this, ShareSDK.getPlatform(Wechat.NAME).getName(), share_url);
                break;
            case R.id.ll_friends:
                ShareUtil.showShareWxURL(this, ShareSDK.getPlatform(WechatMoments.NAME).getName(), share_url);
                break;
            case R.id.rel_content:
                if (shareDialog != null && shareDialog.isShowing())
                    shareDialog.dismiss();
                break;

        }
    }


}
