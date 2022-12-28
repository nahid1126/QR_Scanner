package com.nahid.qr_scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class SplashActivity extends AppCompatActivity {
    private ImageView image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        image = findViewById(R.id.img);
        YoYo.with(Techniques.BounceInUp).duration(2000).onEnd(animator -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }).playOn(image);
    }
}