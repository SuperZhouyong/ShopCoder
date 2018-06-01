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
    private List<ChooseBean1> mDataList = new ArrayList<>();

    public TagAdapter(Context context) {
        this.mContext = context;


    }

    @Override
    public int getCount() {

        return mDataList.size();
    }

    @Override
    public ChooseBean1 getItem(int position) {

        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_flowlayout, null);

        TextView name = (TextView) view.findViewById(R.id.tv_name);
        name.setText(mDataList.get(position).getName());


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
