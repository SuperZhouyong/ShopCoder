package com.intention.sqtwin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.intention.sqtwin.utils.conmonUtil.LogUtils;

/**
 * Created by Administrator on 2018/3/22 0022.
 */

public class MaxHeightRelativeLayout extends RelativeLayout {
    private static int MAX_HEIGHT = 284;

    public MaxHeightRelativeLayout(Context context) {
        super(context);
//        this(context, null);
    }

    public MaxHeightRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        this(context, attrs, 0);
    }

    public MaxHeightRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (getChildCount() ==0){
            throw new NullPointerException("there is no child in the MaxHeightRelativeLayout");
        }
        View childAt = getChildAt(0);
        if (childAt instanceof EditText) {
            MAX_HEIGHT = childAt.getMeasuredHeight() + 32;
        } else {
            throw new ClassCastException("the first child must be EditView");
        }
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
