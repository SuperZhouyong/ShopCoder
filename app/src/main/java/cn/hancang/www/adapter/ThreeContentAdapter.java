package cn.hancang.www.adapter;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.hancang.www.R;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;

/**
 * Description: 保佑无bug
 * Data：2018/6/22-上午12:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class ThreeContentAdapter extends CommonRecycleViewAdapter<ConfirmOrderBean.DataBean.AddressListBean> {
    private List<String> mList;

    public ThreeContentAdapter(Context context) {
        super(context, R.layout.item_thre_address);
        mList = new ArrayList<>();
    }

    @Override
    public void convert(ViewHolderHelper helper, final ConfirmOrderBean.DataBean.AddressListBean addressListBean, int position) {
        SmoothCheckBox smoothCheckBox = helper.getView(R.id.sCheckbox_wx);
        helper.setText(R.id.tv_name, addressListBean.getProvince_name() + addressListBean.getCity_name() + addressListBean.getArea_name() + addressListBean.getAddress());
        smoothCheckBox.setChecked(mList.contains(addressListBean.getId() + ""));
        smoothCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mList.size() != 0)
                    mList.clear();
                mList.add(addressListBean.getId() + "");

                notifyDataSetChanged();

            }
        });

    }
}
