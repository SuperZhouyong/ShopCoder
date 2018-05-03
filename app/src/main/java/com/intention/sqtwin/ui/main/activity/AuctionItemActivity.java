package com.intention.sqtwin.ui.main.activity;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.ArtistDetailBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.PriceRecordBena;
import com.intention.sqtwin.bean.WorkerListBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;
import com.intention.sqtwin.ui.main.model.AutionItemModel;
import com.intention.sqtwin.ui.main.presenter.AutionItemPresenter;
import com.intention.sqtwin.widget.ShareDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 拍品页
 * Data：2018/4/21-上午12:53
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionItemActivity extends BaseActivity<AutionItemPresenter, AutionItemModel> implements AutionItemContract.View {
    @BindView(R.id.rel_back)
    RelativeLayout relBack;


    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyvlerView;
    private Integer auctItemId = 1;

//    private LRecyclerViewAdapter mLadapter ;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionitem;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {

        mPresenter.getAutionDetailRequest(auctItemId);
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
    public void returnAutionItemDeatil(AutionItemDetailBean autionItemDetailBean) {

    }

    @OnClick({R.id.rel_back, R.id.iv_qr_code})
    void onclick(View v) {
        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.iv_qr_code:
//                ShareDialog shareDialog = new ShareDialog(this,R.layout.share_dialog,false);
//                ShareDialog shareDialog = new ShareDialog(this);
                Dialog shareDialog = new Dialog(this, R.style.MyDialog);
                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog, null));
//                shareDialog.setContentView(getLayoutInflater().inflate(R.layout.share_dialog,null),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                shareDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                shareDialog.show();
                break;
        }
    }


}
