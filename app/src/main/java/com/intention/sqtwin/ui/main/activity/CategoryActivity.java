package com.intention.sqtwin.ui.main.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.CategoryBena;
import com.intention.sqtwin.ui.main.contract.CategoryContract;
import com.intention.sqtwin.ui.main.model.CategoryModel;
import com.intention.sqtwin.ui.main.presenter.CategorPresenter;

import butterknife.BindView;

/**
 * Description: 保佑无bug
 * Data：2018/5/4-下午11:32
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class CategoryActivity extends BaseActivity<CategorPresenter, CategoryModel> implements CategoryContract.View {
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.mrecy_left)
    RecyclerView mrecyLeft;
    @BindView(R.id.mrecy_right)
    RecyclerView mrecyRight;
    @BindView(R.id.rel_all)
    RelativeLayout relAll;



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
    public void returnCategoryData(CategoryBena categoryBena) {

    }


}
