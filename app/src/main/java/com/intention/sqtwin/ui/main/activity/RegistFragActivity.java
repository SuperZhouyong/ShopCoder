package com.intention.sqtwin.ui.main.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.ui.main.activity.fragment.RegistCompleteFragment;
import com.intention.sqtwin.ui.main.activity.fragment.RegistFirstFragment;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Description:
 * Data：2017/9/14 0014-下午 17:55
 * Blog：Super简单
 * Author: ZhhouYong
 */

public class RegistFragActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.tool_title_left)
    TextView toolTitleLeft;
    @BindView(R.id.tool_title_right)
    TextView toolTitleRight;
    @BindView(R.id.fragment_content)
    FrameLayout fragmentContent;

    private RegistFirstFragment mRegistFristFragment;
    private RegistCompleteFragment mRegistCompleteFragment;
    private int tag;
    //    private int tag;

//    public PostRegistInfo getPostRegistInfo() {
//        return postRegistInfo;
//    }

    public RegistCompleteFragment getmRegistCompleteFragment() {
        return mRegistCompleteFragment;
    }

//    private PostRegistInfo postRegistInfo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_regist_fragment;
    }

    @Override
    public void initPresenter() {

    }

    public RegistFirstFragment getmRegistFristFragment() {
        return mRegistFristFragment;
    }

    @Override
    public void initView() {
//        postRegistInfo = new PostRegistInfo();
        toolTitleLeft.setText("注册");
        toolTitleRight.setText("已有账号？");
        toolTitleRight.setTextColor(getResources().getColor(R.color.font_2));
        mRegistFristFragment = RegistFirstFragment.newInstance();
        mRegistCompleteFragment = RegistCompleteFragment.newInstance();
        FragmentTransaction show = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_content, RegistFirstFragment.newInstance())
                .add(R.id.fragment_content, mRegistCompleteFragment)
                .hide(mRegistCompleteFragment)
                .show(mRegistFristFragment);
        show.commit();

        mRxManager.on(AppConstant.Finsh_Rel, new Action1<Boolean>() {

            @Override
            public void call(final Boolean aBoolean) {
                relBack.setOnClickListener(null);
                relBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (aBoolean)
                            SwitchTo(0);
                        else
                            finish();

                    }
                });
            }
        });
        SwitchTo(0);

    }

    public void SwitchTo(int position) {
        tag = position;

        mRxManager.post(AppConstant.Finsh_Rel, position == 1 ? true : false);
        setTextRight(position == 1 ? "完善信息" : "注册");
//        tag = position ;
        LogUtils.logd("主页菜单position" + position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            //首页
            case 0:
                transaction.show(mRegistFristFragment);
                transaction.hide(mRegistCompleteFragment);
                break;
            //美女
            case 1:
                transaction.hide(mRegistFristFragment);
                transaction.show(mRegistCompleteFragment);
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    public void setTextRight(String s) {
        toolTitleLeft.setText(s);
        toolTitleRight.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (tag == 1) {
            SwitchTo(0);
        } else {
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.rel_back, R.id.tool_title_right})
    void Onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tool_title_right:
                startActivity(LoginActivity.class, null);
                finish();
                break;

        }
    }

}
