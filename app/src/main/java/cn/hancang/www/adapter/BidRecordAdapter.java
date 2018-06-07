package cn.hancang.www.adapter;

import android.content.Context;

import cn.hancang.www.R;

import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.BidRecordBean;

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
        helper.setImageRoundUrl(R.id.iv_icon, priceBean.getAvatar());

        helper.setText(R.id.tv_name, priceBean.getNickname());
        helper.setText(R.id.tv_bid_desc, "出价");
        helper.setText(R.id.tv_bid_price, priceBean.getPrice() + ("0".equals(priceBean.getPrice()) ? "" : "(代理)"));
        helper.setText(R.id.tv_time, priceBean.getBid_time());
    }
}
