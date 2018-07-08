package cn.hancang.www.ui.mall.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import cn.hancang.www.bean.ToBenPaidBean;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Date;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.OrderListBean;
import cn.hancang.www.bean.WxPayBean;
import cn.hancang.www.ui.mall.contract.ToBePaidAContract;
import cn.hancang.www.ui.mall.model.ToBePaidAModel;
import cn.hancang.www.ui.mall.presenter.ToBePaidAPresenter;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.utils.conmonUtil.JsonUtils;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.PublicKetUtils;
import cn.hancang.www.utils.payUtils.PayResult;
import rx.functions.Action1;

/**
 * Description: 待支付界面
 * Data：2018/7/1-下午5:01
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ToBePaidActivity extends BaseActivity<ToBePaidAPresenter, ToBePaidAModel> implements ToBePaidAContract.View {
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
    @BindView(R.id.iv_goods_pic)
    ImageView ivGoodsPic;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_goods_time)
    TextView tvGoodsTime;
    @BindView(R.id.tv_goods_num)
    TextView tvGoodsNum;
    @BindView(R.id.tv_goods_price)
    TextView tvGoodsPrice;
    @BindView(R.id.iv_wx_pay)
    ImageView ivWxPay;
    @BindView(R.id.sCheckbox_wx)
    SmoothCheckBox sCheckboxWx;
    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.rel_wx_pay)
    RelativeLayout relWxPay;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.sCheckbox_ali)
    SmoothCheckBox sCheckboxAli;
    @BindView(R.id.rel_ali_pay)
    RelativeLayout relAliPay;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    private OrderListBean.DataBean dataBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tobepaid;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    /* helper.setImageUrl(R.id.iv_goods_pic, orderListBean.getGoods_image());
            helper.setText(R.id.tv_goods_name, orderListBean.getGoods_name());
            Date date = new Date();
            date.setTime(orderListBean.getAdd_time());
            helper.setText(R.id.tv_goods_time, PublicKetUtils.df.get().format(date));
            helper.setText(R.id.tv_goods_price, "￥" + orderListBean.getOrder_amount());
            helper.setText(R.id.tv_goods_num, "x" + orderListBean.getCount());*/
    @Override
    public void initView() {
        relSearch.setVisibility(View.INVISIBLE);
        centerTitle.setText("支付方式");
        dataBean = getIntent().getExtras().getParcelable(AppConstant.DataBean);

        ImageLoaderUtils.display(this, ivGoodsPic, dataBean.getGoods_image());
        tvGoodsName.setText(dataBean.getGoods_name());
        Date date = new Date();
        date.setTime(dataBean.getAdd_time());
        tvGoodsTime.setText(PublicKetUtils.df.get().format(date));
        tvGoodsPrice.setText("￥" + dataBean.getOrder_amount());
        tvGoodsNum.setText("x" + dataBean.getCount());


        mRxManager.on(AppConstant.TOCONFIRMORDER, new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
//                AppManager.getAppManager().returnToActivity();
                finish();
            }
        });
    }


    @OnClick({R.id.rel_back, R.id.tv_confirm, R.id.sCheckbox_ali, R.id.sCheckbox_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                if (!sCheckboxAli.isChecked() && !sCheckboxWx.isChecked()) {
                    showShortToast("请选择支付方式");
                    return;
                }
//                mPresenter.getOrderIdBeanRequest(moneyNum, smoothCheckBoxWx.isChecked() ? "1" : "2", "我是支付");
                mPresenter.getToBePaidRequest(dataBean.getOrder_id(), sCheckboxWx.isChecked() ? 1 : 2);
                break;
            case R.id.sCheckbox_ali:
                sCheckboxAli.setChecked(true, true);
                sCheckboxWx.setChecked(false);
                break;
            // 微信
            case R.id.sCheckbox_wx:
                sCheckboxWx.setChecked(true, true);
                sCheckboxAli.setChecked(false);
                break;
        }
    }

    public static void gotoToBePaidActivity(BaseActivity mContext, OrderListBean.DataBean orderListBean) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstant.DataBean, orderListBean);
        mContext.startActivity(ToBePaidActivity.class, bundle);
    }

    @Override
    public void StartLoading(String RequestId) {

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
    public void returnToBePaidBean(ToBenPaidBean submitOrderBean) {
        if (!submitOrderBean.isIs_success()) {
            showShortToast(submitOrderBean.getMessage());
            return;
        }
        if (sCheckboxWx.isChecked()) {
            WxPayTyoe(submitOrderBean);
        } else {
            AliPayType(submitOrderBean);
        }
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
                        finish();
                        //todo 进入到 个人订单界面
//                        OrderListActivity.GotoOrderListActivity(ConfirmOrderActivity.this, 0, 0);
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
    private void AliPayType(final ToBenPaidBean orderIdBean) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(ToBePaidActivity.this);
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

    private void WxPayTyoe(ToBenPaidBean orderIdBean) {
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
