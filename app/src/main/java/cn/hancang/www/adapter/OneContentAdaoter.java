package cn.hancang.www.adapter;

import android.content.Context;

import java.util.List;

import cn.hancang.www.R;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.bean.MyCompeteBean;

/**
 * Description: 保佑无bug
 * Data：2018/6/16-下午12:56
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class OneContentAdaoter extends CommonRecycleViewAdapter<ConfirmOrderBean> {
    public OneContentAdaoter(Context context) {
        super(context, R.layout.item_confirmorder_one);
    }

    @Override
    public void convert(ViewHolderHelper helper, ConfirmOrderBean confirmOrderBean, int position) {
        //tv_goods_name
        //tv_goods_desc
        //tv_goods_price
        //tv_goods_desc_foot
        //tv_goods_price_foot

    }
}
