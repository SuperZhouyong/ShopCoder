package cn.hancang.www.adapter;

import android.content.Context;
import android.view.View;

import cn.hancang.www.R;

import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.FavBean;
import cn.hancang.www.bean.PpAllDateBean;
import cn.hancang.www.ui.main.activity.AuctionOrgActivity;
import cn.hancang.www.ui.main.activity.MainActivity;
import cn.hancang.www.utils.conmonUtil.PublicKetUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

    public interface AddFocusInterface {
        void addFocus(FavBean favBean);
    }

    private AddFocusInterface addFocusInterface;

    public void setAddFocusInterface(AddFocusInterface addFocusInterface) {
        this.addFocusInterface = addFocusInterface;
    }

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

        // 如果机构不存在
        if (auctionFieldListBean.getOrganization() == null) {
            helper.setVisible(R.id.tv_company_name, false);
            helper.setVisible(R.id.iv_logo, false);
        } else {
            helper.setVisible(R.id.tv_company_name, true);
            helper.setVisible(R.id.iv_logo, true);
            helper.setText(R.id.tv_company_name, auctionFieldListBean.getOrganization().getName());
            helper.setImageRoundUrl(R.id.iv_logo, auctionFieldListBean.getOrganization().getImage());
            helper.setOnClickListener(R.id.tv_company_name, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuctionOrgActivity.gotoAuctionOrg((MainActivity) mContext, auctionFieldListBean.getOrganization_id());
                }
            });
            helper.setOnClickListener(R.id.iv_logo, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuctionOrgActivity.gotoAuctionOrg((MainActivity) mContext, auctionFieldListBean.getOrganization_id());
                }
            });
        }

        helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关注
//                RxBus.getInstance().post(AppConstant.PpAuction, new FavBean(position, auctionFieldListBean.getId()));
                if (addFocusInterface != null)
                    addFocusInterface.addFocus(new FavBean(position, auctionFieldListBean.getId()));
            }
        });
        String start_time = auctionFieldListBean.getStart_time();
        String end_time = auctionFieldListBean.getEnd_time();
        // 显示拍卖时间
        showAuctionTime(helper, start_time, end_time);
        helper.setText(R.id.tv_fouce_num, String.valueOf(auctionFieldListBean.getFans_count()));
        helper.setText(R.id.tv_lot_num, String.valueOf(auctionFieldListBean.getItem_count()));
        helper.setText(R.id.tv_price_num, String.valueOf(auctionFieldListBean.getBid_count()));
        helper.setText(R.id.tv_filed_name, auctionFieldListBean.getName());
        helper.setImageUrl(R.id.iv_pos_goods, auctionFieldListBean.getImage());


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
