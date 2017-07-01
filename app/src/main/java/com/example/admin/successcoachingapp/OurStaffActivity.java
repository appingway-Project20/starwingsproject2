package com.example.admin.successcoachingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class OurStaffActivity extends AppCompatActivity {
    String[] names = {"SHAWN MATHEWS","SUZZANE PETERS","JOHN COBAIN","SHELLY NTINI","JACK WHITE",
                        "WILL GREEN","SALLY HOUGHTON"};
    TextView staffIntrotv;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    private DividerItemDecoration mDividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        staffIntrotv = (TextView)findViewById(R.id.staff_intro);
        staffIntrotv.setText("We are who we are because of our staff. Get a chance to learn more " +
                            "about our teachers.");

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
               DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        adapter = new MyAdapter(names);
        mRecyclerView.setAdapter(adapter);

    }

}
