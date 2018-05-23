package com.intention.sqtwin.adapter;

import android.content.Context;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AllMallDateBean;
import com.intention.sqtwin.ui.main.activity.AuctionOrgActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Description: 保佑无bug
 * Data：2018/4/19-下午10:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MallAdapter extends CommonRecycleViewAdapter<AllMallDateBean.DataBean.FieldBean> {


    public MallAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
    }


    @Override
    public void convert(ViewHolderHelper helper, final AllMallDateBean.DataBean.FieldBean recommendFieldBean, int position) {

        if (recommendFieldBean.getOrganization() == null) {
            helper.setVisible(R.id.tv_company_name, false);
            helper.setVisible(R.id.iv_logo, false);
        } else {
            helper.setVisible(R.id.tv_company_name, true);
            helper.setVisible(R.id.iv_logo, true);
            helper.setText(R.id.tv_company_name, recommendFieldBean.getOrganization().getName());
            helper.setImageRoundUrl(R.id.iv_logo, recommendFieldBean.getOrganization().getImage());
            helper.setOnClickListener(R.id.tv_company_name, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuctionOrgActivity.gotoAuctionOrg((MainActivity) mContext, recommendFieldBean.getOrganization_id());
                }
            });
        }

        helper.setText(R.id.tv_fouce_num, String.valueOf(recommendFieldBean.getFans_count()));
        helper.setText(R.id.tv_lot_num, String.valueOf(recommendFieldBean.getItem_count()));
        helper.setText(R.id.tv_price_num, String.valueOf(recommendFieldBean.getBid_count()));
        helper.setText(R.id.tv_filed_name, recommendFieldBean.getName());
        helper.setImageUrl(R.id.iv_pos_goods, recommendFieldBean.getImage());
        String start_time = recommendFieldBean.getStart_time();
        String end_time = recommendFieldBean.getEnd_time();

        try {
            Date startTime = PublicKetUtils.df.get().parse(start_time);
            Date endTime = PublicKetUtils.df.get().parse(end_time);
            Date currentTime = new Date();
            if (currentTime.getTime() < endTime.getTime() && currentTime.getTime() > startTime.getTime()) {
                // 拍卖中
                long OverMin = (endTime.getTime() - currentTime.getTime()) / (1000 * 60);
                helper.setText(R.id.tv_time_calculate, OverMin / 60 + "时" + OverMin % 60 + "分");

            } else if (currentTime.getTime() < startTime.getTime()) {
//                未开拍
                helper.setText(R.id.tv_time_calculate, "距开拍" + start_time);

            } else {
                helper.setText(R.id.tv_time_calculate, "已结束" + end_time);
            }
//            if (new Date().getTime()<endTime.getTime()&&)
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        helper.setText(R.id.tv_time_calculate)
        helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关注
            }
        });

    }
}
