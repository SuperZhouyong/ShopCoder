package com.intention.sqtwin.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.RecommendedLots;
import com.intention.sqtwin.ui.main.activity.AuctionItemActivity;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;

/**
 * Description: 保佑无bug
 * Data：2018/4/20-上午12:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class HeadTwoAdapter  extends CommonRecycleViewAdapter<AllDateBean.DataBean.RecommendItemBean>{
    private String TAG = "HeadTwoAdapter";

    public HeadTwoAdapter(Context context) {
        super(context, R.layout.item_homepage_headview_two_item);
    }

  /*  @Override
    public void convert(ViewHolderHelper helper, RecommendedLots.DataBean dataBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo,dataBean.getImage());
        helper.setText(R.id.tv_headtwo,dataBean.getName());
    }*/

    @Override
    public void convert(ViewHolderHelper helper, final AllDateBean.DataBean.RecommendItemBean recommendItemBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo,recommendItemBean.getImage());
        helper.setText(R.id.tv_headtwo,recommendItemBean.getName());
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AuctionItemActivity.class);
                intent.putExtra(AppConstant.auctionItemId,recommendItemBean.getId());
                LogUtils.logd(TAG+"-------"+recommendItemBean.getId());
                mContext.startActivity(intent);
            }
        });
    }
}
