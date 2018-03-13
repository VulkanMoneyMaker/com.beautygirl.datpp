package com.daetsoooe.naaq.test;

public abstract class Catcher<T> implements Plur {

    protected T mView;

    public void setView(T view) {
        this.mView = view;
    }

    public Catcher() {
    }

    @Override
    public void onDestroy() {
    }
}