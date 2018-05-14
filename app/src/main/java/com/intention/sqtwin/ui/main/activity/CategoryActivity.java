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

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:32
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryActivity extends BaseActivity<CategorPresenter, CategoryModel> implements CategoryContract.View, LoadingTip.onReloadListener {

    @BindView(R.id.mrecy_right)
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
    ImageView ivDilver;
    private CommonRecycleViewAdapter<CategoryAllBean.DataBean.CategoryBean> mLeftAdapter;
    private CommonRecycleViewAdapter<CategoryAllBean.DataBean.SubCategoryBean> mRightAdapter;
    private Integer current_category_id = 19;
    private LRecyclerViewAdapter mLadapter;
    private TextView viewById;

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
        categoryLogo.setImageResource(R.mipmap.logo);

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
            public void convert(ViewHolderHelper helper, CategoryAllBean.DataBean.SubCategoryBean categoryBean, int position) {
                helper.setImageUrl(R.id.iv_goods, categoryBean.getImage());
                helper.setText(R.id.tv_name, categoryBean.getName());
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(AuctionItemListActivity.class);
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


}
