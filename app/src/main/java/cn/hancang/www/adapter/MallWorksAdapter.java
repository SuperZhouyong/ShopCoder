package cn.hancang.www.adapter;

import android.content.Context;
import android.view.View;

import cn.hancang.www.R;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AllMallDateBean;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.main.activity.MainActivity;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-下午 14:22
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallWorksAdapter extends CommonRecycleViewAdapter<AllMallDateBean.DataBean.ItemBean> {
    private String TAG = "HeadTwoAdapter";

    public MallWorksAdapter(Context context) {
        super(context, R.layout.item_homepage_headview_two_item);
    }

  /*  @Override
    public void convert(ViewHolderHelper helper, RecommendedLots.DataBean dataBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo,dataBean.getImage());
        helper.setText(R.id.tv_headtwo,dataBean.getName());
    }*/

    @Override
    public void convert(ViewHolderHelper helper, final AllMallDateBean.DataBean.ItemBean recommendItemBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo, recommendItemBean.getImage());
        helper.setText(R.id.tv_headtwo, recommendItemBean.getName());
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(mContext, AuctionItemActivity.class);
                intent.putExtra(AppConstant.auctionItemId,recommendItemBean.getId());
                LogUtils.logd(TAG+"-------"+recommendItemBean.getId());
                mContext.startActivity(intent);*/
                AuctionItemActivity.gotoAuctionItemActivity((MainActivity) mContext, recommendItemBean.getId());
            }
        });
    }
}
