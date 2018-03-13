package com.dareaakq.naaq.tips;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.dareaakq.naaq.R;
import com.dareaakq.naaq.TutorialActivity;


public class TipsActivity extends FragmentActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private TextView tvNumber;
    private String key;
    private ConstraintLayout constraintLayout;
    private TextView tvTitle;
    private View line;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        constraintLayout = findViewById(R.id.main_view);
        tvTitle = findViewById(R.id.tv_title);
        line = findViewById(R.id.view_line);
        tvNumber = findViewById(R.id.tv_number);
        if (getIntent() != null) {
            key = getIntent().getStringExtra(TutorialActivity.KEY_HUMAN);
            if (key.equals(TutorialActivity.BOY_SCREEN)) {
                boyMode();
            } else {
                girlMode();
            }
        }
        pager = findViewById(R.id.container);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), key);
        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String number = String.format("%s/%s", position + 1, "6");
                tvNumber.setText(number);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void girlMode() {
        int color = getResources().getColor(R.color.colorGirl);
        constraintLayout.setBackground(getResources().getDrawable(R.drawable.bg_girl));
        tvTitle.setText(getString(R.string.tips_for_women));
        tvTitle.setTextColor(color);
        tvNumber.setTextColor(color);
        line.setBackgroundColor(color);
    }

    private void boyMode() {
        int color = getResources().getColor(R.color.colorMen);
        constraintLayout.setBackground(getResources().getDrawable(R.drawable.bg_boy));
        tvTitle.setText(getString(R.string.tips_for_man));
        tvTitle.setTextColor(color);
        tvNumber.setTextColor(color);
        line.setBackgroundColor(color);
    }
}
