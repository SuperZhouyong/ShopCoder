package cn.hancang.www.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.hancang.www.R;

/**
 * 分隔线装饰
 *
 * @author youmingdot
 */
public class DividerLine extends RecyclerView.ItemDecoration {
    /**
     * 水平方向
     */
    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    /**
     * 垂直方向
     */
    public static final int VERTICAL = LinearLayoutManager.VERTICAL;

    // 画笔
    private Paint paint;

    private int left = 10;
    private Context context;
    // 布局方向
    private int orientation;
    // 分割线颜色
    private int color;
    // 分割线尺寸

    public void setLeft(int left) {
        this.left = left;
    }

    private int size = 2;

    public DividerLine() {
        this(null, VERTICAL);
    }

    public DividerLine(Context context, int orientation) {
        this.context = context;
        this.orientation = orientation;
//        this.color = context.getResources().getColor(R.color.app_focus);
        paint = new Paint();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        if (orientation == VERTICAL) {
            drawHorizontal(c, parent, left);
        } else {
            drawVertical(c, parent);
        }
    }

    /**
     * 设置分割线颜色
     *
     * @param color 颜色
     */
    public void setColor(int color) {
        this.color = color;
        paint.setColor(color);
    }

    /**
     * 设置分割线尺寸
     *
     * @param size 尺寸
     */
    public void setSize(int size) {
        this.size = size;
    }

    // 绘制垂直分割线
    protected void drawVertical(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + size;

            c.drawRect(left, top, right, bottom, paint);
        }
    }

    // 绘制水平分割线
    protected void drawHorizontal(Canvas c, RecyclerView parent, int selfleft) {
//        final int left = parent.getPaddingLeft();
//        final int left = parent.getPaddingLeft()+context.getResources().getDimensionPixelOffset(R.dimen.x10) ;
        final int left = parent.getPaddingLeft() + selfleft;
//        final int right = parent.getWidth() - parent.getPaddingRight();
        final int right = parent.getWidth() - left;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + size;

            c.drawRect(left, top, right, bottom, paint);
        }
    }
}

