package com.intention.sqtwin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.baserx.RxManager;
import com.intention.sqtwin.bean.StoreInfoComBean;
import com.intention.sqtwin.ui.Store.activity.StoreFocusActivity;
import com.intention.sqtwin.ui.main.activity.AuctionItemActivity;
import com.intention.sqtwin.ui.main.activity.AuctionOrgActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.ui.main.activity.SynchAuctionItemActivity;
import com.intention.sqtwin.utils.conmonUtil.PublicKetUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午4:13
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoComAdapter extends CommonRecycleViewAdapter {
    private Integer mTypeId;
    private RxManager rxManager;

    public interface CancelFocusInterfeac {
        void toCancelFocus(Integer favId, Integer postion, String FocusType);
    }

    private CancelFocusInterfeac cancelFocusInterfeac;

    public void setCancelFocusInterfeac(CancelFocusInterfeac cancelFocusInterfeac) {
        this.cancelFocusInterfeac = cancelFocusInterfeac;
    }

    public StoreInfoComAdapter(Context context, int layoutId, Integer mTypeId, RxManager rxManager) {
        super(context, layoutId);
        this.mTypeId = mTypeId;
        this.rxManager = rxManager;
    }

    @Override
    public void convert(ViewHolderHelper helper, Object o, int position) {
        // 拍品
        /*if (mTypeId == 0)

            //拍场
            if (mTypeId == 1)


                if (mTypeId == 2)

                    if (mTypeId == 3)

                        //店鋪，需要設置底部的价格为gone
                        if (mTypeId == 4)*/
        switch (mTypeId) {
            case 1:
                convertOne(helper, o, position);
                break;
            case 2:
                convertTwo(helper, o, position);
                break;
            case 3:
                convertThree(helper, o, position);
                break;
            case 4:
                convertFore(helper, o, position);
                break;
            case 5:
                convertFive(helper, o, position);
                break;
        }


    }

    private void convertFive(ViewHolderHelper helper, Object o, final int position) {
        final StoreInfoComBean.DataBean.FavoriteStoreBean mBean = (StoreInfoComBean.DataBean.FavoriteStoreBean) o;
        helper.setImageUrl(R.id.iv_goods_pic, mBean.getStore_logo());
        helper.setText(R.id.tv_goods_name, mBean.getStore_name());
        helper.setVisible(R.id.tv_time, true);
        helper.setOnClickListener(R.id.tv_time, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelFocusInterfeac != null)
                    cancelFocusInterfeac.toCancelFocus(mBean.getStore_id(), position, AppConstant.store);
            }
        });
    }

    private void convertFore(ViewHolderHelper helper, Object o, final int position) {
        final StoreInfoComBean.DataBean.FavoriteArtistBean mBean = (StoreInfoComBean.DataBean.FavoriteArtistBean) o;
        helper.setText(R.id.tv_name, mBean.getName());
        helper.setText(R.id.tv_bid_desc, "拍品数量");
        helper.setText(R.id.tv_bid_price, mBean.getAuction_count() + "");
        // 取消关注
        helper.getView(R.id.tv_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelFocusInterfeac != null)
                    cancelFocusInterfeac.toCancelFocus(mBean.getId(), position, AppConstant.artst);
            }
        });

    }

    private void convertThree(ViewHolderHelper helper, Object o, final int position) {
        final StoreInfoComBean.DataBean.FavoriteOrganBean mBean = (StoreInfoComBean.DataBean.FavoriteOrganBean) o;
        helper.setImageUrl(R.id.iv_icon, mBean.getLogo());
        helper.setText(R.id.tv_name, mBean.getName());
        helper.setText(R.id.tv_bid_desc, mBean.getDescription());
        helper.setVisible(R.id.tv_bid_price, false);
        //取消关注
        helper.getView(R.id.tv_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelFocusInterfeac != null)
                    cancelFocusInterfeac.toCancelFocus(mBean.getOrganization_id(), position, AppConstant.organ);
            }
        });

    }

    private void convertTwo(ViewHolderHelper helper, Object o, final int position) {
        final StoreInfoComBean.DataBean.FavoriteFieldBean recommendFieldBean = (StoreInfoComBean.DataBean.FavoriteFieldBean) o;

        helper.setText(R.id.tv_fouce_num, String.valueOf(recommendFieldBean.getFans_count()));
        helper.setText(R.id.tv_lot_num, String.valueOf(recommendFieldBean.getItem_count()));
        helper.setText(R.id.tv_price_num, String.valueOf(recommendFieldBean.getBid_count()));
        helper.setText(R.id.tv_filed_name, recommendFieldBean.getName());
        helper.setImageUrl(R.id.iv_pos_goods, recommendFieldBean.getImage());
        String start_time = recommendFieldBean.getStart_time();
        String end_time = recommendFieldBean.getEnd_time();

        // 显示拍卖时间
        showAuctionTime(helper, start_time, end_time);
        helper.setVisible(R.id.iv_focus, false);
        helper.setText(R.id.tv_focus, "取消");
        // 取消关注
        helper.setOnClickListener(R.id.rel_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelFocusInterfeac != null)
                    cancelFocusInterfeac.toCancelFocus(recommendFieldBean.getId(), position, AppConstant.field);
            }
        });
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
                    AuctionOrgActivity.gotoAuctionOrg((StoreFocusActivity) mContext, recommendFieldBean.getOrganization_id());
                }
            });
            helper.setOnClickListener(R.id.iv_logo, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuctionOrgActivity.gotoAuctionOrg((StoreFocusActivity) mContext, recommendFieldBean.getOrganization_id());
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

    private void convertOne(ViewHolderHelper helper, Object o, final int position) {
        final StoreInfoComBean.DataBean.FavoriteItemBean auctionItemListBean = (StoreInfoComBean.DataBean.FavoriteItemBean) o;
        helper.setImageUrl(R.id.iv_goods, auctionItemListBean.getImage());
        helper.setText(R.id.tv_goods_name, auctionItemListBean.getName());

        helper.setText(R.id.tv_goods_price_foot, auctionItemListBean.getBid_leader());
        helper.setText(R.id.tv_goods_desc_foot, "领先者");

        helper.setText(R.id.tv_goods_price, auctionItemListBean.getCurrent_price());
        helper.setText(R.id.tv_goods_desc, "当前价");

        helper.setVisible(R.id.tv_cancle_focus, true);
        helper.setOnClickListener(R.id.tv_cancle_focus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancelFocusInterfeac != null)
                    cancelFocusInterfeac.toCancelFocus(auctionItemListBean.getId(), position, AppConstant.goods);
            }
        });
     /*   helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (TextUtils.isEmpty(intoWay) || AppConstant.IntoWayOne.equals(intoWay))
                    AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) mContext, auctionItemListBean.getId());
                *//*else
                    SynchAuctionItemActivity.gotoSynchAuctionItem((BaseActivity) mContext, auctionItemListBean.getId());*//*
            }
        });*/
    }


}
