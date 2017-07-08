package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //same layout file as staff screen.
        setContentView(R.layout.activity_home_screen);



    }
    public void onClick(View view){
        Intent intent = new Intent(HomeScreenActivity.this,OurStaffActivity.class);
        startActivity(intent);
    }
}
