package cn.hancang.www.ui.myinfo.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.utils.conmonUtil.AppUtil;

/**
 * Description: 保佑无bug
 * Data：2018/7/2-下午8:04
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class DeveloperActivity extends BaseActivity {
    @BindView(R.id.tv_version)
    TextView tvVersion;

    @Override
    public int getLayoutId() {
        return R.layout.activity_developer;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        tvVersion.setText("您的当前版本code" + AppUtil.appBuildCode() + "\n" + " 版本Version  " + AppUtil.androidVersion() + "\n" + " 版本 " + AppUtil.appVersionName());
    }


}
