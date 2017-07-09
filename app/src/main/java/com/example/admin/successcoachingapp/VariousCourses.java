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
    ImageView coursesImage;
    String title;
    Button back;
    ImageView testimonial,gallery,map,home;
    TextView coursesInfo1,coursesInfo2,coursesInfo3,coursesInfo4,coursesInfo5,coursesInfo6,titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_various_courses);

        coursesInfo1 = (TextView) findViewById(R.id.tvVariousCourses1);
        coursesInfo2 = (TextView) findViewById(R.id.tv2);
        coursesInfo3 = (TextView) findViewById(R.id.tv3);
        coursesInfo4 = (TextView) findViewById(R.id.tv4);
        coursesInfo5 = (TextView) findViewById(R.id.tv5);
        coursesInfo6 = (TextView) findViewById(R.id.tv6);
        coursesImage = (ImageView) findViewById(R.id.ivVariousCourses);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        testimonial= (ImageView) findViewById(R.id.ivTestimonial);
        gallery= (ImageView) findViewById(R.id.ivGallery);
        map= (ImageView) findViewById(R.id.ivMap);
        back= (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);

        switch (getIntent().getIntExtra("index", 0)){
            case 0:
                coursesImage.setImageResource(R.drawable.english);
                coursesInfo2.setText("  1. Introduction of Accounting\\n\n" +
                        " 2. Accounting Terms\\n\n" +
                        " 3. ACcounting Principles and Concept\\n\n" +
                        " 4. Vouchers\\n\n" +
                        " 5. Accounting Equations\\n\n" +
                        " 6. Rules of Debit and Credit\\n\n" +
                        " 7. Journal Entries, Ledger and Trial Balance\\n\n" +
                        " 8. Cash Book\\n\n" +
                        " 9. Subsidiary Books\\n\n" +
                        "10. Depreciation\\n\n" +
                        "11. Rectification of Errors\\n\n" +
                        "12. Bank Reconcilation Statement\\n\n" +
                        "13. Bills of Exchange\\n\n" +
                        "14. Final Accounts\\n\n" +
                        "15. Single Entries\\n\n" +
                        "16. NPO");
                title="11Tth CLASS ACCOUNTS";
                break;
            case 1:
                coursesImage.setImageResource(R.drawable.ielts);
                coursesInfo1.setText("Partnership Accounts");
                coursesInfo2.setText(" 1. Fundamentals of Partnership\n 2. Goodwill\n 3. Change in Profit Sharing Ratio\n 4. Admission of Partner\n 5. Retirement/Death of a Partner\n 6. Dissolution of Partnership firm");
                coursesInfo3.setText("Company Accounts");
                coursesInfo4.setText(" 1. Issue of Shares\n 2. Issue of Debentures\n 3. Redemption of Debentures ");
                coursesInfo5.setText("Analysis Of Financial Statements");
                coursesInfo6.setText(" 1. Financial Statements\n 2. Tools of Financial Statements\n 3. Comparative and Common Size Statements\n 4. Ratio Analysis\n 5. Cash Flow Statements");
                title="12th CLASS ACCOUNTS";
                break;
            default:
                break;

        }
        titleView= (TextView) toolbar.findViewById(R.id.title);
        titleView.setText(title);
        setSupportActionBar(toolbar);

        testimonial.setOnClickListener(this);
        gallery.setOnClickListener(this);
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
            case R.id.ivMap:
                i=new Intent(VariousCourses.this,LocateUsActivity.class);
                startActivity(i);
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

}
