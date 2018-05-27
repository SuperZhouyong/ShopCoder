package com.intention.sqtwin.ui.main.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.CategoryAllBean;
import com.intention.sqtwin.ui.main.contract.CategoryContract;
import com.intention.sqtwin.ui.main.model.CategoryModel;
import com.intention.sqtwin.ui.main.presenter.CategorPresenter;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:32
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryActivity extends BaseActivity<CategorPresenter, CategoryModel> implements CategoryContract.View, LoadingTip.onReloadListener {
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
    @BindView(R.id.mrecy_left)
    RecyclerView mrecyLeft;
    @BindView(R.id.iv_dilver)
    ImageView ivDilver;
    @BindView(R.id.mrecy_right)
    LRecyclerView mrecyRight;
    @BindView(R.id.rel_all)
    RelativeLayout relAll;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
   /* @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;
    @BindView(R.id.mrecy_left)
    RecyclerView mrecyLeft;
    @BindView(R.id.iv_dilver)
    ImageView ivDilver;
    @BindView(R.id.mrecy_right)
    LRecyclerView mrecyRight;
    @BindView(R.id.rel_all)
    RelativeLayout relAll;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;*/

  /*  @BindView(R.id.mrecy_right)
    LRecyclerView mrecyRight;
    @BindView(R.id.rel_all)
    RelativeLayout relAll;
    @BindView(R.id.iv_love)
    ImageView ivLove;
    @BindView(R.id.iv_readme)
    ImageView ivReadme;
    @BindView(R.id.mrecy_left)
    RecyclerView mrecyLeft;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.category_logo)
    ImageView categoryLogo;
    @BindView(R.id.iv_dilver)
    ImageView ivDilver*/;
    private CommonRecycleViewAdapter<CategoryAllBean.DataBean.CategoryBean> mLeftAdapter;
    private CommonRecycleViewAdapter<CategoryAllBean.DataBean.SubCategoryBean> mRightAdapter;
    // 进来默认为1
    private Integer current_category_id = 1;
    private LRecyclerViewAdapter mLadapter;
    private TextView viewById;
    // 由上一个界面传入进来
    private Integer CategoryType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
//        centerTitle.set
        String mTitle = getIntent().getExtras().getString(AppConstant.CategoryTitle);
        centerTitle.setText(mTitle);
        CategoryType = getIntent().getExtras().getInt(AppConstant.CategoryType, -1);
//        current_category_id = getIntent().getExtras().getInt(AppConstant.)

//        categoryLogo.setImageResource(R.mipmap.logo);

        mLeftAdapter = new CommonRecycleViewAdapter<CategoryAllBean.DataBean.CategoryBean>(this, R.layout.item_category_left) {
            @Override
            public void convert(final ViewHolderHelper helper, final CategoryAllBean.DataBean.CategoryBean categoryBean, int position) {
//                if (){
//                    helper.getConvertView().setBackgroundColor(mContext.getResources().getColor(R.color.app_bottom_colour));
//                }else
                helper.getConvertView().setBackgroundColor(categoryBean.getCategory_id() == current_category_id ? mContext.getResources().getColor(R.color.app_bottom_colour) : mContext.getResources().getColor(R.color.white));
                if (current_category_id == categoryBean.getCategory_id())
                    viewById.setText(categoryBean.getName());
                helper.setText(R.id.tv_category, categoryBean.getName());
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (current_category_id != categoryBean.getCategory_id()) {
                            current_category_id = categoryBean.getCategory_id();
                            notifyDataSetChanged();
                            mPresenter.getCategoryBeanRequest(current_category_id);
                        }
                    }
                });
            }
        };

        mrecyLeft.setLayoutManager(new LinearLayoutManager(this));
        mrecyLeft.setAdapter(mLeftAdapter);

        mRightAdapter = new CommonRecycleViewAdapter<CategoryAllBean.DataBean.SubCategoryBean>(this, R.layout.item_category_right) {
            @Override
            public void convert(ViewHolderHelper helper, final CategoryAllBean.DataBean.SubCategoryBean categoryBean, int position) {
                helper.setImageUrl(R.id.iv_goods, categoryBean.getImage());
                helper.setText(R.id.tv_name, categoryBean.getName());
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AuctionItemListActivity.GotoAuctionItemListActivity((BaseActivity) mContext, CategoryType, categoryBean.getName(), categoryBean.getCategory_id());

                    }
                });
            }
        };


        mLadapter = new LRecyclerViewAdapter(mRightAdapter);

        mrecyRight.setLayoutManager(new GridLayoutManager(this, 3));
        mrecyRight.setAdapter(mLadapter);
        mrecyRight.setPullRefreshEnabled(false);
        mrecyRight.setLoadMoreEnabled(false);

        View homeHeadTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        viewById = (TextView) homeHeadTitle.findViewById(R.id.yv_all_recy_head_title);
        setMarGinTop(viewById, (int) getResources().getDimension(R.dimen.x22), 0);
        viewById.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.x30));
        viewById.getPaint().setFakeBoldText(true);
        mLadapter.addHeaderView(homeHeadTitle);

        mPresenter.getCategoryBeanRequest(current_category_id);
    }

    // 入口目前为 两个地方  1拍品---拍品分类，，，， 2衍生品的分类--商品
    //商品类型：0=拍品，1=普通商品，2=众筹商品  分类界面的入口
    public static void GotoCategoryActivity(BaseActivity mActivity, Integer type, String title) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstant.CategoryType, type);
        bundle.putString(AppConstant.CategoryTitle, title);
        mActivity.startActivity(CategoryActivity.class, bundle);

    }

    @Override
    public void StartLoading(String RequestId) {
        if (mLeftAdapter.getDataList().size() == 0) {
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
        showShortToast(msg);

    }

    @Override
    public void returnCategoryData(CategoryAllBean categoryAllBean) {
        if (!categoryAllBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (mLeftAdapter.getDataList().size() == 0)
            mLeftAdapter.addAll(categoryAllBean.getData().getCategory());
        mRightAdapter.clearData();
        mLadapter.notifyDataSetChanged();
        mRightAdapter.addAll(categoryAllBean.getData().getSub_category());
    }


    @Override
    public void reloadLodTip() {
        mPresenter.getCategoryBeanRequest(current_category_id);
    }


   /* @OnClick({R.id.rel_search, R.id.iv_love, R.id.iv_readme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 去搜索
            case R.id.rel_search:
                break;
            //去关注
            case R.id.iv_love:
                break;
            // 去提醒
            case R.id.iv_readme:
                break;
        }
    }*/


    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
        }
    }
}
