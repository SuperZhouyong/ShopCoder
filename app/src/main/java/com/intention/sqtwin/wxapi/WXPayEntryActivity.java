/*
package com.intention.sqtwin.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baseapp.AppManager;
import com.intention.sqtwin.baserx.RxBus;
//import com.intention.sqtwin.ui.shoppingmall.ConfirmAnOrderActivity;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;
import com.intention.sqtwin.utils.conmonUtil.ToastUitl;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
    @BindView(R.id.tool_title_left)
    TextView toolTitleLeft;
    @BindView(R.id.tool_title_right)
    TextView toolTitleRight;
    @BindView(R.id.tv_ordernum)
    TextView orderNum;
    @BindView(R.id.tv_deltype)
    TextView deltype;
    @BindView(R.id.tv_time)
    TextView time;
    @BindView(R.id.tv_pay)
    TextView pay;
    @BindView(R.id.iv_paydown)
    ImageView iv_paydown;

    private IWXAPI api;
    //    private TextView pay;
//    private String[] split;
    String msg = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);
        ButterKnife.bind(this);
     */
/*   iv_paydown = (ImageView) findViewById(R.id.iv_paydown);
        pay = (TextView) findViewById(R.id.tv_pay);*//*

        api = WXAPIFactory.createWXAPI(this, AppConstant.WxAPP_ID);
        api.handleIntent(getIntent(), this);
        toolTitleLeft.setText("返回");
        toolTitleRight.setVisibility(View.GONE);
        String stringData = SPUtils.getSharedStringData(this, "towxpayentry");
        LogUtils.logd("StringData--------" + stringData + "========" + "         " + (iv_paydown == null) + "----" + (pay == null));
        deltype.setText("微信支付");
        if (!TextUtils.isEmpty(stringData)) {
//            split = stringData.split("\\,");
            orderNum.setText(stringData);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str = formatter.format(new Date(System.currentTimeMillis()));//获取当前时间
            time.setText(str);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
//        LogUtils.logi("onPayFinish, errCode = " + resp.errCode + "-----" + Thread.currentThread().getName());
        if (resp.errCode == 0) {
//            LogUtils.logi("onPayFinish, errCode == 0 " + resp.errCode + "-----" + Thread.currentThread().getName());
            msg = "支付成功";
            pay.setText("支付成功");
            RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
            iv_paydown.setImageResource(R.mipmap.complete);
        } else if (resp.errCode == -1) {

//            LogUtils.logi("onPayFinish, errCode == -1  " + (iv_paydown == null) + "-----" + Thread.currentThread().getName());
            pay.setText("支付取消");
            iv_paydown.setImageResource(R.mipmap.payfail);

        } else if (resp.errCode == -2) {
            pay.setText("支付失败");
//            LogUtils.logi("onPayFinish, errCode == -2  " + resp.errCode + "-----" + Thread.currentThread().getName());
            iv_paydown.setImageResource(R.mipmap.payfail);


        }

    }

    @Override
    public void onBackPressed() {
        updata();
    }

    private void updata() {
        if (msg.equals("支付成功")) {
//            switch (split[0]) {
//                case AppConstant.FROMRECRE:// 推荐
//            RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
//                    break;
//                case AppConstant.FROMSCHRE:// 学校
//                    RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
//                    break;
//                case AppConstant.FROMPUBRE:// 公共
//                    RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
//                    break;
//                case AppConstant.FROMPRORE:// 职业
//                    RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
//                    break;
//            }
        }
        finish();

    }

    @OnClick(R.id.rel_back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                updata();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister(AppConstant.TOCONFIRMORDER);
    }
}*/
