package com.intention.sqtwin.adapter;

import android.content.Context;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.baserx.RxBus;
import com.intention.sqtwin.bean.AllDateBean;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.bean.RecommendField;
import com.intention.sqtwin.ui.main.activity.AuctionOrgActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/4/19-下午10:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class HomeAdapter extends CommonRecycleViewAdapter<AllDateBean.DataBean.RecommendFieldBean> {

    private List<Integer> mList;

    public List<Integer> getmList() {
        return mList;
    }

    public void AddList(Integer FavId) {


        mList.add(FavId);
    }

    public HomeAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
        mList = new ArrayList<>();
    }


    @Override
    public void convert(ViewHolderHelper helper, final AllDateBean.DataBean.RecommendFieldBean recommendFieldBean, final int position) {
//        helper.setVisible(R.id.tv_filed_title, position == 0);
        if ("true".equals(recommendFieldBean.getIs_favorite()) || mList.contains(recommendFieldBean.getId())) {
            helper.setVisible(R.id.iv_focus, false);
            helper.setText(R.id.tv_focus, "已关注");
        } else {
            helper.setVisible(R.id.iv_focus, true);
            helper.setText(R.id.tv_focus, "关注");
            helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 点击关注
                    RxBus.getInstance().post(AppConstant.HomeFiled, new FavBean(position, recommendFieldBean.getId()));

                }
            });
        }

        helper.setText(R.id.tv_company_name, recommendFieldBean.getOrganization().getName());
        helper.setImageRoundUrl(R.id.iv_logo, recommendFieldBean.getOrganization().getImage());
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

        helper.setOnClickListener(R.id.tv_company_name, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuctionOrgActivity.gotoAuctionOrg((MainActivity) mContext, recommendFieldBean.getOrganization_id());
            }
        });
    }
}
