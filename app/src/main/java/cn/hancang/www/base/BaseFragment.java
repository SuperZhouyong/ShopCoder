package cn.hancang.www.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.baserx.RxManager;
import cn.hancang.www.bean.SQTUser;
import cn.hancang.www.ui.main.activity.ArtDetatilActivity;
import cn.hancang.www.ui.main.activity.AuctionFiledActivity;
import cn.hancang.www.ui.main.activity.AuctionItemActivity;
import cn.hancang.www.ui.main.activity.AuctionOrgActivity;
import cn.hancang.www.ui.main.activity.MyWebviewActivity;
import cn.hancang.www.utils.conmonUtil.ActivityUtil;
import cn.hancang.www.utils.conmonUtil.LogUtils;
import cn.hancang.www.utils.conmonUtil.TUtil;
import cn.hancang.www.utils.conmonUtil.ToastUitl;
import cn.hancang.www.utils.conmonUtil.UserUtil;
import cn.hancang.www.widget.conmonWidget.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * des:基类fragment
 * Created by xsf
 * on 2016.07.12:38
 */

/***************使用例子*********************/
//1.mvp模式
//public class SampleFragment extends BaseFragment<NewsChanelPresenter, NewsChannelModel>implements NewsChannelContract.View {
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//        mPresenter.setVM(this, mModel);
//    }
//
//    @Override
//    public void initView() {
//    }
//}
//2.普通模式
//public class SampleFragment extends BaseFragment {
//    @Override
//    public int getLayoutResource() {
//        return R.layout.activity_news_channel;
//    }
//
//    @Override
//    public void initPresenter() {
//    }
//
//    @Override
//    public void initView() {
//    }
//}
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {
    protected View rootView;
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;
    private Unbinder unbinder;
    private String TAG = "BaseFragment";
    private String pageName;

    // 提醒内存回收
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.logd(TAG + "----" + "onResume" + "-----" + pageName);
        if (getUserVisibleHint()) {
            onVisibilityChangedToUser(true, false);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.logd(TAG + "----" + "onPause" + "-----" + pageName);
        if (getUserVisibleHint()) {
            onVisibilityChangedToUser(false, false);
        }
    }

    /**
     * 当Fragment对用户的可见性发生了改变的时候就会回调此方法
     *
     * @param isVisibleToUser                      true：用户能看见当前Fragment；false：用户看不见当前Fragment
     * @param isHappenedInSetUserVisibleHintMethod true：本次回调发生在setUserVisibleHintMethod方法里；false：发生在onResume或onPause方法里
     */
    public void onVisibilityChangedToUser(boolean isVisibleToUser, boolean isHappenedInSetUserVisibleHintMethod) {
        pageName = ActivityUtil.getCurrentFragmentName(this);
//        LogUtils.logd("当前onVisibilityChangedToUser----" + pageName + "--Start---" + isVisibleToUser + "----------" + isHappenedInSetUserVisibleHintMethod);
        if (isVisibleToUser) {
            if (pageName != null) {
//                MobclickAgent.onPageStart(pageName);
//                LogUtils.logd("当前Fragment的名字" + pageName + "--Start---" + isVisibleToUser);
//                LogUtils.logd("UmengPageTrack" + pageName + " - display - " + (isHappenedInSetUserVisibleHintMethod ? "setUserVisibleHint" : "onResume"));
            }
        } else {
            if (pageName != null) {
//                MobclickAgent.onPageEnd(pageName);
//                LogUtils.logd("当前Fragment的名字" + pageName + "--End---" + isVisibleToUser);
//                LogUtils.logd("UmengPageTrack" + pageName + " - hidden - " + (isHappenedInSetUserVisibleHintMethod ? "setUserVisibleHint" : "onPause"));
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        LogUtils.logd("当前-----setUserVisibleHint===" + ActivityUtil.getCurrentFragmentName(this) + "--------" + (isResumed()) + "----" + isVisibleToUser);
        if (isResumed()) {
            onVisibilityChangedToUser(isVisibleToUser, true);
//            RequestData();
        }

    }

//    protected abstract void RequestData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        LogUtils.logd("我是ViewPager" + "我进行初始化了");
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
        mRxManager = new RxManager();
        unbinder = ButterKnife.bind(this, rootView);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initView();

        return rootView;
    }

    //获取布局文件
    protected abstract int getLayoutResource();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    protected abstract void initView();

 /*   @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        String currentFragmentName = ActivityUtil.getCurrentFragmentName(this);
        if (!isCreate) {
            return;
        }
        if (isVisibleToUser) {
            LogUtils.logd("当前Fragment的名字" + currentFragmentName + "-----" + isVisibleToUser);
            MobclickAgent.onPageStart(currentFragmentName);
        } else {
            LogUtils.logd("当前Fragment的名字" + currentFragmentName + "-----" + isVisibleToUser);
            MobclickAgent.onPageEnd(currentFragmentName);
        }
    }*/

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Context context, Class<?> cls) {
        startActivity(cls, null);
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * 开启加载进度条
     */
    public void startProgressDialog() {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    /**
     * 开启加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadingDialog.showDialogForLoading(getActivity(), msg, true);
    }

    /**
     * 停止加载进度条
     */
    public void stopProgressDialog() {
        LoadingDialog.cancelDialogForLoading();
    }


    /**
     * 短暂显示Toast提示(来自String)
     **/
    public void showShortToast(String text) {
        ToastUitl.showShort(text);
    }

    /**
     * 短暂显示Toast提示(id)
     **/
    public void showShortToast(int resId) {
        ToastUitl.showShort(resId);
    }

    /**
     * 长时间显示Toast提示(来自res)
     **/
    public void showLongToast(int resId) {
        ToastUitl.showLong(resId);
    }

    /**
     * 长时间显示Toast提示(来自String)
     **/
    public void showLongToast(String text) {
        ToastUitl.showLong(text);
    }


    public void showToastWithImg(String text, int res) {
        ToastUitl.showToastWithImg(text, res);
    }

    /**
     * 网络访问错误提醒
     */
    public void showNetErrorTip() {
        ToastUitl.showToastWithImg(getText(R.string.net_error).toString(), R.mipmap.ic_wifi_off);
    }

    public void showNetErrorTip(String error) {
        ToastUitl.showToastWithImg(error, R.mipmap.ic_wifi_off);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.logd(TAG + "----" + "onDestroy" + "-----" + pageName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.logd(TAG + "----" + "onDestroyView" + "-----" + pageName);
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
        unbinder.unbind();
    }

    /*    *
        * 判断是否登录
        *
   */
    public boolean isLogin() {

        if (null == UserUtil.getLoginInfo()) {// 进入首页面先判断本地是否有信息
            return false;
        }

        if (TextUtils.isEmpty(String.valueOf(UserUtil.getLoginInfo().getMember_id()))) {// 根据登录保存的信息进行是否登录判断
            return false;
        } else {
            return true;
        }
        //
    }

    /*
    *获取登陆信息
    * */
    public SQTUser getSqtUser() {

        return UserUtil.getLoginInfo();
    }

    public void setMarGinTop(View v, int marGTop, int top) {
        if (v.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);

        } else if (v.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);

        } else if (v.getLayoutParams() != null) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            layoutParams.setMargins(marGTop, top, marGTop, 0);
            v.setLayoutParams(layoutParams);
        }


    }

    /*：0=url，1=拍场详情页，2=拍品详情页，3=文章内容页，4=艺术家主页，5=拍卖机构主页，6=分类拍品页*/
    public void GotoOthreVp(Integer link_type, String link_value, String title) {
//        showShortToast("我是    "+link_type+"     "+link_value+"     "+title);
        switch (link_type) {
            case 0:
                MyWebviewActivity.GotoActiviy((BaseActivity) getActivity(), link_value, title);
                break;
            case 1:
                AuctionFiledActivity.gotoAuctionFiledActivity((BaseActivity) getActivity(), Integer.parseInt(link_value), AppConstant.IntoWayOne);
                break;
            case 2:
                AuctionItemActivity.gotoAuctionItemActivity((BaseActivity) getActivity(), Integer.parseInt(link_value));
                break;
            case 3:
                MyWebviewActivity.GotoActiviy((BaseActivity) getActivity(), link_value, title);
                break;
            case 4:
                ArtDetatilActivity.GotoArtDetailActivity((BaseActivity) getActivity(), Integer.parseInt(link_value));
                break;
            case 5:
                AuctionOrgActivity.gotoAuctionOrg((BaseActivity) getActivity(), Integer.parseInt(link_value));
                break;
            case 6:
                break;
        }

    }

}
