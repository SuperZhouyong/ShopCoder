package com.intention.sqtwin.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.SearchInfoBean;
import com.intention.sqtwin.ui.main.activity.AuctionItemActivity;
import com.intention.sqtwin.ui.main.activity.SynchAuctionItemActivity;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/6/1 0001-下午 17:23
 * Blog：Super简单
 * Author: ZhouYong
 */

public class SearchAdapter extends CommonRecycleViewAdapter<SearchInfoBean.DataBean.ItemListBean> {


    public SearchAdapter(Context context) {
        super(context, R.layout.item_auction_file_item);
    }

    @Override
    public void convert(ViewHolderHelper helper, final SearchInfoBean.DataBean.ItemListBean auctionItemListBean, int position) {
        helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
        helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());

        helper.setText(R.id.tv_goods_price_foot, auctionItemListBean.getBid_leader());
        helper.setText(R.id.tv_goods_desc_foot, "领先者");

        helper.setText(R.id.tv_goods_price, auctionItemListBean.getCurrent_price());
        helper.setText(R.id.tv_goods_desc, "当前价");

        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, auctionItemListBean.getId());
               /* if (TextUtils.isEmpty(intoWay) || AppConstant.IntoWayOne.equals(intoWay))
                    AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, auctionItemListBean.getId());
                else
                    SynchAuctionItemActivity.gotoSynchAuctionItem((BaseActivity) mContext, auctionItemListBean.getId());*/
            }
        });
    }
}
