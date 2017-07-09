package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OurStaffActivity extends AppCompatActivity implements MyAdapter.ListItemClickListener {
    String[] names = {"SHAWN MATHEWS","SUZZANE PETERS","JOHN COBAIN","SHELLY NTINI","JACK WHITE",
                        "WILL GREEN","SALLY HOUGHTON"};
    TextView staffIntrotv;
    ImageView testimonialIv, galleryIv, locateUsIv,homeIv;
    Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration mDividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setSupportActionBar(toolbar);

        staffIntrotv.setText("We are who we are because of our staff. Get a chance to learn more " +
                            "about our teachers.");

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
               DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        adapter = new MyAdapter(names,this);
        mRecyclerView.setAdapter(adapter);

        testimonialIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurStaffActivity.this, TestimonialActivity.class);
                startActivity(intent);
            }
        });

        galleryIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurStaffActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });
        locateUsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurStaffActivity.this, LocateUsActivity.class);
                startActivity(intent);
            }
        });
        homeIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurStaffActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onListItemClicked(int index) {
        Intent intent;
        switch (index){
            case 0:
             intent = new Intent(OurStaffActivity.this, StaffActivity.class);
            startActivity(intent);break;
            case 1:
                 intent = new Intent(OurStaffActivity.this, StaffActivity.class);
                startActivity(intent);break;
            case 2:
                intent = new Intent(OurStaffActivity.this, StaffActivity.class);
                startActivity(intent);break;
            case 3:
                intent = new Intent(OurStaffActivity.this, StaffActivity.class);
                startActivity(intent);break;
            case 4:
                intent = new Intent(OurStaffActivity.this, StaffActivity.class);
                startActivity(intent);break;
            case 5:
                intent = new Intent(OurStaffActivity.this, StaffActivity.class);
                startActivity(intent);break;
            case 6:
                intent = new Intent(OurStaffActivity.this, StaffActivity.class);
                startActivity(intent);break;
            default:
                return;

        }
    }
    private void initViews(){
        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        staffIntrotv = (TextView)findViewById(R.id.staff_intro);
        homeIv = (ImageView)findViewById(R.id.ivHome);
        testimonialIv = (ImageView)findViewById(R.id.ivTestimonial);
        galleryIv = (ImageView)findViewById(R.id.ivGallery);
        locateUsIv = (ImageView)findViewById(R.id.ivMap);
    }
}
