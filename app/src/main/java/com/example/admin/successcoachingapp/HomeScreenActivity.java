package com.example.admin.successcoachingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    String[] itemNames = {"ABOUT US","COURSES","OUR STAFF"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //same layout file as staff screen.
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.staff_intro);
        tv.setVisibility(View.INVISIBLE);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(itemNames);
        mRecyclerView.setAdapter(adapter);

    }
}
