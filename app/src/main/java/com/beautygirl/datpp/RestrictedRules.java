package com.beautygirl.datpp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class RestrictedRules extends Catcher<SortingData> {

    private String data;
    private int codeRestricted = -1;

    @Override
    public void onCreateView(Bundle saveInstance) {
        mView.next();
        data = mView.getContext().getString(R.string.opening_url);
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
        webView.setWebViewClient(nextLoadClient());
        loadData(webView.getSettings());
        webView.loadUrl(data);
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
                view.loadUrl(url);
                mView.clear(url);
                return true;
            }

            @RequiresApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                mView.clear(request.getUrl().toString());
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                mView.hide();
                mView.errorSecond(error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                mView.hide();
                mView.errorOne(errorResponse);
            }
        };
    }
}
