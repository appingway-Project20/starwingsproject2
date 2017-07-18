package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lalit on 02-07-2017.
 */

public class GalleryActivity extends AppCompatActivity implements GalleryAdapter.ListItemClickListener,View.OnClickListener{
    Toolbar toolbar;
    TextView titleView;
    Button back;
    ImageView home;
    private static int image_ids[]={
                    R.mipmap.a,
                    R.mipmap.b,
                    R.mipmap.c,
                    R.mipmap.d,
                    R.mipmap.e,
                    R.mipmap.f,
                    R.mipmap.g,
                    R.mipmap.h,
                    R.mipmap.i,
                    R.mipmap.j,
                    R.mipmap.k,
                    R.mipmap.l,
                    R.mipmap.m,
                    R.mipmap.n,
                    R.mipmap.o,
                    R.mipmap.p,
                    R.mipmap.q,
                    R.mipmap.r,
                    R.mipmap.s,
                    R.mipmap.t,
                    R.mipmap.u,
                    R.mipmap.v,
                    R.mipmap.w,
                    R.mipmap.x,
                    R.mipmap.y,
                    R.mipmap.z,
                    R.mipmap.aa,
                    R.mipmap.bb,
                    R.mipmap.cc,
                    R.mipmap.dd,
                    R.mipmap.ee,
                    R.mipmap.ff,
                    R.mipmap.gg,
                    R.mipmap.hh,
                    R.mipmap.ii,
                    R.mipmap.jj,
                    R.mipmap.kk,
                    R.mipmap.ll,
                    R.mipmap.mm,
                    R.mipmap.nn,
                    R.mipmap.oo,
                    R.mipmap.pp,
                    R.mipmap.qq,
                    R.mipmap.rr,
                    R.mipmap.ss,
                    R.mipmap.tt,
                    R.mipmap.uu,
                    R.mipmap.vv,
                    R.mipmap.ww,
                    R.mipmap.xx};
                    ArrayList<CreateList> createLists;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        titleView= (TextView) findViewById(R.id.title);
        titleView.setText("GALLERY");
        back= (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);
        back.setOnClickListener(this);
        home.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        createLists= prepareData();
        GalleryAdapter adapter = new GalleryAdapter(getApplicationContext(), createLists ,this);
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
        intent.putExtra("imageID", image_ids[index]);
        startActivity(intent);
    }
    @Override

    public void onClick(View v) {
        if(v.getId() == R.id.back_button){
            finish();
        }else{
            Intent i=new Intent(GalleryActivity.this,HomeScreenActivity.class);
            startActivity(i);
        }
    }
}

