package com.intention.sqtwin.ui.Store.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.base.LazzyFragment;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.StoreReportTwo;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Description: 绝无Bug
 * Data：2018/5/21 0021-上午 11:43
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreReportTwoFragment extends LazzyFragment implements LoadingTip.onReloadListener {
    @BindView(R.id.tv_one_one_price)
    TextView tvOneOnePrice;
    @BindView(R.id.tv_one_one_num)
    TextView tvOneOneNum;
    @BindView(R.id.tv_three_one_price)
    TextView tvThreeOnePrice;
    @BindView(R.id.tv_three_one_num)
    TextView tvThreeOneNum;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    @BindView(R.id.tv_two_one_price)
    TextView tvTwoOnePrice;


    private String mTitle;
    private Integer mcategory_id;

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_storetworeport;
    }

    @Override
    protected void RequestNetWorkData() {
        RequestStoreTwoReport();
    }

    public static StoreReportTwoFragment getInstance(String mTitle, int i) {
        StoreReportTwoFragment sf = new StoreReportTwoFragment();
        sf.mTitle = mTitle;

        sf.mcategory_id = i;
        return sf;

    }

    private void RequestStoreTwoReport() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .getManageReport()
                .compose(RxSchedulers.<StoreReportTwo>io_main())
                .subscribe(new RxSubscriber<StoreReportTwo>(getActivity()) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected void _onNext(StoreReportTwo storeReportTwo) {
                        showShortToast(storeReportTwo.getMessage());
                        if (!storeReportTwo.isIs_success()) {
                            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                            return;
                        }
                        if (mLoadingTip.getVisibility() == View.VISIBLE)
                            mLoadingTip.setViewGone();
                        StoreReportTwo.DataBean data = storeReportTwo.getData();
                        tvOneOnePrice.setText(data.getFans() + "");
                        tvOneOneNum.setText(data.getFans_add() + "");

                        tvTwoOnePrice.setText(data.getPublish_count() + "");

                        tvThreeOnePrice.setText(data.getPayment_number() + "");
                        tvThreeOneNum.setText(data.getScale() + "%");


                    }

                    @Override
                    protected void _onError(String message) {
                        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                        mLoadingTip.setOnReloadListener(StoreReportTwoFragment.this);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
                    }

                }));

    }


    @Override
    public void reloadLodTip() {
        RequestStoreTwoReport();
    }
}
