package cn.hancang.www.ui.main.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;

import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.LazzyFragment;
import cn.hancang.www.ui.Store.activity.StoreFocusActivity;
import cn.hancang.www.ui.main.activity.MainActivity;
import cn.hancang.www.ui.myinfo.activity.AccountActivity;
import cn.hancang.www.ui.myinfo.activity.DeveloperActivity;
import cn.hancang.www.ui.myinfo.activity.EditInfoActivity;
import cn.hancang.www.ui.myinfo.activity.LoginActivity;
import cn.hancang.www.ui.myinfo.activity.MessageActicity;
//import cn.hancang.www.ui.myinfo.activity.MyCompeteActivity;
import cn.hancang.www.ui.myinfo.activity.MyCompeteNewActivity;
import cn.hancang.www.ui.myinfo.activity.OrderListActivity;
import cn.hancang.www.ui.myinfo.activity.SettingActivity;
import cn.hancang.www.utils.conmonUtil.ImageLoaderUtils;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.SPUtils;

import com.toptechs.libaction.action.SingleCall;

import butterknife.BindView;
import butterknife.OnClick;
import cn.hancang.www.utils.conmonUtil.UserUtil;

/**
 * Created by Administrator on 2017/2/9 0009.
 */

public class MyInfoFragment extends LazzyFragment {


    @BindView(R.id.iv_shareicon)
    ImageView ivShareicon;
    @BindView(R.id.iv_head_icon)
    ImageView ivHeadIcon;
    @BindView(R.id.ll_one)
    LinearLayout llOne;
    @BindView(R.id.ll_two)
    LinearLayout llTwo;
    @BindView(R.id.ll_three)
    LinearLayout llThree;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.rel_message)
    RelativeLayout relMessage;
    @BindView(R.id.iv_account)
    ImageView ivAccount;
    @BindView(R.id.rel_acount)
    RelativeLayout relAcount;
    @BindView(R.id.iv_mycompete)
    ImageView ivMycompete;
    @BindView(R.id.rel_mycompete)
    RelativeLayout relMycompete;
    @BindView(R.id.iv_identity)
    ImageView ivIdentity;
    /* @BindView(R.id.rel_identit)
     RelativeLayout relIdentit;*/
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.rel_setting)
    RelativeLayout relSetting;
    @BindView(R.id.iv_help)
    ImageView ivHelp;
    /* @BindView(R.id.rel_help)
     RelativeLayout relHelp;*/
    @BindView(R.id.iv_store_manage)
    ImageView ivStoreManage;
    @BindView(R.id.rel_store_mange)
    RelativeLayout relStoreMange;
    @BindView(R.id.iv_focus)
    ImageView ivFocus;
    @BindView(R.id.rel_focus)
    RelativeLayout relFocus;
    @BindView(R.id.tv_name)
    TextView tvname;
    private java.lang.String TAG = "MyInfoFragment";

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_myinfo;
    }

    @Override
    protected void RequestNetWorkData() {

    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    private int clickNum = 0;   //点击后门的次数
    private long mLimitTime; //临时存储第一次点击后门入口时候的毫秒值

    @Override
    protected void initView() {


//        if (!TextUtils.isEmpty(SPUtils.getSharedStringData(getActivity(), AppConstant.ImageUrl)))

        ivHeadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.5秒 点击五次后门入口方可进入开发入口、
                if (clickNum == 0) {
                    mLimitTime = System.currentTimeMillis();
                } else {
                    if (System.currentTimeMillis() - mLimitTime > 1500 || System.currentTimeMillis() - mLimitTime < 0) {
                        clickNum = 0;
                        mLimitTime = System.currentTimeMillis();
                    }
                }
                ++clickNum;
                if (clickNum == 7) {
                    //开启后门
                    clickNum = 0;
                    Intent intent = new Intent(getActivity(), DeveloperActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ImageLoaderUtils.displayRound(getActivity(), ivHeadIcon, SPUtils.getSharedStringData(getActivity(), AppConstant.ImageUrl));
        LogUtils.logd(TAG + "-------------" + SPUtils.getSharedStringData(getActivity(), AppConstant.ImageUrl) + "-----" + SPUtils.getSharedStringData(getActivity(), AppConstant.UserName));
//        if (!TextUtils.isEmpty(SPUtils.getSharedStringData(getActivity(), AppConstant.UserName)))
        tvname.setText(SPUtils.getSharedStringData(getActivity(), AppConstant.UserName));

    }

    // R.id.rel_identit,  R.id.rel_help,
    @OnClick({R.id.iv_shareicon, R.id.ll_one, R.id.ll_two, R.id.ll_three, R.id.rel_message, R.id.rel_acount, R.id.rel_mycompete, R.id.rel_setting, R.id.rel_store_mange, R.id.rel_focus})
    public void onViewClicked(View view) {

        if (!isLogin()) {
            SingleCall.getInstance().clear();
            LoginActivity.start(getActivity());
            return;
        }

        switch (view.getId()) {
            case R.id.iv_shareicon:
                startActivity(getActivity(), EditInfoActivity.class);
                break;
            //0：拍卖订单 1：商品订单
            case R.id.ll_one:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 1, 0);
//                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_two:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 3, 0);
//                startActivity(getActivity(), OrderListActivity.class);
                break;
            case R.id.ll_three:
                OrderListActivity.GotoOrderListActivity((MainActivity) getActivity(), 0, 0);
//                startActivity(getActivity(), OrderListActivity.class);
                break;
            // 消息
            case R.id.rel_message:
                startActivity(getActivity(), MessageActicity.class);
                break;
            // 资金账户
            case R.id.rel_acount:
                startActivity(getActivity(), AccountActivity.class);
                break;
            // 我的竞拍
            case R.id.rel_mycompete:
                startActivity(getActivity(), MyCompeteNewActivity.class);
//                startActivity(getActivity(), MyCompeteActivity.class);
                break;
            // 身份认证
          /*  case R.id.rel_identit:
                startActivity(getActivity(), IdentityProveActivity.class);
                break;*/
            // 设置
            case R.id.rel_setting:
//                startActivity(getActivity(), SettingActivity.class);
                if (isLogin()) {
                    UserUtil.setLoginInfo(null);
                    showShortToast("已完成退出登录");
                    SPUtils.setSharedStringData(getActivity(), AppConstant.ImageUrl, "");
                    SPUtils.setSharedStringData(getActivity(), AppConstant.UserName, "");
                    mRxManager.post(AppConstant.EnterClear, true);
                    MainActivity.startAction(getActivity());
                } else
                    showShortToast("您未登录");
                break;
         /*   // 帮助中心
            case R.id.rel_help:
                break;*/
            // 店铺管理
            case R.id.rel_store_mange:
                ((MainActivity) getActivity()).setCurrentPostion(2);
                break;
            case R.id.rel_focus:
                // 关注列表
                startActivity(getActivity(), StoreFocusActivity.class);
                break;
        }
    }

}
