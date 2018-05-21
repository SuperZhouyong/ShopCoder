package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Intent;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.api.Api;
import com.intention.sqtwin.api.HostType;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baserx.RxSchedulers;
import com.intention.sqtwin.baserx.RxSubscriber;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.MyInfoBean;
import com.intention.sqtwin.utils.TakePictureManager;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;
import com.intention.sqtwin.widget.wheelpicker.WheelPickerUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;

/**
 * Description: 保佑无bug
 * Data：2018/5/8-上午1:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EditInfoActivity extends BaseActivity implements LoadingTip.onReloadListener, TakePictureManager.takePictureCallBackListener, BottomDialog.ViewListener {


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
    @BindView(R.id.tv_icon)
    TextView tvIcon;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.user_icon)
    ImageView userIcon;
    @BindView(R.id.rel_icon)
    RelativeLayout relIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_name)
    ImageView ivName;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.rel_name)
    RelativeLayout relName;
    @BindView(R.id.iv_postion)
    ImageView ivPostion;
    @BindView(R.id.tv_postion)
    TextView tvPostion;
    @BindView(R.id.user_postion)
    TextView userPostion;
    @BindView(R.id.rel_postion)
    RelativeLayout relPostion;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.iv_sex)
    ImageView ivSex;
    @BindView(R.id.user_sex)
    TextView userSex;
    @BindView(R.id.rel_sex)
    RelativeLayout relSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.iv_birthday)
    ImageView ivBirthday;
    @BindView(R.id.user_birthday)
    TextView userBirthday;
    @BindView(R.id.rel_birthday)
    RelativeLayout relBirthday;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.iv_city)
    ImageView ivCity;
    @BindView(R.id.user_city)
    TextView userCity;
    @BindView(R.id.rel_city)
    RelativeLayout relCity;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.iv_address)
    ImageView ivAddress;
    @BindView(R.id.user_address)
    TextView userAddress;
    @BindView(R.id.rel_adress)
    RelativeLayout relAdress;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.user_phone)
    TextView userPhone;
    @BindView(R.id.rel_phone)
    RelativeLayout relPhone;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private TakePictureManager takePictureManager;
    private BaseBottomDialog bottomDialog;
    private final int requestCodePhone = 300;
    private final int requestCodeName = 301;

    @Override
    public int getLayoutId() {
        return R.layout.activity_editinfo;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("编辑资料");
        ImageLoaderUtils.display(this, ivSearch, R.mipmap.icon_contact);
        takePictureManager = new TakePictureManager(this);
        takePictureManager.setTailor(1, 1, 200, 200);

        takePictureManager.setTakePictureCallBackListener(this);
        RequestMyinfo();

    }

    // 性别选择
    private void initpopwindow(TextView select, List<String> bgList) {
        View view = getLayoutInflater().inflate(R.layout.item_one_wheeloicker, null);
        final PopupWindow pop = WheelPickerUtils.oneWheelPickerPop(view, select, bgList, false);
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.7f;
        getWindow().setAttributes(params);
        // 消失的监听，让背景色变回来
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1f;
                getWindow().setAttributes(params);
            }
        });
    }

    // 地址选择
    private void intithreepop(List<AllRegion.DataBean> mAllRegion) {

        View view = getLayoutInflater().inflate(R.layout.wheelviewthree, null);
        final PopupWindow pop = WheelPickerUtils.threeWheelPickerPop(view, tvCity, mAllRegion);
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.7f;
        getWindow().setAttributes(params);
        // 消失的监听，让背景色变回来
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1f;
                getWindow().setAttributes(params);

            }
        });
    }

    @OnClick({R.id.rel_back, R.id.rel_search, R.id.rel_icon, R.id.tv_confirm, R.id.rel_sex, R.id.rel_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.rel_search:
                break;
            // 头像
            case R.id.rel_icon:
                ShowBootomDialog("one");
                break;
            // 确认上传编辑数据
            case R.id.tv_confirm:
                break;
            // 选择性别
            case R.id.rel_sex:
                ArrayList<String> strings = new ArrayList<>();
                strings.add("男");
                strings.add("女");
                initpopwindow(userSex, strings);
                break;
            // 绑定手机号
            case R.id.rel_phone:
                startActivityForResult(BindPhoneNumActivity.class, requestCodePhone);
                break;
        }
    }

    private void RequestMyinfo() {
        mRxManager.add(Api.getDefault(HostType.Jsonpart)
                .getMyInfoBean()
                .compose(RxSchedulers.<MyInfoBean>io_main())
                .subscribe(new RxSubscriber<MyInfoBean>(mContext) {
                    @Override
                    protected void _onNext(MyInfoBean myInfoBean) {
                        if (!myInfoBean.isIs_success()) {
                            showShortToast(myInfoBean.getMessage());
                            return;
                        }
                        if (mLoadingTip.getVisibility() == View.VISIBLE)
                            mLoadingTip.setViewGone();
                        ImageLoaderUtils.display(mContext, userIcon, myInfoBean.getData().getImage());
                        if (!TextUtils.isEmpty(myInfoBean.getData().getImage()))
                            SPUtils.setSharedStringData(mContext, AppConstant.ImageUrl, myInfoBean.getData().getImage());
                        MyInfoBean.DataBean data = myInfoBean.getData();
                        userName.setText(data.getName());
                        userPostion.setText(data.getTitle());
                        userSex.setText(data.getSex());
                        userBirthday.setText(data.getBirthday());
                        // 城市Id 不对
//                        userCity.setText(data.getCity_id());
                        userAddress.setText(data.getAddress());
                        userPhone.setText(data.getPhone());
                    }

                    @Override
                    protected void _onError(String message) {
                        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                        mLoadingTip.setOnReloadListener(EditInfoActivity.this);
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
                    }
                }));
    }

    @Override
    public void reloadLodTip() {
        RequestMyinfo();
    }

    private void ShowBootomDialog(String tag) {
        bottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setLayoutRes(R.layout.bottom_takephoto)
                .setViewListener(this)
                .setTag(tag)
                .show();
    }

    @Override
    public void successful(boolean isTailor, File outFile, Uri filePath) {
        // 生成图片
        ImageLoaderUtils.display(this, userIcon, outFile);
    }

    @Override
    public void failed(int errorCode, List<String> deniedPermissions) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        takePictureManager.attachToActivityForResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            // 电话号码输入
            case requestCodePhone:
                break;
            case requestCodeName:
                break;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        takePictureManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
