package cn.hancang.www.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import cn.hancang.www.R;
import cn.hancang.www.adapter.OrganPeoAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.bean.AddFavBean;
import cn.hancang.www.bean.FavBean;
import cn.hancang.www.bean.OrganPeBean;
import cn.hancang.www.ui.main.contract.OrganPeContract;
import cn.hancang.www.ui.main.model.OrganPeModel;
import cn.hancang.www.ui.main.presenter.OrganPePresenter;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Description: 主理人界面没找到
 * Data：2018/5/4-上午12:24
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OrganPeoActivity extends BaseActivity<OrganPePresenter, OrganPeModel> implements OrganPeContract.View, OnLoadMoreListener, LoadingTip.onReloadListener, OnNetWorkErrorListener, Action {

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
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    //    private CommonRecycleViewAdapter<OrganPeBean.DataBean.AuctionFieldListBean> mcomAdapter;
    private LRecyclerViewAdapter mLadapter;
    private Integer staffID = 1;
    private Integer page = 0;
    private int pagesize = 10;
    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;
    private OrganPeoAdapter organpeoAdapter;
    private Integer currentPostion;
    private Integer currentFavId;
    private ImageView ivHead;
//    private ImageView ivOrganHead;

    @Override
    public int getLayoutId() {
        return R.layout.activity_organpeo;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        staffID = getIntent().getExtras().getInt(AppConstant.PeoID);
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
        centerTitle.setText("主理人");

        organpeoAdapter = new OrganPeoAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLadapter = new LRecyclerViewAdapter(organpeoAdapter);
        mRecyclerView.setAdapter(mLadapter);
        mRecyclerView.setPullRefreshEnabled(false);
        mRecyclerView.setOnLoadMoreListener(this);
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 30, 1, getResources().getColor(R.color.app_bottom_colour)));
        View artDetailHead = getLayoutInflater().inflate(R.layout.item_organpeo_head, null);
        ivHead = (ImageView) artDetailHead.findViewById(R.id.iv_icon);
        tv_one = (TextView) artDetailHead.findViewById(R.id.tv_one);
        tv_two = (TextView) artDetailHead.findViewById(R.id.tv_two);
        tv_three = (TextView) artDetailHead.findViewById(R.id.tv_three);
//        ivOrganHead = (ImageView) artDetailHead.findViewById(R.id.iv_organ_head);
//        setMarGinTop(artDetailHead.findViewById(R.id.rel_desc), (int) getResources().getDimension(R.dimen.x22),(int) getResources().getDimension(R.dimen.y30));
//        setMarGinTop(artDetailHead.findViewById(R.id.rel_background), (int) getResources().getDimension(R.dimen.x22),(int) getResources().getDimension(R.dimen.y100));
        mLadapter.addHeaderView(artDetailHead);
        //item_home_head_title
        View homeHeadTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView tv_title = (TextView) homeHeadTitle.findViewById(R.id.yv_all_recy_head_title);
        tv_title.setText("参与主理的拍场");
        setMarGinTop(homeHeadTitle.findViewById(R.id.yv_all_recy_head_title), (int) getResources().getDimension(R.dimen.x22), 0);
        mLadapter.addHeaderView(homeHeadTitle);
//        View allHeadView = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
//        mLadapter.addHeaderView(allHeadView);
        mPresenter.getRequestData(staffID, page);

        mRxManager.on(AppConstant.OrganPeoFiled, new Action1<FavBean>() {
            @Override
            public void call(FavBean favBean) {
                currentPostion = favBean.getPostion();
                currentFavId = favBean.getFavId();
                SingleCall.getInstance()
                        .addAction(OrganPeoActivity.this, AppConstant.oneMessage)
                        .addValid(new LoginValid(OrganPeoActivity.this))
                        .doCall();

            }


        });
    }


    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId) && organpeoAdapter.getDataList().size() == 0)
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
    }

    @Override
    public void returnOrganPeData(OrganPeBean organPeBean) {
        if (!organPeBean.isIs_success()) {
            // 非第一页数据请求失败 不同于网路请求，由服务器不反悔数据
            showShortToast(organPeBean.getMessage());
            if (page == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                mLoadingTip.setOnReloadListener(this);
            }
            return;
        }

        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page == 0) {
            ImageLoaderUtils.displayRound(this, ivHead, organPeBean.getData().getStaff_info().getAvatar());
            tv_one.setText(organPeBean.getData().getStaff_info().getName());
            tv_two.setText(organPeBean.getData().getStaff_info().getType() == 0 ? "主理人" : "专家");
            tv_three.setText(organPeBean.getData().getStaff_info().getDescription());
//            ImageLoaderUtils.displayRound(this, ivOrganHead, organPeBean.getData().getStaff_info().getAvatar());
        }


        if (page >= organPeBean.getData().getPage_count()) {
            mRecyclerView.setNoMore(true);
            return;
        }

        organpeoAdapter.addAll(organPeBean.getData().getAuction_field_list());
        ++page;

    }

    @Override
    public void returnAddFavBean(AddFavBean addFavBean) {
        showShortToast(addFavBean.getMessage());
        if (!addFavBean.isIs_success()) {
            return;
        }
        // 收藏完毕就刷新
        organpeoAdapter.AddList(currentFavId);
        organpeoAdapter.notifyItemChanged(currentPostion);
        showShortToast(addFavBean.getMessage());
    }


    @Override
    public void onLoadMore() {
        mPresenter.getRequestData(staffID, page);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getRequestData(staffID, page);
    }

    @Override
    public void reload() {
        mPresenter.getRequestData(staffID, page);
    }

    public static void gotoActivity(BaseActivity auctionItemActivity, int author_id) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.PeoID, author_id);
        auctionItemActivity.startActivity(OrganPeoActivity.class, bundle);
    }


    @OnClick({R.id.rel_back, R.id.left_title, R.id.center_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.left_title:
                break;
            case R.id.center_title:
                break;
        }
    }


    @Override
    public void call(String tag) {
        if (AppConstant.oneMessage.equals(tag))
            mPresenter.getAddFavBean(currentFavId, AppConstant.field);
    }
}
