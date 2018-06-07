package cn.hancang.www.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.utils.conmonUtil.LogUtils;

import java.util.List;


/**
 * Created by dongjunkun on 2015/6/17.
 */
public class DropDownMenu extends LinearLayout {

    //顶部菜单布局
    private LinearLayout tabMenuView;
    //底部容器，包含popupMenuViews，maskView
    private FrameLayout containerView;
    //弹出菜单父布局
    private FrameLayout popupMenuViews;
    //遮罩半透明View，点击可关闭DropDownMenu
    private View maskView;
    //tabMenuView里面选中的tab位置，-1表示未选中
    private int current_tab_position = -1;

    //分割线颜色
    private int dividerColor = 0xffcccccc;
    //tab选中颜色
    private int textSelectedColor = 0xff890c85;
    //tab未选中颜色
    private int textUnselectedColor = 0xff111111;
    //遮罩颜色
    private int maskColor = 0x00000000;
    //tab字体大小
    private int menuTextSize = 14;
    //tab文字与图标的间距
    private int drawablePadding = -50;
    // tab文字距右侧的padding值
    private int padRight = 20;

    public void setShowCollected(boolean showCollected) {
        isShowCollected = showCollected;
    }

    private boolean isShowCollected = false;
    private boolean clickCollected = false;
    //tab选中图标
    private int menuSelectedIcon;
    //tab未选中图标
    private int menuUnselectedIcon;
    private Drawable menuSelect;
    private Drawable menuUnSelct;
    private int menuBackgroundColor;
    private int underlineColor;

    //    private boolean isCollectStatus = false;

    public DropDownMenu(Context context) {
        super(context, null);
    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);

        //为DropDownMenu添加自定义属性
        menuBackgroundColor = 0xffffff;
        underlineColor = 0xffcccccc;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenu);
        underlineColor = a.getColor(R.styleable.DropDownMenu_ddunderlineColor, underlineColor);
        dividerColor = a.getColor(R.styleable.DropDownMenu_dddividerColor, dividerColor);
        textSelectedColor = a.getColor(R.styleable.DropDownMenu_ddtextSelectedColor, textSelectedColor);
        textUnselectedColor = a.getColor(R.styleable.DropDownMenu_ddtextUnselectedColor, textUnselectedColor);
        menuBackgroundColor = a.getColor(R.styleable.DropDownMenu_ddmenuBackgroundColor, menuBackgroundColor);
        maskColor = a.getColor(R.styleable.DropDownMenu_ddmaskColor, maskColor);
        menuTextSize = a.getDimensionPixelSize(R.styleable.DropDownMenu_ddmenuTextSize, menuTextSize);
        menuSelectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuSelectedIcon, menuSelectedIcon);
        menuUnselectedIcon = a.getResourceId(R.styleable.DropDownMenu_ddmenuUnselectedIcon, menuUnselectedIcon);
        /*初始化 连个选择状态*/
        menuSelect = getResources().getDrawable(menuSelectedIcon);
        menuUnSelct = getResources().getDrawable(menuUnselectedIcon);
        menuSelect.setBounds(0, 0, dpTpPx(13), dpTpPx(7));
        menuUnSelct.setBounds(0, 0, dpTpPx(13), dpTpPx(7));
        a.recycle();

        //初始化tabMenuView并添加到tabMenuView
        tabMenuView = new LinearLayout(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tabMenuView.setOrientation(HORIZONTAL);
        tabMenuView.setBackgroundColor(menuBackgroundColor);
        tabMenuView.setLayoutParams(params);
        addView(tabMenuView, 0);

        //为tabMenuView添加下划线
        View underLine = new View(getContext());
        underLine.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpTpPx(0.5f)));
        underLine.setBackgroundColor(underlineColor);
        addView(underLine, 1);

        //初始化containerView并将其添加到DropDownMenu
        containerView = new FrameLayout(context);
     /*   if (isCollectStatus) {
            containerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        } else {

        }*/
        containerView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        addView(containerView, 2);

    }

    public void VisShow(boolean b) {
        tabMenuView.setVisibility(b ? VISIBLE : GONE);
    }

    /**
     * 初始化DropDownMenu
     *
     * @param tabTexts
     * @param popupViews
     * @param contentView
     */
    public void setDropDownMenu(@NonNull List<String> tabTexts, @NonNull List<View> popupViews, @NonNull View contentView) {
        tabMenuView.removeAllViews();
        containerView.removeAllViews();

        if (tabTexts.size() != popupViews.size()) {
            throw new IllegalArgumentException("params not match, tabTexts.size() should be equal popupViews.size()");
        }
        for (int i = 0; i < tabTexts.size(); i++) {
            addTab(tabTexts, i);
        }


//        addTabCollect(isShowCollected);


        containerView.addView(contentView, 0);
        maskView = new View(getContext());
     /*   if (isCollectStatus) {
            maskView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        } else {

        }*/
        maskView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        maskView.setBackgroundColor(maskColor);
        maskView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                closeMenu();
            }
        });
        containerView.addView(maskView, 1);
        maskView.setVisibility(GONE);

        popupMenuViews = new FrameLayout(getContext());
        popupMenuViews.setVisibility(GONE);
      /*  FrameLayout.LayoutParams poplayoutParams = (FrameLayout.LayoutParams) popupMenuViews.getLayoutParams();
        poplayoutParams.height = dpTpPx(216);
        popupMenuViews.setLayoutParams(poplayoutParams);*/
        containerView.addView(popupMenuViews, 2);

        for (int i = 0; i < popupViews.size(); i++) {
            popupViews.get(i).setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            popupMenuViews.addView(popupViews.get(i), i);
        }

    }

    /*private void addTabCollect(boolean isShowCollected) {
        if (isShowCollected) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_collect, null, false);
//            LinearLayout mLinlayout = new LinearLayout(getContext());
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_collect);

            LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
//            inflate.setOrientation(HORIZONTAL);
//            params.gravity=Gravity.CENTER_VERTICAL;
            inflate.setBackgroundColor(menuBackgroundColor);
            inflate.setLayoutParams(params);
            tabMenuView.addView(inflate);
            inflate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemDropClickListener != null) {
                        clickCollected = !clickCollected;
                        onItemDropClickListener.LinearLayoutClickerListener(clickCollected);
                        imageView.setImageResource(clickCollected?R.mipmap.gouxuan_s:R.mipmap.gouxuan);
                    }
                }
            });
        }

    }
*/
    private void addTab(@NonNull List<String> tabTexts, int i) {

        final TextView tab = new TextView(getContext());

        tab.setSingleLine();
        tab.setEllipsize(TextUtils.TruncateAt.END);
        tab.setGravity(Gravity.CENTER);
        tab.setMaxEms(2);
        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, menuTextSize);
//        tab.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tab.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
        tab.setTextColor(textUnselectedColor);
        tab.setCompoundDrawables(null, null, menuUnSelct, null);
        /*
        * 如果显示不正常  调试这里
        * */
        tab.setCompoundDrawablePadding(drawablePadding);//设置文字图片的间距
        tab.setText(tabTexts.get(i));
        tab.setPadding(dpTpPx(5), dpTpPx(12), dpTpPx(padRight), dpTpPx(12));//dpTpPx(20)
        //添加点击事件
        tab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMenu(tab);
            }
        });
        tabMenuView.addView(tab);
        //添加分割线
        if (i < tabTexts.size() - 1) {
            View view = new View(getContext());
            view.setLayoutParams(new LayoutParams(dpTpPx(0.5f), ViewGroup.LayoutParams.MATCH_PARENT));
            view.setBackgroundColor(dividerColor);
            tabMenuView.addView(view);
        }
    }

    /**
     * 改变tab文字
     *
     * @param text
     */
    public void setTabText(String text) {
        if (current_tab_position != -1) {

            ((TextView) tabMenuView.getChildAt(current_tab_position)).setText(text);
        }

    }

    // 设置最后䘝隐藏
    public void SetTextGone(Boolean isShow) {
        for (int i = 0; i < tabMenuView.getChildCount(); i = i + 2) {
            if (i == 4) {
                ((TextView) tabMenuView.getChildAt(i)).setVisibility(isShow ? VISIBLE : GONE);
            }
        }
    }

    /*
    * 修改 所有的  字体
    * */
    public void settabTexts(List<String> texts) {
        for (int i = 0; i < tabMenuView.getChildCount(); i = i + 2) {
            ((TextView) tabMenuView.getChildAt(i)).setText(texts.get(i == 0 ? 0 : i / 2));
            ((TextView) tabMenuView.getChildAt(i)).setTextColor(getResources().getColor(R.color.font_2));


        }

    }

    public void setPadRight(int padRight) {
        this.padRight = padRight;
    }

    /**
     * 改变tab文字与图标的间距
     *
     * @param drawablePadding
     */
    public void setDrawablePadding(int drawablePadding) {
        this.drawablePadding = drawablePadding;
    }

    /**
     * 改变tab字体的颜色
     */
    public void setTabTextColor(int color) {
        if (current_tab_position != -1) {
            LogUtils.logd("我是当前点击的tabView" + current_tab_position);
            ((TextView) tabMenuView.getChildAt(current_tab_position)).setTextColor(color);
        }
    }

    public void setTabClickable(boolean clickable) {
        for (int i = 0; i < tabMenuView.getChildCount(); i = i + 2) {
            tabMenuView.getChildAt(i).setClickable(clickable);
        }
    }

    /**
     * 关闭菜单
     */
    public void closeMenu() {
        if (current_tab_position != -1) {
//            ((TextView) tabMenuView.getChildAt(current_tab_position)).setTextColor(textUnselectedColor);
            ((TextView) tabMenuView.getChildAt(current_tab_position)).setCompoundDrawables(null, null,
                    menuUnSelct, null);
            popupMenuViews.setVisibility(View.GONE);
            popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_out));
            maskView.setVisibility(GONE);
            maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_out));
            current_tab_position = -1;
        }

    }

    public void isCollectStatus(boolean isCollectStatus) {
//        this.isCollectStatus = isCollectStatus;
    }

    /**
     * DropDownMenu是否处于可见状态
     *
     * @return
     */
    public boolean isShowing() {
        return current_tab_position != -1;
    }

    /**
     * 切换菜单
     *
     * @param target
     */
    private void switchMenu(View target) {
        System.out.println(current_tab_position);

        for (int i = 0; i < tabMenuView.getChildCount(); i = i + 2) {
            if (target == tabMenuView.getChildAt(i)) {
                if (current_tab_position == i) {
                    closeMenu();
                } else {
                    if (current_tab_position == -1) {
                        popupMenuViews.setVisibility(View.VISIBLE);
                        popupMenuViews.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_menu_in));
                        // 设置收藏
//                        maskView.setVisibility(isCollectStatus ? GONE : VISIBLE);
                        maskView.setVisibility(VISIBLE);
                        maskView.setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dd_mask_in));
                        popupMenuViews.getChildAt(i / 2).setVisibility(View.VISIBLE);
                        FrameLayout.LayoutParams popLayoutParams = (FrameLayout.LayoutParams) popupMenuViews.getLayoutParams();
//                        popLayoutParams.height = dpTpPx(300);
//                        popLayoutParams.height = isCollectStatus ? 0 : dpTpPx(300);

//                        popupMenuViews.setLayoutParams(popLayoutParams);
                    } else {
                        popupMenuViews.getChildAt(i / 2).setVisibility(View.VISIBLE);
                        FrameLayout.LayoutParams popLayoutParams = (FrameLayout.LayoutParams) popupMenuViews.getLayoutParams();
//                        popLayoutParams.height = dpTpPx(300);
//                        popupMenuViews.setLayoutParams(popLayoutParams);
                    }
                    current_tab_position = i;
                    LogUtils.logd("我是当前点击的tabView" + current_tab_position / 2);

                    ((TextView) tabMenuView.getChildAt(i)).setTextColor(textSelectedColor);

                    ((TextView) tabMenuView.getChildAt(i)).setCompoundDrawables(null, null,
                            menuSelect, null);
                    // 点击监听
                    if (onItemDropClickListener != null) {
                        onItemDropClickListener.DropOnclickListener(current_tab_position / 2);
                    }
                }
            } else {
                ((TextView) tabMenuView.getChildAt(i)).setTextColor(textUnselectedColor);
                ((TextView) tabMenuView.getChildAt(i)).setCompoundDrawables(null, null,
                        menuUnSelct, null);
                popupMenuViews.getChildAt(i / 2).setVisibility(View.GONE);
            }
        }
    }

    public int dpTpPx(float value) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, dm) + 0.5);
    }

    public interface OnItemDropClickListener {
        void DropOnclickListener(int position);

        void LinearLayoutClickerListener(boolean isCollect);
    }

    private OnItemDropClickListener onItemDropClickListener;

    public void setOnItemDropClickListener(OnItemDropClickListener onItemThreeClickListener) {
        this.onItemDropClickListener = onItemThreeClickListener;
    }
}
