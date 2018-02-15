package com.beautygirl.datpp;

import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;

public interface SortingData extends Kokert {

    void next();
    void hide();
    void errorOne(WebResourceResponse errorResponse);
    void errorSecond(WebResourceError error);
    void clear(String data);
}
