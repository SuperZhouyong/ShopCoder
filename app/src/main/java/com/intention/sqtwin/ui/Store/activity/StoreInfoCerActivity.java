package com.intention.sqtwin.ui.Store.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;
import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.ReanlNameStoreInfoBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.ui.Store.contract.StoreInfoCerCOntract;
import com.intention.sqtwin.ui.Store.model.StoreInfoCerModel;
import com.intention.sqtwin.ui.Store.model.StoreInfoComModel;
import com.intention.sqtwin.ui.Store.presenter.StoreInfoCerPresenter;
import com.intention.sqtwin.utils.TakePictureManager;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Description: 店铺提交
 * Data：2018/5/18-下午11:24
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoCerActivity extends BaseActivity<StoreInfoCerPresenter, StoreInfoCerModel> implements TakePictureManager.takePictureCallBackListener, BottomDialog.ViewListener, StoreInfoCerCOntract.View {


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

    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.ec_name)
    EditText ecName;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    //    @BindView(R.id.ec_identity_num)
//    EditText ecIdentityNum;
    @BindView(R.id.ec_phone_num)
    EditText ecPhoneNum;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.stepView)
    HorizontalStepView horizontalStepView;
    private TakePictureManager takePictureManager;
    private BaseBottomDialog bottomDialog;
    private HashMap<String, String> mHashMap;
    private Map<String, RequestBody> mMaps;

    @Override
    public int getLayoutId() {
        return R.layout.activity_storeinfocer;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("认证中心");
        relSearch.setVisibility(View.GONE);

        mHashMap = new HashMap<>();
        mMaps = new LinkedHashMap<>();

        takePictureManager = new TakePictureManager(this);
        takePictureManager.setTailor(1, 1, 300, 300);

        takePictureManager.setTakePictureCallBackListener(this);

        String string = getIntent().getExtras().getString(AppConstant.RealNameType);
        List<StepBean> stepsBeanList = new ArrayList<>();
        if (AppConstant.RealNameTypeOne.equals(string)) {
            StepBean stepBean0 = new StepBean("个人信息", -1);
            StepBean stepBean1 = new StepBean("店铺信息", 1);
            StepBean stepBean2 = new StepBean("提交审核", -1);

            stepsBeanList.add(stepBean0);
            stepsBeanList.add(stepBean1);
            stepsBeanList.add(stepBean2);


        } else {
            StepBean stepBean0 = new StepBean("企业信息", -1);
            StepBean stepBean1 = new StepBean("个人信息", -1);
            StepBean stepBean2 = new StepBean("店铺信息", 1);
            StepBean stepBean3 = new StepBean("提交审核", -1);

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
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.real_name_bg))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.real_name_bg_nu))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.real_name_bg_nu));//设置StepsViewIndicator AttentionIcon


    }


    @OnClick({R.id.rel_back, R.id.tv_confirm, R.id.rel_logo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_logo:
                ShowBootomDialog(AppConstant.oneMessage);
                break;
            case R.id.tv_confirm:
                String userName = ecName.getText().toString().trim();
                String userDesc = ecPhoneNum.getText().toString().trim();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(userDesc)) {
                    showShortToast("请检查必填信息，确认是否完整填写");
                    return;
                }
                mMaps.clear();
                File file1 = new File(mHashMap.get(AppConstant.oneMessage));
                RequestBody requestFile1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                mMaps.put("1image\"; filename=\"" + file1.getName(), requestFile1);


                mPresenter.updateImageRequest(mMaps);
//                SubmitAuditActivity.gotoSubmitAuditActivity(this, getIntent().getExtras().getString(AppConstant.RealNameType));
                break;
        }
    }


    public static void gotoTheActivity(BaseActivity mActivity, String type) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.RealNameType, type);
        mActivity.startActivity(StoreInfoCerActivity.class, bundle);
    }

    @Override
    public void successful(boolean isTailor, File outFile, Uri filePath) {
        if (AppConstant.oneMessage.equals(bottomDialog.getFragmentTag())) {
            ImageLoaderUtils.display(this, ivLogo, outFile.getAbsolutePath());
            mHashMap.put(AppConstant.oneMessage, outFile.getAbsolutePath());
        }
    }

    @Override
    public void failed(int errorCode, List<String> deniedPermissions) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        takePictureManager.attachToActivityForResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        takePictureManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void ShowBootomDialog(String tag) {
        bottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setLayoutRes(R.layout.bottom_takephoto)
                .setViewListener(this)
                .setTag(tag)
                .show();
    }

    @Override
    public void bindView(View view) {
        view.findViewById(R.id.tv_take_carema).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                takePictureManager.startTakeWayByCarema();

            }
        });
        view.findViewById(R.id.tv_take_albun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                takePictureManager.startTakeWayByAlbum();
            }
        });
    }

    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {

    }

    @Override
    public void showErrorTip(String RequestId, String msg) {

    }

    @Override
    public void returnUpdateImage(UpdateImageBean updateImageBean) {
        if (!updateImageBean.isIs_success()) {
            showShortToast(updateImageBean.getMessage());
            return;
        }
        mPresenter.UpdateStoreInfoCer(ecName.getText().toString().trim(), ecPhoneNum.getText().toString().trim(), updateImageBean.getData().get(0).getUrl());

    }

    @Override
    public void returnUpdateStoreInfoCer(ReanlNameStoreInfoBean reanlNameStoreInfoBean) {
        if (!reanlNameStoreInfoBean.isIs_success()){
            showShortToast(reanlNameStoreInfoBean.getMessage());
            return;
        }

        SubmitAuditActivity.gotoSubmitAuditActivity(this, getIntent().getExtras().getString(AppConstant.RealNameType));
    }
}
