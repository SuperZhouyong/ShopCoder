package com.intention.sqtwin.adapter;

import android.content.Context;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.DerivativesBean;

import java.util.List;

/**
 * Description: 绝无Bug
 * Data：2018/5/11 0011-下午 16:47
 * Blog：Super简单
 * Author: ZhouYong
 */

public class DerivativesOneAdapter extends CommonRecycleViewAdapter<DerivativesBean.DataBean.ArticleBean> {
    public DerivativesOneAdapter(Context context) {
        super(context, R.layout.item_goods_home_one);
    }

    @Override
    public void convert(ViewHolderHelper helper, DerivativesBean.DataBean.ArticleBean articleBean, int position) {
        helper.setVisible(R.id.rel_time_d, false);
        helper.setImageUrl(R.id.iv_pos_goods, articleBean.getArticle_image());
        helper.setText(R.id.tv_filed_name, articleBean.getArticle_title());
    }
}
