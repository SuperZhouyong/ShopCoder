package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.widget.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 文本编辑的类
 * Data：2018/5/22 0022-上午 11:00
 * Blog：Super简单
 * Author: ZhouYong
 */

public class EditTextInputActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.tool_title_left)
    TextView toolTitleLeft;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.tool_title_right)
    TextView toolTitleRight;
    @BindView(R.id.ed_name)
    ClearEditText edName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_edittextinput;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        toolTitleLeft.setVisibility(View.GONE);
        centerTitle.setText("信息编辑");
        toolTitleRight.setText("保存");

    }


    @OnClick({R.id.rel_back, R.id.tool_title_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tool_title_right:
                String edCurrentName = edName.getText().toString();
                if (TextUtils.isEmpty(edCurrentName)) {
                    showLongToast("修改名字不能为空");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(AppConstant.EditInfo, edCurrentName);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }


}
