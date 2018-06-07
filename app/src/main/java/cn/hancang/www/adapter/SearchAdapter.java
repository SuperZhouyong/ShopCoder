package cn.hancang.www.adapter;

import android.content.Context;
import android.view.View;

import cn.hancang.www.R;

import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.SearchInfoBean;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;

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
