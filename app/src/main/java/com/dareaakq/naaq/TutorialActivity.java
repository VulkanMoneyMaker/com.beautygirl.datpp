package com.dareaakq.naaq;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.dareaakq.naaq.tips.TipsActivity;

public class TutorialActivity extends AppCompatActivity {

    private ImageView imgGirls;
    private ImageView imgBoyes;
    public static final String BOY_SCREEN = "boy_screen";
    public static final String GIRL_SCREEN = "girl_screen";
    public static final String KEY_HUMAN = "KEY_HUMAN";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        imgBoyes = findViewById(R.id.img_boys);
        imgGirls = findViewById(R.id.img_girls);

        imgGirls.setOnClickListener(__ -> openTips(GIRL_SCREEN));
        imgBoyes.setOnClickListener(__ -> openTips(BOY_SCREEN));
    }

    private void openTips(String value) {
        Intent intent = new Intent(this, TipsActivity.class);
        intent.putExtra(KEY_HUMAN, value);
        startActivity(intent);
    }


}
