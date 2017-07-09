package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StaffActivity extends AppCompatActivity {
    ImageView testimonialIv, galleryIv, locateUsIv;
    TextView staffBioTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        initViews();
        String bioText = "Shawn Matthews" + "\n" + "School Director" + "\n\n" + "Hi there, I am " +
                            "Shawn and I am the School Director at Success Coaching Centre." + "\n\n"
                            + "My teaching career took its origin in Spain and ever since then, I " +
                            "have taught in Malaysia,Thailand,Turkey,United States and currently, " +
                            "in London.I have gained considerable knowledge and experience teaching" +
                            "teaching all over the world nad meeting many interesting people, as well" +
                            "as learning about different cultures." + "\n" + "Amongst the numerous " +
                            "responsibilities I face in my job, the most important one is to make sure" +
                            "that students enrolling in success have the most fruitful nad rewarding" +
                            "experience. I really cherish being a part of the academic management team" +
                            "at Success and the challenge it has to offer. My job is to work closely with" +
                            "teachers and students alike and ensure that Success continues to pioneer" +
                            "and prosper in the education field." + "\n\n" + "My hobbies include" +
                            "sports and I am an avid crickt fan and love playing the sport, as well" +
                            "as football and squash. I hope to meet with you soon";

        testimonialIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffActivity.this, TestimonialActivity.class);
                startActivity(intent);
            }
        });

        galleryIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });
        locateUsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffActivity.this, LocateUsActivity.class);
                startActivity(intent);
            }
        });
        staffBioTv.setText(bioText);
    }
    private void initViews(){
        staffBioTv = (TextView)findViewById(R.id.staff_bio);
        testimonialIv = (ImageView)findViewById(R.id.ivTestimonial);
        galleryIv = (ImageView)findViewById(R.id.ivGallery);
        locateUsIv = (ImageView)findViewById(R.id.ivMap);
    }
}
