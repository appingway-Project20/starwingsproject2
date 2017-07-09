package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

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
        qrcode= (ImageView) findViewById(R.id.ivQrCodes);
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
        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent("com.google.zxing.client.android.SCAN");
                i.setPackage("com.google.zxing.client.android");
                i.putExtra("SCAN_MODE", "QR_CODE_MODE");
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if(isIntentSafe) {
                    startActivityForResult(i, 0);
                }else {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.zxing.client.android"));
                    startActivity(i);
                }
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

