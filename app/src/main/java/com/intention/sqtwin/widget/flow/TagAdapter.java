package com.intention.sqtwin.widget.flow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.bean.ChooseBean1;
import com.intention.sqtwin.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanHailong on 15/10/19.
 */
public class TagAdapter extends BaseAdapter implements OnInitSelectedPosition {

    private final Context mContext;
    private List<ChooseBean1> mDataList;
//    private final List<MajorDisBean> mDataList;

    //    public TagAdapter(Context context,List<MajorDisBean> mList) {
//        this.mContext = context;
//        this.mDataList = mList;
//    }
    public TagAdapter(Context context) {
        this.mContext = context;
        mDataList = new ArrayList<>();
//        this.mDataList = (List<T>) list;

//        mDataList = mList;
    }

    @Override
    public int getCount() {
//        LogUtils.logi("getCount"+mDataList.size());
//        return 10;
        return mDataList.size();
    }

    @Override
    public ChooseBean1 getItem(int position) {
//        LogUtils.logi("getItem"+mDataList.size());
//        return null;
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
//        LogUtils.logi("getItemId"+mDataList.size());
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
//        LogUtils.logi("2222222222222222222222222");
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_flowlayout, null);

        CircleImageView ivColor = (CircleImageView) view.findViewById(R.id.iv_color);
        TextView name = (TextView) view.findViewById(R.id.tv_name);
        ivColor.setEnabled(false);
//        ivColor.setImageDrawable(new ColorDrawable(mDataList.get(position).getCurrentId()));
//        name.setText(mDataList.get(position).getName());

//        if (t instanceof String) {
//            // 字数超过了，就设置其宽度
//            if (((String) t).length() > 21){
//                ViewGroup.LayoutParams params = textView.getLayoutParams();
//                params.width = mContext.getResources().getDimensionPixelOffset(R.dimen.x570);
//                textView.setLayoutParams(params);
//            }
//            textView.setText((String) t);
//        }
        return view;
    }

    public void onlyAddAll(List<ChooseBean1> datas) {
        mDataList.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearAndAddAll(List<ChooseBean1> datas) {
        mDataList.clear();
        onlyAddAll(datas);
    }

    @Override
    public boolean isSelectedPosition(int position) {
        if (position % 2 == 0) {
            return true;
        }
        return false;
    }
}
