package cn.hancang.www.ui.Store.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import cn.hancang.www.R;
import cn.hancang.www.adapter.StoreInfoComAdapter;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;
import cn.hancang.www.base.LazzyFragment;
import cn.hancang.www.bean.DeleteFavBean;
import cn.hancang.www.bean.StoreInfoComBean;
import cn.hancang.www.ui.Store.contract.StoreInfoComContract;
import cn.hancang.www.ui.Store.model.StoreInfoComModel;
import cn.hancang.www.ui.Store.presenter.StoreInfoComPresenter;
import cn.hancang.www.ui.main.activity.ArtDetatilActivity;
import cn.hancang.www.ui.main.activity.AuctionFiledActivity;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.main.activity.OrganPeoActivity;
import cn.hancang.www.ui.mall.activity.TaoBaoStoreInfoActivity;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.widget.conmonWidget.LoadingTip;

import butterknife.BindView;

/**
 * Description: 保佑无bug
 * Data：2018/5/19-下午1:41
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class StoreInfoComFragement extends LazzyFragment<StoreInfoComPresenter, StoreInfoComModel> implements StoreInfoComContract.View, OnNetWorkErrorListener, OnLoadMoreListener, OnRefreshListener, OnItemClickListener, StoreInfoComAdapter.CancelFocusInterfeac {

    private String mTitle;
    private Integer mcategory_id;
    @BindView(R.id.mLRecyclerView)
    LRecyclerView mLRecyclerView;
    @BindView(R.id.mLoadingTip)
    LoadingTip mLoadingTip;
    private LRecyclerViewAdapter mLadapter;
    //    private CommonRecycleViewAdapter mAdapter;
    private StoreInfoComAdapter mAdapter;
    private Integer resId;
    private Integer page = 0;
    private int pagesize = 10;
    private java.lang.String TAG = "StoreInfoComFragement";
    private Integer currentPostion;

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        resId = switctResId(mcategory_id);
        if (resId == 9) {
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            return;
        }
        LogUtils.logd(TAG + "     " + resId + "-----" + mcategory_id);
        mAdapter = new StoreInfoComAdapter(getActivity(), resId, mcategory_id, mRxManager);
        mAdapter.setCancelFocusInterfeac(this);
        mLadapter = new LRecyclerViewAdapter(mAdapter);

        if (mcategory_id == 5)
            mLRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        else
            mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLRecyclerView.setAdapter(mLadapter);
        View headView = getActivity().getLayoutInflater().inflate(R.layout.item_space, null);
        mLadapter.addHeaderView(headView);
        if (mcategory_id == 1 || mcategory_id == 2 || mcategory_id == 5)
            mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(0, 20, 1, getResources().getColor(R.color.app_bottom_colour)));
        else
            mLRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(20, 2, 1, getResources().getColor(R.color.app_bottom_colour)));
        mLRecyclerView.setOnLoadMoreListener(this);
        mLRecyclerView.setOnRefreshListener(this);

        mLadapter.setOnItemClickListener(this);


      /*  mRxManager.on(AppConstant.DeletFocus, new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

            }
        });*/
    }

    private Integer switctResId(Integer mcategory_id) {
        // 拍品
        if (mcategory_id == 1)
            return R.layout.item_auction_file_item;
        //拍场
        if (mcategory_id == 2)
            return R.layout.item_wholegoods;

        if (mcategory_id == 3)
//            return R.layout.item_org_page;
            return R.layout.item_store_art;
        if (mcategory_id == 4)
            return R.layout.item_store_art;
        //店鋪，需要設置底部的价格为gone
        if (mcategory_id == 5)
            return R.layout.item_store_info;
        return 9;


    }

    public static StoreInfoComFragement getInstance(String title, Integer category_id) {
        StoreInfoComFragement sf = new StoreInfoComFragement();
        sf.mTitle = title;
//        LogUtils.logd("StoreInfoComFragement"+"-----"+mcategory_id);
        sf.mcategory_id = category_id;
        return sf;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_storeinfocom;
    }

    @Override
    protected void RequestNetWorkData() {
        mPresenter.getStoreInfoComRequest(page, mcategory_id);

    }

    @Override
    public void StartLoading(String RequestId) {
        if (mAdapter.getDataList().size() == 0)
            mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.StartLoading);
    }

    @Override
    public void showLoading(String RequestId, String title) {

    }

    @Override
    public void stopLoading(String RequestId) {
        mLRecyclerView.refreshComplete(pagesize);
//        mLRecyclerView.setNoMore(true);
    }

    @Override
    public void showErrorTip(String RequestId, String msg) {
        if (AppConstant.oneMessage.equals(RequestId)) {
            if (page == 0)
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            else
                mLRecyclerView.setOnNetWorkErrorListener(this);

        }
    }

    @Override
    public void returnStoreInfoCom(StoreInfoComBean storeInfoComBean) {
        if (!storeInfoComBean.isIs_success()) {
            if (page == 0)
                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
            else
                mLRecyclerView.setOnNetWorkErrorListener(this);

            return;
        }
        if (mcategory_id == 1 && page == 0) {
//            mAdapter.addAll(storeInfoComBean.getData().getFavorite_item());
            if (storeInfoComBean.getData().getFavorite_item().size() == 0) {

                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                return;
            }

        }
        //拍场
        if (mcategory_id == 2 && page == 0) {
            if (storeInfoComBean.getData().getFavorite_field().size() == 0) {

                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                return;
            }

        }

        if (mcategory_id == 3 && page == 0) {
            if (storeInfoComBean.getData().getFavorite_organ().size() == 0) {

                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                return;
            }

        }
        if (mcategory_id == 4 && page == 0) {
            if (storeInfoComBean.getData().getFavorite_artist().size() == 0) {

                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                return;
            }

        }
        //店鋪，需要設置底部的价格为gone
        if (mcategory_id == 5 && page == 0) {
            if (storeInfoComBean.getData().getFavorite_store().size() == 0) {

                mLoadingTip.setNoLoadTip(LoadingTip.NoloadStatus.NoCollect);
                return;
            }

        }
        if (mLoadingTip.getVisibility() == View.VISIBLE)
            mLoadingTip.setViewGone();

        if (page == 0 && mAdapter.getDataList().size() != 0)
            mAdapter.clear();

        if (mcategory_id == 1) {
            if (page >= storeInfoComBean.getData().getItem_page_total()) {
                mLRecyclerView.setNoMore(true);
                return;
            }
            mAdapter.addAll(storeInfoComBean.getData().getFavorite_item());
            ++page;

        }
        //拍场
        if (mcategory_id == 2) {
            if (page >= storeInfoComBean.getData().getField_page_total()) {
                mLRecyclerView.setNoMore(true);
                return;

            }

            mAdapter.addAll(storeInfoComBean.getData().getFavorite_field());
            ++page;

        }

        if (mcategory_id == 3) {
            if (page >= storeInfoComBean.getData().getOrganization_page_total()) {
                mLRecyclerView.setNoMore(true);
                return;
            }
            mAdapter.addAll(storeInfoComBean.getData().getFavorite_organ());
            ++page;

        }
        if (mcategory_id == 4) {
            if (page >= storeInfoComBean.getData().getArtist_page_total()) {

                mLRecyclerView.setNoMore(true);
                return;
            }
            mAdapter.addAll(storeInfoComBean.getData().getFavorite_artist());
            ++page;

        }
        //店鋪，需要設置底部的价格为gone
        if (mcategory_id == 5) {
            if (page >= storeInfoComBean.getData().getStore_page_total()) {

                mLRecyclerView.setNoMore(true);
                return;
            }
            mAdapter.addAll(storeInfoComBean.getData().getFavorite_store());
            ++page;

        }


    }

    @Override
    public void returnCancelFocus(DeleteFavBean deleteFavBean) {

        mAdapter.removeAt(currentPostion);
        mLadapter.notifyDataSetChanged();
    }


    @Override
    public void reload() {
        mPresenter.getStoreInfoComRequest(page, mcategory_id);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getStoreInfoComRequest(page, mcategory_id);
    }

    @Override
    public void onRefresh() {
        page = 0;
        mLRecyclerView.setNoMore(false);
        mPresenter.getStoreInfoComRequest(page, mcategory_id);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (mcategory_id == 1) {
            AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) getActivity(), ((StoreInfoComBean.DataBean.FavoriteItemBean) mAdapter.get(position)).getId());
        }
        //拍场
        if (mcategory_id == 2) {
            AuctionFiledActivity.gotoAuctionFiledActivity((BaseActivity) getActivity(), ((StoreInfoComBean.DataBean.FavoriteFieldBean) mAdapter.get(position)).getId(), AppConstant.IntoWayOne);
        }

        if (mcategory_id == 3) {
            OrganPeoActivity.gotoActivity((BaseActivity) getActivity(), ((StoreInfoComBean.DataBean.FavoriteOrganBean) mAdapter.get(position)).getOrganization_id());
        }
        if (mcategory_id == 4) {
            ArtDetatilActivity.GotoArtDetailActivity((BaseActivity) getActivity(), ((StoreInfoComBean.DataBean.FavoriteArtistBean) mAdapter.get(position)).getId());
        }
        if (mcategory_id == 5) {
            TaoBaoStoreInfoActivity.GotoTaoBaoSTireInfoActivity((BaseActivity) getActivity(), ((StoreInfoComBean.DataBean.FavoriteStoreBean) mAdapter.get(position)).getStore_id());
        }
    }

    @Override
    public void toCancelFocus(Integer favId, Integer postion, String FocusType) {
        mPresenter.getCancelFocuRequest(favId, FocusType);
        currentPostion = postion;
    }
}
