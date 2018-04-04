package com.intention.sqtwin.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.intention.sqtwin.utils.conmonUtil.LogUtils;

/**
 * Created by Administrator on 2017/2/27 0027.
 * 给recycleview 的item 设置间距
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    private int mEdgeSpace;

    public SpacesItemDecoration(int space) {
        this.mSpace = space;
    }

    public SpacesItemDecoration(int space, int mEdgeSpace, Context ctx) {
        this.mSpace = (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mSpace, ctx.getResources().getDisplayMetrics()) + 0.5f);
        this.mEdgeSpace = (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mEdgeSpace, ctx.getResources().getDisplayMetrics()) + 0.5f);


    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
       /* outRect.left = 10;
        outRect.right = 10;*/

        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
//        int childPosition = parent.getChildAdapterPosition(view);
//        int itemCount = parent.getAdapter().getItemCount();
        if (layoutManager != null) {

            outRect.bottom = mSpace;
         /*   if (layoutManager instanceof GridLayoutManager) {
                // manager为GridLayoutManager时
                setGridOffset(((GridLayoutManager) layoutManager).getOrientation(), ((GridLayoutManager) layoutManager).getSpanCount(), outRect, childPosition, itemCount);
            } else if (layoutManager instanceof LinearLayoutManager) {


                // manager为LinearLayoutManager时
//                setLinearOffset(((LinearLayoutManager) manager).getOrientation(), outRect, childPosition, itemCount);
            }*/
        }


//        // Add top margin only for the first item to avoid double space between items
//        if (parent.getChildPosition(view) == 0)
//            outRect.top = space;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    private void setGridOffset(int orientation, int spanCount, Rect outRect, int childPosition, int itemCount) {
        float totalSpace = mSpace * (spanCount - 1) + mEdgeSpace * 2;
        float eachSpace = totalSpace / spanCount;
        int column = childPosition % spanCount;
        int row = childPosition / spanCount;

        float left;
        float right;
        float top;
        float bottom;
        if (orientation == GridLayoutManager.VERTICAL) {
            top = 0;
            bottom = mSpace;

            if (childPosition < spanCount) {
                top = mEdgeSpace;
            }
            if (itemCount % spanCount != 0 && itemCount / spanCount == row ||
                    itemCount % spanCount == 0 && itemCount / spanCount == row + 1) {
                bottom = mEdgeSpace;
            }

            if (spanCount == 1) {
                left = mEdgeSpace;
                right = left;
            } else {
                left = column * (eachSpace - mEdgeSpace - mEdgeSpace) / (spanCount - 1) + mEdgeSpace;
                right = eachSpace - left;
            }
        } else {
            left = 0;
            right = mSpace;

            if (childPosition < spanCount) {
                left = mEdgeSpace;
            }
            if (itemCount % spanCount != 0 && itemCount / spanCount == row ||
                    itemCount % spanCount == 0 && itemCount / spanCount == row + 1) {
                right = mEdgeSpace;
            }

            if (spanCount == 1) {
                top = mEdgeSpace;
                bottom = top;
            } else {
                top = column * (eachSpace - mEdgeSpace - mEdgeSpace) / (spanCount - 1) + mEdgeSpace;
                bottom = eachSpace - top;
            }
        }
        outRect.set((int) left, (int) top, (int) right, (int) bottom);
    }


}
