package love.fjsadasdkas.pop.tips;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import love.fjsadasdkas.pop.R;
import love.fjsadasdkas.pop.test.TutorialActivity;


public class FKlfs extends FragmentActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    private TextView tvNumber;
    private String key;
    private ImageView imgIcon;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);


        tvNumber = findViewById(R.id.tv_number);
        imgIcon = findViewById(R.id.imageView2);
        if (getIntent() != null) {
            key = getIntent().getStringExtra(TutorialActivity.KEY_HUMAN);
            if (key.equals(TutorialActivity.BOY_SCREEN)) {
                boyMode();
            } else {
                girlMode();
            }
        }
        pager = findViewById(R.id.container);
        pagerAdapter = new FKDFD(getSupportFragmentManager(), key);
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
        imgIcon.setImageResource(R.drawable.small_gitl_icon);
    }

    private void boyMode() {
        imgIcon.setImageResource(R.drawable.small_boy_icon);
    }
}
