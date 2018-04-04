package com.intention.sqtwin.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

import com.intention.sqtwin.utils.conmonUtil.CollectionUtils;

import java.util.List;

/**
 * @data 2017/5/19 0019
 * @aurher Administrator
 */

public class BasePageStateAdapter extends FragmentPagerAdapter {

    public FragmentManager fm;
    public List<Fragment> list;
    private List<String> mTitles;

/*    public BasePageStateAdapter(FragmentManager fm) {
        super(fm);
    }

    public BasePageStateAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fm = fm;
        this.list = list;
    }*/

    public BasePageStateAdapter(FragmentManager supportFragmentManager, List<Fragment> mListFragment, List<String> strings) {
        super(supportFragmentManager);
        this.fm = supportFragmentManager;
        this.list = mListFragment;
        this.mTitles = strings;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Log.i("sssssssssssss", "getItem");
        fragment = list.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", "" + position);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setFragments(FragmentManager fm, List<Fragment> fragments, List<String> mTitles) {
        this.mTitles = mTitles;
        if (this.list != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.list) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            ft = null;
            fm.executePendingTransactions();
        }
        this.list = fragments;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        fm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return !CollectionUtils.isNullOrEmpty(mTitles) ? mTitles.get(position) : "";
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        Fragment fragment = list.get(position);
        fm.beginTransaction().hide(fragment).commit();
    }
}

