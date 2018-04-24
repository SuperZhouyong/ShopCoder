package com.intention.sqtwin.adapter;

import android.content.Context;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.RecommendedLots;

/**
 * Description: 保佑无bug
 * Data：2018/4/20-上午12:35
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class HeadTwoAdapter  extends CommonRecycleViewAdapter<AllDateBean.DataBean.RecommendItemBean>{


    public HeadTwoAdapter(Context context) {
        super(context, R.layout.item_homepage_headview_two_item);
    }

  /*  @Override
    public void convert(ViewHolderHelper helper, RecommendedLots.DataBean dataBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo,dataBean.getImage());
        helper.setText(R.id.tv_headtwo,dataBean.getName());
    }*/

    @Override
    public void convert(ViewHolderHelper helper, AllDateBean.DataBean.RecommendItemBean recommendItemBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo,recommendItemBean.getImage());
        helper.setText(R.id.tv_headtwo,recommendItemBean.getName());
    }
}
