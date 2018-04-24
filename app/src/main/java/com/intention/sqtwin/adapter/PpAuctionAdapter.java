package com.intention.sqtwin.adapter;

import android.content.Context;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.PpAllDateBean;

import java.util.List;

/**
 * Description: 保佑无bugh
 * Data：2018/4/23-下午11:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class PpAuctionAdapter extends CommonRecycleViewAdapter<PpAllDateBean.DataBean.AuctionFieldListBean> {


    public PpAuctionAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
    }

    @Override
    public void convert(ViewHolderHelper helper, PpAllDateBean.DataBean.AuctionFieldListBean auctionFieldListBean, int position) {

    }
}
