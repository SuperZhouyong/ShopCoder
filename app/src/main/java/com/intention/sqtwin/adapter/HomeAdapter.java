package com.intention.sqtwin.adapter;

import android.content.Context;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.RecommendField;

/**
 * Description: 保佑无bug
 * Data：2018/4/19-下午10:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class HomeAdapter extends CommonRecycleViewAdapter<RecommendField.DataBean>{



    public HomeAdapter(Context context, int layoutId) {
        super(context, R.layout.item_wholegoods);
    }

    @Override
    public void convert(ViewHolderHelper helper, RecommendField.DataBean dataBean, int position) {

    }
}
