package com.intention.sqtwin.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.intention.sqtwin.R;
import com.intention.sqtwin.utils.conmonUtil.DisplayUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class LableView extends View {


    private int textSize;//文本尺寸，dp转px
    private int textColor;//文本颜色
    private Paint mPaintText;// 用于绘制文本
    private ArrayList<String> dataList;
    private int width;// 控件宽
    private int height;// 控件高

    public LableView(Context context) {
        super(context);
    }

    public LableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LableView);
        textSize = typedArray.getDimensionPixelSize(R.styleable.LableView_lv_textsize, DisplayUtil.dip2px(13));
        textColor = typedArray.getColor(R.styleable.LableView_lv_textColor, Color.BLACK);
        typedArray.recycle();

        mPaintText = new Paint();
        mPaintText.setColor(textColor);
        mPaintText.setTextSize(textSize);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setAntiAlias(true);


        dataList = new ArrayList<>();
    }

    /**
     * 传入数据，得到dataList并确定一部分变量的值
     *
     * @param
     */
    public void setDataList(int min) {
        dataList.clear();
        for (int i = min; i < min + 11; i++) {
            dataList.add(String.valueOf(i));
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制X轴
        int itemWidth = width / 11;
//        for (int i = 0;i<11;i++){
        if (!dataList.isEmpty()) {
//                if (i==0||i == 10){
//                    canvas.drawText(dataList.get(i), (textSize+2)+((itemWidth+5)*i), height / 2 + textSize / 2, mPaintText);
//                }else {
//                    canvas.drawText(dataList.get(i).substring(2,4), (textSize+2)+((itemWidth+5)*i), height / 2 + textSize / 2, mPaintText);
//                }
            canvas.drawText(dataList.get(0), (textSize + 2) + ((itemWidth + 5) * 0) + 5, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(1).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 1) + 4, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(2).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 2) - 1, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(3).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 3) - 5, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(4).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 4) - 9, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(5).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 5) - 13, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(6).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 6) - 17, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(7).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 7) - 20, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(8).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 8) - 24, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(9).substring(2, 4), (textSize + 2) + ((itemWidth + 5) * 9) - 28, height / 2 + textSize / 2, mPaintText);
            canvas.drawText(dataList.get(10), (textSize + 2) + ((itemWidth + 5) * 10) - 20, height / 2 + textSize / 2, mPaintText);
        }
//        }

    }
}
