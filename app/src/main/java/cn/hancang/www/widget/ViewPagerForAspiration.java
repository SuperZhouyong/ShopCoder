package cn.hancang.www.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Created by Administrator on 2017/11/8 0008.
 * viewpager 事件冲突处理
 * 不允许左右滑动，但允许子控件上下滑动
 */

public class ViewPagerForAspiration extends ViewPager {
    private float xStart;
    private float yStart;
    private int touchSlop;
    private float xDistance;
    private float yDistance;

    public ViewPagerForAspiration(Context context) {
        super(context);
        init();

    }

    public ViewPagerForAspiration(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /**
     * 是否消费事件
     * 消费:事件就结束  return  true
     * 不消费:往父控件传
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        xDistance = 0f;
        yDistance = 0f;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // x起始点
                xStart = ev.getX();
                // y起始点
                yStart = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float xEnd = ev.getX();//
                float yEnd = ev.getY();//
                xDistance += Math.abs(xStart - xEnd);
                yDistance += Math.abs(yStart - yEnd);
                if (Math.abs(xDistance) > touchSlop && Math.abs(yDistance) > touchSlop) {
                    //通过距离差判断方向
                    int orientation = getOrientation(xDistance, yDistance);
                    switch (orientation) {
                        case 'r':// 右
                        case 'l':// 左
                            return true;
                        case 'b':// 下
                        case 't'://上
                            return super.onTouchEvent(ev);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                float xEnd1 = ev.getX();// x结束点
                float yEnd1 = ev.getY();// y结束点
                float dx = xStart - xEnd1;
                float dy = yStart - yEnd1;
                if (Math.abs(dx) > touchSlop && Math.abs(dy) > touchSlop) {
                    //通过距离差判断方向
                    int orientation = getOrientation(dx, dy);
                    switch (orientation) {
                        case 'r':// 右
                        case 'l':// 左
                            return true;
                        case 'b':// 下
                        case 't'://上
                            return super.onTouchEvent(ev);
                    }
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * dispatchTouchEvent一般情况不做处理
     * 如果修改了默认的返回值,子孩子都无法收到事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    private int getOrientation(float dx, float dy) {
        if (Math.abs(dx) > Math.abs(dy)) {
            //X轴移动
            return dx > 0 ? 'r' : 'l';
        } else {
            //Y轴移动
            return dy > 0 ? 'b' : 't';
        }
    }

    /**
     * 是否拦截
     * 拦截:会走到自己的onTouchEvent方法里面来
     * 不拦截:事件传递给子孩子
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        xDistance = yDistance = 0f;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // x起始点
                xStart = ev.getX();
                // y起始点
                yStart = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float xEnd = ev.getX();//
                float yEnd = ev.getY();//
                xDistance += Math.abs(xStart - xEnd);
                yDistance += Math.abs(yStart - yEnd);
                //通过距离差判断方向
                int orientation = getOrientation(xDistance, yDistance);
                switch (orientation) {
                    case 'r':// 右
                    case 'l':// 左
                        return false;
                    case 'b':// 下
                    case 't'://上
                        return super.onInterceptTouchEvent(ev);
                }
                break;
            case MotionEvent.ACTION_UP:
                float xEnd1 = ev.getX();// x结束点
                float yEnd1 = ev.getY();// y结束点
                float dx = xStart - xEnd1;
                float dy = yStart - yEnd1;
                //通过距离差判断方向
                int orientation1 = getOrientation(dx, dy);
                switch (orientation1) {
                    case 'r':// 右
                    case 'l':// 左
                        return false;
                    case 'b':// 下
                    case 't'://上
                        return super.onInterceptTouchEvent(ev);
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
