package cn.hancang.www.ui.Store.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseapp.AppManager;
import cn.hancang.www.ui.main.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-上午1:28
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class SubmitAuditActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;

    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.stepView)
    HorizontalStepView horizontalStepView;
    private String string;

    @Override
    public int getLayoutId() {
        return R.layout.activity_submitadit;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("认证中心");
        relSearch.setVisibility(View.GONE);
        string = getIntent().getExtras().getString(AppConstant.RealNameType);
        List<StepBean> stepsBeanList = new ArrayList<>();
        if (AppConstant.RealNameTypeOne.equals(string)) {
            StepBean stepBean0 = new StepBean("个人信息", -1);
            StepBean stepBean1 = new StepBean("店铺信息", -1);
            StepBean stepBean2 = new StepBean("提交审核", 1);

            stepsBeanList.add(stepBean0);
            stepsBeanList.add(stepBean1);
            stepsBeanList.add(stepBean2);


        } else {
            StepBean stepBean0 = new StepBean("企业信息", -1);
            StepBean stepBean1 = new StepBean("个人信息", -1);
            StepBean stepBean2 = new StepBean("店铺信息", -1);
            StepBean stepBean3 = new StepBean("提交审核", 1);

            stepsBeanList.add(stepBean0);
            stepsBeanList.add(stepBean1);
            stepsBeanList.add(stepBean2);
            stepsBeanList.add(stepBean3);


        }
        horizontalStepView.setStepViewTexts(stepsBeanList)
                .setTextSize(16)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, R.color.font_2))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.font_2))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, R.color.font_1))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.font_1))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.mipmap.icon_current_ing))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.mipmap.icon_current_nomal))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.mipmap.icon_current_nomal));//设置StepsViewIndicator AttentionIcon


    }


    @OnClick({R.id.rel_back, R.id.rel_search, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
            case R.id.tv_confirm:
                // 个人信息

                AppManager.getAppManager().returnToActivity(MainActivity.class);
                /*if (AppConstant.RealNameTypeOne.equals(string)) {
                    AppManager.getAppManager().finishActivity(RealNamePeoOneActivity.class);
                    AppManager.getAppManager().finishActivity(RealNamePeoTwoActivity.class);
                    AppManager.getAppManager().finishActivity(StoreInfoCerActivity.class);
                } else {
                    // 企业信息
                    AppManager.getAppManager().finishActivity(RealNameEnterOneActivity.class);
                    AppManager.getAppManager().finishActivity(RealNameEnterTwoActivity.class);
                    AppManager.getAppManager().finishActivity(RealNameEnterThreeActivity.class);
                    AppManager.getAppManager().finishActivity(StoreInfoCerActivity.class);
                }*/


                finish();
                break;
        }
    }

    public static void gotoSubmitAuditActivity(BaseActivity mActivity, String type) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.RealNameType, type);
        mActivity.startActivity(SubmitAuditActivity.class, bundle);
    }
}
