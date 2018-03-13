package com.daetsoooe.naaq.test;

import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;

public interface SortingData extends Kokert {

    void next();
    void hide();
    void errorOne(WebResourceResponse errorResponse);
    void errorSecond(WebResourceError error);
    void clear(String data);

    void openTutotial();
}
