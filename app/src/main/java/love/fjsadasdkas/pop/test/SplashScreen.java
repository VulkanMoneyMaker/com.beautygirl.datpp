package love.fjsadasdkas.pop.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.daetsoooe.naaq.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(t -> openOpeningLaunchScreen());
    }

    private void openOpeningLaunchScreen() {
        Intent intent = new Intent(this, OpeningLaunchScreen.class);
        startActivity(intent);
        finish();
    }
}
