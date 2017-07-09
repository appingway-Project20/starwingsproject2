package com.example.admin.successcoachingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lalit on 02-07-2017.
 */

public class GalleryActivity extends AppCompatActivity implements GalleryAdapter.ListItemClickListener{
    Toolbar toolbar;
    TextView titleView;
    private final Integer image_ids[] = {
            R.drawable.courses,
            R.drawable.igcse,
            R.drawable.staff_people,
            R.drawable.bulats,
            R.drawable.english,
            R.drawable.business,
            R.drawable.gmat,
            R.drawable.toeic,
            R.drawable.people,
            R.drawable.sat,
            R.drawable.igcse,
            R.drawable.toefl,
            R.drawable.people,
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        titleView= (TextView) findViewById(R.id.title);
        titleView.setText("GALLERY");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        GalleryAdapter adapter = new GalleryAdapter(getApplicationContext(), createLists,this);
        recyclerView.setAdapter(adapter);
    }
    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theimage = new ArrayList<>();
        for(int i = 0; i< image_ids.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_ID(image_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }

    @Override
    public void onListItemClicked(int index) {
        Intent intent=new Intent(GalleryActivity.this,GalleryImage.class);
        intent.putExtra("imageID",image_ids[index]);
        startActivity(intent);
    }
}

