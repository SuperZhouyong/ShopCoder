package com.intention.sqtwin.ui.Store.activity;

import android.content.Intent;
import android.net.Uri;
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
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.RealNamePeoTwoBean;
import com.intention.sqtwin.bean.UpComPanyTwoBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.ui.Store.contract.RealNameEnterTwoContract;
import com.intention.sqtwin.ui.Store.model.RealNameEnterTwoModel;
import com.intention.sqtwin.ui.Store.presenter.RealNameEnterTwoPresenter;
import com.intention.sqtwin.utils.TakePictureManager;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.RegexUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Description: 保佑无bug
 * Data：2018/5/18-下午10:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class RealNameEnterTwoActivity extends BaseActivity<RealNameEnterTwoPresenter, RealNameEnterTwoModel> implements RealNameEnterTwoContract.View, TakePictureManager.takePictureCallBackListener, BottomDialog.ViewListener {
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
    @BindView(R.id.ec_identity_num)
    EditText ecIdentityNum;
    @BindView(R.id.ec_phone_num)
    EditText ecPhoneNum;
    @BindView(R.id.tv_identity_one)
    TextView tvIdentityOne;
    @BindView(R.id.take_pic_one)
    ImageView takePicOne;
    @BindView(R.id.iv_src_identity_one)
    ImageView ivSrcIdentityOne;
    @BindView(R.id.tv_identity_two)
    TextView tvIdentityTwo;
    @BindView(R.id.take_pic_two)
    ImageView takePicTwo;
    @BindView(R.id.iv_src_identity_two)
    ImageView ivSrcIdentityTwo;
    @BindView(R.id.tv_identity_three)
    TextView tvIdentityThree;
    @BindView(R.id.take_pic_three)
    ImageView takePicThree;
    @BindView(R.id.iv_src_identity_three)
    ImageView ivSrcIdentityThree;
    @BindView(R.id.tv_bottom)
    TextView tvBottom;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.stepView)
    HorizontalStepView horizontalStepView;
    private TakePictureManager takePictureManager;
    private BaseBottomDialog bottomDialog;
    private HashMap<String, String> mHashMap;
    private Map<String, RequestBody> mMaps;
    private UpComPanyTwoBean upComPanyTwoBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_realnameentertwo;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        relSearch.setVisibility(View.GONE);
        centerTitle.setText("认证中心");

        mHashMap = new HashMap<>();
        mMaps = new LinkedHashMap<>();
        upComPanyTwoBean = new UpComPanyTwoBean();

        takePictureManager = new TakePictureManager(this);
        takePictureManager.setTailor(1, 1, 300, 300);


        takePictureManager.setTakePictureCallBackListener(this);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("企业信息", 1);
        StepBean stepBean1 = new StepBean("个人信息", -1);
        StepBean stepBean2 = new StepBean("店铺信息", -1);
        StepBean stepBean3 = new StepBean("提交审核", -1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
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


    @OnClick({R.id.rel_back, R.id.take_pic_one, R.id.take_pic_two, R.id.take_pic_three, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.take_pic_one:
                ShowBootomDialog(AppConstant.oneMessage);
                break;
            case R.id.take_pic_two:
                ShowBootomDialog(AppConstant.twoMessage);
                break;
            case R.id.take_pic_three:
                ShowBootomDialog(AppConstant.threeMessage);
                break;

            case R.id.tv_confirm:
                // 企业名称
                String comName = this.ecName.getText().toString().trim();
                //法人姓名
                String comPeoName = ecIdentityNum.getText().toString().trim();
                //身份证号
                String comUserIdenNum = ecPhoneNum.getText().toString().trim();

                if (TextUtils.isEmpty(comName) || TextUtils.isEmpty(comPeoName) || TextUtils.isEmpty(comUserIdenNum)) {
                    showShortToast("请检查必填信息，确认是否完整填写");
                    return;
                }

                if (!RegexUtils.isIDCard15(comUserIdenNum) && !RegexUtils.isIDCard18(comUserIdenNum)) {
                    showShortToast("请输入正确的身份证号");
                    return;
                }
                upComPanyTwoBean.setCompany_name(comName);
                upComPanyTwoBean.setCorporation_name(comPeoName);
                upComPanyTwoBean.setCorporation_id_card_number(comUserIdenNum);

                mMaps.clear();
                if (TextUtils.isEmpty(mHashMap.get(AppConstant.oneMessage))) {
                    showShortToast("请上传营业执照照片");
                    return;
                }
                if (TextUtils.isEmpty(mHashMap.get(AppConstant.twoMessage))) {
                    showShortToast("请上传法人身份证正面照");
                    return;
                }
                if (TextUtils.isEmpty(mHashMap.get(AppConstant.threeMessage))) {
                    showShortToast("请上传法人身份证反面照");
                    return;
                }
                File file1 = new File(mHashMap.get(AppConstant.oneMessage));
                RequestBody requestFile1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                mMaps.put("1image\"; filename=\"" + file1.getName(), requestFile1);

                File file2 = new File(mHashMap.get(AppConstant.twoMessage));
                RequestBody requestFile2 = RequestBody.create(MediaType.parse("multipart/form-data"), file2);
                mMaps.put("2image\"; filename=\"" + file2.getName(), requestFile2);


                File file3 = new File(mHashMap.get(AppConstant.threeMessage));
                RequestBody requestFile3 = RequestBody.create(MediaType.parse("multipart/form-data"), file3);
                mMaps.put("3image\"; filename=\"" + file3.getName(), requestFile3);


                mPresenter.updateImageRequest(mMaps);

//                startActivity(RealNameEnterThreeActivity.class);
                break;
        }
    }

    @Override
    public void successful(boolean isTailor, File outFile, Uri filePath) {
        // 正面照
        String tag = bottomDialog.getFragmentTag();
        if (AppConstant.oneMessage.equals(bottomDialog.getFragmentTag())) {
            ImageLoaderUtils.display(this, ivSrcIdentityOne, outFile.getAbsolutePath());
            mHashMap.put(AppConstant.oneMessage, outFile.getAbsolutePath());
        } else if (AppConstant.twoMessage.equals(bottomDialog.getFragmentTag())) {
            //背面照
            ImageLoaderUtils.display(this, ivSrcIdentityTwo, outFile.getAbsolutePath());
            mHashMap.put(AppConstant.twoMessage, outFile.getAbsolutePath());
        } else if (AppConstant.threeMessage.equals(bottomDialog.getFragmentTag())) {
            ImageLoaderUtils.display(this, ivSrcIdentityThree, outFile.getAbsolutePath());
            mHashMap.put(AppConstant.threeMessage, outFile.getAbsolutePath());

        }

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

    @Override
    public void failed(int errorCode, List<String> deniedPermissions) {

    }

    private void ShowBootomDialog(String tag) {
        bottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setLayoutRes(R.layout.bottom_takephoto)
                .setViewListener(this)
                .setTag(tag)
                .show();
    }


    @Override
    public void bindView(android.view.View view) {
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
        upComPanyTwoBean.setBusiness_licence_number_electronic(updateImageBean.getData().get(0).getUrl());
        upComPanyTwoBean.setCorporation_id_card_photo_front(updateImageBean.getData().get(1).getUrl());
        upComPanyTwoBean.setCorporation_id_card_photo_back(updateImageBean.getData().get(2).getUrl());
        mPresenter.UpPeoEnterInfoRequest(upComPanyTwoBean);
    }

    @Override
    public void returnUpdateEnterTwo(RealNamePeoTwoBean realNamePeoTwoBean) {
        if (!realNamePeoTwoBean.isIs_success()) {
            showShortToast(realNamePeoTwoBean.getMessage());
            return;
        }
        startActivity(RealNameEnterThreeActivity.class);
    }
}
