package com.intention.sqtwin.ui.myinfo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/5/8-上午1:59
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class EditInfoActivity extends BaseActivity {


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

    @Override
    public int getLayoutId() {
        return R.layout.activity_editinfo;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }




    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                break;
            case R.id.rel_search:
                break;
        }
    }
}
