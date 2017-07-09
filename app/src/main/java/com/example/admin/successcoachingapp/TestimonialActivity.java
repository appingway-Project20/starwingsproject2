package com.example.admin.successcoachingapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AKASH on 01-07-2017.
 */

public class TestimonialActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout antonio,tom, tina,kyoko;

    Intent intent,i;
    TextView titleView;
    ImageView testimonialimg,galleryimg;
    Toolbar toolbar;
    private Button back;
    private ImageView home;
    private ImageView qr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testimonial);

        init();

        toolbar= (Toolbar) findViewById(R.id.include3);
        setSupportActionBar(toolbar);
        titleView= (TextView) findViewById(R.id.title);
        titleView.setText("TESTIMONIAL");
        antonio.setOnClickListener(this);
        tom.setOnClickListener(this);
        tina.setOnClickListener(this);
        kyoko.setOnClickListener(this);
        back.setOnClickListener(this);
        home.setOnClickListener(this);

        testimonialimg= (ImageView) findViewById(R.id.testimonialimg);
        galleryimg= (ImageView) findViewById(R.id.galleryimg);
        qr= (ImageView) findViewById(R.id.ivQrCodes);
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
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    }

    private void init() {
        antonio= (LinearLayout) findViewById(R.id.linearLayout2);
        tina= (LinearLayout) findViewById(R.id.linearLayout);
        tom= (LinearLayout) findViewById(R.id.linearLayout3);
        kyoko= (LinearLayout) findViewById(R.id.linearLayout4);
        back = (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);


    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        intent=new Intent(TestimonialActivity.this,TestimonialDetailActivity.class);
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
        if(id==R.id.ivHome){
            intent=new Intent(TestimonialActivity.this,HomeScreenActivity.class);
            startActivity(intent);
        }
        if(id==R.id.back_button){
            finish();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

            } else if (resultCode == RESULT_CANCELED) {

            }
        }
    }
}
