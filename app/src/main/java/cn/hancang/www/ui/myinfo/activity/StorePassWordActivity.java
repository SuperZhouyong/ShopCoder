package cn.hancang.www.ui.myinfo.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.StoreLoginNameBean;
import cn.hancang.www.bean.StorePwInfoBean;
import cn.hancang.www.ui.myinfo.contract.StorePassWordContract;
import cn.hancang.www.ui.myinfo.model.StorePassWordModel;
import cn.hancang.www.ui.myinfo.presenter.StorePassWordPresenter;
import cn.hancang.www.widget.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 绝无Bug
 * Data：2018/5/31 0031-下午 18:08
 * Blog：Super简单
 * Author: ZhouYong
 */

public class StorePassWordActivity extends BaseActivity<StorePassWordPresenter, StorePassWordModel> implements StorePassWordContract.View {
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
    @BindView(R.id.ed_three)
    ClearEditText edThree;
    @BindView(R.id.ed_one)
    ClearEditText edOne;
    @BindView(R.id.ed_two)
    ClearEditText edTwo;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.ed_oldpassword)
    ClearEditText edOldPassword;
    private boolean isCanUpdate = false;
    private String member_name;

    @Override
    public int getLayoutId() {
        return R.layout.activity_storepassword;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("设置管理密码");
        relSearch.setVisibility(View.GONE);
        mPresenter.getStoreLoginNamerequest();
        showShortToast("电脑端网址：  " + AppConstant.appWxUrl);
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
                String edName = edThree.getText().toString().trim();
                String onePw = edOne.getText().toString().trim();
                String twoPw = edTwo.getText().toString().trim();
                String oldPw = edOldPassword.getText().toString();
                if (TextUtils.isEmpty(edName) || TextUtils.isEmpty(onePw) || TextUtils.isEmpty(twoPw)) {

                    showShortToast("请检查输入的信息");
                    return;
                }
                if (!onePw.equals(twoPw)) {
                    showShortToast("两次密码输入不一致");
                    return;
                }
                mPresenter.getStorePwRequest(isCanUpdate ? edName : member_name, onePw, isCanUpdate ? null : oldPw);
                break;
        }
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
    public void returnLoginName(StoreLoginNameBean storeLoginNameBean) {
        if (!storeLoginNameBean.isIs_success()) {
            showShortToast(storeLoginNameBean.getMessage());
            return;
        }
        // 空的代表了可以修改
        isCanUpdate = TextUtils.isEmpty(storeLoginNameBean.getData().getMember_name());
        member_name = storeLoginNameBean.getData().getMember_name();
        edThree.setEnabled(isCanUpdate);
        edThree.setText(isCanUpdate ? "" : member_name);
        edThree.setCaned(isCanUpdate);
//        edOldPassword.setVisibility(isCanUpdate ? View.GONE : View.VISIBLE);
    }

    //todo 暂时还未完成
    @Override
    public void returnStorePwInfo(StorePwInfoBean storePwInfoBean) {
        showShortToast(storePwInfoBean.getMessage());
        if (!storePwInfoBean.isIs_success()) {
            return;
        } else
            finish();
    }
}
