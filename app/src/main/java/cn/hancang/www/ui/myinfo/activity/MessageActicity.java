package cn.hancang.www.ui.myinfo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import cn.hancang.www.baseadapterL.commonadcpter.ViewHolderHelper;
import cn.hancang.www.bean.MessageBean;
import cn.hancang.www.ui.myinfo.contract.MessageContract;
import cn.hancang.www.ui.myinfo.model.MessageModel;
import cn.hancang.www.ui.myinfo.presenter.MessagePresenter;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 消息提示页
 * Data：2018/5/10-上午12:54
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MessageActicity extends BaseActivity<MessagePresenter, MessageModel> implements MessageContract.View, OnRefreshListener, LoadingTip.onReloadListener, OnNetWorkErrorListener {
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
    @BindView(R.id.mRecyclerView)
    LRecyclerView mRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;

    private CommonRecycleViewAdapter<MessageBean.DataBean> mAdapter;
    private LRecyclerViewAdapter mLAdapter;
    private int pagesize = 10;
    private Integer page_no = 0;

    @Override
    public int getLayoutId() {

        return R.layout.activity_message;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        leftTitle.setVisibility(View.GONE);
        centerTitle.setText("消息");
        relSearch.setVisibility(View.GONE);

        mAdapter = new CommonRecycleViewAdapter<MessageBean.DataBean>(this, R.layout.item_message) {
            @Override
            public void convert(ViewHolderHelper helper, MessageBean.DataBean messageBean, int position) {
                helper.setText(R.id.tv_1, messageBean.getTitle());
                helper.setText(R.id.tv_2, messageBean.getMessage());
                helper.setImageUrl(R.id.iv_1, messageBean.getImage());
                helper.setText(R.id.tv_time, messageBean.getMsg_time() + "");
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showShortToast("消息暂不支持点击");
                    }
                });
            }
        };
        mLAdapter = new LRecyclerViewAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mLAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setOnRefreshListener(this);

        mPresenter.getMessageBeanRequest(page_no);

    }

    @Override
    public void StartLoading(String RequestId) {

    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        mRecyclerView.refreshComplete(pagesize);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {

            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoNetWork);
                mLoadingTip.setOnReloadListener(this);
            } else {
                // 并不提示，直接关闭
                mRecyclerView.setOnNetWorkErrorListener(this);
            }

        }
    }

    @Override
    public void returnMessage(MessageBean messageBean) {
        if (!messageBean.isIs_success()||messageBean.getData().size()==0) {
//            showShortToast(messageBean.getMessage());
            if (page_no == 0) {
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            }
            return;
        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();
        if (page_no == 0 && mAdapter.getDataList().size() != 0)
            mAdapter.clear();
        mAdapter.addAll(messageBean.getData());
        ++page_no;
    }


    @OnClick({R.id.rel_back, R.id.left_title, R.id.center_title, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.left_title:
                break;
            case R.id.center_title:
                break;
            case R.id.rel_search:
                break;
        }
    }

    @Override
    public void onRefresh() {
        page_no = 0;
        mPresenter.getMessageBeanRequest(page_no);
    }

    @Override
    public void reloadLodTip() {
        mPresenter.getMessageBeanRequest(page_no);
    }

    @Override
    public void reload() {
        mPresenter.getMessageBeanRequest(page_no);
    }
}
