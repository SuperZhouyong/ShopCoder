package com.intention.sqtwin.adapter;

import android.content.Context;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.PpAllDateBean;

/**
 * Description: 保佑无bugh
 * Data：2018/4/23-下午11:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionAdapter extends CommonRecycleViewAdapter<PpAllDateBean.DataBean.AuctionFieldListBean> {
//    private String[] mTitles = {"全部","拍卖中","预展中","已结拍"};

    public PpAuctionAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
    }

    @Override
    public void convert(ViewHolderHelper helper, PpAllDateBean.DataBean.AuctionFieldListBean auctionFieldListBean, int position) {
//        helper.setVisible(R.id.ll_sort, position == 0);
        helper.setText(R.id.tv_company_name, auctionFieldListBean.getOrganization().getName());
        helper.setImageRoundUrl(R.id.iv_logo, auctionFieldListBean.getOrganization().getImage());
        helper.setText(R.id.tv_fouce_num, String.valueOf(auctionFieldListBean.getFans_count()));
        helper.setText(R.id.tv_lot_num, String.valueOf(auctionFieldListBean.getItem_count()));
        helper.setText(R.id.tv_price_num, String.valueOf(auctionFieldListBean.getBid_count()));
        helper.setText(R.id.tv_filed_name, auctionFieldListBean.getName());
        helper.setImageUrl(R.id.iv_pos_goods, auctionFieldListBean.getImage());
        helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关注
            }
        });

    }
}
