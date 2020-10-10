package com.alcoholic.alcoholic_ingredients.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.alcoholic.alcoholic_ingredients.R;

public class MainActivity extends AppCompatActivity {
    ImageView frontDrink;
    CountDownTimer countTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_splash_screen);
        getSupportActionBar().hide(); // hide

        frontDrink = findViewById(R.id.image_front);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        frontDrink.startAnimation(animation);

        countTimer = new CountDownTimer(2290,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, DashboardController.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }



}