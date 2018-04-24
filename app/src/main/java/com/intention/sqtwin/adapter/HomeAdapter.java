package com.intention.sqtwin.adapter;

import android.content.Context;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.RecommendField;

/**
 * Description: 保佑无bug
 * Data：2018/4/19-下午10:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class HomeAdapter extends CommonRecycleViewAdapter<AllDateBean.DataBean.RecommendFieldBean> {


    public HomeAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
    }


    @Override
    public void convert(ViewHolderHelper helper, AllDateBean.DataBean.RecommendFieldBean recommendFieldBean, int position) {
        helper.setVisible(R.id.tv_filed_title, position == 0);
        helper.setText(R.id.tv_company_name, recommendFieldBean.getOrganzation().getName());
        helper.setImageRoundUrl(R.id.iv_logo, recommendFieldBean.getOrganzation().getLogo());
        helper.setText(R.id.tv_fouce_num, recommendFieldBean.getFans_count());
        helper.setText(R.id.tv_lot_num, recommendFieldBean.getItem_count());
        helper.setText(R.id.tv_price_num, recommendFieldBean.getBid_count());
        helper.setText(R.id.tv_filed_name, recommendFieldBean.getName());
        helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关注
            }
        });
    }
}
