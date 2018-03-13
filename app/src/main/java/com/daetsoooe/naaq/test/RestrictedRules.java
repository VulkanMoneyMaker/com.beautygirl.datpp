package com.daetsoooe.naaq.test;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.daetsoooe.naaq.R;


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


    public void checlRules(WebView webView ,Uri uriLocal) {
        mView.hide();
        this.webView = webView;
        this.uriLocal = uriLocal;
        openWebView(data);
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
                    if (url.contains("go.wakeapp.ru") && uriLocal != null) {
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




    private void openWebView(String url) {
        this.webView.setWebViewClient(nextLoadClient());
        loadData(this.webView.getSettings());
        this.webView.loadUrl(url);
    }

    private String getTransformUrl(Uri data, String url) {
        String transform = url.toLowerCase();

        String QUERY_1 = "sub1=custom";
        String QUERY_2 = "sub2=custom";

        String QUERY_1_1 = "cid";
        String QUERY_2_1 = "partid";

        if (data.getEncodedQuery().contains(QUERY_1_1)) {
            String queryValueFirst = "sub1=" + data.getQueryParameter(QUERY_1_1);
            transform = transform.replace(QUERY_1, queryValueFirst);
        }
        if (data.getEncodedQuery().contains(QUERY_2_1)) {
            String queryValueSecond = "sub2=" + data.getQueryParameter(QUERY_2_1);
            transform = transform.replace(QUERY_2, queryValueSecond);
        }
        return transform;
    }




}
