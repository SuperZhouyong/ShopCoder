package com.intention.sqtwin.utils.conmonUtil;

import android.app.ActivityManager;
import android.content.Context;

import com.intention.sqtwin.app.BaseApplication;
import com.intention.sqtwin.base.BaseFragment;

/**
 * @data 2017/4/25 0025
 * @aurher Administrator
 */

public class ActivityUtil {
    public static String getRunningActivityName() {
        ActivityManager manager = (ActivityManager) BaseApplication.getAppContext().getSystemService(Context.ACTIVITY_SERVICE);
        String activityName = manager.getRunningTasks(1).get(0).topActivity.getClassName();
        String name = activityName.substring(activityName.lastIndexOf(".") + 1, activityName.length());
        return name;
    }

    /**
     * 获取当前显示的Fragment名称
     *
     * @return
     */
    public static String getCurrentFragmentName(BaseFragment fragment) {
        String fragName = fragment.getClass().toString();
        fragName = fragName.substring(fragName.lastIndexOf(".") + 1, fragName.length());
        return fragName;
    }
}
