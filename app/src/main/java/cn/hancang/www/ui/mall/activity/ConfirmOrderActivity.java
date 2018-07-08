package cn.hancang.www.ui.mall.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


import java.util.List;
import java.util.Map;

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
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.SubmitOrderBean;
import cn.hancang.www.bean.WxPayBean;
import cn.hancang.www.ui.mall.contract.ConfirmOrderContract;
import cn.hancang.www.ui.mall.model.ConfirmOrderModel;
import cn.hancang.www.ui.mall.presenter.ConfirmOrderPresenter;
import cn.hancang.www.ui.myinfo.activity.AccountActivity;
import cn.hancang.www.ui.myinfo.activity.AddReAddressActivity;
import cn.hancang.www.ui.myinfo.activity.OrderListActivity;
import cn.hancang.www.ui.myinfo.activity.ReceivedGoodsActivity;
import cn.hancang.www.ui.myinfo.activity.SelectChargeActivity;
import cn.hancang.www.utils.conmonUtil.JsonUtils;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.payUtils.PayResult;
import cn.hancang.www.widget.conmonWidget.LoadingTip;
import rx.functions.Action1;

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
    private String goodsId;
    private String goodsNum;
    private Double total_freight;

    private String conFirmType;

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
        mLRecyclerView.setLoadMoreEnabled(false);
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

        mLAdapter.getHeaderViews().clear();
        mLAdapter.getmHeaderTypes().clear();

        mLAdapter.addHeaderView(oneTitle);
        mLAdapter.addHeaderView(oneContent);
        mLAdapter.addHeaderView(twoOnctent);
        mLAdapter.addHeaderView(ThreeContent);
        mLAdapter.addHeaderView(forContent);
        goodsId = getIntent().getExtras().getString(AppConstant.GoodsId);

        conFirmType = getIntent().getExtras().getString(AppConstant.ConfirmTYpe);
        goodsNum = getIntent().getExtras().getString(AppConstant.GoodsNum);
        if (AppConstant.oneMessage.equals(conFirmType)) {
            mPresenter.getCOnfirmOrderBeanRequest(goodsId, goodsNum);
        } else {
            mPresenter.getCreateOrderByWinner(goodsId);
        }

        mRxManager.on(AppConstant.TOCONFIRMORDER, new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                OrderListActivity.GotoOrderListActivity(ConfirmOrderActivity.this, 0, 0);
//                AppManager.getAppManager().returnToActivity();
//                startActivity(AccountActivity.class);
            }
        });
    }

   /* public static void gotoConfirmOrderActivity(BaseActivity mBaseActivity, String orderList) {

        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.orderList, orderList);
        mBaseActivity.startActivity(ConfirmOrderActivity.class, bundle);

    }*/

    /**
     * @param mBaseActivity
     * @param Good_id
     * @param count
     * @param type          购物车或者立即购买进入，或者 未完成订单界面进入 AppContent.onemessage 代表了 立即购买，其他代表了   购物车
     */
    public static void gotoConfirmOrderActivity(BaseActivity mBaseActivity, String Good_id, String count, String type) {

        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.GoodsId, Good_id);
        bundle.putString(AppConstant.GoodsNum, count);
        bundle.putString(AppConstant.ConfirmTYpe, type);
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

   /* @Override
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
    }*/
   private void updateTextColor(TextView tv, int starts, int end) {
       SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       spannedString.setSpan(new AbsoluteSizeSpan((int) mContext.getResources().getDimension(R.dimen.x20)), starts, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       spannedString.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.font_2)),starts,tv.getText().toString().indexOf("元")+1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
       tv.setText(spannedString);
   }
    @Override
    public void returnConfirmOrderBean(GoodsBuyNewBean confirmOrderBean) {
        if (!confirmOrderBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
       /* if (oneContentAdaoter.getDataList().size() != 0)
            oneContentAdaoter.clear();*/
        oneContentAdaoter.addAll(confirmOrderBean.getData().getGoods_list());
        tv_carriage.setText(confirmOrderBean.getData().getTotal_freight() + "");
       /* if (threeContentAdapter.getDataList().size() != 0)
            threeContentAdapter.clear();*/
        threeContentAdapter.addAll(confirmOrderBean.getData().getAddress_list());
        /*if (fiveContentAdapter.getDataList().size() != 0)
            fiveContentAdapter.clear();*/
        fiveContentAdapter.addAll(confirmOrderBean.getData().getPay_list());
        tvGoodsTotal.setText("商品总计：  ￥" + confirmOrderBean.getData().getTotal_amount() + "元");
        total_freight = confirmOrderBean.getData().getTotal_amount();
        updateTextColor(tvGoodsTotal,tvGoodsTotal.getText().toString().indexOf("￥"),tvGoodsTotal.getText().toString().indexOf("￥")+1);
    }

    @Override
    public void returnOrderIdData(OrderIdBean orderIdBean) {
        /*if (!orderIdBean.isIs_success()) {
            showShortToast(orderIdBean.getMessage());
            return;
        }
        if (("1").equals(fiveContentAdapter.getmList().get(0))) {
            WxPayTyoe(orderIdBean);
        } else {
            AliPayType(orderIdBean);
        }*/
    }

    /**
     * 提交订单页
     *
     * @param submitOrderBean
     */
    @Override
    public void returnOrderSubmit(SubmitOrderBean submitOrderBean) {
        if (!submitOrderBean.isIs_success()) {
            showShortToast(submitOrderBean.getMessage());
            return;
        }
        if (("1").equals(fiveContentAdapter.getmList().get(0))) {
            WxPayTyoe(submitOrderBean);
        } else {
            AliPayType(submitOrderBean);
        }
    }

    @Override
    public void returnCreateOrderByWinner(GoodsBuyNewBean confirmOrderBean) {
        if (!confirmOrderBean.isIs_success()) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
       /* if (oneContentAdaoter.getDataList().size() != 0)
            oneContentAdaoter.clear();*/
        oneContentAdaoter.addAll(confirmOrderBean.getData().getGoods_list());
        tv_carriage.setText(confirmOrderBean.getData().getTotal_freight() + "");
       /* if (threeContentAdapter.getDataList().size() != 0)
            threeContentAdapter.clear();*/
        threeContentAdapter.addAll(confirmOrderBean.getData().getAddress_list());
        /*if (fiveContentAdapter.getDataList().size() != 0)
            fiveContentAdapter.clear();*/
        fiveContentAdapter.addAll(confirmOrderBean.getData().getPay_list());
        tvGoodsTotal.setText("商品总计：  ￥" + confirmOrderBean.getData().getTotal_amount() + "元");
        total_freight = confirmOrderBean.getData().getTotal_amount();
        updateTextColor(tvGoodsTotal,tvGoodsTotal.getText().toString().indexOf("￥"),tvGoodsTotal.getText().toString().indexOf("￥")+1);
    }


    @OnClick({R.id.rel_back, R.id.rel_search, R.id.tv_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
            case R.id.tv_submit:
                if (threeContentAdapter.getmList().size() == 0) {

                    showShortToast("请选择默认地址信息");
                    return;
                }
                if (fiveContentAdapter.getmList().size() == 0) {
                    showShortToast("请选择支付方式");
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilderTwo = new StringBuilder();
                List<GoodsBuyNewBean.DataBean.GoodsListBean> dataList = oneContentAdaoter.getDataList();
                for (int i = 0; i < dataList.size(); i++) {
                    if (i != dataList.size() - 1) {

                        stringBuilder.append(dataList.get(i).getGoods_id() + ",");
                        stringBuilderTwo.append(dataList.get(i).getCount() + ",");
                    } else {
                        stringBuilder.append(dataList.get(i).getGoods_id());
                        stringBuilderTwo.append(dataList.get(i).getCount());
                    }
                }
//                mPresenter.getOrderIdBeanRequest(total_freight, ("1").equals(fiveContentAdapter.getmList().get(0)) ? "1" : "2", "我是支付");
                mPresenter.getSubmitOrderBean(stringBuilder.toString(), stringBuilderTwo.toString(), Integer.parseInt(threeContentAdapter.getmList().get(0)), Integer.parseInt(fiveContentAdapter.getmList().get(0)), "我是支付");
//                mPresenter.getOrderIdBeanRequest();
                break;

        }
    }

    @Override
    public void reloadLodTip() {
//

        if (AppConstant.oneMessage.equals(conFirmType)) {
            mPresenter.getCOnfirmOrderBeanRequest(goodsId, goodsNum);
        } else {
            mPresenter.getCreateOrderByWinner(goodsId);
        }
//        mPresenter.getCOnfirmOrderBeanRequest(goodsId, goodsNum);
    }

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private final IWXAPI msgApi = WXAPIFactory.createWXAPI(this, AppConstant.WxAPP_ID);
    /*
       * 支付宝的处理方式
       * */
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    LogUtils.logd("resultStatus------" + payResult.toString());
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
//                    LogUtils.logd("支付" + resultStatus + "------" + payResult.getResultStatus() + "-----------" + TextUtils.equals(resultInfo, "9000"));
                    // 判断resultStatus 为9000则代表支付成功
//                    if (TextUtils.equals(resultStatus.trim(), "9000")) {
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        //todo 进入到 个人订单界面
                        OrderListActivity.GotoOrderListActivity(ConfirmOrderActivity.this, 0, 0);
//                        mPresenter.getOrderBackGroundRequest(UserUtil.getLoginInfo().getGid(), mOrderId, actionType);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(mContext, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }


            }
        }
    };

    private void AliPayType(final SubmitOrderBean orderIdBean) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(ConfirmOrderActivity.this);
                String version = alipay.getVersion();
                LogUtils.logd("AliPayType" + version);
                Map<String, String> result = alipay.payV2(orderIdBean.getData().getAlipay_app_orderString(), true);
//                        LogUtils.logd("msp" + JsonUtils.toJson(mPayInfo.getData().getPara()) + "-----------" + alipay.getVersion() + "----------" + result.toString() + "alipay" + JsonUtils.toJson(mPayInfo.getData().getPara()));
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private void WxPayTyoe(SubmitOrderBean orderIdBean) {
        msgApi.registerApp(AppConstant.WxAPP_ID);
        PayReq request = new PayReq();
        String wechat_app_orderString = orderIdBean.getData().getWechat_app_orderString();
        WxPayBean wxPayBean = (WxPayBean) JsonUtils.fromJson(wechat_app_orderString, WxPayBean.class);
//        request.appId = mPayInfo.getData().getWxpay().
//        request.partnerId = mPayInfo.getData().getWxpay().get
        request.appId = wxPayBean.getResult().getAppid();
        request.partnerId = wxPayBean.getResult().getPartnerid();
        request.prepayId = wxPayBean.getResult().getPrepayid();
        request.nonceStr = wxPayBean.getResult().getNoncestr();
        request.timeStamp = String.valueOf(wxPayBean.getResult().getTimestamp());
        request.packageValue = wxPayBean.getResult().getPackageX();
        request.sign = wxPayBean.getResult().getSign();
        msgApi.sendReq(request);

    }

}
