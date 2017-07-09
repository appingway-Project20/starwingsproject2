package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class Courses extends AppCompatActivity implements CoursesAdapter.ListItemClickListener, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DividerItemDecoration mDividerItemDecoration;
    Toolbar toolbar;
    TextView titleView;
    Button back;
    ImageView testimonial, gallery, qr, map, home;
    String[] coursesnames = {"General English Courses", "IELTS", "Business English Courses", "BULATS", "TOEFL", "TOEIC", "GED", "SAT", "IGCSE", "GMAT", "GRE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        init();
        titleView.setText("COURSES");
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        mAdapter = new CoursesAdapter(coursesnames, this);
        mRecyclerView.setAdapter(mAdapter);

        testimonial.setOnClickListener(this);
        gallery.setOnClickListener(this);
        qr.setOnClickListener(this);
        map.setOnClickListener(this);
        back.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleView = (TextView) toolbar.findViewById(R.id.title);
        testimonial = (ImageView) findViewById(R.id.ivTestimonial);
        gallery = (ImageView) findViewById(R.id.ivGallery);
        qr = (ImageView) findViewById(R.id.ivQrCodes);
        map = (ImageView) findViewById(R.id.ivMap);
        back = (Button) findViewById(R.id.back_button);
        home = (ImageView) findViewById(R.id.ivHome);
    }

    @Override
    public void onListItemClicked(int index) {
        Intent intent = new Intent(Courses.this, VariousCourses.class);
        intent.putExtra("index", index);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.ivTestimonial:
                i = new Intent(Courses.this, TestimonialActivity.class);
                startActivity(i);
                break;
            case R.id.ivGallery:
                i = new Intent(Courses.this, GalleryActivity.class);
                startActivity(i);
                break;
            case R.id.ivQrCodes:
                i = new Intent("com.google.zxing.client.android.SCAN");
                i.setPackage("com.google.zxing.client.android");
                i.putExtra("SCAN_MODE", "QR_CODE_MODE");
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;
                if (isIntentSafe) {
                    startActivityForResult(i, 0);
                } else {
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.zxing.client.android"));
                    startActivity(i);
                }
                break;
            case R.id.ivMap:

                break;
            case R.id.ivHome:
                i = new Intent(Courses.this, HomeScreenActivity.class);
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
