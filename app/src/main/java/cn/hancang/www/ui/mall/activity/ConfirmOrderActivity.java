package cn.hancang.www.ui.mall.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.bean.SubmitOrderBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.adapter.FiveContentAdapter;
import cn.hancang.www.adapter.OneContentAdaoter;
import cn.hancang.www.adapter.ThreeContentAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;
import cn.hancang.www.ui.mall.model.ConfirmOrderModel;
import cn.hancang.www.ui.mall.presenter.ConfirmOrderPresenter;
import cn.hancang.www.ui.myinfo.activity.AddReAddressActivity;
import cn.hancang.www.ui.myinfo.activity.ReceivedGoodsActivity;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:17
 * Blog：Super简单58
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ConfirmOrderActivity extends BaseActivity<ConfirmOrderPresenter, ConfirmOrderModel> implements ConfirmOrderContract.View, LoadingTip.onReloadListener {
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
    @BindView(R.id.tv_goods_total)
    TextView tvGoodsTotal;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    private OneContentAdaoter oneContentAdaoter;
    private FiveContentAdapter fiveContentAdapter;
    private ThreeContentAdapter threeContentAdapter;
    private TextView tv_carriage;
    private RecyclerView threRecyclerView;
    private LRecyclerViewAdapter mLAdapter;
    private View tvMangerAddress;
    private TextView edBeizhu;

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

        fiveContentAdapter = new FiveContentAdapter(this);
        mLAdapter = new LRecyclerViewAdapter(fiveContentAdapter);
//        mLRecyclerView.addItemDecoration(com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration.newInstance(0, 1, 1, R.color.app_bottom_colour));
        mLRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLRecyclerView.setAdapter(mLAdapter);
//        mLRecyclerView.setLoadMoreEnabled(false);
        mLRecyclerView.setPullRefreshEnabled(false);

        // 第一个订单详情标题
        View oneTitle = getLayoutInflater().inflate(R.layout.item_all_recy_head_title, null);
        TextView viewById1 = (TextView) oneTitle.findViewById(R.id.yv_all_recy_head_title);
        viewById1.setText("订单详情");
        setMarGinTop(viewById1, (int) getResources().getDimension(R.dimen.x22), 0);
        // 订单详情的具体情况

        View oneContent = getLayoutInflater().inflate(R.layout.item_homepage_headview_two, null);
        RecyclerView mRecyclerView = (RecyclerView) oneContent.findViewById(R.id.mRecyclerView);
        oneContentAdaoter = new OneContentAdaoter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(oneContentAdaoter);
        // 运费界面
        View twoOnctent = getLayoutInflater().inflate(R.layout.item_confirm_two, null);
        tv_carriage = (TextView) twoOnctent.findViewById(R.id.tv_carriage);
        // 收货地址列表
        View ThreeContent = getLayoutInflater().inflate(R.layout.item_confirm_three, null);
        tvMangerAddress = ThreeContent.findViewById(R.id.tv_mange);
        tvMangerAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ReceivedGoodsActivity.class);
            }
        });
        threRecyclerView = (RecyclerView) ThreeContent.findViewById(R.id.mRecyclerView);
        threeContentAdapter = new ThreeContentAdapter(this);
        threRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        threRecyclerView.setAdapter(threeContentAdapter);
        // 备注
        View forContent = getLayoutInflater().inflate(R.layout.item_confir_four, null);
        edBeizhu = (TextView) forContent.findViewById(R.id.et_beizhu);
        // 支付方式
       /* View fiveContent = getLayoutInflater().inflate(R.layout.item_confirm_five, null);
        RecyclerView mRecyclerFive = (RecyclerView) fiveContent.findViewById(R.id.mRecyclerViewfive);
        fiveContentAdapter = new FiveContentAdapter(this);
        mRecyclerFive.addItemDecoration(new SpacesItemDecoration(5));
        mRecyclerFive.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerFive.setAdapter(fiveContentAdapter);*/

        mLAdapter.addHeaderView(oneTitle);
        mLAdapter.addHeaderView(oneContent);
        mLAdapter.addHeaderView(twoOnctent);
        mLAdapter.addHeaderView(ThreeContent);
        mLAdapter.addHeaderView(forContent);

        mPresenter.getCOnfirmOrderBeanRequest(getIntent().getExtras().getString(AppConstant.orderList));


    }

    public static void gotoConfirmOrderActivity(BaseActivity mBaseActivity, String orderList) {

        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.orderList, orderList);
        mBaseActivity.startActivity(ConfirmOrderActivity.class, bundle);

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
        if (AppConstant.oneMessage.equals(RequestId)) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
            mLoadingTip.setOnReloadListener(this);
        }
    }

    @Override
    public void returnConfirmOrderBean(ConfirmOrderBean confirmOrderBean) {
        if (!confirmOrderBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (oneContentAdaoter.getDataList().size() != 0)
            oneContentAdaoter.clear();
        oneContentAdaoter.addAll(confirmOrderBean.getData().getGoods_list());
        tv_carriage.setText(confirmOrderBean.getData().getTotal_freight() + "");
        if (threeContentAdapter.getDataList().size() != 0)
            threeContentAdapter.clear();
        threeContentAdapter.addAll(confirmOrderBean.getData().getAddress_list());
        if (fiveContentAdapter.getDataList().size() != 0)
            fiveContentAdapter.clear();
        fiveContentAdapter.addAll(confirmOrderBean.getData().getPay_list());
        tvGoodsTotal.setText("商品总计：  " + confirmOrderBean.getData().getTotal_amount() + "元");
    }

    /**
     * 提交订单页
     * @param submitOrderBean
     */
    @Override
    public void returnOrderSubmit(SubmitOrderBean submitOrderBean) {

    }


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

    @Override
    public void reloadLodTip() {
        mPresenter.getCOnfirmOrderBeanRequest(getIntent().getExtras().getString(AppConstant.orderList));
    }


}
