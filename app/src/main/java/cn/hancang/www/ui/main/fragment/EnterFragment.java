package cn.hancang.www.ui.main.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.LazzyFragment;
import cn.hancang.www.base.LoginValid;
import cn.hancang.www.bean.StoreInfoBean;
import cn.hancang.www.ui.Store.activity.RealCerOneActivity;
import cn.hancang.www.ui.Store.activity.StoreMessageActivity;
import cn.hancang.www.ui.Store.activity.StoreRemainingMoneyActivity;
import cn.hancang.www.ui.Store.activity.StoreReportActivity;
import cn.hancang.www.ui.main.activity.MainActivity;
import cn.hancang.www.ui.main.contract.EnterContract;
import cn.hancang.www.ui.main.model.EnterModel;
import cn.hancang.www.ui.main.presenter.EnterPresenter;
import cn.hancang.www.ui.myinfo.activity.LoginActivity;
import cn.hancang.www.ui.myinfo.activity.OrderListActivity;
import cn.hancang.www.ui.myinfo.activity.StorePassWordActivity;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;

import com.toptechs.libaction.action.Action;
import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Description: 绝无Bug
 * Data：2018/4/15-下午2:47
 * Blog：Super简单
 * Author: ZhouYong
 */

public class EnterFragment extends LazzyFragment<EnterPresenter, EnterModel> implements EnterContract.View, Action {
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
    ImageView ivHeadIcon;
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
    @BindView(R.id.tv_store_desc)
    TextView tvstoredesc;
    private boolean isCan = false;

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
    public void onResume() {
        super.onResume();


    }

    @Override
    public void initView() {
        relHeadTitle.setBackgroundColor(getResources().getColor(R.color.transparent));
        relBack.setVisibility(View.GONE);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("店铺");
        relSearch.setVisibility(View.GONE);
        ImageLoaderUtils.displayRoundInt(getActivity(), ivHeadIcon, R.mipmap.ic_launcher);
        mRxManager.on(AppConstant.EnterFragment, new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                if (aBoolean) {
                    SingleCall.getInstance()
                            .addAction(EnterFragment.this, AppConstant.oneMessage)
                            .addValid(new LoginValid(getActivity()))
                            .doCall();
                }
            }
        });
        mRxManager.on(AppConstant.EnterClear, new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                ImageLoaderUtils.displayRound(getActivity(), ivHeadIcon, "");
                tvStoreName.setText("店铺名字");
                tvFansNum.setText("粉丝    ");
                tvstoredesc.setText("");
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
    public void returnStoreInfo(StoreInfoBean storeInfoBean) {
        isCan = storeInfoBean.isIs_success();
        if (!storeInfoBean.isIs_success()) {
            showShortToast(storeInfoBean.getMessage());
            startActivity(RealCerOneActivity.class, null);
            return;
        }
        StoreInfoBean.DataBean data = storeInfoBean.getData();
        ImageLoaderUtils.displayRound(getActivity(), ivHeadIcon, data.getStore_logo());
        tvStoreName.setText(TextUtils.isEmpty(data.getStore_name()) ? "" : data.getStore_name());
        tvFansNum.setText("粉丝    " + data.getFans_count());
        tvstoredesc.setText(data.getStore_description());
    }


    @OnClick({R.id.ll_one, R.id.ll_two, R.id.ll_three, R.id.ll_fore, R.id.ll_five, R.id.rel_remaining_sum, R.id.rel_seller_message, R.id.rel_identit, R.id.rel_store_pw})
    public void onViewClicked(View view) {
        if (!isLogin()) {
            SingleCall.getInstance().clear();
            LoginActivity.start(getActivity());
            return;
        }


        switch (view.getId()) {
            // 待付款
            case R.id.ll_one:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 1, 1);
                break;
            //待发货---> 已发货
            case R.id.ll_two:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 2, 1);
                break;
            // 待收货 ---> 已收货
            case R.id.ll_three:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 3, 1);
                break;
            //售后
            case R.id.ll_fore:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 0, 1);
                break;
            //店铺报表
            case R.id.ll_five:
                startActivity(StoreReportActivity.class, null);
                break;
            //余额
            case R.id.rel_remaining_sum:
                startActivity(StoreRemainingMoneyActivity.class, null);
                break;
            // 进入消息界面
            case R.id.rel_seller_message:
                startActivity(StoreMessageActivity.class, null);
                break;
            // 实名认证
            case R.id.rel_identit:
                if (isCan) {
                    showShortToast("您已完成认证，不需要再次认证");
                    return;
                }

                startActivity(RealCerOneActivity.class, null);
                break;
            case R.id.rel_store_pw:
                if (!isCan) {
                    showShortToast("您目前没有入住店铺，不能设置密码");
                    return;
                }
                startActivity(StorePassWordActivity.class, null);
                break;
        }
    }

    @Override
    public void call(String tag) {
        if (AppConstant.oneMessage.equals(tag))
            mPresenter.getStoreInfoRequest();
    }
}
