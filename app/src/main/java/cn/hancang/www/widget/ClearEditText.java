package cn.hancang.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import cn.hancang.www.R;
import cn.hancang.www.utils.conmonUtil.LogUtils;


/**
 * 自带清除按钮的输入框，清除按钮的作用是清空输入框的输入内容；
 * 需要注意的是，清除按钮会占据drawableRight的位置，所以设置drawableRight会无效
 *
 */
public class ClearEditText extends AppCompatEditText implements View.OnFocusChangeListener {
    /**
     * 默认的清除按钮图标资源
     */
    private static final int ICON_CLEAR_DEFAULT = R.mipmap.clear_all;
    private boolean IsFcuse = false;
    private boolean canClick = false;

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        IsFcuse = hasFocus;
        updateIconClear();
    }

    /**
     * 清楚按钮的图标
     */
    public interface SearchInterface {
        void UpdateSearchResult(String ImportText);

        void UpdateEmptyImpore();
    }

    private SearchInterface msearchInterface;

    public void setSearchInterface(SearchInterface msearchInterface) {
        this.msearchInterface = msearchInterface;
    }

    private Drawable drawableClear;

    public ClearEditText(Context context) {
        super(context);
        init(context, null);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // 获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ClearEditText);
        // 获取清除按钮图标资源
        int iconClear =
                typedArray.getResourceId(R.styleable.ClearEditText_iconClear, ICON_CLEAR_DEFAULT);
        drawableClear = getResources().getDrawable(iconClear);
        drawableClear.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.width_right), getResources().getDimensionPixelSize(R.dimen.width_right));
        updateIconClear();
        typedArray.recycle();

        // 设置TextWatcher用于更新清除按钮显示状态
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateIconClear();
                if (msearchInterface != null) {
                    String ImportText = getText().toString().trim();
                    if (ImportText.length() <= 1) {
                        return;
                    }

                    if (TextUtils.isEmpty(ImportText)) {
                        msearchInterface.UpdateEmptyImpore();
                    } else {
                        msearchInterface.UpdateSearchResult(ImportText);
                    }
                }
            }
        });

        setOnFocusChangeListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            // 点击是的 x 坐标
            int xDown = (int) event.getX();
            // 清除按钮的起始区间大致为[getWidth() - getCompoundPaddingRight(), getWidth()]，
            // 点击的x坐标在此区间内则可判断为点击了清除按钮
            int compoundPaddingRight = getCompoundPaddingRight();
            int width = getWidth();
            if ((xDown >= (width - compoundPaddingRight)) && (xDown < width)) {
                LogUtils.logd("Edittext点击范围" + "我是点击范围");
                // 清空文本
                setText("");
                if (msearchInterface != null) {
                    msearchInterface.UpdateEmptyImpore();
                }
            }
            LogUtils.logd("Edittext点击范围----" + xDown + "----" + (width - compoundPaddingRight) + "----" + width + "----" + compoundPaddingRight);
            LogUtils.logd("Edittext点击范围----" + ((xDown >= (width - compoundPaddingRight)) && (xDown < width)));
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            if (canClick){
                return false;
            }
        }
        return super.onTouchEvent(event);
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 更新清除按钮图标显示
     */
    public void updateIconClear() {
        // 获取设置好的drawableLeft、drawableTop、drawableRight、drawableBottom
        Drawable[] drawables = getCompoundDrawables();
        //输入框有输入内容才显示删除按钮
        if (length() > 0 && IsFcuse) {
            setCompoundDrawables(drawables[0], drawables[1], drawableClear,
                    drawables[3]);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], null,
                    drawables[3]);
        }
    }

    /**
     * 设置清除按钮图标样式
     *
     * @param resId 图标资源id
     */
    public void setIconClear(@DrawableRes int resId) {
        drawableClear = getResources().getDrawable(resId);
        updateIconClear();
    }
}
