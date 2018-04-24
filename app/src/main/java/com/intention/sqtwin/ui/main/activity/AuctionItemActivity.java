package com.intention.sqtwin.ui.main.activity;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.ArtistDetailBean;
import com.intention.sqtwin.bean.AutionItemDetailBean;
import com.intention.sqtwin.bean.PriceRecordBena;
import com.intention.sqtwin.bean.WorkerListBean;
import com.intention.sqtwin.ui.main.contract.AutionItemContract;
import com.intention.sqtwin.ui.main.model.AutionItemModel;
import com.intention.sqtwin.ui.main.presenter.AutionItemPresenter;

import butterknife.BindView;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午12:53
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class AuctionItemActivity extends BaseActivity<AutionItemPresenter, AutionItemModel> implements AutionItemContract.View {
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
   /* @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
*/
//    private LRecyclerViewAdapter mLadapter ;

    @Override
    public int getLayoutId() {
        return R.layout.activity_auctionitem;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {


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
    public void returnWorkList(WorkerListBean workerListBean) {

    }

    @Override
    public void returnAutionItemDeatil(AutionItemDetailBean autionItemDetailBean) {

    }

    @Override
    public void returnArtistDetail(ArtistDetailBean artistDetailBean) {

    }

    @Override
    public void returnPriceRecord(PriceRecordBena priceRecordBena) {

    }


}
