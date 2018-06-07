package cn.hancang.www.adapter;

import android.content.Context;

import cn.hancang.www.R;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.DerivativesBean;

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
