package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by AKASH on 01-07-2017.
 */

public class TestimonialDetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button back;
    ImageView home;


    ImageView testimonialimg,galleryimg,qrcode,locateus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testimonial_fragment);
        toolbar= (Toolbar) findViewById(R.id.include4);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Testimonials");
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



        testimonialimg= (ImageView) findViewById(R.id.ivTestimonial);
        galleryimg= (ImageView) findViewById(R.id.ivGallery);
        locateus= (ImageView) findViewById(R.id.ivMap);
        back = (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);

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


        locateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(TestimonialDetailActivity.this,HomeScreenActivity.class);
                startActivity(i);
            }
        });
    }
}

