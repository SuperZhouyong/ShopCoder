package com.intention.sqtwin.ui.main.activity;

import android.app.Activity;
import android.content.Intent;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class AuthcodeActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_authcode;
    }

    @Override
    public void initPresenter() {

    }


    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, AuthcodeActivity.class);
        activity.startActivity(intent);
        /*activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);*/
    }

    @Override
    public void initView() {

    }

}
