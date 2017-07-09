package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AboutUsActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView testimonialimg,galleryimg,qrimg,map;
    TextView titleView;
    Button back;
    ImageView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        toolbar= (Toolbar) findViewById(R.id.include2);
        testimonialimg= (ImageView) findViewById(R.id.testimonialimg);
        galleryimg= (ImageView) findViewById(R.id.galleryimg);
        qrimg= (ImageView) findViewById(R.id.ivQrCodes);
        map= (ImageView) findViewById(R.id.ivMap);
        back= (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);
        setSupportActionBar(toolbar);
        titleView= (TextView) findViewById(R.id.title);
        titleView.setText("ABOUT US");

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
        qrimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.google.zxing.client.android.SCAN");
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
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Intent intent = new Intent(AboutUsActivity.this, LocateUsActivity.class);
                startActivity(intent);
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
                Intent intent=new Intent(AboutUsActivity.this,HomeScreenActivity.class);
                startActivity(intent);

            }
        });

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
