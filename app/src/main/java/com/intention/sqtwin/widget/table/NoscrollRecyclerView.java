package com.intention.sqtwin.widget.table;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.ListView;

public class NoscrollRecyclerView extends RecyclerView {

    public NoscrollRecyclerView(Context context) {
        super(context);
    }

    public NoscrollRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoscrollRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}