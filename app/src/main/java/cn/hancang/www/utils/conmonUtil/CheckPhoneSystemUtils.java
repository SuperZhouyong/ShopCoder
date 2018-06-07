package cn.hancang.www.utils.conmonUtil;

import android.os.Build;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Description: 绝无Bug
 * Data：2018/1/2 0002-下午 17:40
 * Blog：Super简单
 * Author: ZhouYong
 */

public class CheckPhoneSystemUtils {
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    /**
     * 检测MIUI
     *
     * @return
     */
    public static boolean isMIUI() {
        try {
            final BuildProperties prop = BuildProperties.newInstance();
            return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
        } catch (final IOException e) {
            return false;
        }
    }

    /**
     * 检测Flyme
     *
     * @return
     */
    public static boolean isFlyme() {
        try { // Invoke Build.hasSmartBar()
            final Method method = Build.class.getMethod("hasSmartBar");
            return method != null;
        } catch (final Exception e) {
            return false;
        }
    }
}
