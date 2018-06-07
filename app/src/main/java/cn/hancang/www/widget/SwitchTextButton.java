package cn.hancang.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

import cn.hancang.www.R;

/**
 * Created by Administrator on 2017/10/17 0017.
 */

public class SwitchTextButton extends ViewGroup {

    public SwitchTextButton(Context context) {
        this(context, null);
    }

    public SwitchTextButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchTextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.switchTextButton);
        typedArray.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
