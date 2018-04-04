package com.intention.sqtwin.widget;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.intention.sqtwin.R;
import com.intention.sqtwin.bean.MyScoreMakBean;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;

import java.util.ArrayList;

/**
 * @data 2017/8/26 0026
 * @aurher Administrator
 */

public class MyScoreMask extends MarkerView {
    private final ArrayList<MyScoreMakBean> mListMask;
    private final TextView tvContent;
    private final TextView tvContent1;
    private final TextView tvTitle;
    private final String TAG = "MyScoreMask";
    private final TextView tvContent2;
    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource the layout resource to use for the MarkerView
     */
    public MyScoreMask(Context context, int layoutResource, ArrayList<MyScoreMakBean> list) {
        super(context, layoutResource);
        mListMask = list;
        tvContent = (TextView) findViewById(R.id.tvContent);
        tvContent1 = (TextView) findViewById(R.id.tvContent1);
        tvContent2 = (TextView) findViewById(R.id.tvContent2);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        LogUtils.logd(TAG + e.getX());
        int index = (int) e.getX() - 1;
        LogUtils.logd(TAG + "-----" + mListMask.toString());
       /* tvTitle.setText(mListMask.get(index).getGrade());
        tvContent.setText(mListMask.get(index).getMiddleEnd());
        tvContent1.setText(mListMask.get(index).getSubject());
        tvContent2.setText(mListMask.get(index).getScore());*/
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
