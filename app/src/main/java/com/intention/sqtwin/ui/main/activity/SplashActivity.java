package com.intention.sqtwin.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.intention.sqtwin.baserx.RxManager;


/**
 * @data 2017/5/16 0016
 * @aurher Administrator
 */

public class SplashActivity extends AppCompatActivity {
    private Boolean isFirstStart = false;
    //    private Boolean ShouldToLogin = false;
    private RxManager mRxManager;
    private long currentTime;
    private long overTime;
    private Handler mHander;
    private float old_version;
    private float new_version;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
//        initView();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
/*   @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }*/
/*
*
*   float old_version = Float.parseFloat(BaseApplication.getCurVersion());
                        float new_version = Float.parseFloat(versionCode.getData().getVersions());
                        LogUtils.logd("Version"+old_version+"-----------"+new_version);
                        if (new_version > old_version) {
                            gotoUpdate(versionCode.getData().getVersions(), versionCode.getData().getUrl());
                        } else {
                            isFirstStart = SPUtils.getSharedBooleanData(SplashActivity.this, AppConstant.isFirstStart);
                            if (!isFirstStart) {
                                startActivity(new Intent(SplashActivity.this, GuideActivity.class));

                            } else {
                                // 应该登陆
                                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            }
                            finish();
                        }
* */

 /*   public void initView() {
        AppManager.getAppManager().addActivity(this);
//        SetTranslanteBar();
        // 初始化数据
        currentTime = (new Date()).getTime();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                StartToNext();
////                LogUtils.logd("当前时间----onNext-延时执行" + currentTime + "=======" + overTime + "----" + (overTime - currentTime) + "-----" + new Date().getTime());
//            }
//        }, 2000 + currentTime - overTime);

        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .getVersionCode()
                .compose(RxSchedulers.<VersionCode>io_main())

                .subscribe(new RxSubscriber<VersionCode>(SplashActivity.this) {
                    @Override
                    protected void _onNext(final VersionCode versionCode) {
                        switch (versionCode.getStatus()) {
                            case 1:
                                overTime = new Date().getTime();
                                LogUtils.logd("当前时间----onNext" + currentTime + "=======" + overTime + "----" + (overTime - currentTime));
                                // Vicode
                                old_version = Float.parseFloat(String.valueOf(AppUtil.appBuildCode()));
                                new_version = Float.parseFloat(versionCode.getData().getVersions());

                                LogUtils.logd("Version" + old_version + "-----------" + new_version);

                                if ((overTime - currentTime) >= 1000) {
                                    VersionToActivity(versionCode);
//                            StartToNext();
                                } else {
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            VersionToActivity(versionCode);
                                            LogUtils.logd("当前时间----onNext-延时执行" + currentTime + "=======" + overTime + "----" + (overTime - currentTime) + "-----" + new Date().getTime());
                                        }
                                    }, 1000 + currentTime - overTime);
                                }
                                break;
                            default:

                                ToastUitl.showShort(TextUtils.isEmpty(versionCode.getMsg()) ? "稍后再试" : versionCode.getMsg());

                                break;
                        }

                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        LogUtils.logd("当前时间----onCompleted" + currentTime + "=======" + overTime);

                    }

                    @Override
                    protected void _onError(String message) {
                        overTime = new Date().getTime();
                        LogUtils.logd("当前时间----onError" + currentTime + "=======" + overTime);
                        if ((overTime - currentTime) >= 1000) {
                            StartToNext();
                        } else {
//                            mRxManager.add(Observable.interval(0,2000-(overTime-currentTime),TimeUnit.MICROSECONDS).take());
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    StartToNext();
                                }
                            }, 1000 + currentTime - overTime);
                        }


                    }
                }));

//        mRxManager.add();


    }

    private void VersionToActivity(VersionCode versionCode) {
        if (new_version > old_version) {
            gotoUpdate(versionCode.getData().getVersions(), versionCode.getData().getUrl());
        } else {
            StartToNext();
        }
    }

    private void StartToNext() {
        isFirstStart = SPUtils.getSharedBooleanData(SplashActivity.this, AppConstant.isFirstStart);
        //// TODO: 2017/12/8 0008 暂且关闭跳转 GuideActivity
        if (!isFirstStart) {
            LogUtils.logi("SplashActivity    StartToNext       ");
//            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
            startActivity(new Intent(SplashActivity.this,GuidetwoActivity.class));
        } else {
            // 直接去主界面
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        finish();
    }
      *//*  mRxManager.add(Observable.interval(0, 1, TimeUnit.MILLISECONDS)
                .take(1)
                .compose(RxSchedulers.<Long>io_main()).subscribe(new RxSubscriber<Long>(this) {
                    @Override
                    protected void _onNext(Long aLong) {

                    }

                    @Override
                    public void onStart() {
                        super.onStart();


                    }

                    @Override
                    protected void _onError(String message) {

                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        isFirstStart = SPUtils.getSharedBooleanData(SplashActivity.this, AppConstant.isFirstStart);
                        if (!isFirstStart) {
                            startActivity(new Intent(SplashActivity.this, GuideActivity.class));

                        } else {
                            // 应该登陆
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        }
                        finish();
                    }
                }));*//*


    private void gotoUpdate(String latest, String UrlApk) {
        LogUtils.logi("SplashActivity   gotoUpdate       ");
        Intent intent = new Intent(this, UpdateActivity.class);
        intent.putExtra(AppConstant.Update, latest);
        intent.putExtra(AppConstant.App_DownUrl, UrlApk);
       *//* intent.putExtra(AppUpdaterActivity.INTENT_PARAMS_INT_KEY_BUILD_MIN_VERSION, min);
        intent.putExtra(AppUpdaterActivity.INTENT_PARAMS_STRING_KEY_DOWNLOAD_URL, downloadUrl);
        intent.putExtra(AppUpdaterActivity.INTENT_PARAMS_BOOLEAN_KEY_NEED_LAUNCH_MAIN_ACTIVITY, true);*//*
        startActivity(intent);
        finish();
//        overridePendingTransition(R.anim.anim_not_change, R.anim.pop_out);
//        new Handler().postDelayed(this::finish, 300);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRxManager.clear();
        AppManager.getAppManager().finishActivity(this);
    }*/
}
