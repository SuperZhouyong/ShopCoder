package cn.hancang.www.ui.main.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.hancang.www.R;
import cn.hancang.www.app.AppConstant;
import cn.hancang.www.base.BaseActivity;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 保佑无bug
 * Data：2018/4/21-上午12:32
 * Blog：Super简单
 * Author: ZhouYong
 * QQ: 437397161
 */

public class MyWebviewActivity extends BaseActivity {
//    @BindView(R.id.my_web_view)
//    WebView myWebView;
    @BindView(R.id.iv_back)
    ImageView ivBack;


    @BindView(R.id.iv_search)
    ImageView ivSearch;

    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.center_title)
    TextView centerTitle;
    @BindView(R.id.rel_search)
    RelativeLayout relSearch;
    @BindView(R.id.ll_layout)
    LinearLayout linearLayout;
//    private String webUrl;
    private AgentWeb mAgentWeb;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mywebview;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent( linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
//                .setWebLayout(new WebLayout(this))
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(getIntent().getExtras().getString(AppConstant.WEBURL));
        String sTitle = getIntent().getExtras().getString(AppConstant.WEBTITLE);
//        webUrl = getIntent().getExtras().getString(AppConstant.WEBURL);
        leftTitle.setText(sTitle);
        relSearch.setVisibility(View.GONE);

//        WebSettings settings = myWebView.getSettings();
        //todo 缓存
        /*settings.setDomStorageEnabled(false);
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

               *//* ShowDialog = true;


                view.loadUrl(javascript);*//**//*
                view.loadUrl("javascript:hideEle();");*//*
            }
        });*/
    }


    public static void GotoActiviy(BaseActivity mBaseactivity, String article, String mTitle) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.WEBURL, article);
        bundle.putString(AppConstant.WEBTITLE, mTitle);
        mBaseactivity.startActivity(MyWebviewActivity.class, bundle);
    }


    @OnClick({R.id.rel_back, R.id.rel_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rel_back:
                finish();
                break;
            case R.id.rel_search:
                break;
        }
    }
    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
//            Log.i("Info","onProgress:"+newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
           /* if (centerTitle != null) {
                centerTitle.setText(title);
            }*/
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAgentWeb.destroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }
}
