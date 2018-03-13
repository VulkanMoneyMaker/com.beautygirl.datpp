package com.daetsoooe.naaq;


import android.content.Context;

public interface Kokert {

    Context getContext();

    void clear(int code);
    int nextData();
}
