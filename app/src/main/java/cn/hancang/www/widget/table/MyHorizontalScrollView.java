package cn.hancang.www.widget.table;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class MyHorizontalScrollView extends HorizontalScrollView {

    // 自定义的监听器
    private OnHorizontalScrollListener listener;

    public MyHorizontalScrollView(Context context){
        super(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnHorizontalScrollListener(OnHorizontalScrollListener listener){
        this.listener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        // 通知自定义的listener
        if (listener != null){
            listener.onHorizontalScrolled(this, l, t, oldl, oldt);
        }
    }

    //内部接口，用来监听系统的onScrollChangedListener监听到的数据
    interface OnHorizontalScrollListener {
        void onHorizontalScrolled(MyHorizontalScrollView view, int l, int t, int oldl, int oldt);
    }
}
