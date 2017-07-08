package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by AKASH on 01-07-2017.
 */

public class TestimonialDetailActivity extends AppCompatActivity {

    Toolbar toolbar;



    ImageView testimonialimg,galleryimg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testimonial_fragment);
        toolbar= (Toolbar) findViewById(R.id.include4);
        setSupportActionBar(toolbar);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        String id=getIntent().getStringExtra("name");
        if(id.equals("1")){
            ft.replace(R.id.listFragment,new AntonioFragment() );
            ft.commit();
        }
        if(id.equals("2")){
            ft.replace(R.id.listFragment,new TinaFragment() );
            ft.commit();
        }
        if(id.equals("3")){
            ft.replace(R.id.listFragment,new TomFragment() );
            ft.commit();
        }
        if(id.equals("4")){
            ft.replace(R.id.listFragment, new kyoukoFragment());
            ft.commit();
        }



        testimonialimg= (ImageView) findViewById(R.id.testimonialimg);
        galleryimg= (ImageView) findViewById(R.id.galleryimg);

        testimonialimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestimonialDetailActivity.this,TestimonialActivity.class);
                startActivity(intent);
            }
        });
        galleryimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestimonialDetailActivity.this,GalleryActivity.class);
                startActivity(intent);
            }
        });
    }
}

