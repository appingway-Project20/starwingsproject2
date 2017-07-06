package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class AboutUsActivity extends AppCompatActivity {
Toolbar toolbar;
    ImageView testimonialimg,galleryimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        toolbar= (Toolbar) findViewById(R.id.include2);
        testimonialimg= (ImageView) findViewById(R.id.testimonialimg);
        galleryimg= (ImageView) findViewById(R.id.galleryimg);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Us");

        testimonialimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutUsActivity.this,TestimonialActivity.class);
                startActivity(intent);
            }
        });
        galleryimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AboutUsActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });
    }
}
