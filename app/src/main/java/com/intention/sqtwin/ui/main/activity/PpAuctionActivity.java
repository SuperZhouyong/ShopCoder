package com.intention.sqtwin.ui.main.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.flyco.tablayout.listener.OnTabSelectListener;
import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnNetWorkErrorListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.R;
import com.intention.sqtwin.adapter.PpAuctionAdapter;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.bean.PpAllDateBean;
import com.intention.sqtwin.ui.main.contract.PpAuctionContract;
import com.intention.sqtwin.ui.main.fragment.SimpleCardFragment;
import com.intention.sqtwin.ui.main.model.PpAuctionModel;
import com.intention.sqtwin.ui.main.presenter.PpAuctionPresenter;
import com.intention.sqtwin.utils.conmonUtil.ImageLoaderUtils;
import com.intention.sqtwin.widget.SlidingTabLayout;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ezy.ui.view.BannerView;

/**
 * Description: 自营拍界面
 * Data：2018/4/23-下午11:34
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

/*public class PpAuctionActivity extends BaseActivity {


}*/
