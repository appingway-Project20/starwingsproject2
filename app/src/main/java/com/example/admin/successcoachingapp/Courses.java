package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class Courses extends AppCompatActivity implements CoursesAdapter.ListItemClickListener{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DividerItemDecoration mDividerItemDecoration;
    Toolbar toolbar;
    TextView titleView;
    String[] coursesnames={"General English Courses","IELTS","Business English Courses","BULATS","TOEFL","TOEIC","GED","SAT","IGCSE","GMAT","GRE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        titleView=toolbar.findViewById(R.id.title);
        titleView.setText("COURSES");
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        mAdapter = new CoursesAdapter(coursesnames,this);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
    public void onListItemClicked(int index) {
        Intent intent =new Intent(Courses.this, VariousCourses.class);
        intent.putExtra("index",index);
        startActivity(intent);
    }
}
