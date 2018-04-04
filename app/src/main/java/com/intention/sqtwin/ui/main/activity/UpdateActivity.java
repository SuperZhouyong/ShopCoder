package com.intention.sqtwin.ui.main.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.app.BaseApplication;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseapp.AppManager;
import com.intention.sqtwin.utils.conmonUtil.AppUtil;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;
import com.intention.sqtwin.widget.NormalDialog;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.model.FileDownloadStatus;
import com.liulishuo.filedownloader.notification.BaseNotificationItem;
import com.liulishuo.filedownloader.notification.FileDownloadNotificationHelper;
import com.liulishuo.filedownloader.notification.FileDownloadNotificationListener;
import com.liulishuo.filedownloader.util.FileDownloadHelper;
import com.umeng.analytics.MobclickAgent;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @data 2017/6/2 0002
 * @aurher Administrator
 */

public class UpdateActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.donut_progress)
    DonutProgress donutProgress;
    @BindView(R.id.txt_tips)
    TextView tipsTextView;
    //
    private File apkFile = null;

    private String AppVersion;
    private String OldVersion;
    // 下载任务
    private BaseDownloadTask baseDownloadTask;
    private String Url_downApk;
    //
    private Boolean isFirstStart = false;
    private int downloadId = 0;
    private FileDownloadNotificationHelper<NotificationItem> notificationHelper;
    private NormalDialog dialog;
    // 下载按钮
//    private PreferenceTextCenterItem actionButtonItem = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    public void initView() {
        ivSearch.setVisibility(View.GONE);
        title.setText("软件更新");
        relSearch.setVisibility(View.GONE);
        notificationHelper = new FileDownloadNotificationHelper<>();

        AppVersion = getIntent().getStringExtra(AppConstant.Update);
        Url_downApk = getIntent().getStringExtra(AppConstant.App_DownUrl);
        OldVersion = BaseApplication.getCurVersion();

        tipsTextView.setText("当前版本" + BaseApplication.getCurVersion());
        dialog = new NormalDialog(this, R.layout.dialog_layout, false);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("有新版本需要更新");
        dialog.setNoOnclickListener("取消", new NormalDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                dialog.dismiss();
//                LogUtils.logd("测试更新"+"----"+(Float.parseFloat(AppVersion) >= AppUtil.appBuildCode())+"----"+(Float.parseFloat(AppVersion) % 100 == 0)+"----"+((Float.parseFloat(AppVersion) / 100) > (AppUtil.appBuildCode() / 100))+"--AppUtil.appBuildCode()"+AppUtil.appBuildCode()+"--(Float.parseFloat(AppVersion)"+(Float.parseFloat(AppVersion)));
//                LogUtils.logd("测试更新"+"----"+(Float.parseFloat(AppVersion) / 100)+"----"+(AppUtil.appBuildCode() / 100));
                if (((Float.parseFloat(AppVersion) >= AppUtil.appBuildCode()) && (Float.parseFloat(AppVersion) % 100 == 0)) || (((int) Float.parseFloat(AppVersion) / 100) > (AppUtil.appBuildCode() / 100))) {
                    AppManager.getAppManager().AppExit(BaseApplication.getAppContext(), false);
                } else if (Float.parseFloat(AppVersion) >= AppUtil.appBuildCode() && Float.parseFloat(AppVersion) % 100 != 0) {
                    isFirstStart = SPUtils.getSharedBooleanData(UpdateActivity.this, AppConstant.isFirstStart);
                    // TODO: 2017/12/8 0008 暂且关闭跳转 GuideActivity
                    startActivity(new Intent(UpdateActivity.this, MainActivity.class));
                    finish();
                } else {
                    finish();
                }

            }
        });
        dialog.setYesOnclickListener("确定", new NormalDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                dialog.dismiss();
                LogUtils.logd("Version" + "getApkFile().exists()" + "-----------" + getApkFile().exists());
                if (getApkFile().exists()) {
                    launchInstallApp();
                } else {
                    downloadId = downloadApkTask().start();
                }


            }
        });
        dialog.show();
    }

    private BaseDownloadTask downloadApkTask() {
        baseDownloadTask = FileDownloader.getImpl()
                .create(Url_downApk)
                .setPath(getApkFile().getAbsolutePath())
                .setListener(new FileDownloadNotificationListener(notificationHelper) {
                    @Override
                    protected BaseNotificationItem create(BaseDownloadTask task) {
                        return new NotificationItem(task.getDownloadId(), getString(R.string.app_name), "");
                    }

                    @Override
                    protected boolean interceptCancel(BaseDownloadTask task,
                                                      BaseNotificationItem n) {
                        // in this demo, I don't want to cancel the notification, just show for the test
                        // so return true
                        return true;
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        super.progress(task, soFarBytes, totalBytes);
                        showIndicator(donutProgress);
                        donutProgress.setMax(100);
                        donutProgress.setProgress((int) ((soFarBytes * 1.0f / totalBytes * 1.0f) * 100));
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        super.completed(task);
//                        MyLog.CAI_YING.d(task.getSmallFileTotalBytes() + " - 3");
                        donutProgress.setProgress(100);
                        launchInstallApp();
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        super.error(task, e);
                        BaseApplication.st(getBaseContext().getResources().getString(R.string.text_14));
                        e.printStackTrace();
                    }

                });
        return baseDownloadTask;

    }

    private void launchInstallApp() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(getApkFile()), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // without this flag android returned a intent error!
        startActivity(intent);
        finish();
    }
    // 下载文件

    private File getApkFile() {
        if (apkFile == null) {
            String packageName = BaseApplication.getAppContext().getPackageName();
            // 绣袋了  最新的版本号文件就算更新了 几次都是没问题
            String apkFileName = packageName.substring(packageName.lastIndexOf(".") + 1) + "-" + AppVersion + "志愿" + ".apk";
            apkFile = new File(AppUtil.getDiskCacheDir(BaseApplication.getAppContext()).getAbsolutePath() + File.separator + apkFileName);
        }
//        MyLog.CAI_YING.d(apkFile.getAbsolutePath());
        return apkFile;
    }

    @OnClick({R.id.rel_back})
    public void UpdateOnclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;

        }
    }

    private void showIndicator(View view) {
     /*   donutProgress.setVisibility(View.GONE);
        tipsTextView.setVisibility(View.GONE);*/
        view.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        this.notificationHelper.clear();
        clear();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (Build.VERSION.SDK_INT > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
//            Log.d("CDA", "onKeyDown Called");
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
//        Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

    private void clear() {
        if (downloadId == 0) {
            return;
        }
        /**
         * why not use {@link FileDownloadNotificationHelper#clear()} directly?
         * @see FileDownloadNotificationListener#interceptCancel(BaseDownloadTask, BaseNotificationItem)
         */
        ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).
                cancel(downloadId);
    }

    public class NotificationItem extends BaseNotificationItem {

        public NotificationItem(int id, String title, String desc) {
            super(id, title, desc);
        }

        private String progressDesc() {
            String current = String.format("%.2f", getSofar() * 1.0f / (1024 * 1024)) + "M";
            String total = String.format("%.2f", getTotal() * 1.0f / (1024 * 1024)) + "M";
            return String.valueOf((int) ((getSofar() * 1.0f / getTotal() * 1.0f) * 100)) + "%   " + current + "/" + total;
        }

        @Override
        public void show(boolean statusChanged, int status, boolean isShowProgress) {
            NotificationCompat.Builder builder = new NotificationCompat.
                    Builder(FileDownloadHelper.getAppContext());

            String desc = getDesc();
            switch (status) {
                case FileDownloadStatus.pending:
                    desc += BaseApplication.getAppContext().getString(R.string.text_16);
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_16));
                    break;
                case FileDownloadStatus.progress:
                    desc += progressDesc();
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_12));
                    break;
                case FileDownloadStatus.retry:
                    desc += BaseApplication.getAppContext().getString(R.string.text_17);
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_17));
                    break;
                case FileDownloadStatus.error:
                    desc += BaseApplication.getAppContext().getResources().getString(R.string.text_20);
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_17));
                    break;
                case FileDownloadStatus.paused:
                    desc += BaseApplication.getAppContext().getResources().getString(R.string.text_12);
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_13));
                    break;
                case FileDownloadStatus.completed:
                    desc += BaseApplication.getAppContext().getResources().getString(R.string.text_18);
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_6));
                    break;
                case FileDownloadStatus.warn:
                    desc += BaseApplication.getAppContext().getResources().getString(R.string.text_19);
//                    actionButtonItem.setTitle(getBaseContext().getResources().getString(R.string.text_17));
                    break;

            }
            LogUtils.logd("FileDownloadStatus----" + desc);
            builder.setDefaults(Notification.DEFAULT_LIGHTS)
                    .setOngoing(true)

                    .setPriority(NotificationCompat.PRIORITY_MIN)
                    .setContentTitle(getTitle())
                    .setContentText(desc)
                    .setSmallIcon(R.mipmap.ic_launcher);

            if (statusChanged) {
                builder.setTicker(desc);
            }

            builder.setProgress(getTotal(), getSofar(), !isShowProgress);
            getManager().notify(getId(), builder.build());
        }


    }
}


