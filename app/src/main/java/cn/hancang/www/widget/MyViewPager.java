package cn.hancang.www.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.hancang.www.utils.conmonUtil.LogUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class MyViewPager extends ViewPager {
    private Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
    private int current;
    private ViewGroup parent;
    private boolean canScroll = true;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNestedpParent(ViewGroup parent) {
        this.parent = parent;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        int j = getChildCount();
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            view.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            calculate(i, view.getMeasuredHeight());
            LogUtils.logd("测试高度" + "每次循环的高度" + view.getMeasuredHeight() + maps);
//            height = Math.max(view.getMeasuredHeight(), height);
            height = getChildAt(0).getMeasuredHeight();
//            calculate(i,view.getMeasuredHeight());
        }
        if (current == 0) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtils.logd("测试高度" + height);
    }

    public void resetHeight(int current) {
        LogUtils.logd("测试高度" + "resetHeight------" + current + "----map集合中的数据----" + maps.toString());
        if (maps.size() > current) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();

            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, maps.get(current));
            } else {
                layoutParams.height = maps.get(current);
            }
//            setLayoutParams(layoutParams);

            startAnimation(layoutParams, maps.get(this.current), maps.get(current));

        }
        this.current = current;
    }

    private void startAnimation(final RelativeLayout.LayoutParams layoutParams, int pre, int current) {

        ValueAnimator valueAnimator;
        valueAnimator = ValueAnimator.ofInt(pre, current);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = (int) valueAnimator.getAnimatedValue();
                setLayoutParams(layoutParams);
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.start();
        LogUtils.logd("测试高度===" + pre + "--------" + current);
//        LogUtils.logd("测试高度", pre + "--------" + current + "我是TAg");
        /*AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.start();*/
    }

    public void calculate(int type, int height) {
        if (type == 0) {
            if (maps.get(0) == null) {
                maps.put(type, height);
            } else {
                Integer integer = maps.get(0);
                maps.put(type, integer > height ? integer : height);
            }
        } else {
            maps.put(type, height);
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (parent != null) {
//            Log.i("dispatch_touch_event","---"+ev.getAction());
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (parent != null) {
//            Log.i("onintercepte_touch_eve","---"+ev.getAction());
        }
        if (canScroll) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
      /*  if (parent != null) {
//            Log.i("on_touch_event","---"+ev.getAction());
            parent.requestDisallowInterceptTouchEvent(true);
        }*/
        /*getParent().requestDisallowInterceptTouchEvent(true);*/
        if (canScroll) {
            return super.onTouchEvent(ev);
        } else {
            return false;
        }
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }
}
