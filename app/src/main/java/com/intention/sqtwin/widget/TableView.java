/*
package com.intention.sqtwin.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.bean.EntryScoreBean;
import com.intention.sqtwin.bean.ScoreLineInfo;
import com.intention.sqtwin.utils.conmonUtil.DisplayUtil;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Administrator on 2017/3/31 0031.
 *//*


public class TableView extends View {
    private int dataNum; //数据量
    private int textSize;//文本尺寸，dp转px
    private int textColor;//文本颜色
    private int tableItemHeight;//表格单元高
    private int tableItemWidth;// 单元格宽
    private Paint mPaintLine;// 用于画表格的线
    private Paint mPaintLightGrey;//线的背景
    private Paint mPaintText;// 用于绘制文本
    private ArrayList<EntryScoreBean> dataList;
    private List<ScoreLineInfo.DataBean> mList;
    private int width;// 控件宽
    private int height;// 控件高
    private float startX;
    private float startY;

    public TableView(Context context) {
        super(context);
    }

    public TableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TableView);
        textSize = typedArray.getDimensionPixelSize(R.styleable.TableView_tv_textsize, DisplayUtil.dip2px(13));
        textColor = typedArray.getColor(R.styleable.TableView_tv_textColor, Color.BLACK);
        tableItemHeight = typedArray.getDimensionPixelSize(R.styleable.TableView_itemheight, DisplayUtil.dip2px(36));
        typedArray.recycle();

        mPaintLine = new Paint();
        mPaintLine.setColor(Color.LTGRAY);
        mPaintLine.setStrokeWidth(1);
        mPaintLine.setAntiAlias(true);

        mPaintText = new Paint();
        mPaintText.setColor(textColor);
        mPaintText.setTextSize(textSize);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setAntiAlias(true);

        mPaintLightGrey = new Paint();
        mPaintLightGrey.setColor(Color.argb(255, 250, 250, 250));
        mPaintLightGrey.setStyle(Paint.Style.FILL);
        mPaintLightGrey.setAntiAlias(true);

        dataList = new ArrayList<>();
    }

    */
/**
     * 传入数据，得到dataList并确定一部分变量的值
     *
     * @param dataList
     *//*

    public void setDataList(ArrayList<EntryScoreBean> dataList) {
        setVisibility(VISIBLE);
        this.dataList = dataList;
        dataNum = dataList.size();
        LogUtils.logi("设置数据");

        invalidate();
    }

    public void setScoreLinInfo(ArrayList<ScoreLineInfo.DataBean> mList) {
        this.mList = mList;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
//        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        LogUtils.logd("tabView-----1" + "onMeasure" + height + "---" + width + "----tableItemHeight---" + tableItemHeight + "----" + dataNum);
        //根据数据数量来得到控件高
        if (dataNum != 0) {
            height = dataNum * 4 * tableItemHeight;
        } else {
            height = 10 * 4 * tableItemHeight;
        }


        //表格单元宽
        tableItemWidth = width / 3;

        setMeasuredDimension(width, height);
        LogUtils.logd("tabView" + "onMeasure" + height + "---" + width + "----tableItemHeight---" + tableItemHeight + "----" + dataNum);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        LogUtils.logi("制作表格");
        //绘制统计表
//        canvas.drawRect(startX, startY, width, height, mPaintLightGrey);
        canvas.drawLine(0, 0, 0, height, mPaintLine);
//        canvas.drawLine(width,width,0,height,mPaintLine);
        canvas.drawRect(width - 1, 0, width, height, mPaintLine);
        for (int i = 0; i < dataNum; i++) {
            canvas.drawText(dataList.get(i).getYear(), startX + tableItemWidth / 2, startY + tableItemHeight * 2 + textSize / 2, mPaintText);

            canvas.drawText("本科一批", startX + tableItemWidth * 3 / 2, startY + tableItemHeight / 2 + textSize / 2, mPaintText);
            if (dataList.get(i).getFirstTier() == null || dataList.get(i).getFirstTier().isEmpty()) {
                canvas.drawText("-", startX + tableItemWidth * 5 / 2, startY + tableItemHeight / 2 + textSize / 2, mPaintText);
            } else {
                canvas.drawText(dataList.get(i).getFirstTier(), startX + tableItemWidth * 5 / 2, startY + tableItemHeight / 2 + textSize / 2, mPaintText);
            }
            canvas.drawLine(tableItemWidth, startY + tableItemHeight, width, startY + tableItemHeight, mPaintLine);

            canvas.drawText("本科二批", startX + tableItemWidth * 3 / 2, startY + tableItemHeight * 3 / 2 + textSize / 2, mPaintText);
            if (dataList.get(i).getSecondTier() == null || dataList.get(i).getSecondTier().isEmpty()) {
                canvas.drawText("-", startX + tableItemWidth * 5 / 2, startY + tableItemHeight * 3 / 2 + textSize / 2, mPaintText);
            } else {
                canvas.drawText(dataList.get(i).getSecondTier(), startX + tableItemWidth * 5 / 2, startY + tableItemHeight * 3 / 2 + textSize / 2, mPaintText);
            }
            canvas.drawLine(tableItemWidth, startY + tableItemHeight * 2, width, startY + tableItemHeight * 2, mPaintLine);

            canvas.drawText("本科三批", startX + tableItemWidth * 3 / 2, startY + tableItemHeight * 5 / 2 + textSize / 2, mPaintText);
            if (dataList.get(i).getThreeTier() == null || dataList.get(i).getThreeTier().isEmpty()) {
                canvas.drawText("-", startX + tableItemWidth * 5 / 2, startY + tableItemHeight * 5 / 2 + textSize / 2, mPaintText);
            } else {
                canvas.drawText(dataList.get(i).getThreeTier(), startX + tableItemWidth * 5 / 2, startY + tableItemHeight * 5 / 2 + textSize / 2, mPaintText);
            }
            canvas.drawLine(tableItemWidth, startY + tableItemHeight * 3, width, startY + tableItemHeight * 3, mPaintLine);

            canvas.drawText("专科", startX + tableItemWidth * 3 / 2, startY + tableItemHeight * 7 / 2 + textSize / 2, mPaintText);
            if (dataList.get(i).getJuniorCollege() == null || dataList.get(i).getJuniorCollege().isEmpty()) {
                canvas.drawText("-", startX + tableItemWidth * 5 / 2, startY + tableItemHeight * 7 / 2 + textSize / 2, mPaintText);
            } else {
                canvas.drawText(dataList.get(i).getJuniorCollege(), startX + tableItemWidth * 5 / 2, startY + tableItemHeight * 7 / 2 + textSize / 2, mPaintText);
            }
            canvas.drawLine(0, startY + tableItemHeight * 4, width, startY + tableItemHeight * 4, mPaintLine);
            // 两条 分割线
            canvas.drawLine(tableItemWidth, 0, tableItemWidth, startY + tableItemHeight * 4, mPaintLine);
            canvas.drawLine(tableItemWidth * 2, 0, tableItemWidth * 2, startY + tableItemHeight * 4, mPaintLine);
            startY += tableItemHeight * 4;
        }
        startX = 0;
        startY = 0;
    }
}
*/
