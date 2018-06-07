package cn.hancang.www.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/3/22 0022.
 */

public class MaxHeightRecyclerView extends RecyclerView {
    private static int MAX_HEIGHT = 354;

    public MaxHeightRecyclerView(Context context) {
        super(context);
//        this(context, null);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        this(context, attrs, 0);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (heightMode == MeasureSpec.EXACTLY) {
            heightSize = heightSize <= MAX_HEIGHT ? heightSize
                    : (int) MAX_HEIGHT;
        }
        if (heightMode == MeasureSpec.UNSPECIFIED) {
            heightSize = heightSize <= MAX_HEIGHT ? heightSize
                    : (int) MAX_HEIGHT;
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = heightSize <= MAX_HEIGHT ? heightSize
                    : (int) MAX_HEIGHT;
        }
        int maxHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
                heightMode);
        super.onMeasure(widthMeasureSpec, maxHeightMeasureSpec);
    }
}
