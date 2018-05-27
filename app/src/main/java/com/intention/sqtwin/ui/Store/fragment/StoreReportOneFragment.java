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
import com.intention.sqtwin.bean.StoreReportOne;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Description: 绝无Bug
 * Data：2018/5/21 0021-上午 11:43
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StoreReportOneFragment extends LazzyFragment implements LoadingTip.onReloadListener {

    @BindView(R.id.tv_one_one_price)
    TextView tvOneOnePrice;
    @BindView(R.id.tv_one_one_num)
    TextView tvOneOneNum;
    @BindView(R.id.tv_two_one_price)
    TextView tvTwoOnePrice;
    @BindView(R.id.tv_two_one_num)
    TextView tvTwoOneNum;
    @BindView(R.id.tv_two_two_price)
    TextView tvTwoTwoPrice;
    @BindView(R.id.tv_two_two_num)
    TextView tvTwoTwoNum;
    @BindView(R.id.tv_three_price)
    TextView tvThreePrice;
    @BindView(R.id.tv_three_num)
    TextView tvThreeNum;
    @BindView(R.id.tv_fore_one_price)
    TextView tvForeOnePrice;
    @BindView(R.id.tv_for_one_num)
    TextView tvForOneNum;
    @BindView(R.id.tv_fore_two_price)
    TextView tvForeTwoPrice;
    @BindView(R.id.tv_fore_two_num)
    TextView tvForeTwoNum;
    @BindView(R.id.tv_fore_three_price)
    TextView tvForeThreePrice;
    @BindView(R.id.tv_for_three_num)
    TextView tvForThreeNum;
    @BindView(R.id.tv_fore_fore_price)
    TextView tvForeForePrice;
    @BindView(R.id.tv_for_for_num)
    TextView tvForForNum;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;

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
        return R.layout.fragment_storeonereport;
    }

    @Override
    protected void RequestNetWorkData() {
        RequestStoreReportOne();
    }

    public static StoreReportOneFragment getInstance(String mTitle, int i) {
        StoreReportOneFragment sf = new StoreReportOneFragment();
        sf.mTitle = mTitle;

        sf.mcategory_id = i;
        return sf;

    }

    private void RequestStoreReportOne() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .getCapitalReport()
                .compose(RxSchedulers.<StoreReportOne>io_main())
                .subscribe(new RxSubscriber<StoreReportOne>(getActivity()) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected void _onNext(StoreReportOne storeReportOne) {
                        showShortToast(storeReportOne.getMessage());
                        if (!storeReportOne.isIs_success()) {
                            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                            return;
                        }
                        if (mLoadingTip.getVisibility() == View.VISIBLE)
                            mLoadingTip.setViewGone();
                        StoreReportOne.DataBean data = storeReportOne.getData();
                        tvOneOnePrice.setText(data.getHas_taken() + "");
                        tvOneOneNum.setText(data.getHas_taken_count() + "");

                        tvTwoOnePrice.setText(data.getPaid() + "");
                        tvTwoOneNum.setText(data.getPaid_count() + "");
                        tvTwoTwoPrice.setText(data.getRefunded() + "");
                        tvTwoTwoNum.setText(data.getRefunded_count() + "");

                        tvThreePrice.setText(data.getReceived() + "");
                        tvThreeNum.setText(data.getReceived_count() + "");

                        tvForeOnePrice.setText(data.getUnconfirmed() + "");
                        tvForOneNum.setText(data.getUnconfirmed_count() + "");
                        tvForeTwoPrice.setText(data.getUnconfirmed() + "");
                        tvForeTwoNum.setText(data.getUnconfirmed_count() + "");
                        tvForeThreePrice.setText(data.getRefunding() + "");
                        tvForThreeNum.setText(data.getRefunding_count() + "");
                        tvForeForePrice.setText(data.getReturn_goods() + "");
                        tvForForNum.setText(data.getReturn_goods_count() + "");


                    }

                    @Override
                    protected void _onError(String message) {

                        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                        mLoadingTip.setOnReloadListener(StoreReportOneFragment.this);
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
        RequestStoreReportOne();
    }
}
