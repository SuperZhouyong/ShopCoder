package cn.hancang.www.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

//import com.tinfinite.saas.MyLog;
//import com.tinfinite.saas.utils.AppUtil;

/**
 * Created by caiying on 07/04/15.
 */
public class Preferences extends LinearLayout {

    public Preferences(Context context) {
        super(context);
    }

    public Preferences(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public Preferences(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

  /*  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Preferences(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void createPreferences(PreferenceAbstractItem... items) {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutParams dividerParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        setOrientation(VERTICAL);
//        if(items.length == 1){
//            this.addView(new PreferenceLineDivider(getContext()).createView(), dividerParams);
//        }
        for (int i = 0; i < items.length; i++) {
            this.addView(items[i].createView(), layoutParams);
//            MyLog.CAI_YING.i(" createPreferences : " + i);
            if (i != items.length - 1) {
                this.addView(new PreferenceLineDivider(getContext()).createView(), dividerParams);
            }
        }
//        if(items.length == 1){
//            this.addView(new PreferenceLineDivider(getContext()).createView(), dividerParams);
//        }
        this.setPadding(0, AppUtil.dp(20), 0, 0);
    }

    public void removePreferenceAll() {
//        this.removeViewAt(index);
        this.removeAllViews();
    }*/
}
