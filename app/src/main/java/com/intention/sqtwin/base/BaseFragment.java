package com.intention.sqtwin.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intention.sqtwin.R;
import com.intention.sqtwin.baserx.RxManager;
import com.intention.sqtwin.bean.SQTUser;
import com.intention.sqtwin.utils.conmonUtil.ActivityUtil;
import com.intention.sqtwin.utils.conmonUtil.LogUtils;
import com.intention.sqtwin.utils.conmonUtil.TUtil;
import com.intention.sqtwin.utils.conmonUtil.ToastUitl;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;
import com.intention.sqtwin.widget.conmonWidget.LoadingDialog;
import com.umeng.analytics.MobclickAgent;

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
        LogUtils.logd(TAG+"----"+"onResume"+"-----"+pageName);
        if (getUserVisibleHint()) {
            onVisibilityChangedToUser(true, false);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.logd(TAG+"----"+"onPause"+"-----"+pageName);
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
                MobclickAgent.onPageStart(pageName);
//                LogUtils.logd("当前Fragment的名字" + pageName + "--Start---" + isVisibleToUser);
//                LogUtils.logd("UmengPageTrack" + pageName + " - display - " + (isHappenedInSetUserVisibleHintMethod ? "setUserVisibleHint" : "onResume"));
            }
        } else {
            if (pageName != null) {
                MobclickAgent.onPageEnd(pageName);
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
        LogUtils.logd(TAG+"----"+"onDestroy"+"-----"+pageName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.logd(TAG+"----"+"onDestroyView"+"-----"+pageName);
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

        if (TextUtils.isEmpty(UserUtil.getLoginInfo().getGid())) {// 根据登录保存的信息进行是否登录判断
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

}
