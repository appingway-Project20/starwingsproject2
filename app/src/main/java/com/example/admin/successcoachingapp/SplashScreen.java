package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_TIME = 2500;
    static int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsplash);
        Thread th= new Thread(){
            @Override
            public void run() {
                try {
                    sleep(SPLASH_TIME);

                    Intent intent= new Intent(getApplicationContext(),HomeScreenActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}
