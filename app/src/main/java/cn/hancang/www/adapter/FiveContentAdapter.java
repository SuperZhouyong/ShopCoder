package cn.hancang.www.adapter;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.hancang.www.R;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.ConfirmOrderBean;
import cn.hancang.www.bean.GoodsBuyNewBean;
import cn.hancang.www.utils.checkbox.SmoothCheckBox;

/**
 * Description: 保佑无bug
 * Data：2018/6/21-下午9:02
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class FiveContentAdapter extends CommonRecycleViewAdapter<GoodsBuyNewBean.DataBean.PayListBean> {
    public FiveContentAdapter(Context context) {
        super(context, R.layout.item_pay_list);
        mList = new ArrayList<>();
    }

    public List<String> getmList() {
        return mList;
    }

    public void setmList(List<String> mList) {
        this.mList = mList;
    }

    private List<String> mList;

    @Override
    public void convert(ViewHolderHelper helper, final GoodsBuyNewBean.DataBean.PayListBean payListBean, int position) {
        helper.setVisible(R.id.imageView6, position != getDataList().size() - 1);
        if (payListBean.getName().contains("宝"))
            helper.setBackgroundRes(R.id.iv_wx_pay, R.mipmap.ali_pay);
        else
            helper.setBackgroundRes(R.id.iv_wx_pay, R.mipmap.wx_icon);

        helper.setText(R.id.tv_name, payListBean.getName());

        final SmoothCheckBox smoothCheckBox = helper.getView(R.id.sCheckbox_wx);
        smoothCheckBox.setChecked(mList.contains(payListBean.getPay_type() + ""));
        smoothCheckBox.setClickable(false);
        helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mList.size() != 0)
                        mList.clear();
                    mList.add(payListBean.getPay_type() + "");
               /* if (mList.contains(payListBean.getPay_type()+"")) {
                    mList.remove(payListBean.getPay_type()+"");


                } else {
                    mList.add(payListBean.getPay_type()+"");
                }*/
                    notifyDataSetChanged();

                }
        });

    }


}
