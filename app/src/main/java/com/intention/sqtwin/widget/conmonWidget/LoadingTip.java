package com.intention.sqtwin.widget.conmonWidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
    private Button bt_operate;
    private String errorMsg;
    private onReloadListener onReloadListener;


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
        FeeFailed, NoCollect, NoNetWork, NoRecorrd, NoShopCart, NoResult, NoLogin
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.dialog_loading_tip, this);
        img_tip_logo = (ImageView) findViewById(R.id.img_tip_logo);
        tv_tips = (TextView) findViewById(R.id.tv_tips);
        bt_operate = (Button) findViewById(R.id.bt_operate);
        //重新尝试
        bt_operate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onReloadListener != null) {
                    onReloadListener.reload();
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
//              FeeFailed , NoCollect ,NoEmpty ,NoRecorrd ,NoShopCart ,Noresulte
            case FeeFailed:
                setVisibility(View.VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.fee_failed);

                tv_tips.setText("扣费失败,请重试");
                bt_operate.setVisibility(View.VISIBLE);
                bt_operate.setText("重试");
                break;
            case NoCollect:
                setVisibility(View.VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.no_collect);
                tv_tips.setText("暂无任何收藏内容");
                bt_operate.setVisibility(View.GONE);
                break;
            case NoNetWork:
                setVisibility(View.VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.no_network);
                tv_tips.setText("数据加载失败");
                bt_operate.setVisibility(View.VISIBLE);
                bt_operate.setText("请重试");
                break;
            case NoRecorrd:
                setVisibility(View.VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.no_record);
                tv_tips.setText("暂无任何记录");
                bt_operate.setVisibility(View.GONE);
                break;
            case NoShopCart:
                setVisibility(View.VISIBLE);

                img_tip_logo.setImageResource(R.mipmap.no_shopcart);
                tv_tips.setText("你的购物车还是空的,赶紧行动吧");
                bt_operate.setVisibility(View.VISIBLE);
                bt_operate.setText("去商场");
                break;
            case NoResult:
                setVisibility(View.VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.fee_failed);
                tv_tips.setText("暂无结果");
                bt_operate.setVisibility(View.GONE);
                break;
            case NoLogin:
                setVisibility(View.VISIBLE);
                img_tip_logo.setImageResource(R.mipmap.fee_failed);
                tv_tips.setText("请先登录");
                bt_operate.setText("登录");
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
        void reload();
    }


}
