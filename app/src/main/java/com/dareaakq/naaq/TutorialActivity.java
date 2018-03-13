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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        imgBoyes = findViewById(R.id.img_boys);
        imgGirls = findViewById(R.id.img_girls);

        imgGirls.setOnClickListener(__ -> openTips());
        imgBoyes.setOnClickListener(__ -> openTips());
    }

    private void openTips() {
        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }


}
