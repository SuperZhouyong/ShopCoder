package com.intention.sqtwin.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.multidex.MultiDex;
import android.widget.Toast;

import com.intention.sqtwin.greendaohelper.DaoManager;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.liulishuo.filedownloader.FileDownloader;
import com.mob.MobSDK;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

//import com.squareup.leakcanary.LeakCanary;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        // 这里会初始化本地的 user 信息
        // 关闭默认的Umeng 统计
//        MobclickAgent.openActivityDurationTrack(false);
        //内部存储查看
//        Stetho.initializeWithDefaults(this);
        //初始化logger  初始化 调试模式
        LogUtils.logInit(true);
        // 初始化自定义的数据库
        DaoManager.init(this);
        // 初始化异常捕获类
//        CrashHandler.getInstance().init(this);
        // 内存检测工具
//        UMConfigure.setLogEnabled(true);
//        ShareSDK.initSDK(this);
        MobSDK.init(this);
        // 这里和Manifest中的文件不可重复添加
//        UMGameAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this,"58fefa5182b6355d31000505","Channel_ID"));
     /*   if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);*/
       /* if (UserUtil.getLoginInfo() != null) {
            LogUtils.logd(AppConstant.ALLTAG + "已经登录");
            MobclickAgent.onProfileSignIn(UserUtil.getLoginInfo().getGid());

        } else {
            LogUtils.logd(AppConstant.ALLTAG + "未登陆，现在去登录");
//            LoginActivity.startAction(this);
            //去登陆
        }*/
        // 版本下载
        FileDownloader.init(getAppContext());

    }

    public static void st(final String message) {
        if (baseApplication == null) {
//            MyLog.CAI_YING.e("application sInstance is null");
        } else {
            Observable.just(new Object()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Object>() {
                @Override
                public void call(Object o) {
                    Toast.makeText(baseApplication, message, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public static Context getAppContext() {
        return baseApplication;
    }

    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

 /*   *//**
     * 分包
     * @param base
     *//*
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
       // 分包暂时不考虑
        // MultiDex.install(this);
    }*/

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return 进程号
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

    public static String getCurVersion() {
        PackageManager packageManager = baseApplication.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(baseApplication.getPackageName(), 0);
            String version = packageInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
