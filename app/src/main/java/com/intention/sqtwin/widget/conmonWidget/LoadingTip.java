package com.intention.sqtwin.widget.conmonWidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;


/**
 * des:加载页面内嵌提示
 * Created by xsf
 * on 2016.07.17:22
 */
public class LoadingTip extends LinearLayout {

    private ImageView img_tip_logo;
    //    private ProgressBar progress;
    private TextView tv_tips;
    private TextView bt_operate;
    private String errorMsg;
    private onReloadListener onReloadListener;
    private LinearLayout llTip;
    private RelativeLayout relTip;
    private ImageView ivTipStatus;
    private TextView tvTipStatusDesc;
    private TextView tvTipConfirl;


    public LoadingTip(Context context) {
        super(context);
        initView(context);
    }

    public LoadingTip(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingTip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadingTip(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    public void setMarGinTop(int marGTop) {
        if (getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.setMargins(0, marGTop, 0, 0);
            setLayoutParams(layoutParams);
            invalidate();
        } else if (getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.setMargins(0, marGTop, 0, 0);
            setLayoutParams(layoutParams);
            invalidate();
        }


    }
 /*   //分为服务器失败，网络加载失败、数据为空、加载中、完成四种状态
    public static enum LoadStatus {
        sereverError, error, empty, loading, finish
    }*/

    // 扣费失败 ，没有收藏 ，无网络 ， 没有收藏记录 ， 购物车为空 ,搜素无结果

    public static enum NoloadStatus {
        NoCollect, NoNetWork, StartLoading, NoShopCart, NoReceivedAdress
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.dialog_loading_tip, this);
        img_tip_logo = (ImageView) findViewById(R.id.img_tip_logo);
        tv_tips = (TextView) findViewById(R.id.tv_tips);
        bt_operate = (TextView) findViewById(R.id.bt_operate);

        llTip = (LinearLayout) findViewById(R.id.ll_tip);
        relTip = (RelativeLayout) findViewById(R.id.rel_tip);
        ivTipStatus = (ImageView) findViewById(R.id.iv_tip_status);
        tvTipStatusDesc = (TextView) findViewById(R.id.tv_tip_status_desc);
        tvTipConfirl = (TextView) findViewById(R.id.tv_tip_confirm);


        //重新尝试
        bt_operate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onReloadListener != null) {
                    onReloadListener.reloadLodTip();
                }
            }
        });
        setVisibility(View.GONE);
    }

    public void setTips(String tips) {
        if (tv_tips != null) {
            tv_tips.setText(tips);
        }
    }

    public void setViewGone() {
        setVisibility(View.GONE);
    }

    public void setNoLoadTip(NoloadStatus noLoadTip) {
        switch (noLoadTip) {
            case NoCollect:
                setVisibility(View.VISIBLE);
                relTip.setVisibility(GONE);
                llTip.setVisibility(VISIBLE);
                img_tip_logo.setVisibility(VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.no_date);
                tv_tips.setText("暂无内容");
                bt_operate.setVisibility(View.GONE);
                break;

            case NoNetWork:
                setVisibility(View.VISIBLE);
                relTip.setVisibility(GONE);
                llTip.setVisibility(VISIBLE);
                img_tip_logo.setVisibility(VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.no_network);
                tv_tips.setText("网络不太给力，点击重新加载");
                bt_operate.setVisibility(View.VISIBLE);
                bt_operate.setText("刷新");
                break;
            // 没有收获地址
            case NoReceivedAdress:
                setVisibility(VISIBLE);
                llTip.setVisibility(GONE);
                relTip.setVisibility(VISIBLE);
                tvTipStatusDesc.setText("您还没有添加收获地址");
                tvTipConfirl.setText("+  新建地址");
                tvTipConfirl.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onReloadListener != null)
                            onReloadListener.reloadLodTip();
                    }
                });
                break;
            case NoShopCart:
                setVisibility(View.VISIBLE);
                relTip.setVisibility(GONE);
                llTip.setVisibility(VISIBLE);
                img_tip_logo.setVisibility(VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.shop_cart_empty);
                tv_tips.setText("暂无内容");
                bt_operate.setVisibility(View.GONE);
               /* tvTipConfirl.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onReloadListener != null)
                            onReloadListener.reloadLodTip();
                    }
                });*/
                break;

            case StartLoading:
                setVisibility(VISIBLE);
                llTip.setVisibility(VISIBLE);
                tv_tips.setText("加载中...");
                img_tip_logo.setVisibility(GONE);
                bt_operate.setVisibility(GONE);
                relTip.setVisibility(GONE);
                break;
        }
        if (getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
            LogUtils.logd("getLayoutParams" + " LinearLayout.LayoutParams");
            invalidate();
        } else if (getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            LogUtils.logd("getLayoutParams" + " RelativeLayout.LayoutParams");
            setLayoutParams(layoutParams);
            invalidate();
        }
    }


    public void setOnReloadListener(onReloadListener onReloadListener) {
        this.onReloadListener = onReloadListener;
    }

    /**
     * 重新尝试接口
     */
    public interface onReloadListener {
        void reloadLodTip();
    }


}

