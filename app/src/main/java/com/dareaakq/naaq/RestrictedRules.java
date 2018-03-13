package com.dareaakq.naaq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.applinks.AppLinkData;


public class RestrictedRules extends Catcher<SortingData> {

    private String data;
    private String riderect_url;
    private int codeRestricted = -1;
    private WebView webView;
    private Uri uriLocal;
    

    @Override
    public void onCreateView(Bundle saveInstance) {
        mView.next();
        data = mView.getContext().getString(R.string.opening_url);
        riderect_url = mView.getContext().getString(R.string.riderect_url);
        codeRestricted = mView.nextData();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mView.clear(codeRestricted);
    }


    public void checlRules(WebView webView) {
        mView.hide();
        this.webView = webView;
        configParameters(data);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadData(WebSettings webSettings) {
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
    }

    private WebViewClient nextLoadClient() {
        return new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!url.contains(riderect_url)) {
                    if (url.contains("http://go.wakeapp.ru") && uriLocal != null) {
                        view.loadUrl(getTransformUrl(uriLocal, url));
                    } else {
                        view.loadUrl(url);
                    }
                } else {
                    mView.openTutotial();
                }
                mView.clear(url);
                return true;
            }
        };
    }


    private void configParameters(final String url) {
        Handler mainHandler = new Handler(Looper.getMainLooper());
        AppLinkData.fetchDeferredAppLinkData(mView.getContext(),
                appLinkData -> {
                    if (appLinkData != null) uriLocal = appLinkData.getTargetUri();
                    Runnable myRunnable = () -> openWebView(url);
                    mainHandler.post(myRunnable);
                }
        );

        openWebView(url);
    }

    private void openWebView(String url) {
        this.webView.setWebViewClient(nextLoadClient());
        loadData(this.webView.getSettings());
        this.webView.loadUrl(url);
    }

    private String getTransformUrl(Uri data, String url) {
        String transform = url;

        String QUERY_1 = "sub1";
        String QUERY_2 = "sub2";

        String QUERY_1_1 = "cid";
        String QUERY_2_1 = "partid";

        if (data.getEncodedQuery().contains(QUERY_1_1)) {
            String queryValueFirst = data.getQueryParameter(QUERY_1_1);
            transform = transform.replace(QUERY_1, queryValueFirst);
        }
        if (data.getEncodedQuery().contains(QUERY_2_1)) {
            String queryValueSecond = data.getQueryParameter(QUERY_2_1);
            transform = transform.replace(QUERY_2, queryValueSecond);
        }
        return transform;
    }




}
