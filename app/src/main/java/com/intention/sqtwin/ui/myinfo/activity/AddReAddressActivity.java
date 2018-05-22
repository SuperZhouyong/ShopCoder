package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.AllRegion;
import com.intention.sqtwin.bean.BeanId;
import com.intention.sqtwin.bean.SubmitAddressBean;
import com.intention.sqtwin.bean.UpdateAddressBean;
import com.intention.sqtwin.ui.myinfo.contract.AddReAddressContract;
import com.intention.sqtwin.ui.myinfo.model.AddReAddressModel;
import com.intention.sqtwin.ui.myinfo.presenter.AddReAddressPresenter;
import com.intention.sqtwin.widget.wheelpicker.WheelPickerUtils;
import com.kyleduo.switchbutton.SwitchButton;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Description: 绝无Bug
 * Data：2018/5/17 0017-下午 14:48
 * Blog：Super简单
 * Author: ZhouYong
 */

public class AddReAddressActivity extends BaseActivity<AddReAddressPresenter, AddReAddressModel> implements AddReAddressContract.View, CompoundButton.OnCheckedChangeListener {
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
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.ec_name)
    EditText ecName;
    @BindView(R.id.tv_three)
    TextView tvThree;
    @BindView(R.id.ec_phone)
    EditText ecPhone;
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.rel_city)
    RelativeLayout relCity;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ec_address)
    EditText ecAddress;
    @BindView(R.id.tv_fore)
    TextView tvFore;
    @BindView(R.id.switch_button)
    SwitchButton switchButton;
    @BindView(R.id.tv_save)
    TextView tvSave;
    private AllRegion mAllRegion;
    private UpdateAddressBean mUpdateAddressBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_addreaddress;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("添加收货地址");
        relSearch.setVisibility(View.GONE);
        mUpdateAddressBean = new UpdateAddressBean();
        mUpdateAddressBean.setAddress_is_default(0);
        // 监听到确认按钮
        mRxManager.on(AppConstant.ConfirmOk, new Action1<BeanId>() {
            @Override
            public void call(BeanId beanId) {
                mUpdateAddressBean.setProvince_id(beanId.getProvinceId());
                mUpdateAddressBean.setCity_id(beanId.getCityId());
                mUpdateAddressBean.setArea_id(beanId.getRegionID());
            }
        });
        mPresenter.getAllRegion();
        switchButton.setOnCheckedChangeListener(this);
    }


    @OnClick({R.id.rel_back, R.id.rel_city, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_city:
                IsShowHideInput();

                if (mAllRegion != null) {
                    intithreepop(mAllRegion.getData());
                } else {
                    // 重试重试机制
                    mPresenter.getAllRegion();
                    showShortToast("请稍候再试");
                }
                break;
            case R.id.tv_save:
                String name = ecName.getText().toString().trim();
                String phoneNum = ecPhone.getText().toString().trim();
                String address = ecAddress.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    showShortToast("请填写您的名字");
                    return;
                }
                if (TextUtils.isEmpty(phoneNum)) {
                    showShortToast("请填写联系电话");
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    showShortToast("请填写详细地址");
                    return;
                }

                mUpdateAddressBean.setName(name);
                mUpdateAddressBean.setPhone(phoneNum);
                mUpdateAddressBean.setAddress(address);

                mPresenter.getSubmitAddressBean(mUpdateAddressBean);
                break;
        }
    }

    private void IsShowHideInput() {
        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

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
    public void returnAllregion(AllRegion allRegion) {
        if (allRegion.isIs_success())
            mAllRegion = allRegion;
    }

    @Override
    public void returnSubmitAddressBean(SubmitAddressBean submitAddressBean) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mUpdateAddressBean.setAddress_is_default(isChecked?1:0);
    }
}