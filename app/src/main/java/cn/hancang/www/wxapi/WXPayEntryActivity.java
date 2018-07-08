package cn.hancang.www.wxapi;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baserx.RxBus;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.SPUtils;


public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
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
    @BindView(R.id.iv_paydown)
    ImageView ivPaydown;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_ordernum)
    TextView tvOrdernum;
    @BindView(R.id.tv_deltype)
    TextView tvDeltype;
    @BindView(R.id.tv_time)
    TextView tvTime;
   /* @BindView(R.id.tool_title_left)
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
    ImageView iv_paydown;*/

    private IWXAPI api;
    //    private TextView pay;
//    private String[] split;
    String msg = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayoutId() {
        return R.layout.pay_result;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        api = WXAPIFactory.createWXAPI(this, AppConstant.WxAPP_ID);
        api.handleIntent(getIntent(), this);
        leftTitle.setText("返回");
        relSearch.setVisibility(View.GONE);
        String stringData = SPUtils.getSharedStringData(this, "towxpayentry");
//        LogUtils.logd("StringData--------" + stringData + "========" + "         " + (iv_paydown == null) + "----" + (pay == null));
        centerTitle.setText("微信支付");
        if (!TextUtils.isEmpty(stringData)) {
//            split = stringData.split("\\,");
            tvOrdernum.setText(stringData);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str = formatter.format(new Date(System.currentTimeMillis()));//获取当前时间
            tvTime.setText(str);
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
        LogUtils.logi("onPayFinish, errCode = " + resp.errCode + "-----" + Thread.currentThread().getName());
        if (resp.errCode == 0) {
//            LogUtils.logi("onPayFinish, errCode == 0 " + resp.errCode + "-----" + Thread.currentThread().getName());
            msg = "支付成功";
            tvPay.setText("支付成功");

//            ConstantsAPI.COMMAND_PAY_BY_WX
//            RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
            ivPaydown.setImageResource(R.mipmap.complete);
        } else if (resp.errCode == -1) {

//            LogUtils.logi("onPayFinish, errCode == -1  " + (iv_paydown == null) + "-----" + Thread.currentThread().getName());
            tvPay.setText("支付取消");
            ivPaydown.setImageResource(R.mipmap.payfail);

        } else if (resp.errCode == -2) {
            tvPay.setText("支付失败");
//            LogUtils.logi("onPayFinish, errCode == -2  " + resp.errCode + "-----" + Thread.currentThread().getName());
            ivPaydown.setImageResource(R.mipmap.payfail);


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void updata() {
        if (msg.equals("支付成功")) {
            RxBus.getInstance().post(AppConstant.TOCONFIRMORDER, true);
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
                finish();
//                updata();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mRxManager.post();
        updata();
//        mRxManager.add(RxBus.getInstance().unregister(AppConstant.TOCONFIRMORDER));
    }
}
