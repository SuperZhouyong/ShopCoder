package com.intention.sqtwin.base;

/**
 * des:baseview
 * Created by xsf
 * on 2016.07.11:53
 */
public interface BaseView {
    /*******内嵌加载*******/
   /* void showLoading(String title);

    void stopLoading();

    void showErrorTip(String msg);*/

    void showLoading(String RequestId, String title);

    void stopLoading(String RequestId);

    void showErrorTip(String RequestId, String msg);
}
