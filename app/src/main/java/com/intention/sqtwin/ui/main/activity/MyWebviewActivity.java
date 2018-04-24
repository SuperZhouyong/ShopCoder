package com.intention.sqtwin.ui.main.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.base.BaseActivity;
import com.intention.sqtwin.baseapp.AppManager;
import com.intention.sqtwin.widget.conmonWidget.LoadingDialog;

import butterknife.BindView;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午12:32
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyWebviewActivity extends BaseActivity {
    @BindView(R.id.my_web_view)
    WebView myWebView;
    private String webUrl;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mywebview;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        webUrl = getIntent().getBundleExtra(AppConstant.WEBVIEW).getString(AppConstant.WEBVIEWURL);
        WebSettings settings = myWebView.getSettings();
        //todo 缓存
        settings.setDomStorageEnabled(false);
//        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);  //支持插件
        settings.setLoadWithOverviewMode(true);
//        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。
        // H5缓存
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
//        myWebView.addJavascriptInterface(new JsInterNation(), "JsToAndroid");

        myWebView.loadUrl(webUrl);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
                // 接受所有网站的证书
                handler.proceed();
                view.getSettings().setJavaScriptEnabled(true);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (LoadingDialog.getmLoadingDialog() == null) {
                    if (AppManager.getAppManager().currentActivity() == MyWebviewActivity.this)
                        LoadingDialog.showDialogForLoading(MyWebviewActivity.this, "加载中", true);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (LoadingDialog.getmLoadingDialog() != null) {
                    LoadingDialog.cancelDialogForLoading();
                }

               /* ShowDialog = true;


                view.loadUrl(javascript);*//*
                view.loadUrl("javascript:hideEle();");*/
            }
        });
    }


}
