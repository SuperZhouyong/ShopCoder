package cn.hancang.www.ui.myinfo.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.OrderIdBean;
import cn.hancang.www.bean.OrderIdDetailBean;
import cn.hancang.www.bean.TellBackBean;
import cn.hancang.www.ui.myinfo.contract.SelectChargeContract;
import cn.hancang.www.ui.myinfo.model.SelectChargeModel;
import cn.hancang.www.ui.myinfo.presenter.SelectChargePresenter;
import cn.hancang.www.utils.PayResult;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;
import cn.hancang.www.utils.conmonUtil.LogUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/6/1-上午1:00
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SelectChargeActivity extends BaseActivity<SelectChargePresenter, SelectChargeModel> implements SelectChargeContract.View {
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
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.iv_wx_pay)
    ImageView ivWxPay;
    @BindView(R.id.rel_wx_pay)
    RelativeLayout relWxPay;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.rel_ali_pay)
    RelativeLayout relAliPay;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.cb_check)
    CheckBox cbCheck;
    @BindView(R.id.tv_agreement)
    TextView tvAgreement;
    @BindView(R.id.sCheckbox_wx)
    SmoothCheckBox smoothCheckBoxWx;
    @BindView(R.id.sCheckbox_ali)
    SmoothCheckBox smoothCheckBoxAli;
    private Float moneyNum;
    private String AliAppId = "2018060160317416";
    private static final int SDK_PAY_FLAG = 1;
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
//                        mPresenter.getOrderBackGroundRequest(UserUtil.getLoginInfo().getGid(), mOrderId, actionType);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(mContext, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    };

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


    private void AliPayType(final OrderIdDetailBean orderIdBean) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(SelectChargeActivity.this);
                String version = alipay.getVersion();
                LogUtils.logd("AliPayType" + version);
                Map<String, String> result = alipay.payV2("", true);
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

    private void WxPayTyoe(OrderIdDetailBean orderIdBean) {
    }

    /**
     * 获取订单id
     *
     * @param orderIdBean
     */
    @Override
    public void returnOrderIdData(OrderIdBean orderIdBean) {
        if (!orderIdBean.isIs_success()) {
            showShortToast(orderIdBean.getMessage());
            return;
        }
        mPresenter.getOrderIdDetailRequest(orderIdBean.getData().getPay_sn(), "10");
    }

    /**
     * 告诉服务器信息，支付成功
     *
     * @param tellBackBean
     */
    @Override
    public void tellBackOrderId(TellBackBean tellBackBean) {

    }

    /**
     * 根据订单id获取详细信息
     *
     * @param orderIdDetailBean
     */
    @Override
    public void returnOderIdDetail(OrderIdDetailBean orderIdDetailBean) {
        if (smoothCheckBoxWx.isChecked()) {
            WxPayTyoe(orderIdDetailBean);
        } else {
            AliPayType(orderIdDetailBean);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_selectcharge;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        moneyNum = getIntent().getExtras().getFloat(AppConstant.Moneynum, -1);
        tvMoney.setText("￥" + moneyNum);
        relSearch.setVisibility(View.GONE);
    }

    public static void gotoSelectChargeActivity(Context context, Float moneyNum) {
        Bundle bundle = new Bundle();
        bundle.putFloat(AppConstant.Moneynum, moneyNum);
        ((BaseActivity) context).startActivity(SelectChargeActivity.class, bundle);
    }


    @OnClick({R.id.rel_back, R.id.tv_confirm, R.id.tv_agreement, R.id.sCheckbox_ali, R.id.sCheckbox_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                if (!smoothCheckBoxWx.isChecked() && !smoothCheckBoxAli.isChecked()) {
                    showShortToast("请选择支付方式");
                    return;
                }
                mPresenter.getOrderIdBeanRequest(moneyNum, smoothCheckBoxWx.isChecked() ? "1" : "2", "我是支付");
                break;
            case R.id.tv_agreement:
                break;
            // 支付宝
            case R.id.sCheckbox_ali:
                smoothCheckBoxAli.setChecked(true, true);
                smoothCheckBoxWx.setChecked(false);
                break;
            // 微信
            case R.id.sCheckbox_wx:
                smoothCheckBoxWx.setChecked(true, true);
                smoothCheckBoxAli.setChecked(false);
                break;
        }
    }
}
