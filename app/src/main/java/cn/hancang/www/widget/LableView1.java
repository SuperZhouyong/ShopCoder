package cn.hancang.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import cn.hancang.www.R;
import cn.hancang.www.utils.conmonUtil.DisplayUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/31 0031.
 */

public class LableView1 extends View {


    private int textSize;//文本尺寸，dp转px
    private int textColor;//文本颜色
    private Paint mPaintText;// 用于绘制文本
    private ArrayList<String> dataList;
    private int width;// 控件宽
    private int height;// 控件高
    private Paint paint;
    private int lableHeight;
    private Paint paint1;
    private Paint paint2;
    private int preyear = 2020; // 预测的年份

    public LableView1(Context context) {
        super(context);
    }

    public LableView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LableView1);
        textSize = typedArray.getDimensionPixelSize(R.styleable.LableView1_lv1_textsize, DisplayUtil.dip2px(13));
        textColor = typedArray.getColor(R.styleable.LableView1_lv1_textColor, Color.BLACK);
        typedArray.recycle();

        mPaintText = new Paint();
        mPaintText.setColor(textColor);
        mPaintText.setTextSize(textSize);
        mPaintText.setTextAlign(Paint.Align.CENTER);
        mPaintText.setAntiAlias(true);

        paint = new Paint();// 坐标的
        paint.setColor(getResources().getColor(R.color.app_bottom_colour));

        paint1 = new Paint();// 预测
        paint1.setColor(getResources().getColor(R.color.font_3));
        paint1.setTextSize(DisplayUtil.dip2px(9));

        paint2 = new Paint();// 第一个标签
        paint2.setColor(getResources().getColor(R.color.red));

        dataList = new ArrayList<>();
    }

    /**
     * 传入数据，得到dataList并确定一部分变量的值
     *
     * @param
     */
    public void setDataList(int min, int year) {
        dataList.clear();
        for (int i = min; i < min + 5; i++) {
            dataList.add(String.valueOf(i));
        }
        preyear = year;

        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        lableHeight = height / 4;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(0, 0, width, height, paint);
        //绘制X轴
        if (!dataList.isEmpty()) {
            canvas.drawText(dataList.get(0), textSize + 45, textSize, mPaintText);
            canvas.drawText(dataList.get(1), width / 6 + textSize / 2 + 40, textSize, mPaintText);
            canvas.drawText(dataList.get(2), width * 2 / 6 + textSize / 2 + 25, textSize, mPaintText);
            canvas.drawText(dataList.get(3), width * 3 / 6 + 20, textSize, mPaintText);
            canvas.drawText(dataList.get(4), width * 4 / 6 - 7, textSize, mPaintText);
            canvas.drawText(String.valueOf(preyear), width - textSize - 20, textSize, mPaintText);
            canvas.drawText("(预测)", width - textSize - 60, textSize * 2, paint1);
        }
    }
}
