package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
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


public class Courses extends AppCompatActivity implements CoursesAdapter.ListItemClickListener, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DividerItemDecoration mDividerItemDecoration;
    Toolbar toolbar;
    TextView titleView;
    Button back;
    ImageView testimonial, gallery, map, home;
    String[] coursesnames = {"11th CLASS ACCOUNTS", "12th CLASS ACCOUNTS","CA","CS","CPT","IPCC","FINAL","IFRS","B.COM","M.COM","MBA","BBA"};

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
        map.setOnClickListener(this);
        back.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleView = (TextView) toolbar.findViewById(R.id.title);
        testimonial = (ImageView) findViewById(R.id.ivTestimonial);
        gallery = (ImageView) findViewById(R.id.ivGallery);
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
            case R.id.ivMap:
                i = new Intent(Courses.this, LocateUsActivity.class);
                startActivity(i);
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

}
