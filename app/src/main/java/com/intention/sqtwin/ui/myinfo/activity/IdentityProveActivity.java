package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.OnItemClickListener;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.IdentityProveBean;
import com.intention.sqtwin.bean.UpdateImageBean;
import com.intention.sqtwin.bean.UpdateMySelf;
import com.intention.sqtwin.ui.myinfo.contract.IdentityProveContract;
import com.intention.sqtwin.ui.myinfo.model.IdentityProveModel;
import com.intention.sqtwin.ui.myinfo.presenter.IdentityProvePresenter;
import com.intention.sqtwin.utils.TakePictureManager;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.RegexUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
 * Description: 上传身份证证件
 * Data：2018/5/17-上午12:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class IdentityProveActivity extends BaseActivity<IdentityProvePresenter, IdentityProveModel> implements IdentityProveContract.View, TakePictureManager.takePictureCallBackListener, BottomDialog.ViewListener {
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
    @BindView(R.id.tv_head_desc)
    TextView tvHeadDesc;
    @BindView(R.id.iv_identity_one)
    ImageView ivIdentityOne;
    @BindView(R.id.iv_identity_two)
    ImageView ivIdentityTwo;
    @BindView(R.id.ec_name)
    EditText ecName;
    @BindView(R.id.ec_identity_num)
    EditText ecIdentityNum;
    @BindView(R.id.ec_postion_name)
    EditText ecPostionName;
    @BindView(R.id.ec_recommend_peo)
    EditText ecRecommendPeo;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.tv_updatecolor_one)
    TextView tvUpdatecolorOne;
    @BindView(R.id.tv_updatecolor_two)
    TextView tvUpdatecolorTwo;
    @BindView(R.id.tv_updatecolor_three)
    TextView tvUpdatecolorThree;
    @BindView(R.id.tv_updatecolor_fore)
    TextView tvUpdatecolorFore;
    private CommonRecycleViewAdapter<String> mAdapter;
    private TakePictureManager takePictureManager;
    private BaseBottomDialog bottomDialog;
    private UpdateMySelf updateMySelf;
    private HashMap<String, String> mHashMap;
    private Map<String, RequestBody> mMaps;


    @Override
    public int getLayoutId() {
        return R.layout.activity_identityprove;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("身份认证");
        relSearch.setVisibility(View.GONE);
        tvConfirm.setText("确认");
        ecRecommendPeo.setHint("请填写推荐人");
        ecIdentityNum.setHint("请填写身份证号码");
        ecPostionName.setHint("请填写职位");


        updateMySelf = new UpdateMySelf();
        ArrayList<String> strings = new ArrayList<>();
        updateMySelf.setImages(strings);

        mHashMap = new HashMap<>();

        mAdapter = new CommonRecycleViewAdapter<String>(this, R.layout.item_identity_iv) {
            @Override
            public void convert(ViewHolderHelper helper, String nullBean, int position) {
                if (!TextUtils.isEmpty(nullBean))
                    helper.setImageUrl(R.id.iv_identity_one, nullBean);
            }
        };
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                ShowBootomDialog(AppConstant.threeMessage);
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.add("");

        takePictureManager = new TakePictureManager(this);
        takePictureManager.setTailor(1, 1, 300, 300);

        takePictureManager.setTakePictureCallBackListener(this);

        mMaps = new HashMap<>();


        updateTextColor(tvUpdatecolorOne, 0, 1);
        updateTextColor(tvUpdatecolorTwo, 0, 1);
        updateTextColor(tvUpdatecolorThree, 0, 1);
        updateTextColor(tvUpdatecolorFore, 0, 1);
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
    public void returnIdentityProveBean(IdentityProveBean identityProveBean) {

    }

    @Override
    public void returnUpdateImage(UpdateImageBean updateImageBean) {
        if (!updateImageBean.isIs_success()) {
            showShortToast(updateImageBean.getMessage());
            return;
        }
        List<UpdateImageBean.DataBean> data = updateImageBean.getData();
        updateMySelf.setId_card_photo_front(data.get(0).getUrl());
        updateMySelf.setId_card_photo_back(data.get(1).getUrl());
//        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (i < 2) {
                continue;
            }
            updateMySelf.getImages().add(data.get(i).getUrl());
        }
        mPresenter.getIdentityProveRequest(updateMySelf);

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


    @OnClick({R.id.rel_back, R.id.rel_one, R.id.rel_two, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_one:
                ShowBootomDialog(AppConstant.oneMessage);
                break;
            case R.id.rel_two:
                ShowBootomDialog(AppConstant.twoMessage);
                break;
            case R.id.tv_confirm:
                String uName = ecName.getText().toString().trim();
                String idenNUm = ecIdentityNum.getText().toString().trim();
                String postionName = ecPostionName.getText().toString().trim();
                String recomPeo = ecRecommendPeo.getText().toString().trim();
                if (TextUtils.isEmpty(uName) || TextUtils.isEmpty(idenNUm) || TextUtils.isEmpty(postionName)) {
                    showShortToast("请检查必填信息，确认是否完整填写");
                    return;

                }
               /* if (!RegexUtils.isIDCard15(idenNUm) || !RegexUtils.isIDCard18(idenNUm)) {
                    showShortToast("请检查身份证码是否填写正确");
                    return;
                }*/

                updateMySelf.setMember_name(uName);
                updateMySelf.setId_card_number(idenNUm);
                updateMySelf.setProfession(postionName);
                if (!TextUtils.isEmpty(recomPeo))
                    updateMySelf.setOrderinviter_member_name(recomPeo);


                mMaps.clear();
//                if (mHashMap.get(AppConstant.oneMessage))
                if (TextUtils.isEmpty(mHashMap.get(AppConstant.oneMessage))) {
                    showShortToast("请上传身份证正面照");
                    return;
                }
                if (TextUtils.isEmpty(mHashMap.get(AppConstant.twoMessage))) {
                    showShortToast("请上传身份证背面照");
                    return;
                }
                File file1 = new File(mHashMap.get(AppConstant.oneMessage));
                RequestBody requestFile1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                mMaps.put("image\"; filename=\"" + file1.getName(), requestFile1);

                File file2 = new File(mHashMap.get(AppConstant.twoMessage));
                RequestBody requestFile2 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                mMaps.put("image\"; filename=\"" + file2.getName(), requestFile2);

                for (String sFile : mAdapter.getDataList()) {
                    if (TextUtils.isEmpty(sFile))
                        continue;
                    File file = new File(sFile);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    mMaps.put("image\"; filename=\"" + file.getName(), requestFile);
                }


                mPresenter.updateImageRequest(mMaps);

                break;

        }
    }

    private void ShowBootomDialog(String tag) {
        bottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setLayoutRes(R.layout.bottom_takephoto)
                .setViewListener(this)
                .setTag(tag)
                .show();
    }

    private void updateTextColor(TextView tv, int starts, int end) {
        SpannableString spannedString = new SpannableString(tv.getText().toString());
//        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.app_main)), starts[i], starts[i + 1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.font_2)), starts, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannedString);
    }

    // 照片回调成功
    @Override
    public void successful(boolean isTailor, File outFile, Uri filePath) {
        // 正面照
        String tag = bottomDialog.getFragmentTag();
        if (AppConstant.oneMessage.equals(bottomDialog.getFragmentTag())) {
            ImageLoaderUtils.display(this, ivIdentityOne, outFile.getAbsolutePath());
            mHashMap.put(AppConstant.oneMessage, outFile.getAbsolutePath());
//            updateMySelf.setId_card_photo_front(outFile);
        } else if (AppConstant.twoMessage.equals(bottomDialog.getFragmentTag())) {
            //背面照
            ImageLoaderUtils.display(this, ivIdentityTwo, outFile.getAbsolutePath());
            mHashMap.put(AppConstant.twoMessage, outFile.getAbsolutePath());
        } else if (AppConstant.threeMessage.equals(bottomDialog.getFragmentTag())) {
            List<String> dataList = mAdapter.getDataList();
            dataList.add(0, outFile.getAbsolutePath());
            mAdapter.notifyDataSetChanged();

        }


    }

    @Override
    public void failed(int errorCode, List<String> deniedPermissions) {

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


}
