package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {

     Toolbar toolbar;
     TextView titleView,aboutUs,staff,courses;
     ImageView testimonial,gallery,map,home;

     Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //same layout file as staff screen.
        setContentView(R.layout.activity_home_screen);
        init();
        titleView.setText("HOME");
        setSupportActionBar(toolbar);
        
        testimonial.setOnClickListener(this);
        gallery.setOnClickListener(this);
        map.setOnClickListener(this);
        aboutUs.setOnClickListener(this);
        courses.setOnClickListener(this);
        staff.setOnClickListener(this);
        back.setOnClickListener(this);
        home.setOnClickListener(this);

    }
    public void onClick(View view){
        Intent i;
        switch (view.getId()){
            case R.id.ivTestimonial:
                i=new Intent(HomeScreenActivity.this,TestimonialActivity.class);
                startActivity(i);
                break;
            case R.id.ivGallery:
                i=new Intent(HomeScreenActivity.this,GalleryActivity.class);
                startActivity(i);
                break;
            case R.id.ivMap:
                    i = new Intent(HomeScreenActivity.this,LocateUsActivity.class);
                    startActivity(i);
                break;
            case R.id.tvAboutUs:
                i =new Intent(HomeScreenActivity.this,AboutUsActivity.class);
                startActivity(i);
                break;
            case R.id.tvCourses:
                i =new Intent(HomeScreenActivity.this,Courses.class);
                startActivity(i);
                break;
            case R.id.tvStaff:
                i =new Intent(HomeScreenActivity.this,OurStaffActivity.class);
                startActivity(i);
                break;
            case R.id.back_button:
                finish();
                break;

        }

    }
    public void init() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        titleView= (TextView) toolbar.findViewById(R.id.title);
        back = (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);
        testimonial= (ImageView) findViewById(R.id.ivTestimonial);
        gallery= (ImageView) findViewById(R.id.ivGallery);
        map =  (ImageView) findViewById(R.id.ivMap);
        aboutUs= (TextView) findViewById(R.id.tvAboutUs);
        courses= (TextView) findViewById(R.id.tvCourses);
        staff= (TextView) findViewById(R.id.tvStaff);
    }
}
