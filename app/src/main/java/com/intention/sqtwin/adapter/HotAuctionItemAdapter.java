package com.intention.sqtwin.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.TaobaoStoreInfoBean;
import com.intention.sqtwin.ui.main.activity.AuctionItemActivity;

import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/24-上午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class HotAuctionItemAdapter extends CommonRecycleViewAdapter<TaobaoStoreInfoBean.DataBean.ItemListBean> {
    public HotAuctionItemAdapter(Context context) {
        super(context, R.layout.item_artdetail);
    }

    @Override
    public void convert(ViewHolderHelper helper, final TaobaoStoreInfoBean.DataBean.ItemListBean goodsListBean, int position) {
        helper.setImageUrl(R.id.iv_goods_pic, goodsListBean.getImage());
        helper.setText(R.id.tv_goods_name, goodsListBean.getName());
//                helper.setText(R.id.tv_price,itemListBean.getCurrent_price());
        helper.setText(R.id.tv_price, "￥ " + goodsListBean.getCurrent_price());
        updateTextColor((TextView) helper.getView(R.id.tv_price), 0, 1);

        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, goodsListBean.getId());
            }
        });
    }

    private void updateTextColor(TextView tv, int starts, int end) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan((int) mContext.getResources().getDimension(R.dimen.x20)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }
}
