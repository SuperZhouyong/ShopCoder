/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intention.sqtwin.utils.conmonUtil;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.intention.sqtwin.app.BaseApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtil {

    private static final Hashtable<String, Typeface> typefaceCache = new Hashtable<String, Typeface>();
    private static int prevOrientation = -10;
    private static boolean waitingForSms = false;
    private static final Object smsLock = new Object();

    public static int statusBarHeight = 0;
    public static float density = 1;
    public static Point displaySize = new Point();
    public static Integer photoSize = null;
    public static DisplayMetrics displayMetrics = new DisplayMetrics();
    public static int leftBaseline;
    private static Boolean isTablet = null;

    static {
        density = BaseApplication.getAppContext().getResources().getDisplayMetrics().density;
        leftBaseline = isTablet() ? 80 : 72;
        checkDisplaySize();
    }

    public static Typeface getTypeface(String assetPath) {
        synchronized (typefaceCache) {
            if (!typefaceCache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(BaseApplication.getAppContext().getAssets(), assetPath);
                    typefaceCache.put(assetPath, t);
                } catch (Exception e) {
//                    MyLog.CAI_YING.e("Could not getPhoto typeface '" + assetPath + "' because " + e.getMessage());
                    return null;
                }
            }
            return typefaceCache.get(assetPath);
        }
    }

    public static boolean isWaitingForSms() {
        boolean value = false;
        synchronized (smsLock) {
            value = waitingForSms;
        }
        return value;
    }

    public static void setWaitingForSms(boolean value) {
        synchronized (smsLock) {
            waitingForSms = value;
        }
    }

    public static void showKeyboard(View view) {
        if (view == null) {
            return;
        }
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static boolean isKeyboardShowed(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        return inputManager.isActive(view);
    }

    public static void hideKeyboard(View view) {
        if (view == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!imm.isActive()) {
            return;
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static File getCacheDir() {
        String state = null;
        try {
            state = Environment.getExternalStorageState();
        } catch (Exception e) {
//            MyLog.CAI_YING.e(e.getMessage());
        }
        if (state == null || state.startsWith(Environment.MEDIA_MOUNTED)) {
            try {
                File file = BaseApplication.getAppContext().getExternalCacheDir();
                if (file != null) {
                    return file;
                }
            } catch (Exception e) {
//                MyLog.CAI_YING.e(e.getMessage());
            }
        }
        try {
            File file = BaseApplication.getAppContext().getCacheDir();
            if (file != null) {
                return file;
            }
        } catch (Exception e) {
//            MyLog.CAI_YING.e(e.getMessage());
        }
        return new File("");
    }

    public static int dp(float value) {
        return (int) Math.ceil(density * value);
    }

    public static float dpf2(float value) {
        return density * value;
    }

    public static void checkDisplaySize() {
        try {
            WindowManager manager = (WindowManager) BaseApplication.getAppContext().getSystemService(Context.WINDOW_SERVICE);
            if (manager != null) {
                Display display = manager.getDefaultDisplay();
                if (display != null) {
                    display.getMetrics(displayMetrics);
                    if (Build.VERSION.SDK_INT < 13) {
                        displaySize.set(display.getWidth(), display.getHeight());
                    } else {
                        display.getSize(displaySize);
                    }
//                    MyLog.CAI_YING.e("display size = " + displaySize.x + " " + displaySize.y + " " + displayMetrics.xdpi + "x" + displayMetrics.ydpi);
                }
            }
        } catch (Exception e) {
//            MyLog.CAI_YING.e(e.getMessage());
        }
    }

    public static float getPixelsInCM(float cm, boolean isX) {
        return (cm / 2.54f) * (isX ? displayMetrics.xdpi : displayMetrics.ydpi);
    }

    public static long makeBroadcastId(int id) {
        return 0x0000000100000000L | ((long) id & 0x00000000FFFFFFFFL);
    }

    public static int getMyLayerVersion(int layer) {
        return layer & 0xffff;
    }

    public static int getPeerLayerVersion(int layer) {
        return (layer >> 16) & 0xffff;
    }

    public static int setMyLayerVersion(int layer, int version) {
        return layer & 0xffff0000 | version;
    }

    public static int setPeerLayerVersion(int layer, int version) {
        return layer & 0x0000ffff | (version << 16);
    }

    public static boolean isTablet() {
//        if (isTablet == null) {
//            isTablet = Phoncol.getInstance().getResources().getBoolean(R.bool.isTablet);
//        }
        return false;
    }

    public static boolean isSmallTablet() {
        float minSide = Math.min(displaySize.x, displaySize.y) / density;
        return minSide <= 700;
    }

    public static int getMinTabletSide() {
        if (!isSmallTablet()) {
            int smallSide = Math.min(displaySize.x, displaySize.y);
            int leftSide = smallSide * 35 / 100;
            if (leftSide < dp(320)) {
                leftSide = dp(320);
            }
            return smallSide - leftSide;
        } else {
            int smallSide = Math.min(displaySize.x, displaySize.y);
            int maxSide = Math.max(displaySize.x, displaySize.y);
            int leftSide = maxSide * 35 / 100;
            if (leftSide < dp(320)) {
                leftSide = dp(320);
            }
            return Math.min(smallSide, maxSide - leftSide);
        }
    }

    public static int getPhotoSize() {
        if (photoSize == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                photoSize = 1280;
            } else {
                photoSize = 800;
            }
        }
        return photoSize;
    }

    public static void clearCursorDrawable(EditText editText) {
        if (editText == null || Build.VERSION.SDK_INT < 12) {
            return;
        }
        try {
            Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            mCursorDrawableRes.setAccessible(true);
            mCursorDrawableRes.setInt(editText, 0);
        } catch (Exception e) {
//            MyLog.CAI_YING.e(e.getMessage());
        }
    }

    public static void setProgressBarAnimationDuration(ProgressBar progressBar, int duration) {
        if (progressBar == null) {
            return;
        }
        try {
            Field mCursorDrawableRes = ProgressBar.class.getDeclaredField("mDuration");
            mCursorDrawableRes.setAccessible(true);
            mCursorDrawableRes.setInt(progressBar, duration);
        } catch (Exception e) {
//            MyLog.CAI_YING.e(e.getMessage());
        }
    }

    public static int getViewInset(View view) {
        if (view == null || Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        try {
            Field mAttachInfoField = View.class.getDeclaredField("mAttachInfo");
            mAttachInfoField.setAccessible(true);
            Object mAttachInfo = mAttachInfoField.get(view);
            if (mAttachInfo != null) {
                Field mStableInsetsField = mAttachInfo.getClass().getDeclaredField("mStableInsets");
                mStableInsetsField.setAccessible(true);
                Rect insets = (Rect) mStableInsetsField.get(mAttachInfo);
                return insets.bottom;
            }
        } catch (Exception e) {
//            MyLog.CAI_YING.e(e.getMessage());
        }
        return 0;
    }

    public static int getCurrentActionBarHeight() {
        if (isTablet()) {
            return dp(64);
        } else if (BaseApplication.getAppContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return dp(48);
        } else {
            return dp(56);
        }
    }

    public static void clearDrawableAnimation(View view) {
        if (Build.VERSION.SDK_INT < 21 || view == null) {
            return;
        }
        Drawable drawable = null;
        if (view instanceof ListView) {
            drawable = ((ListView) view).getSelector();
            if (drawable != null) {
                drawable.setState(StateSet.NOTHING);
            }
        } else {
            drawable = view.getBackground();
            if (drawable != null) {
                drawable.setState(StateSet.NOTHING);
                drawable.jumpToCurrentState();
            }
        }
    }

/*    public static Spannable replaceBold(String str) {
        int start;
        ArrayList<Integer> bolds = new ArrayList<Integer>();
        while ((start = str.indexOf("<b>")) != -1) {
            int end = str.indexOf("</b>") - 3;
            str = str.replaceFirst("<b>", "").replaceFirst("</b>", "");
            bolds.add(start);
            bolds.add(end);
        }
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder(str);
        for (int a = 0; a < bolds.size() / 2; a++) {
            TypefaceSpan span = new TypefaceSpan(AppUtil.getTypeface("fonts/rmedium.ttf"));
            stringBuilder.setSpan(span, bolds.get(a * 2), bolds.get(a * 2 + 1), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return stringBuilder;
    }*/

    /*public static void turnOffHardwareAcceleration(Window window) {
        if (window == null || Build.MODEL == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        if (Build.MODEL.contains("GT-S5301") ||
                Build.MODEL.contains("GT-S5303") ||
                Build.MODEL.contains("GT-B5330") ||
                Build.MODEL.contains("GT-S5302") ||
                Build.MODEL.contains("GT-S6012B") ||
                Build.MODEL.contains("MegaFon_SP-AI")) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        }
    }*/


    public static final String DIRC_NAME = "tinfinite";

    public static File getDiskCacheDir(Context context) {
        return DiskUtil.getDiskCacheDir(context, DIRC_NAME);
    }

/*    public static String getFilePath(Context context, String avatar_url) {
        File file = DiskUtil.getDiskCacheDir(context, DIRC_NAME);
        String filename = DiskUtil.hashKeyForDisk(avatar_url);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                file = files[i];
                if (file.getName().contains(filename))
                    return file.getAbsolutePath();
            }
        }
        return null;
    }*/

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, BaseApplication.getAppContext().getResources().getDisplayMetrics());
    }

    public static int deviceScreenWidth() {
        WindowManager windowManager = (WindowManager) BaseApplication.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getWidth();
    }

    public static int deviceScreenHeight() {
        WindowManager windowManager = (WindowManager) BaseApplication.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        return windowManager.getDefaultDisplay().getHeight();
    }

    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = BaseApplication.getAppContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = BaseApplication.getAppContext().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        if (BaseApplication.getAppContext().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data, BaseApplication.getAppContext().getResources().getDisplayMetrics());
        }
        return AppUtil.dp(48);
    }

    public static int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color) * factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }

/*    public static String getMetadata(String name) {
        try {
            ApplicationInfo appInfo = BaseApplication.getAppContext().getPackageManager().getApplicationInfo(
                BaseApplication.getAppContext().getPackageName(), PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                return appInfo.metaData.getString(name);
            }
        } catch (PackageManager.NameNotFoundException e) {
            MyLog.CAI_YING.e(e.getMessage());
        }
        return null;
    }*/

/*    public static String distanceFormat(String distance) {
        if (distance == null || Strings.isNullOrEmpty(distance)) {
            return BaseApplication.getAppContext().getStringFromXml(R.string.text_336);
        }

        return distanceFormat(Float.valueOf(distance));
    }*/

 /*   public static String distanceFormat(float distance) {
        int disanceInt = (int) distance;
        if (disanceInt > 1000) {
            return disanceInt / 1000 + BaseApplication.getAppContext().getStringFromXml(R.string.text_337);
        }
        return disanceInt + BaseApplication.getAppContext().getStringFromXml(R.string.text_338);
    }*/


/*    public static String lifeTime(Date date) {
        return lifeTime(date.getTime());
    }

    public static String collectionTime(long ts) {
        if(DateUtil.isTheDay(new Date(ts), new Date())){//今天
            return BaseApplication.getAppContext().getStringFromXml(R.string.text_134);
        }else if(DateUtil.isYesterDay(new Date(ts))){//昨天
            return BaseApplication.getAppContext().getStringFromXml(R.string.text_344);
        }else {
            long l = (DateUtil.dayEnd(new Date()).getTime() - ts) / 1000l;
            if (l <= 15 * 24 * 60 * 60) {
                Integer i = (int) (l / (24 * 3600L));
                return i + BaseApplication.getAppContext().getStringFromXml(R.string.text_341);
            } else {
                return DateUtil.getTimeYearMonDay(new Date(ts));
            }
        }
    }*/

  /*  public static String lifeTime(long ts) {
        if(DateUtil.isTheDay(new Date(ts), new Date())){//今天
            long l = (System.currentTimeMillis() - ts) / 1000l;
            if (l < 60 * 60) {// xx 分钟前
                int j = (int) Math.max(l / 60L, 1L);
                StringBuilder sbminute = new StringBuilder(String.valueOf(j));
                return sbminute.toString() + BaseApplication.getAppContext().getStringFromXml(R.string.text_339);
            } else { // xx 小时前
                int i = (int) (l / 3600L);
                StringBuilder sbhour = new StringBuilder(String.valueOf(i)).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_340));
                return sbhour.toString();
            }
        }else if(DateUtil.isYesterDay(new Date(ts))){//昨天
            return BaseApplication.getAppContext().getStringFromXml(R.string.text_344);
        }else {
            long l = (DateUtil.dayEnd(new Date()).getTime() - ts) / 1000l;
            if (l <= 30 * 24 * 60 * 60) {
                Integer i = (int) (l / (24 * 3600L));
                return i + BaseApplication.getAppContext().getStringFromXml(R.string.text_341);
            } else if (l <= 12 * 30 * 24 * 60 * 60) {
                Integer i = (int) (l / (30 * 24 * 3600L));
                return i + BaseApplication.getAppContext().getStringFromXml(R.string.text_342);
            } else {
                return BaseApplication.getAppContext().getStringFromXml(R.string.text_343);
            }
        }
    }*/

  /*  public static String messageTime(DateTime time) {
        return messageTime(time, false);
    }*/

  /*  public static String messageTime(DateTime time, boolean trim) {
        if(time == null){
            return "";
        }
        DateTime now = new DateTime(new Date(), DateTimeZone.forID("Asia/Shanghai"));
        LocalDate today = now.toLocalDate();
        LocalDate yesterday = today.minusDays(1);
        DateTime startOfToday = today.toDateTimeAtStartOfDay(DateTimeZone.forID("Asia/Shanghai"));
        DateTime startOfYesterday = yesterday.toDateTimeAtStartOfDay(DateTimeZone.forID("Asia/Shanghai"));
        StringBuffer sb = new StringBuffer();
        boolean isToday = false;
        if (time.isBefore(now) && time.isAfter(startOfToday)) {
            isToday = true;
        } else if (time.isBefore(startOfToday) && time.isAfter(startOfYesterday)) {
            sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_344));
        } else if (DateUtil.isTheYear(time.toDate(), new Date())){
            sb.append(time.getMonthOfYear()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_92)).append(time.getDayOfMonth()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_349));
        } else {
            sb.append(time.getYear()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_91)).append(time.getMonthOfYear())
            .append(BaseApplication.getAppContext().getStringFromXml(R.string.text_92)).append(time.getDayOfMonth()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_349));
        }
        if (isToday) {
            if (time.getHourOfDay() < 12) {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_345));
            } else if (time.getHourOfDay() >= 12 && time.getHourOfDay() < 13) {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_346));
            } else if (time.getHourOfDay() >= 13 && time.getHourOfDay() < 18) {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_347));
            } else {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_348));
            }
        } else {
            sb.append(" ");
        }
        if (isToday) {
            if (time.getHourOfDay() < 10) {
                sb.append("0");
            }
            sb.append(time.getHourOfDay()).append(":");
            if (time.getMinuteOfHour() < 10) {
                sb.append("0");
            }
            sb.append(time.getMinuteOfHour());
        }
        return sb.toString();
    }*/

 /*   public static String streamTS(DateTime time) {
        if (time == null) return "";
        DateTime now = new DateTime(new Date(), DateTimeZone.forID("Asia/Shanghai"));
        LocalDate today = now.toLocalDate();
        LocalDate tomorrow = today.plusDays(1);
        DateTime startOfToday = today.toDateTimeAtStartOfDay(DateTimeZone.forID("Asia/Shanghai"));
        DateTime startOfTomorrow = tomorrow.toDateTimeAtStartOfDay(DateTimeZone.forID("Asia/Shanghai"));
        StringBuffer sb = new StringBuffer();
        if (time.isBefore(now)) {
            sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_176));
        } else if (time.isBefore(startOfTomorrow) && time.isAfter(startOfToday)) {
            if (time.getHourOfDay() < 12) {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_345));
            } else if (time.getHourOfDay() >= 12 && time.getHourOfDay() < 13) {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_346));
            } else if (time.getHourOfDay() >= 13 && time.getHourOfDay() < 18) {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_347));
            } else {
                sb.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_348));
            }
            sb.append(" ");
            if (time.getHourOfDay() < 10) {
                sb.append("0");
            }
            sb.append(time.getHourOfDay()).append(":");
            if (time.getMinuteOfHour() < 10) {
                sb.append("0");
            }
            sb.append(time.getMinuteOfHour());
        } else {
            sb.append(time.getMonthOfYear()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_92)).append(time.getDayOfMonth()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_349));
            sb.append(" ");
            if (time.getHourOfDay() < 10) {
                sb.append("0");
            }
            sb.append(time.getHourOfDay()).append(":");
            if (time.getMinuteOfHour() < 10) {
                sb.append("0");
            }
            sb.append(time.getMinuteOfHour());
        }
        return sb.toString();
    }*/

/*    public static boolean isShowMessageTime(DateTime index, DateTime last) {
        if(index == null || last == null){
            return false;
        }
        return index.isAfter(last.plus(Period.minutes(10)));
    }*/

/*    public static String getDateText(DateTime dateTime) {
        StringBuffer birthday = new StringBuffer().append(dateTime.getYear()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_91));
        if (dateTime.getMonthOfYear() < 10) {
            birthday.append("0");
        }
        birthday.append(dateTime.getMonthOfYear());
        birthday.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_92));
        if (dateTime.getDayOfMonth() < 10) {
            birthday.append("0");
        }
        birthday.append(dateTime.getDayOfMonth());
        birthday.append(BaseApplication.getAppContext().getStringFromXml(R.string.text_349));
        return birthday.toString();
    }*/

/*    public static String getDateTextWithSmartYear(DateTime dateTime) {
        StringBuffer birthday = new StringBuffer();
        if (dateTime.getYear() != new DateTime().getYear()) {
            birthday.append(dateTime.getYear()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_91));
        }
        birthday.append(dateTime.getMonthOfYear()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_92));
        birthday.append(dateTime.getDayOfMonth()).append(BaseApplication.getAppContext().getStringFromXml(R.string.text_349));
        return birthday.toString();
    }*/

    // 取得版本号
    public static String appVersionName() {
        try {
            PackageInfo manager = BaseApplication.getAppContext().getPackageManager().getPackageInfo(
                    BaseApplication.getAppContext().getPackageName(), 0);
            return manager.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown";
        }
    }

    public static int appBuildCode() {
        try {
            PackageInfo manager = BaseApplication.getAppContext().getPackageManager().getPackageInfo(
                    BaseApplication.getAppContext().getPackageName(), 0);
            return manager.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 1;
        }
    }

    public static String androidVersion() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release + ")";
    }

 /*   public static void finishWithPop(Activity activity) {
        if (activity == null) return;
        activity.finish();
        activity.overridePendingTransition(R.anim.anim_not_change, R.anim.pop_out);
    }

    public static void finishWithPush(Activity activity) {
        if (activity == null) return;
        activity.finish();
        activity.overridePendingTransition(R.anim.push_up_in, R.anim.push_empty_out);

    }

    public static void finishWithSlide(Activity activity) {
        if (activity == null) return;
        activity.finish();
        activity.overridePendingTransition(R.anim.slide_left_in, R.anim.slide_right_out);

    }*/

  /*  public static String formatPhone(String phone) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber swissNumberProto = phoneUtil.parse(phone, "CN");
            if (phoneUtil.isValidNumber(swissNumberProto)) {
                return phoneUtil.format(swissNumberProto, PhoneNumberUtil.PhoneNumberFormat.E164);
            }
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return null;
    }*/

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static byte[] bitmap2bytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    //2016-02-02T11:59:33.662Z
    public static String getNowUTCDateString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date());
    }

    public static String month2China(String month) {
        if (month.equals("1")) {
            return "一";
        } else if (month.equals("2")) {
            return "二";
        } else if (month.equals("3")) {
            return "三";
        } else if (month.equals("4")) {
            return "四";
        } else if (month.equals("5")) {
            return "五";
        } else if (month.equals("6")) {
            return "六";
        } else if (month.equals("7")) {
            return "七";
        } else if (month.equals("8")) {
            return "八";
        } else if (month.equals("9")) {
            return "九";
        } else if (month.equals("10")) {
            return "十";
        } else if (month.equals("11")) {
            return "十一";
        } else if (month.equals("12")) {
            return "十二";
        }
        return "未知";
    }

/*    public static void stripUnderlines(TextView textView) {
        if (TextUtils.isEmpty(textView.getText())) {
            return;
        }
        if (textView.getText() instanceof Spannable) {
            Spannable s = (Spannable) textView.getText();
            URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
            for (URLSpan span : spans) {
                int start = s.getSpanStart(span);
                int end = s.getSpanEnd(span);
                s.removeSpan(span);
                span = new URLSpanNoUnderline(span.getURL());
                s.setSpan(span, start, end, 0);
            }
            textView.setText(s);
        }
    }*/

    public static String getDomainName(String url) {
        if (!Patterns.WEB_URL.matcher(url).matches()) {
            return "";
        }
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (uri == null) {
            return url;
        }
        String domain = uri.getHost();
        if (TextUtils.isEmpty(domain)) {
            return domain;
        } else {
            return domain.startsWith("www.") ? domain.substring(4) : domain;
        }
    }

    public static int dateFromObjectId(String objectId) {
        return Integer.parseInt(objectId.substring(0, 8), 16);
    }


    public static String getPictureMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        if (TextUtils.isEmpty(type)) {
            type = "image/jpeg";
        }
        LogUtils.logi("mime : " + type);
        return type;
    }

    public static String getVideoMimeType(String url) {
        String type = null;
        String extension = MimeTypeMap.getFileExtensionFromUrl(url);
        if (extension != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
        if (TextUtils.isEmpty(type)) {
            type = "video/mp4";
        }
        LogUtils.logi("mime : " + type);
        return type;
    }

    /**
     * http://developer.android.com/reference/android/hardware/Camera.html#setDisplayOrientation(int)
     */
    public static void setCameraDisplayOrientation(Activity activity, int cameraId, Camera camera) {
        Camera.CameraInfo info =
                new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay()
                .getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;  // compensate the mirror
        } else {  // back-facing
            result = (info.orientation - degrees + 360) % 360;
        }
        camera.setDisplayOrientation(result);
    }

    /**
     * 根据秒数转换时间成00:00:00格式
     *
     * @param time
     * @return
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
