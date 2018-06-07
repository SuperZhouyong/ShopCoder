package cn.hancang.www.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.DerivativesBean;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;

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
    public void convert(ViewHolderHelper helper, final DerivativesBean.DataBean.GoodsListBean goodsListBean, int position) {
        helper.setImageUrl(R.id.iv_goods_pic, goodsListBean.getGoods_image());
        helper.setText(R.id.tv_goods_name, goodsListBean.getGoods_name());
//                helper.setText(R.id.tv_price,itemListBean.getCurrent_price());
        helper.setText(R.id.tv_price, "￥ " + goodsListBean.getGoods_price());
        updateTextColor((TextView) helper.getView(R.id.tv_price), 0, 1);

        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 拍品页
                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext,goodsListBean.getGoods_id());
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
