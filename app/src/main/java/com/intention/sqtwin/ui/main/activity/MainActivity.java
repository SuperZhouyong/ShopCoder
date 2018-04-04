package com.intention.sqtwin.ui.main.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.app.BaseApplication;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseapp.AppManager;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.TabEntity;
import com.intention.sqtwin.ui.main.fragment.ExpertsFragment;
import com.intention.sqtwin.ui.main.fragment.HomePageFragment;
import com.intention.sqtwin.ui.main.fragment.MyInfoFragment;
import com.intention.sqtwin.ui.main.fragment.ShopFragment;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.ToastUitl;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_body)
    FrameLayout flBody;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private String[] mTitles = {"首页", "专家咨询", "服务", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal, R.mipmap.icon_specialist, R.mipmap.ic_girl_normal, R.mipmap.ic_care_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected, R.mipmap.icon_specialist_s, R.mipmap.ic_girl_selected, R.mipmap.ic_care_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private static int tabLayoutHeight;
    private HomePageFragment mPositionFragment;
    private ExpertsFragment mExpertsFragment;
    private ShopFragment mMessageFragment;
    private MyInfoFragment mMyInfoFragment;
    private boolean isExit;
    //    private String moneyNum1;

    public String getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(String moneyNum) {
        this.moneyNum = moneyNum;
    }

    private String moneyNum;

    /**
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity, String Moneynum) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra(AppConstant.Moneynum, Moneynum);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startActionUpdateRecord(Activity activity, String UpdateRecord) {
        Intent intent = new Intent(activity, MainActivity.class);

        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    public void initView() {
        moneyNum = getIntent().getStringExtra(AppConstant.Moneynum);
        initTab();
      /*  mRxManager.on(AppConstant.ActivitySwictToFragment, new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

                SwitchTo(integer);
                tabLayout.setCurrentTab(integer);


            }
        });*/

       /* RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
        rxPermissions.requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.GET_ACCOUNTS,
                Manifest.permission.CHANGE_NETWORK_STATE
        ).subscribe(new Action1<Permission>() {
            @Override
            public void call(Permission permission) {
                if (permission.granted) {
                    // 同意权限
                    LogUtils.logd("System--" + "同意了权限");
                } else {
                    if (CheckPhoneSystemUtils.isMIUI()) {
                        LogUtils.logd("System--" + "产品/硬件的制造商小米:");
                        Intent intent = new Intent();
                        intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                        intent.putExtra("extra_pkgname", getPackageName());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
//                            Toast.makeText(MediaRecoderService.this, "只有MIUI才可以设置哦", Toast.LENGTH_SHORT).show();
                        }
                    } else if (CheckPhoneSystemUtils.isFlyme()) {
                        Intent intent = new Intent();
                        LogUtils.logd("System--" + "com.meizu.safe.security.SHOW_APPSEC");
                        intent.setAction("com.meizu.safe.security.SHOW_APPSEC");
                        intent.addCategory(Intent.CATEGORY_DEFAULT);
                        intent.putExtra("packageName", getPackageName());
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
//                            Toast.makeText(MediaRecoderService.this, "只有Flyme才可以设置哦", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                *//*else if (permission.shouldShowRequestPermissionRationale) {
                    // 用户拒绝了 没选中不再提示
                } else {
                    // 拒绝 选中了  不再提示
                }*//*

            }
        });*/

    }

    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                initTabBackGround(position);
                SwitchTo(position);

            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    private void initTabBackGround(int position) {
       /* TextView tv = (TextView) tabLayout.getChildAt(position).findViewById(R.id.tv_tab_title);
        if (tv!=null){
            tv.getPaint().setFakeBoldText(true);
        }
        tabLayout.setTextBold(true);*/
    }

    private void SwitchTo(int position) {
        LogUtils.logd("主页菜单position" + position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:
                transaction.hide(mMessageFragment);
                transaction.hide(mMyInfoFragment);
                transaction.hide(mExpertsFragment);
                transaction.show(mPositionFragment);
                transaction.commitAllowingStateLoss();
                break;
            //专家咨询
            case 1:
                transaction.hide(mPositionFragment);
                transaction.hide(mMyInfoFragment);
                transaction.hide(mMessageFragment);
                transaction.show(mExpertsFragment);
//                mExpertsFragment.ShowIsRed();
                transaction.commitAllowingStateLoss();
                break;
            //服务
            case 2:
                transaction.hide(mPositionFragment);
                transaction.hide(mExpertsFragment);
                transaction.hide(mMyInfoFragment);
                transaction.show(mMessageFragment);
                transaction.commitAllowingStateLoss();
                break;
            //我的
            case 3:
                transaction.hide(mPositionFragment);
                transaction.hide(mMessageFragment);
                transaction.hide(mExpertsFragment);
                transaction.show(mMyInfoFragment);
//                mMyInfoFragment.requestData();
                transaction.commitAllowingStateLoss();
                break;

            default:
                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 初始化fragmnet
        initFragment(savedInstanceState);
        tabLayout.measure(0, 0);
        tabLayoutHeight = tabLayout.getMeasuredHeight();
        //监听菜单显示或隐藏
       /* mRxManager.on(AppConstant.MENU_SHOW_HIDE, new Action1<Boolean>() {

            @Override
            public void call(Boolean hideOrShow) {
                startAnimation(hideOrShow);
            }
        });*/

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //奔溃前保存位置 记录 住tablayout 的位置
//        LogUtils.loge("onSaveInstanceState进来了1");
        if (tabLayout != null) {
//            LogUtils.loge("onSaveInstanceState进来了2");
            outState.putInt(AppConstant.HOME_CURRENT_TAB_POSITION, tabLayout.getCurrentTab());
        }
    }

    /**
     * 菜单显示隐藏动画
     *
     * @param showOrHide
     */
    private void startAnimation(boolean showOrHide) {
        final ViewGroup.LayoutParams layoutParams = tabLayout.getLayoutParams();
        ValueAnimator valueAnimator;
        ObjectAnimator alpha;
        if (!showOrHide) {
            valueAnimator = ValueAnimator.ofInt(tabLayoutHeight, 0);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 1, 0);
        } else {
            valueAnimator = ValueAnimator.ofInt(0, tabLayoutHeight);
            alpha = ObjectAnimator.ofFloat(tabLayout, "alpha", 0, 1);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = (int) valueAnimator.getAnimatedValue();
                tabLayout.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(valueAnimator, alpha);
        animatorSet.start();
    }

    /**
     * 监听返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       /* if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);*/
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return ExitApp();

        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private Boolean ExitApp() {
        if (!isExit) {
            isExit = true;
            ToastUitl.showShort("再按一次返回键退出应用程序");
            Observable.interval(0, 1, TimeUnit.SECONDS).take(2).subscribe(new RxSubscriber<Long>(this) {


                @Override
                protected void _onNext(Long aLong) {

                }

                @Override
                protected void _onError(String message) {

                }

                @Override
                public void onCompleted() {
                    super.onCompleted();
                    isExit = false;
                }
            });
        } else {
            AppManager.getAppManager().AppExit(BaseApplication.getAppContext(), false);
        }


        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            mPositionFragment = (HomePageFragment) getSupportFragmentManager().findFragmentByTag("mPositionFragment");
            mExpertsFragment = (ExpertsFragment) getSupportFragmentManager().findFragmentByTag("mExpertsFragment");
            mMessageFragment = (ShopFragment) getSupportFragmentManager().findFragmentByTag("mMessageFragment");
            mMyInfoFragment = (MyInfoFragment) getSupportFragmentManager().findFragmentByTag("mMyInfoFragment");

            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            mPositionFragment = new HomePageFragment();
            mExpertsFragment = new ExpertsFragment();
            mMessageFragment = new ShopFragment();
            mMyInfoFragment = new MyInfoFragment();

            transaction.add(R.id.fl_body, mPositionFragment, "mPositionFragment");
            transaction.add(R.id.fl_body, mExpertsFragment, "mExpertsFragment");
            transaction.add(R.id.fl_body, mMessageFragment, "mMessageFragment");
            transaction.add(R.id.fl_body, mMyInfoFragment, "mMyInfoFragment");

        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }
}
