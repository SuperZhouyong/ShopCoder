package com.intention.sqtwin.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.baserx.RxBus;
import com.intention.sqtwin.bean.FavBean;
import com.intention.sqtwin.bean.TaobaoStoreInfoBean;
import com.intention.sqtwin.ui.main.activity.AuctionOrgActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.ui.mall.activity.TaoBaoStoreInfoActivity;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/24-上午12:20
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class TaoBaoAdapter extends CommonRecycleViewAdapter<TaobaoStoreInfoBean.DataBean.AuctionFieldListBean> {
    private List<Integer> mList;

    public List<Integer> getmList() {
        return mList;
    }

    public void AddList(Integer FavId) {


        mList.add(FavId);
    }

    public TaoBaoAdapter(Context context) {
        super(context, R.layout.item_wholegoods);
        mList = new ArrayList<>();
    }

    @Override
    public void convert(ViewHolderHelper helper, final TaobaoStoreInfoBean.DataBean.AuctionFieldListBean recommendFieldBean, final int position) {
//        helper.setVisible(R.id.tv_filed_title, position == 0);
        if ("true".equals(recommendFieldBean.getIs_favorite()) || mList.contains(recommendFieldBean.getId())) {
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
                RxBus.getInstance().post(AppConstant.TaoBaoFiled, new FavBean(position, recommendFieldBean.getId()));

            }
        });

        helper.setText(R.id.tv_fouce_num, String.valueOf(recommendFieldBean.getFans_count()));
        helper.setText(R.id.tv_lot_num, String.valueOf(recommendFieldBean.getItem_count()));
        helper.setText(R.id.tv_price_num, String.valueOf(recommendFieldBean.getBid_count()));
        helper.setText(R.id.tv_filed_name, recommendFieldBean.getName());
        helper.setImageUrl(R.id.iv_pos_goods, recommendFieldBean.getImage());
        String start_time = recommendFieldBean.getStart_time();
        String end_time = recommendFieldBean.getEnd_time();

        // 显示拍卖时间
        showAuctionTime(helper, start_time, end_time);
//        helper.setText(R.id.tv_time_calculate)

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
                    AuctionOrgActivity.gotoAuctionOrg((TaoBaoStoreInfoActivity) mContext, recommendFieldBean.getOrganization_id());
                }
            });
            helper.setOnClickListener(R.id.iv_logo, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuctionOrgActivity.gotoAuctionOrg((TaoBaoStoreInfoActivity) mContext, recommendFieldBean.getOrganization_id());
                }
            });
        }
    }

    private void showAuctionTime(ViewHolderHelper helper, String start_time, String end_time) {
        try {
            Date startTime = PublicKetUtils.df.get().parse(start_time);
            Date endTime = PublicKetUtils.df.get().parse(end_time);
            Date currentTime = new Date();
            if (currentTime.getTime() < endTime.getTime() && currentTime.getTime() > startTime.getTime()) {
                // 拍卖中
                long OverMin = (endTime.getTime() - currentTime.getTime()) / (1000 * 60);
                helper.setText(R.id.tv_time_calculate, "距结束" + (OverMin / (60 * 24) == 0 ? "" : (OverMin / 60 / 24 + "天")) + ((OverMin % (60 * 24)) / 60 == 0 ? "" : ((OverMin % (60 * 24)) / 60 + "时")) + OverMin % 60 + "分");

            } else if (currentTime.getTime() < startTime.getTime()) {
//                未开拍
                helper.setText(R.id.tv_time_calculate, "距开拍" + start_time);

            } else {
                helper.setText(R.id.tv_time_calculate, "已结束" + end_time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
