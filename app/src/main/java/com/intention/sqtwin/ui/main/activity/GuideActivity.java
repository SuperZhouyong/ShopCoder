package com.intention.sqtwin.ui.main.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.base.BaseFragmentAdapter;
import com.intention.sqtwin.ui.main.activity.fragment.FragmentOne;
import com.intention.sqtwin.ui.main.activity.fragment.FragmentThree;
import com.intention.sqtwin.ui.main.activity.fragment.FragmentTwo;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;
import com.intention.sqtwin.widget.ParallaxViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/25 0025.
 */

public class GuideActivity extends BaseActivity {
    @BindView(R.id.view_pager)
    ParallaxViewPager viewPager;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.tv_next)
    TextView tv_next;
    private BaseFragmentAdapter baseFragmentAdapter;
    private Bitmap backgroundBitmap;
    private Animation animation;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {


    }

    private BitmapFactory.Options getBitmapOption() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = 4;
        return options;
    }

    @Override
    public void initView() {
        // 判断是否是第一次打开App

        iniFirst();


    }

    private void iniFirst() {
        viewPager.setBackgroundResource(R.mipmap.splash_bg1);
        animation = AnimationUtils.loadAnimation(this, R.anim.scale_dot);
        ArrayList fragments = new ArrayList<Fragment>();
        FragmentOne one = new FragmentOne();
        FragmentTwo two = new FragmentTwo();
        FragmentThree three = new FragmentThree();
        fragments.add(one);
        fragments.add(two);
        fragments.add(three);
        if (backgroundBitmap != null) {
            backgroundBitmap.recycle();
        }
        backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.splash_bg1, getBitmapOption());
        baseFragmentAdapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(baseFragmentAdapter);
        viewPager.setBackground(backgroundBitmap);
        changeIcon(iv1, iv2, iv3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                animation.cancel();
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        changeIcon(iv1, iv2, iv3);
                        tv_next.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        changeIcon(iv2, iv3, iv1);
                        tv_next.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        changeIcon(iv3, iv1, iv2);
                        tv_next.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void changeIcon(ImageView imageView1, ImageView imageView2, ImageView imageView3) {
        ViewGroup.LayoutParams params = imageView1.getLayoutParams();
        params.width = getResources().getDimensionPixelSize(R.dimen.x16);
        params.height = getResources().getDimensionPixelSize(R.dimen.x16);
        imageView1.setLayoutParams(params);
        imageView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_circle));
        imageView1.startAnimation(animation);
        ViewGroup.LayoutParams params1 = imageView2.getLayoutParams();
        params1.width = getResources().getDimensionPixelSize(R.dimen.x12);
        params1.height = getResources().getDimensionPixelSize(R.dimen.x12);
        ViewGroup.LayoutParams params2 = imageView3.getLayoutParams();
        params2.width = getResources().getDimensionPixelSize(R.dimen.x12);
        params2.height = getResources().getDimensionPixelSize(R.dimen.x12);
        imageView2.setLayoutParams(params1);
        imageView3.setLayoutParams(params2);
        imageView2.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_circle_small));
        imageView3.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_circle_small));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (backgroundBitmap != null) {
            backgroundBitmap.recycle();
            backgroundBitmap = null;
            System.gc();
        }
    }

    @OnClick(R.id.tv_next)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                SPUtils.setSharedBooleanData(this, AppConstant.isFirstStart, true);

                startActivity(new Intent(this, MainActivity.class));

                finish();
                break;
        }
    }

  /*  *//**
     * 判断是否登录
     *//*
    protected boolean isLogin() {

        if (null == UserUtil.getLoginInfo()) {// 进入首页面先判断本地是否有信息
            return false;
        }

        if (TextUtils.isEmpty(UserUtil.getLoginInfo().getGid())) {// 根据登录保存的信息进行是否登录判断
            return false;
        } else {
            return true;
        }
        //
    }*/
}
