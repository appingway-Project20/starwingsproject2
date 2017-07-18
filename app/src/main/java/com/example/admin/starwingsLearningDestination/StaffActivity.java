package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StaffActivity extends AppCompatActivity {
    ImageView testimonialIv, galleryIv, locateUsIv;
    TextView staffBioTv;
    private Button back;
    private ImageView homeIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        initViews();
        String bioText = " Sachin Kaushik is a throughout first class Graduate with distinction in B.Com from Delhi University.\n He obtained 100% marks in Cost Accounting and INCOME TAX.\n Now he is pursuing in Chartered Accountant(final) as well as Company Secretary (Prof.) as well as he passed exam of MCX, NCX. Now he is working as Financial Analyst in PaisaVassoli.com (a Financial Research Company).\n He is topper in Account in XII class in his Area. He is inspired by his mother Smt. Sunita Kaushik who always motivated and encouraged him.\n His technique of approaching the subject matter, style of revision and guidelines for preparation of examination are quite popular among students.";

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
        homeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StaffActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        staffBioTv.setText(bioText);
    }
    private void initViews(){
        staffBioTv = (TextView)findViewById(R.id.staff_bio);
        testimonialIv = (ImageView)findViewById(R.id.ivTestimonial);
        galleryIv = (ImageView)findViewById(R.id.ivGallery);
        locateUsIv = (ImageView)findViewById(R.id.ivMap);
        back= (Button) findViewById(R.id.back_button);
        homeIv = (ImageView)findViewById(R.id.ivHome);
    }
}
