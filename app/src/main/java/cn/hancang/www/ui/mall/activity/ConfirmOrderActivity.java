package cn.hancang.www.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.adapter.OneContentAdaoter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;
import cn.hancang.www.ui.mall.model.ConfirmOrderModel;
import cn.hancang.www.ui.mall.presenter.ConfirmOrderPresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:17
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ConfirmOrderActivity extends BaseActivity<ConfirmOrderPresenter, ConfirmOrderModel> implements ConfirmOrderContract.View {
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
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private OneContentAdaoter oneContentAdaoter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_confirmorder;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        centerTitle.setText("确认订单页");
        relSearch.setVisibility(View.GONE);

        // 第一个订单详情标题
        View oneTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) oneTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("推荐作品");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);
        // 订单详情的具体情况

        View oneContent = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        RecyclerView mRecyclerView = (RecyclerView) oneContent.findViewById(R.id.mRecyclerView);
        oneContentAdaoter = new OneContentAdaoter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(oneContentAdaoter);
        // 运费界面
        View twoOnctent = getLayoutInflater().inflate(R.layout.item_confirm_two, null);
        // 收货地址列表
        View ThreeContent = getLayoutInflater().inflate(R.layout.item_confirm_three,null);
        // 备注
        View forContent = getLayoutInflater().inflate(R.layout.item_confir_four, null);
    // 支付方式

}

    @Override
    public void StartLoading(String RequestId) {
        if (AppConstant.oneMessage.equals(RequestId))
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);

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
    public void returnConfirmOrderBean(ConfirmOrderBean confirmOrderBean) {

    }


    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.rel_search:
                break;
        }
    }
}
