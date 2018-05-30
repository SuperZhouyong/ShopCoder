package com.intention.sqtwin.adapter;

import android.content.Context;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.baserx.RxBus;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.bean.PpAllDateBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 保佑无bugh
 * Data：2018/4/23-下午11:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionAdapter extends CommonRecycleViewAdapter<PpAllDateBean.DataBean.AuctionFieldListBean> {
    //    private String[] mTitles = {"全部","拍卖中","预展中","已结拍"};
    private List<Integer> mList;

    public List<Integer> getmList() {
        return mList;
    }

    public void AddList(Integer FavId) {


        mList.add(FavId);
    }

    public PpAuctionAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
        mList = new ArrayList<>();
    }

    @Override
    public void convert(ViewHolderHelper helper, final PpAllDateBean.DataBean.AuctionFieldListBean auctionFieldListBean, final int position) {
//        helper.setVisible(R.id.ll_sort, position == 0);
        if ("true".equals(auctionFieldListBean.getIs_favorite()) || mList.contains(auctionFieldListBean.getId())) {
            helper.setVisible(R.id.iv_focus, false);
            helper.setText(R.id.tv_focus, "已关注");
        } else {
            helper.setVisible(R.id.iv_focus, true);
            helper.setText(R.id.tv_focus, "关注");

        }
        helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关注
                RxBus.getInstance().post(AppConstant.PpAuction, new FavBean(position, auctionFieldListBean.getId()));

            }
        });
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
