package com.example.qrcodereader.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.qrcodereader.MainActivity;
import com.example.qrcodereader.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DELAY = 2500;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setBackgroundDrawable(null);

        initializeView();
        animateLogo();
        goToMainActivity();
    }

    private void animateLogo() {
        Animation fadingInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_without_duration);
        fadingInAnimation.setDuration(SPLASH_DELAY);
        imageView.startAnimation(fadingInAnimation);
    }

    private void initializeView() {
        imageView = findViewById(R.id.splash_image_view);

    }

    private void goToMainActivity() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, SPLASH_DELAY);
    }
}