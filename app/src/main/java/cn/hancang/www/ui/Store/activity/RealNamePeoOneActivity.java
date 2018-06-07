package cn.hancang.www.ui.Store.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 实名认证
 * Data：2018/5/18 0018-下午 18:02
 * Blog：Super简单
 * Author: ZhouYong
 */

public class RealNamePeoOneActivity extends BaseActivity {
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

    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.imageView)
    TextView imageView;
    @BindView(R.id.imageView2)
    TextView imageView2;
    @BindView(R.id.imageView3)
    TextView imageView3;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    public int getLayoutId() {
        return R.layout.activity_realnamecer;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        relSearch.setVisibility(View.GONE);
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("实名认证");

    }


    @OnClick({R.id.rel_back, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.tv_confirm:
                startActivity(RealNamePeoTwoActivity.class);
                // 进入认证界面
                break;
        }
    }
}
