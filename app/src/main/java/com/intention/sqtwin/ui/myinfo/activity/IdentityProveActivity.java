package com.intention.sqtwin.ui.myinfo.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.baseadapterL.commonadcpter.ViewHolderHelper;
import com.intention.sqtwin.bean.IdentityProveBean;
import com.intention.sqtwin.bean.NullBean;
import com.intention.sqtwin.ui.myinfo.contract.IdentityProveContract;
import com.intention.sqtwin.ui.myinfo.model.IdentityProveModel;
import com.intention.sqtwin.ui.myinfo.presenter.IdentityProvePresenter;
import com.intention.sqtwin.utils.TakePictureManager;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;

/**
 * Description: 上传身份证证件
 * Data：2018/5/17-上午12:10
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class IdentityProveActivity extends BaseActivity<IdentityProvePresenter, IdentityProveModel> implements IdentityProveContract.View, TakePictureManager.takePictureCallBackListener, BottomDialog.ViewListener {
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
    @BindView(R.id.tv_head_desc)
    TextView tvHeadDesc;
    @BindView(R.id.iv_identity_one)
    ImageView ivIdentityOne;
    @BindView(R.id.iv_identity_two)
    ImageView ivIdentityTwo;
    @BindView(R.id.ec_name)
    EditText ecName;
    @BindView(R.id.ec_identity_num)
    EditText ecIdentityNum;
    @BindView(R.id.ec_postion_name)
    EditText ecPostionName;
    @BindView(R.id.ec_recommend_peo)
    EditText ecRecommendPeo;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    private CommonRecycleViewAdapter<NullBean> mAdapter;
    private TakePictureManager takePictureManager;
    private BaseBottomDialog bottomDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_identityprove;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);

    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("身份认证");
        relSearch.setVisibility(View.GONE);

        mAdapter = new CommonRecycleViewAdapter<NullBean>(this, R.layout.item_identity_iv) {
            @Override
            public void convert(ViewHolderHelper helper, NullBean nullBean, int position) {

            }
        };
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.add(new NullBean());

        takePictureManager = new TakePictureManager(this);
        takePictureManager.setTailor(1, 3, 320, 200);

        takePictureManager.setTakePictureCallBackListener(this);
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
    public void returnIdentityProveBean(IdentityProveBean identityProveBean) {

    }

    private void ShowBootomDialog() {
        bottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setLayoutRes(R.layout.bottom_takephoto)
                .setViewListener(this)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        takePictureManager.attachToActivityForResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        takePictureManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @OnClick({R.id.rel_back, R.id.iv_identity_one, R.id.iv_identity_two, R.id.ec_name, R.id.ec_identity_num, R.id.ec_postion_name, R.id.ec_recommend_peo, R.id.tv_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.iv_identity_one:
                break;
            case R.id.iv_identity_two:
                break;
            case R.id.ec_name:
                break;
            case R.id.ec_identity_num:
                break;
            case R.id.ec_postion_name:
                break;
            case R.id.ec_recommend_peo:
                break;
            case R.id.tv_confirm:

                break;

        }
    }

    // 照片回调成功
    @Override
    public void successful(boolean isTailor, File outFile, Uri filePath) {


    }

    @Override
    public void failed(int errorCode, List<String> deniedPermissions) {

    }

    @Override
    public void bindView(View view) {


        view.findViewById(R.id.tv_take_carema).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                takePictureManager.startTakeWayByCarema();

            }
        });
        view.findViewById(R.id.tv_take_albun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.dismiss();
                takePictureManager.startTakeWayByAlbum();
            }
        });
    }
}
