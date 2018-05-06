package com.intention.sqtwin.adapter;

import android.content.Context;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.BidRecordBean;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/27-上午12:15
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BidRecordAdapter extends CommonRecycleViewAdapter<BidRecordBean.DataBean.PriceBean> {
    public BidRecordAdapter(Context context) {
        super(context, R.layout.item_bidrecord);
    }

    @Override
    public void convert(ViewHolderHelper helper, BidRecordBean.DataBean.PriceBean priceBean, int position) {
        helper.setImageUrl(R.id.iv_goods, priceBean.getAvatar());

        helper.setText(R.id.tv_name, priceBean.getNickname());
        helper.setText(R.id.tv_bid_desc, "出价");
        helper.setText(R.id.tv_bid_price, priceBean.getPrice() + ("0".equals(priceBean.getPrice()) ? "" : "(代理)"));
        helper.setText(R.id.tv_time, priceBean.getBid_time());
    }
}
