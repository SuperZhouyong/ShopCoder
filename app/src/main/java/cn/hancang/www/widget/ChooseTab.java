package cn.hancang.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.hancang.www.R;

/**
 * Created by ZJ on 2018/2/6 0006.
 */

public class ChooseTab extends LinearLayout {
    private String TAG = "ChooseLinearLayout";
    private int textSize = 28;// 默认字体大小
    private int selectTextColor;// 选中的Tab文字颜色
    private int unSelectTextColor;// 未选中的Tab文字颜色
    private String leftText; // 选中Tab的文字
    private String rightText; // 未选中Tab的文字
    private int gap = 0;// 两个Tab之间的间距
    private boolean selectSide = true;// true默认的选中是左边
    private TextView leftTextView;
    private TextView rightTextView;
    private Context context;
    private LinearLayout linearLayout;
    private LayoutParams layoutParams1;
    private LayoutParams layoutParams2;
    private Drawable leftSelectDrawable;// 左边选中样式
    private Drawable leftUnSelectDrawable;// 左边未选中样式
    private Drawable rightSelectDrawable;// 右边选中样式
    private Drawable rightUnSelectDrawable;// 右边未选中样式

    public ChooseTab(Context context) {
        super(context);
        init(context);
    }

    public ChooseTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        init(context);
    }

    public ChooseTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
        init(context);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ChooseTab, 0, 0);
        leftSelectDrawable = typedArray.getDrawable(R.styleable.ChooseTab_leftSelectDrawable);
        leftUnSelectDrawable = typedArray.getDrawable(R.styleable.ChooseTab_leftUnSelectDrawable);
        rightSelectDrawable = typedArray.getDrawable(R.styleable.ChooseTab_rightSelectDrawable);
        rightUnSelectDrawable = typedArray.getDrawable(R.styleable.ChooseTab_rightUnSelectDrawable);
        selectTextColor = typedArray.getColor(R.styleable.ChooseTab_selectTextColor, Color.BLUE);
        unSelectTextColor = typedArray.getColor(R.styleable.ChooseTab_unSelectTextColor, Color.BLACK);
        textSize = typedArray.getDimensionPixelSize(R.styleable.ChooseTab_textSize, textSize);
        leftText = typedArray.getString(R.styleable.ChooseTab_selectText);
        rightText = typedArray.getString(R.styleable.ChooseTab_unSelectText);
        gap = typedArray.getDimensionPixelSize(R.styleable.ChooseTab_gap, gap);
        selectSide = typedArray.getBoolean(R.styleable.ChooseTab_selectSide, true);
        typedArray.recycle();
    }
    private void init(Context context){
        this.context = context;
//        setWillNotDraw(false);
        linearLayout = new LinearLayout(context);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(HORIZONTAL);
        addView(linearLayout);

        leftTextView = new TextView(context);
        layoutParams1 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftTextView.setText(leftText);
        leftTextView.setTextColor(selectSide ? selectTextColor : unSelectTextColor);
        leftTextView.setGravity(Gravity.CENTER);
        leftTextView.setBackground(selectSide ? leftSelectDrawable : leftUnSelectDrawable);
        leftTextView.setTextSize(px2dip(textSize));
        leftTextView.setLayoutParams(layoutParams1);

        rightTextView = new TextView(context);
        layoutParams2 = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightTextView.setText(rightText);
        rightTextView.setTextColor(!selectSide ? selectTextColor : unSelectTextColor);
        rightTextView.setBackground(!selectSide ? rightSelectDrawable : rightUnSelectDrawable);
        rightTextView.setGravity(Gravity.CENTER);
        rightTextView.setTextSize(px2dip(textSize));
        rightTextView.setLayoutParams(layoutParams2);

        linearLayout.addView(leftTextView);
        linearLayout.addView(rightTextView);

        initListener();
    }

    private void initListener() {
        leftTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectSide)
                    return;
                selectSide = true;
                leftTextView.setTextColor(selectTextColor);
                leftTextView.setBackground(leftSelectDrawable);
                rightTextView.setTextColor(unSelectTextColor);
                rightTextView.setBackground(rightUnSelectDrawable);
                if (tabClickListener != null)
                    tabClickListener.onLeftClick();
            }
        });
        rightTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!selectSide)
                    return;
                selectSide = false;
                rightTextView.setTextColor(selectTextColor);
                rightTextView.setBackground(rightSelectDrawable);
                leftTextView.setTextColor(unSelectTextColor);
                leftTextView.setBackground(leftUnSelectDrawable);
                if (tabClickListener != null)
                    tabClickListener.onRightClick();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);

        layoutParams1.width = widthsize/2-gap/2;
        layoutParams1.setMargins(0,0,gap,0);
        leftTextView.setLayoutParams(layoutParams1);

        layoutParams2.width = widthsize/2-gap/2;
        rightTextView.setLayoutParams(layoutParams2);

        setMeasuredDimension(widthsize, heightsize);
    }

    private onTabClickListener tabClickListener;

    public interface onTabClickListener {
        void onLeftClick();

        void onRightClick();
    }

    public void setTabClickListener(onTabClickListener tabClickListener) {
        this.tabClickListener = tabClickListener;
    }

    public int px2dip(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
