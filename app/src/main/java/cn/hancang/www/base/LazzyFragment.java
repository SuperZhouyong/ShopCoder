package cn.hancang.www.base;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.hancang.www.baserx.RxManager;
import cn.hancang.www.bean.SQTUser;
import cn.hancang.www.utils.conmonUtil.TUtil;
import cn.hancang.www.utils.conmonUtil.ToastUitl;
import cn.hancang.www.utils.conmonUtil.UserUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description: 绝无Bug
 * Data：2017/11/11 0011-下午 13:27
 * Blog：Super简单
 * Author: ZhouYong
 */

public abstract class LazzyFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {
    protected View rootView;
    public T mPresenter;
    public E mModel;
    public RxManager mRxManager;
    private Unbinder unbinder;

    // 提醒内存回收
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
//        System.out.print(""+mynane.x);
    }

    //判断控件是否加载完毕
    private boolean isCreateView = false;
    //判断是否已加载过数据
    public boolean isLoadData = false;

    /**
     * 返回layoutView
     *
     * @param inflater
     * @param container
     * @return 初始化布局文件
     */
//    public abstract View getView(LayoutInflater inflater, ViewGroup container);

    /**
     * 初始化控件
     */
//    public abstract void initViews(View view);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(getLayoutResource(), container, false);

        }
        mRxManager = new RxManager();
        unbinder = ButterKnife.bind(this, rootView);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initView();
        isCreateView = true;
        return rootView;
    }

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    protected abstract void initView();

    //获取布局文件
    protected abstract int getLayoutResource();

    //注意，此方法再所有生命周期之前调用，不可操作控件
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isCreateView && !isLoadData) {
            loadData();
        }

    }



    /**
     * 加载数据
     */
    public void loadData() {
        //如果没有加载过就加载，否则就不再加载了
        if (!isLoadData) {
            //加载数据操作
            RequestNetWorkData();

            isLoadData = true;
        }
    }

    protected abstract void RequestNetWorkData();

    // 第一次进入ViewPager的时候我们需要直接加载，因为此时setUserVisibleHint 已经调用过了。
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint())
            loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

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
}


