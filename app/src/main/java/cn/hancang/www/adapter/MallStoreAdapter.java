package cn.hancang.www.adapter;

import android.content.Context;
import android.view.View;

import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.AllMallDateBean;
import cn.hancang.www.ui.mall.activity.TaoBaoStoreInfoActivity;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-下午 14:22
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallStoreAdapter extends CommonRecycleViewAdapter<AllMallDateBean.DataBean.StoreBean> {
    public MallStoreAdapter(Context context) {
//        item_homepage_headview_two_item
        super(context, R.layout.item_mall_store);
    }

    @Override
    public void convert(ViewHolderHelper helper, final AllMallDateBean.DataBean.StoreBean storeBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo, storeBean.getStore_logo());
        helper.setText(R.id.tv_headtwo, storeBean.getStore_name());

        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaoBaoStoreInfoActivity.GotoTaoBaoSTireInfoActivity((BaseActivity) mContext, storeBean.getStore_id());
            }
        });
    }
}
