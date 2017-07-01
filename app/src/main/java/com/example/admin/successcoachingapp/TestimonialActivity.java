package com.example.admin.successcoachingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by AKASH on 01-07-2017.
 */

public class TestimonialActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout antonio,tom,
                tina,kyoko;

    Intent intent;

    ImageView testimonialimg,galleryimg;
    Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonial);
        intent=new Intent(TestimonialActivity.this,TestimonialDetailActivity.class);
        init();

        toolbar= (Toolbar) findViewById(R.id.include3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Testimonials");
        antonio.setOnClickListener(this);
        tom.setOnClickListener(this);
        tina.setOnClickListener(this);
        kyoko.setOnClickListener(this);

        testimonialimg= (ImageView) findViewById(R.id.testimonialimg);
        galleryimg= (ImageView) findViewById(R.id.galleryimg);
        testimonialimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestimonialActivity.this,TestimonialActivity.class);
                startActivity(intent);
            }
        });
        galleryimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestimonialActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        antonio= (LinearLayout) findViewById(R.id.linearLayout2);
        tina= (LinearLayout) findViewById(R.id.linearLayout);
        tom= (LinearLayout) findViewById(R.id.linearLayout3);
        kyoko= (LinearLayout) findViewById(R.id.linearLayout4);


    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.linearLayout2){
            intent.putExtra("name","1");
            startActivity(intent);
        }
        if(id==R.id.linearLayout){
            intent.putExtra("name","2");
            startActivity(intent);
        }
        if(id==R.id.linearLayout3){
            intent.putExtra("name","3");
            startActivity(intent);
        }
        if(id==R.id.linearLayout4){
            intent.putExtra("name","4");
            startActivity(intent);
        }
    }
}
