package com.intention.sqtwin.bean;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by Administrator on 2017/4/12 0012.
 * 学校详情页面的tab
 */

public class TabsEntity implements CustomTabEntity {
    public String title;

    public TabsEntity(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
