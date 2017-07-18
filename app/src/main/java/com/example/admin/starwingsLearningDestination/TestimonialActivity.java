package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by AKASH on 01-07-2017.
 */

public class TestimonialActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout antonio,tom, tina,kyoko;

    Intent intent,i;
    TextView titleView;
    ImageView testimonialimg,galleryimg,map;
    Toolbar toolbar;
    private Button back;
    private ImageView home;

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
        map = (ImageView)findViewById(R.id.ivMap);
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

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestimonialActivity.this, LocateUsActivity.class);
                startActivity(intent);
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
}
