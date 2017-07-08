package com.example.admin.successcoachingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by AKASH on 02-07-2017.
 */

public class GalleryActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView titleView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        titleView= (TextView) findViewById(R.id.title);
        titleView.setText("GALLERY");
    }
}
