package com.pjqdyd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //获得控件
        WebView webView = findViewById(R.id.wv_webview);

        ActionBar actionBar = getSupportActionBar();

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true); // 是否开启JS支持
        webSettings.setPluginState(WebSettings.PluginState.ON); // 是否开启插件支持
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //是否允许JS打开新窗口

        //访问网页
        webView.loadUrl("http://www.baidu.com");

        // 浏览器客户端，用于处理网站图标、网站标题、网站弹窗等
        webView.setWebChromeClient(new WebChromeClient(){

            //获取网页标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (title != null) actionBar.setTitle(title);
            }
        });

        // 系统默认会通过手机浏览器打开网页，所以需要设置WebViewClient显示网页
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    if (url.startsWith("http:") || url.startsWith("https:")) {
                        //使用WebView加载显示url
                        view.loadUrl(url);
                    } else {
                        // 尝试以Intent 打开其他app
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    }
                    return true;
                } catch (Exception e){
                    return false;
                }
            }
        });

        // 点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
        webView.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) { // 表示按返回键时的操作
                    webView.goBack(); // 后退
                    return true; // 已处理
                }
            }
            return false;
        });
    }
}