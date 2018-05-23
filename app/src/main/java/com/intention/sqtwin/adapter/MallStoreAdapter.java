package com.intention.sqtwin.adapter;

import android.content.Context;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.AllMallDateBean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/23 0023-下午 14:22
 * Blog：Super简单
 * Author: ZhouYong
 */

public class MallStoreAdapter extends CommonRecycleViewAdapter<AllMallDateBean.DataBean.StoreBean> {
    public MallStoreAdapter(Context context) {
        super(context, R.layout.item_homepage_headview_two_item);
    }

    @Override
    public void convert(ViewHolderHelper helper, AllMallDateBean.DataBean.StoreBean storeBean, int position) {
        helper.setImageUrl(R.id.iv_headtwo, storeBean.getStore_logo());
        helper.setText(R.id.tv_headtwo, storeBean.getStore_name());
    }
}
