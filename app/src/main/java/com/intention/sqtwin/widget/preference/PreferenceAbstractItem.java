/*
package com.intention.sqtwin.widget.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.common.base.Strings;


import me.caiying.library.viewpagerindicator.BadgeView;


*/
/**
 * Created by caiying on 07/04/15.
 *//*

public abstract class PreferenceAbstractItem extends LinearLayout {
    protected ImageView mIndicatorImageView;
    protected TextView mTitleTextView;
    protected TextView mSubDetailTextView;
    protected RelativeLayout mRightWidgetContainer;
    protected OnClickListener mOnClickListener;
    protected LinearLayout mItemLayout;
    private View mBadgeViewHolder;
    protected BadgeView mBadgeView;

    public PreferenceAbstractItem(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_preference_item, this);
        mIndicatorImageView = (ImageView) findViewById(R.id.indicator);
        mTitleTextView = (TextView) findViewById(R.id.title);
        mRightWidgetContainer = (RelativeLayout) findViewById(R.id.container);
        mSubDetailTextView = (TextView) findViewById(R.id.txt_detail);
        mBadgeViewHolder = findViewById(R.id.badge_holder);
        mItemLayout = (LinearLayout) findViewById(R.id.item_layout);
    }

    public PreferenceAbstractItem createView() {
        setBackgroundResource(R.drawable.preference_item_selector);
        if (mOnClickListener != null) {
            this.setOnClickListener(mOnClickListener);
        }

        if (createRightWidget() != null) {
            mRightWidgetContainer.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            mRightWidgetContainer.addView(createRightWidget(), layoutParams);
        }
        return this;
    }

    public void setTitle(String title) {
        if (!Strings.isNullOrEmpty(title)) {
            mTitleTextView.setText(title);
        }
    }

    public String getTitle() {
        return mTitleTextView.getText().toString();
    }

    public void enbaleIndicator(Drawable drawable) {
        mIndicatorImageView.setVisibility(View.VISIBLE);
        mIndicatorImageView.setImageDrawable(drawable);
    }

    public BadgeView getBadgeView() {
        if (mBadgeView == null) {
            mBadgeView = new BadgeView(getContext(), mBadgeViewHolder);
            mBadgeView.setVisibility(VISIBLE);
            mBadgeView.setBadgePosition(BadgeView.POSITION_CENTER);
            mBadgeView.setBadgeMargin(0, 0);
        }
        return mBadgeView;
    }

    protected View createRightWidget() {
        return null;
    }
}
*/
