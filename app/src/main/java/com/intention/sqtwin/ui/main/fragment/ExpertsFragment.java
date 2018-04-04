package com.intention.sqtwin.ui.main.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.intention.sqtwin.ComInterface.CollegesFiterInterface;
import com.intention.sqtwin.R;
import com.intention.sqtwin.base.BaseFragment;
import com.intention.sqtwin.baseadapterL.commonadcpter.CommonRecycleViewAdapter;
import com.intention.sqtwin.widget.DropDownMenu;
import com.intention.sqtwin.widget.conmonWidget.LoadingTip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;


/**
 * Description: 绝无Bug
 * Data：2018/3/21-上午10:01
 * Blog：Super简单
 * Author: ZhouYong
 */

public class ExpertsFragment extends BaseFragment {
    private static final java.lang.String TAG = "ExpertsFragment";
    @BindView(R.id.remindMessage)
    ImageView remindMessage;
    @BindView(R.id.activity_search_head)
    RelativeLayout activitySearchHead;
    @BindView(R.id.dropmenu)
    DropDownMenu dropmenu;
    @BindView(R.id.rel_search)
    RelativeLayout mRelSearch;

    // 对menu的初始化的集合
    private String[] headers = {"服务地区", "专业等级"};
    private List<View> popupViews = new ArrayList<>();
    private CommonRecycleViewAdapter<CollegesFiterInterface> mComAdapter;
    private LRecyclerView mRecyclerView;
    private LoadingTip mloadtip;
//    private ExpertsContentAdapter mExpertsContentAdapter;
    private LRecyclerViewAdapter mLrecyAdapter;
    private ArrayList<CollegesFiterInterface> mListFiltrate;
    private int pagesize = 10;
    private int page = 0;
//    private ExpertsFilterBean mExpertsFilterBean;
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private boolean isRed;
    private boolean isLoadView = false;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_experts;
    }

    // 不要给我说你前男友了   已经打击到了。我没他厉害
    @Override
    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

      /*  LogUtils.logd(TAG+"-----setUserVisibleHint()");
        if (isLoadView && !isRed){
            LogUtils.logd(TAG+"-----setUserVisibleHint()----"+isLoadView);
            mPresenter.getExpertsReadMessage(isLogin() ? Integer.parseInt(getSqtUser().getGid()) : null);
        }*/
    }

    @Override
    protected void initView() {}



}
