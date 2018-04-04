package com.intention.sqtwin.ui.main.fragment;

import android.app.Dialog;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/9 0009.
 */
//implements PostionContract.View
public class HomePageFragment extends BaseFragment {
    private String moneyNum;
    private TextView tv_num;
    private Dialog mredDialog;
    // 旧的版本号 1010
    private Float old_version;
    // 显得版本号 1020
    private Float new_version;
    //升级下载链接
    private String downLoadurl;
    // 升级的文字
    private String updataText;
    // 版本号 2.02
    private String appVersion;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_homepage;
    }

    // MVP 关联的一步
    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    // 初始化全部的布局
    @Override
    protected void initView() {
       /* notificationHelper = new FileDownloadNotificationHelper<>();
        if (isLogin()) {
            *//*11.24 需求--年级不可更改，需随时更新个人信息里面的年级*//*
            mPresenter.getNinetyDaysRequest(getSqtUser().getGid());
        }
        moneyNum = getActivity().getIntent().getStringExtra(AppConstant.Moneynum);
        if (!TextUtils.isEmpty(moneyNum)) {
            InitDialog();
        }*/

//        mPresenter.getUpdateVersionRequest();
    }


  /*  @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }*/

 /*   @Override
    public void returnOrderRecomnend(OrderInfoShopCart mOrder) {

    }

    @Override
    public void returnUserIsBuyEvaluation(UserIsBuyEvaluation mUserIsBuyEvaluation) {

    }

    @Override
    public void returnUpdate(AppVersionBean mAppVersion) {

    }

    @Override
    public void scrolltoTop() {

    }

    @Override
    public void returnNinetyDaysData(NinetyDays mNinetyDays) {

    }*/
}
