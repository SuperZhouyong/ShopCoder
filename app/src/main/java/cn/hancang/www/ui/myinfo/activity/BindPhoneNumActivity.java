package cn.hancang.www.ui.myinfo.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.ui.myinfo.contract.BindPhoneNumContract;
import com.intention.sqtwin.ui.myinfo.model.BindPhoneNumModel;
import com.intention.sqtwin.ui.myinfo.presenter.BindPhoneNumPresenter;
import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.bean.OtherLoginBean;
import cn.hancang.www.bean.SmsInfoBean;
import cn.hancang.www.utils.conmonUtil.PublicKetUtils;
import cn.hancang.www.utils.conmonUtil.RegexUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**ap
 * Description: 保佑无bug
 * Data：2018/5/18-上午1:15
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class BindPhoneNumActivity extends BaseActivity<BindPhoneNumPresenter,BindPhoneNumModel> implements BindPhoneNumContract.View {
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
    @BindView(R.id.ec_bank)
    EditText ecBank;
    @BindView(R.id.auth_code_time)
    TextView authCodeTime;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    private String iphone_number;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bindphonenum;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("绑定手机");
        relSearch.setVisibility(View.GONE);
        RxView.clicks(authCodeTime).throttleFirst(5, TimeUnit.SECONDS).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {

                iphone_number = ecName.getText().toString().trim();
                if (!TextUtils.isEmpty(iphone_number) && PublicKetUtils.isMobileNO(iphone_number)) {
                    mPresenter.getSmsRequest(iphone_number, "2");
                } else {
                    showShortToast("请检查输入的手机号");
                }
            }
        });
    }


    @OnClick({R.id.rel_back,R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
//            case R.id.auth_code_time:
//                ecName.getText().toString()
//                mPresenter.getSmsRequest();
//                break;
            case R.id.tv_confirm:
                String PhoneNum = ecName.getText().toString();
                if (TextUtils.isEmpty(PhoneNum) || !RegexUtils.isMobileSimple(PhoneNum)) {
                    showShortToast("请输入正确的手机号");
                    return;
                }

                Intent intent = new Intent();
                intent.putExtra(AppConstant.PhoneNum, PhoneNum);
                setResult(RESULT_OK, intent);
                finish();
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
    public void returnSmsBean(SmsInfoBean smsInfoBean) {
        showShortToast(smsInfoBean.getMessage());
        if (!smsInfoBean.isIs_success()) {
            return;
        }
        mPresenter.ShowTvRequest(authCodeTime);
    }

    @Override
    public void returnBindPhoneNUm(OtherLoginBean otherLoginBean) {

    }
}
