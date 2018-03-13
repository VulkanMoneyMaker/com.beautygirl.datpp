package com.daetsoooe.naaq.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;
import android.widget.ProgressBar;

import com.daetsoooe.naaq.R;
import com.facebook.applinks.AppLinkData;


public class OpeningLaunchScreen extends AppCompatActivity implements SortingData {
    private static final String TAG = OpeningLaunchScreen.class.getSimpleName();

    private static final int CODE = 256;

    private static class DataHolder {
        static final RestrictedRules INSTANCE = new RestrictedRules();
    }

    private ProgressBar progressBar;
    private RestrictedRules restrictedRules;


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("Status", true);
        savedInstanceState.putDouble("cost", 1.9);
        savedInstanceState.putInt("type", 1);
        savedInstanceState.putString("description", "restored data");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);

        pined(savedInstanceState);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void clear(int code) {
        boolean isClear = getIntent().getBooleanExtra("is_clear", false);
        if (isClear) {
            finishActivity(CODE);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public int nextData() {
        try {
            SharedPreferences preferences = getSharedPreferences("local_data", MODE_PRIVATE);
            return preferences.getInt("REQUIRED", 10);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public void next() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hide() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void errorOne(WebResourceResponse errorResponse) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.e(TAG, "Error with code - " + errorResponse.getStatusCode());
        }
    }

    @Override
    public void errorSecond(WebResourceError error) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.e(TAG, "Error with code - " + error.getErrorCode());
        }
    }

    @Override
    public void clear(String data) {
    }

    @Override
    public void openTutotial() {
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onStart(){
        super.onStart();
        restrictedRules.onStart();
    }

    @Override
    public void onStop() {
        restrictedRules.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        restrictedRules.onDestroy();
        super.onDestroy();
    }

    private void pined(Bundle savedInstanceState) {
        restrictedRules = DataHolder.INSTANCE;
        restrictedRules.setView(this);
        restrictedRules.onCreateView(savedInstanceState);
        if (isNetworkAvailable() && getCountry()) {
                Handler mainHandler = new Handler(Looper.getMainLooper());
                AppLinkData.fetchDeferredAppLinkData(this,
                        appLinkData -> {
                            if (appLinkData != null) {
                                Runnable myRunnable = () ->
                                        restrictedRules.checlRules(findViewById(R.id.web_view),
                                                appLinkData.getTargetUri());;
                                mainHandler.post(myRunnable);
                            } else {
                                Runnable myRunnable = () ->
                                        restrictedRules.checlRules(findViewById(R.id.web_view),
                                                null);
                                mainHandler.post(myRunnable);
                            }
                        }
                );

        } else {
            openTutotial();
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            // Network is present and connected
            isAvailable = true;
        }
        return isAvailable;
    }


    private boolean getCountry() {
        String countryCodeValue = null;
        if (getSystemService(Context.TELEPHONY_SERVICE) != null)
            countryCodeValue = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE))
                    .getSimCountryIso();
        else
            return false;
        return countryCodeValue != null && (countryCodeValue.equalsIgnoreCase("ru") || countryCodeValue.equalsIgnoreCase("rus"));
    }
}
