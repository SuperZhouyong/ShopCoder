package com.intention.sqtwin.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.DerivativesBean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:59
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesTwoAdapter extends CommonRecycleViewAdapter<DerivativesBean.DataBean.GoodsListBean> {
    public DerivativesTwoAdapter(Context context) {
        super(context, R.layout.item_artdetail);
    }

    @Override
    public void convert(ViewHolderHelper helper, DerivativesBean.DataBean.GoodsListBean goodsListBean, int position) {
        helper.setImageUrl(R.id.iv_goods_pic, goodsListBean.getGoods_image());
        helper.setText(R.id.tv_goods_name, goodsListBean.getGoods_name());
//                helper.setText(R.id.tv_price,itemListBean.getCurrent_price());
        helper.setText(R.id.tv_price, "￥ " + goodsListBean.getGoods_price());
        updateTextColor((TextView) helper.getView(R.id.tv_price), 0, 1);
    }

    private void updateTextColor(TextView tv, int starts, int end) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new AbsoluteSizeSpan((int) mContext.getResources().getDimension(R.dimen.x20)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }
}
