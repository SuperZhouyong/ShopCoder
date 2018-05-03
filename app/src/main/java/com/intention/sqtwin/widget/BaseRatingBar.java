/*
package com.intention.sqtwin.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.intention.sqtwin.R;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Description: 绝无Bug
 * Data：2017/11/9 0009-上午 11:36
 * Blog：Super简单
 * Author: ZhouYong
 *//*


public class BaseRatingBar extends LinearLayout {
    public interface OnRatingChangeListener {
        void onRatingChange(BaseRatingBar ratingBar, float rating);
    }

    public static final String TAG = "SimpleRatingBar";

    private static final int MAX_CLICK_DISTANCE = 5;
    private static final int MAX_CLICK_DURATION = 200;

    private final DecimalFormat mDecimalFormat;

    private int mNumStars;
    private int mPadding = 3;
    private int mStarWidth;
    private int mStarHeight;
    private float mRating = -1;
    private float mStepSize = 1f;
    private float mPreviousRating = 0;
    private boolean mIsTouchable = false;
    private boolean mClearRatingEnabled = true;

    private float mStartX;
    private float mStartY;

    private Drawable mEmptyDrawable;
    private Drawable mFilledDrawable;

    private OnRatingChangeListener mOnRatingChangeListener;

    protected List<PartialView> mPartialViews;

    public BaseRatingBar(Context context) {
        this(context, null);
    }

    */
/* Call by xml layout *//*

    public BaseRatingBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    */
/**
     * @param context      context
     * @param attrs        attributes from XML => app:mainText="mainText"
     * @param defStyleAttr attributes from default style (Application theme or activity theme)
     *//*

    public BaseRatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatingBarAttributes);
        float rating = typedArray.getFloat(R.styleable.RatingBarAttributes_rating, mRating);
        mNumStars = typedArray.getInt(R.styleable.RatingBarAttributes_numStars, mNumStars);
        mPadding = typedArray.getDimensionPixelSize(R.styleable.RatingBarAttributes_starPadding, mPadding);
        mStarWidth = typedArray.getDimensionPixelSize(R.styleable.RatingBarAttributes_starWidth, 0);
        mStarHeight = typedArray.getDimensionPixelSize(R.styleable.RatingBarAttributes_starHeight, 0);
        mStepSize = typedArray.getFloat(R.styleable.RatingBarAttributes_stepSize, mStepSize);
        mEmptyDrawable = typedArray.hasValue(R.styleable.RatingBarAttributes_drawableEmpty) ? ContextCompat.getDrawable(context, typedArray.getResourceId(R.styleable.RatingBarAttributes_drawableEmpty, View.NO_ID)) : null;
        mFilledDrawable = typedArray.hasValue(R.styleable.RatingBarAttributes_drawableFilled) ? ContextCompat.getDrawable(context, typedArray.getResourceId(R.styleable.RatingBarAttributes_drawableFilled, View.NO_ID)) : null;
        mIsTouchable = typedArray.getBoolean(R.styleable.RatingBarAttributes_touchable, mIsTouchable);
        mClearRatingEnabled = typedArray.getBoolean(R.styleable.RatingBarAttributes_clearRatingEnabled, mClearRatingEnabled);
        typedArray.recycle();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        mDecimalFormat = new DecimalFormat("#.##", symbols);

        verifyParamsValue();

        initRatingView();
        setRating(rating);


    }

    private void verifyParamsValue() {
        if (mNumStars <= 0) {
            mNumStars = 5;
        }

        if (mPadding < 0) {
            mPadding = 0;
        }

        if (mEmptyDrawable == null) {
            mEmptyDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.ratingbar_empty);
        }

        if (mFilledDrawable == null) {
            mFilledDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.ratingbar_filled);
        }

        if (mStepSize > 1.0f) {
            mStepSize = 1.0f;
        } else if (mStepSize < 0.1f) {
            mStepSize = 0.1f;
        }

    }

    private void initRatingView() {
        mPartialViews = new ArrayList<>();
        // 之间间距
        mStarWidth += mPadding;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                mStarWidth == 0 ? LinearLayout.LayoutParams.WRAP_CONTENT : mStarWidth,
                mStarHeight == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT : mStarHeight);

//        Rect bounds = mFilledDrawable.getBounds();
//        LogUtils.logd(TAG + "----" + bounds.left + "---" + bounds.top + "---" + bounds.right + "---" + bounds.bottom);
       */
/* mFilledDrawable.setBounds(0,0,mStarWidth,mStarHeight);
        mEmptyDrawable.setBounds(0,0,mStarWidth,mStarHeight);*//*

//        LogUtils.logd(TAG + "----" + bounds.left + "---" + bounds.top + "---" + bounds.right + "---" + bounds.bottom);
        for (int i = 1; i <= mNumStars; i++) {
            PartialView partialView = getPartialView(i, mFilledDrawable, mEmptyDrawable);
//            ViewGroup.LayoutParams layoutParams = partialView.getLayoutParams();


          */
/* if (layoutParams!=null){
               layoutParams.width = mStarWidth ;
               layoutParams.height = mStarHeight;
               partialView.setLayoutParams(layoutParams);
               addView(partialView);
               LogUtils.logd(TAG+"----"+"null");
           }else {
               addView(partialView, params);
               LogUtils.logd(TAG+"----"+"!!!!null");

           }*//*


            mPartialViews.add(partialView);
            addView(partialView, params);


//
            LogUtils.logd(TAG + "----" + partialView.getWidth() + "---" + partialView.getHeight() + "---" + partialView.getMeasuredWidth() + "---" + partialView.getMeasuredHeight() + "---" + getWidth() + "---" + getMeasuredWidth());
        }
    }

    private PartialView getPartialView(final int ratingViewId, Drawable filledDrawable, Drawable emptyDrawable) {
        PartialView partialView = new PartialView(getContext());

        partialView.setId(ratingViewId);
        partialView.setTag(ratingViewId);

        partialView.setPadding(mPadding, 0, 0, 0);
        partialView.setFilledDrawable(filledDrawable);
        partialView.setEmptyDrawable(emptyDrawable);
        return partialView;
    }

    */
/**
     * Retain this method to let other RatingBar can custom their decrease animation.
     *//*

    protected void emptyRatingBar() {
        fillRatingBar(0);
    }

    */
/**
     * Use {maxIntOfRating} because if the rating is 3.5
     * the view which id is 3 also need to be filled.
     *//*

    protected void fillRatingBar(final float rating) {
        for (PartialView partialView : mPartialViews) {
            int ratingViewId = (int) partialView.getTag();
            double maxIntOfRating = Math.ceil(rating);

            if (ratingViewId > maxIntOfRating) {
                partialView.setEmpty();
                continue;
            }

            if (ratingViewId == maxIntOfRating) {
                partialView.setPartialFilled(rating);
            } else {
                partialView.setFilled();
            }
        }
    }

    public void setNumStars(int numStars) {
        if (numStars <= 0) {
            return;
        }

        mPartialViews.clear();
        removeAllViews();

        mNumStars = numStars;
        initRatingView();
    }

    public int getNumStars() {
        return mNumStars;
    }

    public void setRating(float rating) {
        if (rating > mNumStars) {
            rating = mNumStars;
        }

        if (rating < 0) {
            rating = 0;
        }

        if (mRating == rating) {
            return;
        }

        mRating = rating;

        if (mOnRatingChangeListener != null) {
            mOnRatingChangeListener.onRatingChange(this, mRating);
        }

        fillRatingBar(rating);
    }

    public float getRating() {
        return mRating;
    }

    public void setStarPadding(int ratingPadding) {
        if (ratingPadding < 0) {
            return;
        }

        mPadding = ratingPadding;

        for (PartialView partialView : mPartialViews) {
            partialView.setPadding(mPadding, mPadding, mPadding, mPadding);
        }
    }

    public int getStarPadding() {
        return mPadding;
    }

    public void setEmptyDrawableRes(@DrawableRes int res) {
        setEmptyDrawable(ContextCompat.getDrawable(getContext(), res));
    }

    public void setFilledDrawableRes(@DrawableRes int res) {
        setFilledDrawable(ContextCompat.getDrawable(getContext(), res));
    }

    public void setEmptyDrawable(Drawable drawable) {
        mEmptyDrawable = drawable;

        for (PartialView partialView : mPartialViews) {
            partialView.setEmptyDrawable(drawable);
        }
    }

    public void setFilledDrawable(Drawable drawable) {
        mFilledDrawable = drawable;

        for (PartialView partialView : mPartialViews) {
            partialView.setFilledDrawable(drawable);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isTouchable()) {
            return false;
        }

        float eventX = event.getX();
        float eventY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = eventX;
                mStartY = eventY;
                mPreviousRating = mRating;

//                Avoid rating changes two times when is a click event.
//                handleMoveEvent(eventX);
                break;
            case MotionEvent.ACTION_MOVE:
                handleMoveEvent(eventX);
                break;
            case MotionEvent.ACTION_UP:
                if (!isClickEvent(mStartX, mStartY, event)) {
                    return false;
                }

                handleClickEvent(eventX);
        }

        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    private void handleMoveEvent(float eventX) {
        for (PartialView partialView : mPartialViews) {
            if (eventX < partialView.getWidth() / 10f) {
                setRating(0);
                return;
            }

            if (!isPositionInRatingView(eventX, partialView)) {
                continue;
            }

            float rating = calculateRating(eventX, partialView);

            if (mRating != rating) {
                setRating(rating);
            }
        }
    }

    private float calculateRating(float eventX, PartialView partialView) {
        float ratioOfView = Float.parseFloat(mDecimalFormat.format((eventX - partialView.getLeft()) / partialView.getWidth()));
        float steps = Math.round(ratioOfView / mStepSize) * mStepSize;
        return Float.parseFloat(mDecimalFormat.format((int) partialView.getTag() - (1 - steps)));
    }

    private void handleClickEvent(float eventX) {
        for (PartialView partialView : mPartialViews) {
            if (!isPositionInRatingView(eventX, partialView)) {
                continue;
            }

            float rating = mStepSize == 1 ? (int) partialView.getTag() : calculateRating(eventX, partialView);

            if (mPreviousRating == rating && isClearRatingEnabled()) {
                setRating(0);
            } else {
                setRating(rating);
            }
            break;
        }
    }

    private boolean isPositionInRatingView(float eventX, View ratingView) {
        return eventX > ratingView.getLeft() && eventX < ratingView.getRight();
    }

    private boolean isClickEvent(float startX, float startY, MotionEvent event) {
        float duration = event.getEventTime() - event.getDownTime();
        if (duration > MAX_CLICK_DURATION) {
            return false;
        }

        float differenceX = Math.abs(startX - event.getX());
        float differenceY = Math.abs(startY - event.getY());
        return !(differenceX > MAX_CLICK_DISTANCE || differenceY > MAX_CLICK_DISTANCE);
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        mOnRatingChangeListener = onRatingChangeListener;
    }

    public boolean isTouchable() {
        return mIsTouchable;
    }

    public void setTouchable(boolean touchable) {
        this.mIsTouchable = touchable;
    }

    public void setClearRatingEnabled(boolean enabled) {
        this.mClearRatingEnabled = enabled;
    }

    public boolean isClearRatingEnabled() {
        return mClearRatingEnabled;
    }

    public float getStepSize() {
        return mStepSize;
    }

    public void setStepSize(@FloatRange(from = 0.1, to = 1.0) float stepSize) {
        this.mStepSize = stepSize;
    }
}

*/
