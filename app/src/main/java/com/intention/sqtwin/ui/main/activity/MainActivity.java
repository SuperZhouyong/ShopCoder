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
import com.intention.sqtwin.baserx.RxBus;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.TabEntity;
import com.intention.sqtwin.ui.main.fragment.AuctionFragment;
import com.intention.sqtwin.ui.main.fragment.EnterFragment;
import com.intention.sqtwin.ui.main.fragment.HomePageFragment;
import com.intention.sqtwin.ui.main.fragment.MallFragment;
import com.intention.sqtwin.ui.main.fragment.MyInfoFragment;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.ToastUitl;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_body)
    FrameLayout flBody;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    //    private String[] mTitles = {"首页", "专家咨询", "服务", "我的"};
    private String[] mTitles = {"首页", "拍卖", "入驻", "商城", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal, R.mipmap.icon_specialist, R.mipmap.ic_girl_normal, R.mipmap.ic_home_normal, R.mipmap.ic_home_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected, R.mipmap.icon_specialist_s, R.mipmap.ic_girl_selected, R.mipmap.ic_care_selected, R.mipmap.ic_myinfo_slect};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private static int tabLayoutHeight;
    // 首页
    private HomePageFragment mPositionFragment;
    //拍卖
    private AuctionFragment mAuctionFragment;
    //入驻
    private EnterFragment mEnterFragment;
    //商场
    private MallFragment mMallFragment;
    //我的
    private MyInfoFragment mMyInfoFragment;

    private boolean isExit;

    private Boolean isLoadEnterFragment = false;


    private String moneyNum;

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

    /**
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
        initRxBus();

    }

    private void initRxBus() {
        mRxManager.on(AppConstant.SwitchToPostion, new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                tabLayout.setCurrentTab(integer);
                SwitchTo(integer);
            }
        });
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

    }

    public void SwitchTo(int position) {
        LogUtils.logd("主页菜单position" + position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:

                transaction.hide(mEnterFragment);
                transaction.hide(mMyInfoFragment);
                transaction.hide(mAuctionFragment);
                transaction.hide(mMallFragment);
                transaction.show(mPositionFragment);
                transaction.commitAllowingStateLoss();
                break;
            //拍卖
            case 1:
                transaction.hide(mEnterFragment);
                transaction.hide(mMyInfoFragment);
                transaction.show(mAuctionFragment);
                transaction.hide(mMallFragment);
                transaction.hide(mPositionFragment);
//                mExpertsFragment.ShowIsRed();
                transaction.commitAllowingStateLoss();
                break;
            //入驻
            case 2:
                transaction.show(mEnterFragment);
                transaction.hide(mMyInfoFragment);
                transaction.hide(mAuctionFragment);
                transaction.hide(mMallFragment);
                transaction.hide(mPositionFragment);
                transaction.commitAllowingStateLoss();
                isLoadEnterFragment = true;
                mRxManager.post(AppConstant.EnterFragment, isLoadEnterFragment);
                break;
            //商城
            case 3:
                transaction.hide(mEnterFragment);
                transaction.hide(mMyInfoFragment);
                transaction.hide(mAuctionFragment);
                transaction.show(mMallFragment);
                transaction.hide(mPositionFragment);
                transaction.commitAllowingStateLoss();
                break;
            //我的
            case 4:
                transaction.hide(mEnterFragment);
                transaction.show(mMyInfoFragment);
                transaction.hide(mAuctionFragment);
                transaction.hide(mMallFragment);
                transaction.hide(mPositionFragment);
                transaction.commitAllowingStateLoss();
                break;

            default:
                break;
        }
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

    public void setCurrentPostion(int postion) {
        SwitchTo(postion);
        tabLayout.setCurrentTab(postion);
    }

    private void initFragment(Bundle savedInstanceState) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int currentTabPosition = 0;
        if (savedInstanceState != null) {
            mPositionFragment = (HomePageFragment) getSupportFragmentManager().findFragmentByTag("mPositionFragment");
            mAuctionFragment = (AuctionFragment) getSupportFragmentManager().findFragmentByTag("mAuctionFragment");
            mEnterFragment = (EnterFragment) getSupportFragmentManager().findFragmentByTag("mEnterFragment");
            mMallFragment = (MallFragment) getSupportFragmentManager().findFragmentByTag("mMallFragment");
//            mExpertsFragment = (ExpertsFragment) getSupportFragmentManager().findFragmentByTag("mExpertsFragment");
//            mMessageFragment = (ShopFragment) getSupportFragmentManager().findFragmentByTag("mMessageFragment");
            mMyInfoFragment = (MyInfoFragment) getSupportFragmentManager().findFragmentByTag("mMyInfoFragment");

            currentTabPosition = savedInstanceState.getInt(AppConstant.HOME_CURRENT_TAB_POSITION);
        } else {
            mPositionFragment = new HomePageFragment();
            mAuctionFragment = new AuctionFragment();
            mEnterFragment = new EnterFragment();
            mMallFragment = new MallFragment();
            mMyInfoFragment = new MyInfoFragment();

            transaction.add(R.id.fl_body, mPositionFragment, "mPositionFragment");
            transaction.add(R.id.fl_body, mAuctionFragment, "mAuctionFragment");
            transaction.add(R.id.fl_body, mEnterFragment, "mEnterFragment");
            transaction.add(R.id.fl_body, mMallFragment, "mMallFragment");
            transaction.add(R.id.fl_body, mMyInfoFragment, "mMyInfoFragment");

        }
        transaction.commit();
        SwitchTo(currentTabPosition);
        tabLayout.setCurrentTab(currentTabPosition);
    }
}
