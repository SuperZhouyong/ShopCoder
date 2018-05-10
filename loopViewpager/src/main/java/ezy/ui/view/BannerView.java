package ezy.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import ezy.library.bannerview.R;


public class BannerView<Item> extends FrameLayout {
    public static boolean DEBUG = false;
    private static final String TAG = BannerView.class.getSimpleName();

    public interface ViewFactory<Item> {
        View create(Item item, int position, ViewGroup container);
    }

    public interface TitleAdapter<Item> {
        CharSequence getTitle(Item item);
    }

    public static final int VISIBLE_AUTO = 0;
    public static final int VISIBLE_ALWAYS = 1;
    public static final int VISIBLE_NEVER = 2;

    // 设备密度
    private DisplayMetrics mDm;

    private long mDelay;        // 多久后开始滚动
    private long mInterval;     // 滚动间隔
    private boolean mIsAuto;    // 是否自动滚动
    private boolean mBarVisibleWhenLast;    // 最后一条 item 是否显示背景条
    private int mCurrentPosition;

    private boolean mIsStarted = false;
    private boolean mIsVisible = false;
    private boolean mIsResumed = true;
    private boolean mIsRunning = false;
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (DEBUG) {
                Log.e("ezy", "running=" + mIsRunning + ",pos=" + mCurrentPosition);
            }
            if (mIsRunning) {
                vViewPager.setCurrentItem(mCurrentPosition + 1);
                if (isLoop() || mCurrentPosition + 1 < mDataList.size()) {
                    postDelayed(mRunnable, mInterval);
                } else {
                    mIsRunning = false;
                }
            }
        }
    };

    // 内容宽高
    private int mItemWidth;
    private int mItemHeight = LayoutParams.WRAP_CONTENT;

    private ViewPager vViewPager;
    private LinearLayout vBottomBar;
    private TextView vTitleBar;
    private ViewPagerIndicator vIndicator;

    private int mIndicatorVisible;

    private List<Item> mDataList = new ArrayList();
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewFactory mViewFactory;
    private TitleAdapter mTitleAdapter = new TitleAdapter() {
        @Override
        public CharSequence getTitle(Object o) {
            return o.toString();
        }
    };

    public BannerView(Context context) {
        this(context, null, 0);
    }

    public BannerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressWarnings("all")
    public BannerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mDm = context.getResources().getDisplayMetrics();

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BannerView);

        boolean hasAspectRatio = ta.hasValue(R.styleable.BannerView_bvAspectRatio);
        float aspectRatio = ta.getFloat(R.styleable.BannerView_bvAspectRatio, 0f);
        boolean isLoop = ta.getBoolean(R.styleable.BannerView_bvIsLoop, true);
        mDelay = ta.getInt(R.styleable.BannerView_bvDelay, 5000);
        mInterval = ta.getInt(R.styleable.BannerView_bvInterval, 5000);
        mIsAuto = ta.getBoolean(R.styleable.BannerView_bvIsAuto, true);

        mBarVisibleWhenLast = ta.getBoolean(R.styleable.BannerView_bvBarVisibleWhenLast, true);

        int indicatorGravity = ta.getInt(R.styleable.BannerView_bvIndicatorGravity, Gravity.CENTER);
        int barColor = ta.getColor(R.styleable.BannerView_bvBarColor, Color.TRANSPARENT);
        float barPaddingLeft = ta.getDimension(R.styleable.BannerView_bvBarPaddingLeft, dp2px(10));
        float barPaddingTop = ta.getDimension(R.styleable.BannerView_bvBarPaddingTop, dp2px(10));
        float barPaddingRight = ta.getDimension(R.styleable.BannerView_bvBarPaddingRight, dp2px(10));
        float barPaddingBottom = ta.getDimension(R.styleable.BannerView_bvBarPaddingBottom, dp2px(10));

        int titleColor = ta.getColor(R.styleable.BannerView_bvTitleColor, Color.WHITE);
        float titleSize = ta.getDimension(R.styleable.BannerView_bvTitleSize, sp2px(14f));
        boolean titleVisible = ta.getBoolean(R.styleable.BannerView_bvTitleVisible, false);

        // auto, aways, never
        mIndicatorVisible = ta.getInteger(R.styleable.BannerView_bvIndicatorVisible, VISIBLE_AUTO);

        int indicatorWidth = ta.getDimensionPixelSize(R.styleable.BannerView_bvIndicatorWidth, dp2px(4));
        int indicatorHeight = ta.getDimensionPixelSize(R.styleable.BannerView_bvIndicatorHeight, dp2px(4));
        int indicatorGap = ta.getDimensionPixelSize(R.styleable.BannerView_bvIndicatorGap, dp2px(6));
        int indicatorColor = ta.getColor(R.styleable.BannerView_bvIndicatorColor, 0x88ffffff);
        int indicatorColorSelected = ta.getColor(R.styleable.BannerView_bvIndicatorColorSelected, Color.WHITE);

        Drawable indicatorDrawable = ta.getDrawable(R.styleable.BannerView_bvIndicatorDrawable);
        Drawable indicatorDrawableSelected = ta.getDrawable(R.styleable.BannerView_bvIndicatorDrawableSelected);
        ta.recycle();


        //create ViewPager
        vViewPager = isLoop ? new LoopViewPager(context) : new ViewPager(context);
        vViewPager.setOffscreenPageLimit(1);

        int[] systemAttrs = {android.R.attr.layout_width, android.R.attr.layout_height};
        TypedArray a = context.obtainStyledAttributes(attrs, systemAttrs);
        mItemWidth = a.getLayoutDimension(0, mDm.widthPixels);
        mItemHeight = a.getLayoutDimension(1, mItemHeight);
        a.recycle();

        if (mItemWidth < 0) {
            mItemWidth = mDm.widthPixels;
        }

        if (aspectRatio > 0) {
            if (aspectRatio > 1) {
                aspectRatio = 1;
            }
            mItemHeight = (int) (mItemWidth * aspectRatio);
        }

        Log.e(TAG, "w = " + mItemWidth + ", h = " + mItemHeight);
        LayoutParams lp = new LayoutParams(mItemWidth, mItemHeight);
        addView(vViewPager, lp);

        // bottom bar
        vBottomBar = new LinearLayout(context);
        vBottomBar.setBackgroundColor(barColor);
        vBottomBar.setPadding((int) barPaddingLeft, (int) barPaddingTop, (int) barPaddingRight, (int) barPaddingBottom);
        vBottomBar.setClipChildren(false);
        vBottomBar.setClipToPadding(false);
        vBottomBar.setOrientation(LinearLayout.HORIZONTAL);
        vBottomBar.setGravity(Gravity.CENTER);
        addView(vBottomBar, new LayoutParams(mItemWidth, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM));

        vIndicator = new ViewPagerIndicator(context);
        vIndicator.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        vIndicator.setItemSize(indicatorWidth*4, indicatorHeight);
        vIndicator.setItemGap(indicatorGap);
        if (indicatorDrawable != null && indicatorDrawableSelected != null) {
            vIndicator.setItemDrawable(indicatorDrawable, indicatorDrawableSelected);
        } else {
            vIndicator.setItemColor(indicatorColor, indicatorColorSelected);
        }

        // title
        vTitleBar = new TextView(context);
        vTitleBar.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.0F));
        vTitleBar.setSingleLine(true);
        vTitleBar.setTextColor(titleColor);
        vTitleBar.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize);
        vTitleBar.setEllipsize(TextUtils.TruncateAt.END);
        vTitleBar.setVisibility(titleVisible ? VISIBLE : INVISIBLE);

        if (indicatorGravity == Gravity.CENTER) {
            vBottomBar.addView(vIndicator);
        } else if (indicatorGravity == Gravity.RIGHT) {
            vBottomBar.addView(vTitleBar);
            vBottomBar.addView(vIndicator);

            vTitleBar.setPadding(0, 0, dp2px(10), 0);
            vTitleBar.setGravity(Gravity.LEFT);
        } else if (indicatorGravity == Gravity.LEFT) {
            vBottomBar.addView(vIndicator);
            vBottomBar.addView(vTitleBar);

            vTitleBar.setPadding(dp2px(10), 0, 0, 0);
            vTitleBar.setGravity(Gravity.RIGHT);
        }

    }

    public void setDelay(long delay) {
        this.mDelay = delay;
    }

    public void setInterval(long interval) {
        this.mInterval = interval;
    }

    public void setIsAuto(boolean isAuto) {
        this.mIsAuto = isAuto;
    }

    public void setIndicatorVisible(int value) {
        mIndicatorVisible = value;
    }

    public void setBarVisibleWhenLast(boolean value) {
        this.mBarVisibleWhenLast = value;
    }

    public void setBarColor(int barColor) {
        vBottomBar.setBackgroundColor(barColor);
    }

    public void setBarPadding(float left, float top, float right, float bottom) {
        vBottomBar.setPadding(dp2px(left), dp2px(top), dp2px(right), dp2px(bottom));
    }

    public void setTitleColor(int textColor) {
        vTitleBar.setTextColor(textColor);
    }

    public void setTitleSize(float sp) {
        vTitleBar.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp);
    }

    public void setTitleVisible(boolean isTitleVisible) {
        vTitleBar.setVisibility(isTitleVisible ? VISIBLE : INVISIBLE);
    }


    public boolean isLoop() {
        return vViewPager instanceof LoopViewPager;
    }

    public ViewPager getViewPager() {
        return vViewPager;
    }

    public ViewPagerIndicator getIndicator() {
        return vIndicator;
    }

    public void setViewFactory(@NonNull ViewFactory factory) {
        mViewFactory = factory;
    }

    public void setTitleAdapter(@NonNull TitleAdapter adapter) {
        mTitleAdapter = adapter;
    }

    public void setDataList(@NonNull List<Item> list) {
        mDataList = list;
    }

    public void setOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener listener) {
        mOnPageChangeListener = listener;
    }


    void initViewPager() {
        vViewPager.setAdapter(mInternalPagerAdapter);
        vViewPager.removeOnPageChangeListener(mInternalPageListener);
        vViewPager.addOnPageChangeListener(mInternalPageListener);
        vViewPager.setOffscreenPageLimit(mDataList.size());
        mInternalPagerAdapter.notifyDataSetChanged();
        try {
            if (isLoop()) {
                setDuration(vViewPager, 500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void initIndicator() {
        vIndicator.setupWithViewPager(vViewPager);
        boolean visible = mIndicatorVisible == VISIBLE_ALWAYS || (mIndicatorVisible == VISIBLE_AUTO && mDataList.size() > 1);
        vIndicator.setVisibility(visible ? VISIBLE : INVISIBLE);
        vIndicator.setPosition(mCurrentPosition);
    }

    void setCurrentTitle(int position) {
        vTitleBar.setText(mTitleAdapter.getTitle(mDataList.get(position)));
    }


    boolean isValid() {
        if (vViewPager == null) {
            Log.e(TAG, "ViewPager is not exist!");
            return false;
        }
        if (mViewFactory == null) {
            Log.e(TAG, "ViewFactory must be not null!");
            return false;
        }
        if (mTitleAdapter == null) {
            Log.e(TAG, "TitleAdapter must be not null!");
            return false;
        }
        if (mDataList == null || mDataList.size() == 0) {
            Log.e(TAG, "DataList must be not empty!");
            return false;
        }
        return true;
    }

    public void start() {
        if (!isValid()) {
            return;
        }

        if (mCurrentPosition > mDataList.size() - 1) {
            mCurrentPosition = 0;
        }
        initViewPager();
        initIndicator();

        setCurrentTitle(mCurrentPosition);
        mIsStarted = true;
        update();
    }

    void update() {
        if (!isValid()) {
            return;
        }
        boolean running = mIsVisible && mIsResumed && mIsStarted && mIsAuto && mDataList.size() > 1 && (isLoop() || mCurrentPosition + 1 < mDataList.size());
        if (running != mIsRunning) {
            if (running) {
                postDelayed(mRunnable, mDelay);
            } else {
                removeCallbacks(mRunnable);
            }
            mIsRunning = running;
        }
        if (DEBUG) {
            Log.e("ezy", "update:running=" + mIsRunning + ",visible=" + mIsVisible + ",started=" + mIsStarted + ",resumed=" + mIsResumed);
            Log.e("ezy", "update:auto=" + mIsAuto + ",loop=" + isLoop() + ",size=" + mDataList.size() + ",current=" + mCurrentPosition);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mIsVisible = false;
        update();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mIsVisible = visibility == VISIBLE;
        update();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
        case MotionEvent.ACTION_DOWN:
            mIsResumed = false;
            update();
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            mIsResumed = true;
            update();
            break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private int dp2px(float dp) {
        return (int) (dp * mDm.density + 0.5f);
    }

    private float sp2px(float sp) {
        return sp * mDm.scaledDensity;
    }

    private ViewPager.OnPageChangeListener mInternalPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {

            if (DEBUG) {
                Log.e("ezy", "onPageSelected, pos=" + mCurrentPosition);
            }
            mCurrentPosition = position % mDataList.size();
            setCurrentTitle(mCurrentPosition);
            vBottomBar.setVisibility(mCurrentPosition == mDataList.size() - 1 && !mBarVisibleWhenLast ? GONE : VISIBLE);

            if (mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageScrollStateChanged(state);
            }
        }
    };

    private PagerAdapter mInternalPagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View inflate = mViewFactory.create(mDataList.get(position), position, container);
            container.addView(inflate);
            return inflate;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    };

    private static void setDuration(ViewPager pager, int duration) {
        try {
            FixedSpeedScroller scroller = new FixedSpeedScroller(pager.getContext(), new AccelerateDecelerateInterpolator(), duration);
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            field.set(pager, scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class FixedSpeedScroller extends Scroller {
        private int mDuration = 450;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, int duration) {
            super(context, interpolator);
            this.mDuration = duration;
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, this.mDuration);
        }
    }
}