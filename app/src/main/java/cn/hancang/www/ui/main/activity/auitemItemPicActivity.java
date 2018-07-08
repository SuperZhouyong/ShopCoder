package cn.hancang.www.ui.main.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.widget.ViewPagerFixed;
import uk.co.senab.photoview.PhotoView;

/**
 * Description: 保佑无bug
 * Data：2018/6/28-下午9:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class auitemItemPicActivity extends BaseActivity {
    private static ArrayList<String> mlistString;
    private int Postion = 0;
    @BindView(R.id.Vp_Fix)
    ViewPagerFixed VpFix;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.pic_title)
    RelativeLayout picTitle;
    @BindView(R.id.background)
    RelativeLayout background;
    @Override
    public int getLayoutId() {
        return R.layout.activity_auitemitempic;
    }

    public static void startAction(Context mContext, View view, ArrayList<String> mlistString, int postion) {
        LogUtils.logi("1");
//        SchoolPicSDetilActivity.mlistString = mlistString;
        Intent intent = new Intent(mContext, auitemItemPicActivity.class);
        intent.putStringArrayListExtra(AppConstant.PHOTO_DETAIL, mlistString);
        intent.putExtra(AppConstant.VpCutent, postion);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
        ActivityCompat.startActivity((Activity) mContext, intent, options.toBundle());

    }
    @OnClick(R.id.rel_back)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
        }
    }
    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        SetStatusBarColor(getResources().getColor(R.color.black));
        LogUtils.logi("2");
        mlistString = getIntent().getStringArrayListExtra(AppConstant.PHOTO_DETAIL);
        Postion = getIntent().getIntExtra(AppConstant.VpCutent, 0);
        ArrayList<ImageView> list = new ArrayList<>();
        for (int i = 0; i < mlistString.size(); i++) {
            PhotoView imageView = new PhotoView(this);
            Glide.with(this).load(mlistString.get(i)).into(imageView);
            list.add(imageView);
        }
        VpFix.setAdapter(new MyPagerAdapter(list));
        VpFix.setCurrentItem(Postion);
    }
     static class MyPagerAdapter extends PagerAdapter {

        private ArrayList<ImageView> mlist;

        public MyPagerAdapter(ArrayList<ImageView> mlistString) {
            this.mlist = mlistString;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(mlist.get(position), 0);
            return mlist.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(mlist.get(position));
        }
    }
}
