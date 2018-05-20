package com.intention.sqtwin.ui.main.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.LazzyFragment;
import com.intention.sqtwin.bean.StoreInfoBean;
import com.intention.sqtwin.ui.Store.activity.RealCerOneActivity;
import com.intention.sqtwin.ui.main.contract.EnterContract;
import com.intention.sqtwin.ui.main.model.EnterModel;
import com.intention.sqtwin.ui.main.presenter.EnterPresenter;
import com.intention.sqtwin.widget.CircleImageView;


import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Description: 绝无Bug
 * Data：2018/4/15-下午2:47
 * Blog：Super简单
 * Author: ZhouYong
 */

public class EnterFragment extends LazzyFragment<EnterPresenter, EnterModel> implements EnterContract.View {
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

    @BindView(R.id.iv_head_icon)
    CircleImageView ivHeadIcon;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_fans_num)
    TextView tvFansNum;
    @BindView(R.id.iv_item)
    ImageView ivItem;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.ll_two)
    LinearLayout llTwo;
    @BindView(R.id.ll_three)
    LinearLayout llThree;
    @BindView(R.id.ll_fore)
    LinearLayout llFore;
    @BindView(R.id.ll_five)
    LinearLayout llFive;
    @BindView(R.id.iv_account)
    ImageView ivAccount;
    @BindView(R.id.rel_remaining_sum)
    RelativeLayout relRemainingSum;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.rel_seller_message)
    RelativeLayout relSellerMessage;
    @BindView(R.id.iv_identity)
    ImageView ivIdentity;
    @BindView(R.id.rel_identit)
    RelativeLayout relIdentit;
    @BindView(R.id.title)
    RelativeLayout relHeadTitle;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_thestore;
    }

    @Override
    protected void RequestNetWorkData() {
//        mPresenter.getStoreInfoRequest();
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        relHeadTitle.setBackgroundColor(getResources().getColor(R.color.transparent));
        relBack.setVisibility(View.GONE);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("店铺");
        relSearch.setVisibility(View.GONE);

        mRxManager.on(AppConstant.EnterFragment, new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if (aBoolean)
                    mPresenter.getStoreInfoRequest();
            }
        });
    }


    @OnClick({R.id.rel_remaining_sum, R.id.rel_seller_message, R.id.rel_identit})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.rel_remaining_sum:
                break;
            case R.id.rel_seller_message:
                break;
            case R.id.rel_identit:
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
    public void returnStoreInfo(StoreInfoBean storeInfoBean) {
        if (!storeInfoBean.isIs_success())
            showShortToast(storeInfoBean.getMessage());
       /* new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);*/
        startActivity(RealCerOneActivity.class, null);
//        sta
    }
}
