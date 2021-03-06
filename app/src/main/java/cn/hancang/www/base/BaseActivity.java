package cn.hancang.www.base;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baseapp.AppManager;
import cn.hancang.www.baserx.RxManager;
import cn.hancang.www.bean.SQTUser;
import cn.hancang.www.ui.main.activity.ArtDetatilActivity;
import cn.hancang.www.ui.main.activity.AuctionFiledActivity;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.main.activity.AuctionOrgActivity;
import cn.hancang.www.ui.main.activity.MyWebviewActivity;
import cn.hancang.www.utils.StatusBarUtil.StatusBarCompat;
import cn.hancang.www.utils.conmonUtil.ActivityUtil;
import cn.hancang.www.utils.conmonUtil.TUtil;
import cn.hancang.www.utils.conmonUtil.ToastUitl;
import cn.hancang.www.utils.conmonUtil.UserUtil;
import cn.hancang.www.widget.NormalDialog;
import cn.hancang.www.widget.ShareDialog;
import cn.hancang.www.widget.conmonWidget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 基类
 */

/***************使用例子*********************/
//1.mvp模式
//public class SampleActivity extends BaseActivity<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleActivity extends BaseActivity {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public T mPresenter;
    public E mModel;
    public Context mContext;
    public RxManager mRxManager;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        this.initPresenter();

        this.initView();
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {

        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // 默认着色状态栏
//        SetStatusBarColor();
    }

    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();
    /**
     * 设置主题
     */
  /*  private void initTheme() {
        ChangeModeController.setTheme(this, R.style.DayTheme, R.style.NightTheme);
    }*/

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor() {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.app_main));
    }

    // 提醒内存回收
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(int color) {
        StatusBarCompat.setStatusBarColor(this, color);
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar() {
        StatusBarCompat.translucentStatusBar(this);
    }


    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 开启浮动加载进度条
     */
    public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(this);
    }

    /**
     * 开启浮动加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(this, msg, true);
    }

    /**
     * 停止浮动加载进度条
     */
    public void stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading();
    }

    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId) {
        ToastUitl.showShort(resId);
    }

    /**
     * 长时间显示Toast提示(来自res)
     **/
    public void showLongToast(int resId) {
        ToastUitl.showLong(resId);
    }

    /**
     * 长时间显示Toast提示(来自String)
     **/
    public void showLongToast(String text) {
        ToastUitl.showLong(text);
    }

    /**
     * 带图片的toast
     *
     * @param text
     * @param res
     */
    public void showToastWithImg(String text, int res) {
        ToastUitl.showToastWithImg(text, res);
    }

    /**
     * 网络访问错误提醒
     */
    public void showNetErrorTip() {
        ToastUitl.showToastWithImg(getText(R.string.net_error).toString(), R.mipmap.ic_wifi_off);
    }

    public void showNetErrorTip(String error) {
        ToastUitl.showToastWithImg(error, R.mipmap.ic_wifi_off);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*
        * umeng 的数据收集
        * */
        String runningActivityName = ActivityUtil.getRunningActivityName();
        if (!"MainActivity".equals(runningActivityName) && !"SchoolDetailActivity".equals(runningActivityName)) {
            // 不纯的Activity 这里不调用
//            LogUtils.logd("当前activity的名字" + runningActivityName + "执行了OnPageStart");
//            MobclickAgent.onPageStart(runningActivityName);
        }
//        LogUtils.logd("当前activity的名字" + runningActivityName);
//        MobclickAgent.onResume(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        /*
        * umeng 的数据收集
        * */
        String runningActivityName = ActivityUtil.getRunningActivityName();
        if (!"MainActivity".equals(runningActivityName) && !"CollegesAllActivity".equals(runningActivityName)) {
//            MobclickAgent.onPageEnd(runningActivityName);
        }
//        MobclickAgent.onPause(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
        unbinder.unbind();

        AppManager.getAppManager().finishActivity(this);
    }

    /*    *
     * 判断是否登录
     *
*/
    public boolean isLogin() {

        if (null == UserUtil.getLoginInfo()) {// 进入首页面先判断本地是否有信息
            return false;
        }
        SQTUser loginInfo = UserUtil.getLoginInfo();
        if (TextUtils.isEmpty(String.valueOf(UserUtil.getLoginInfo().getMember_id()))) {// 根据登录保存的信息进行是否登录判断
            return false;
        } else {
            return true;
        }
        //
    }

    /*
    *获取登陆信息
    * */
    public SQTUser getSqtUser() {

        return UserUtil.getLoginInfo();
    }

    public void setMarGinTop(View v, int marGTop, int top) {
        if (v.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);

        } else if (v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);

        } else if (v.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);
        }


    }

    public void showContractDialog() {
        final ShareDialog shareDialog = new ShareDialog(this, R.layout.item_reminder, false);
        shareDialog.setMessage("13070167219");
        shareDialog.setYesOnclickListener("确定", new NormalDialog.onYesOnclickListener() {
            @Override
            public void onYesClick() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + shareDialog.getMessageStr()));
                startActivity(intent);
                shareDialog.dismiss();
            }
        });
        shareDialog.setNoOnclickListener("取消", new NormalDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                shareDialog.dismiss();
            }
        });
        shareDialog.show();
    }
    /*：0=url，1=拍场详情页，2=拍品详情页，3=文章内容页，4=艺术家主页，5=拍卖机构主页，6=分类拍品页*/
    public void GotoOthreVp(Integer link_type, String link_value, String title) {
//        showShortToast("我是    "+link_type+"     "+link_value+"     "+title);
      /*  if (TextUtils.isEmpty(link_type))
            return;*/
        switch (link_type) {
            case 0:
                MyWebviewActivity.GotoActiviy(this, link_value, title);
                break;
            case 1:
                AuctionFiledActivity.gotoAuctionFiledActivity(this, Integer.parseInt(link_value), AppConstant.IntoWayOne);
                break;
            case 2:
                AuctionItemActivity.gotoAuctionItemActivity(this, Integer.parseInt(link_value));
                break;
            case 3:
                MyWebviewActivity.GotoActiviy(this, link_value, title);
                break;
            case 4:
                ArtDetatilActivity.GotoArtDetailActivity(this, Integer.parseInt(link_value));
                break;
            case 5:
                AuctionOrgActivity.gotoAuctionOrg(this, Integer.parseInt(link_value));
                break;
            case 6:
                break;
        }

    }

}
