package com.example.admin.successcoachingapp;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VariousCourses extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    TextView coursesInfo,titleView;
    ImageView coursesImage;
    String title;
    Button back;
    ImageView testimonial,gallery,qr,map,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_various_courses);

        coursesInfo = (TextView) findViewById(R.id.tvVariousCourses);
        coursesImage = (ImageView) findViewById(R.id.ivVariousCourses);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        testimonial= (ImageView) findViewById(R.id.ivTestimonial);
        gallery= (ImageView) findViewById(R.id.ivGallery);
        qr= (ImageView) findViewById(R.id.ivQrCodes);
        map= (ImageView) findViewById(R.id.ivMap);
        back= (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);

        switch (getIntent().getIntExtra("index", 0)){
            case 0:
                coursesImage.setImageResource(R.drawable.english);
                coursesInfo.setText("some text");
                title="General English";
                break;
            case 1:
                coursesImage.setImageResource(R.drawable.ielts);
                coursesInfo.setText("some text");
                title="IELTS";
                break;
            case 2:
                coursesImage.setImageResource(R.drawable.business);
                coursesInfo.setText("some text");
                title="Business English";
                break;
            case 3:
                coursesImage.setImageResource(R.drawable.bulats);
                coursesInfo.setText("some text");
                title="BULATS";
                break;
            case 4:
                coursesImage.setImageResource(R.drawable.toefl);
                coursesInfo.setText("some text");
                title="TOEFL";
                break;
            case 5:
                coursesImage.setImageResource(R.drawable.toeic);
                coursesInfo.setText("some text");
                title="TOEIC";
                break;
            case 6:
                coursesImage.setImageResource(R.drawable.ged);
                coursesInfo.setText("some text");
                title="GED";
                break;
            case 7:
                coursesImage.setImageResource(R.drawable.sat);
                coursesInfo.setText("some text");
                title="SAT";
                break;
            case 8:
                coursesImage.setImageResource(R.drawable.igcse);
                coursesInfo.setText("some text");
                title="IGCSE";
                break;
            case 9:
                coursesImage.setImageResource(R.drawable.gmat);
                coursesInfo.setText("some text");
                title="GMAT";
                break;
            case 10:
                coursesImage.setImageResource(R.drawable.gre);
                coursesInfo.setText("some text");
                title="GRE";
                break;
            default:
                break;

        }
        titleView= (TextView) toolbar.findViewById(R.id.title);
        titleView.setText(title);
        setSupportActionBar(toolbar);

        testimonial.setOnClickListener(this);
        gallery.setOnClickListener(this);
        qr.setOnClickListener(this);
        map.setOnClickListener(this);
        back.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.ivTestimonial:
                i=new Intent(VariousCourses.this,TestimonialActivity.class);
                startActivity(i);
                break;
            case R.id.ivGallery:
                i=new Intent(VariousCourses.this,GalleryActivity.class);
                startActivity(i);
                break;
            case R.id.ivQrCodes:
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
                break;
            case R.id.ivMap:

                break;
            case R.id.ivHome:
                i=new Intent(VariousCourses.this,HomeScreenActivity.class);
                startActivity(i);
                break;
            case R.id.back_button:
                finish();
                break;
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
