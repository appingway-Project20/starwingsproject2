package com.example.admin.successcoachingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    String[] itemNames = {"ABOUT US","COURSES","OUR STAFF"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //same layout file as staff screen.
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.staff_intro);
        tv.setVisibility(View.INVISIBLE);


    }
}
