package cn.hancang.www.adapter;

import android.content.Context;

import java.util.List;

import cn.hancang.www.R;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.bean.MyCompeteBean;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OneContentAdaoter extends CommonRecycleViewAdapter<GoodsBuyNewBean.DataBean.GoodsListBean> {
    public OneContentAdaoter(Context context) {
        super(context, R.layout.item_confirmorder_one);
    }

    //tv_goods_name
    //tv_goods_desc
    //tv_goods_price
    //tv_goods_desc_foot
    //tv_goods_price_foot


    @Override
    public void convert(ViewHolderHelper helper, GoodsBuyNewBean.DataBean.GoodsListBean goodsListBean, int position) {
        helper.setImageUrl(R.id.iv_goods, goodsListBean.getGoods_image());
        helper.setText(R.id.tv_goods_name, goodsListBean.getGoods_name());
        helper.setText(R.id.tv_goods_price, goodsListBean.getGoods_price());
        helper.setText(R.id.tv_goods_price_foot, goodsListBean.getCount() + "");

    }
}
