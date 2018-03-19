package lerk.madckdhsm.fun.test;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lerk.madckdhsm.fun.R;


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
                        view.loadUrl(url);
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
        if (uriLocal != null) {
            this.webView.loadUrl(getTransformUrl(uriLocal, url));
        } else {
            this.webView.loadUrl(url);
        }
    }

    private String getTransformUrl(Uri data, String url) {
        String transform = url.toLowerCase();

        String QUERY_1 = "sub_id_1";
        String QUERY_2 = "sub_id_2";
        String QUERY_3 = "sub_id_3";
        if (data.getEncodedQuery().contains(QUERY_1)) {
            String queryValueFirst = "?sub_id_1=" + data.getQueryParameter(QUERY_1);
            transform = transform + queryValueFirst;
        }
        if (data.getEncodedQuery().contains(QUERY_2)) {
            String queryValueSecond = "&sub_id_2=" + data.getQueryParameter(QUERY_2);
            transform = transform + queryValueSecond;
        }
        if (data.getEncodedQuery().contains(QUERY_3)) {
            String queryValueSecond = "&sub_id_3=" + data.getQueryParameter(QUERY_3);
            transform = transform + queryValueSecond;
        }
        return transform;
    }




}
