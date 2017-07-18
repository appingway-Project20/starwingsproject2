package com.example.admin.starwingsLearningDestination;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by Lalit on 09-07-2017.
 */

public class GalleryImage extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private Button back;
    private ImageView home;
    private int index;
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_image);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        image=(ImageView) findViewById(R.id.ivImage);
        back= (Button) findViewById(R.id.back_button);
        home= (ImageView) findViewById(R.id.ivHome);
        back.setOnClickListener(this);
        home.setOnClickListener(this);
        int index=getIntent().getIntExtra("imageID",0);
        image.setImageResource(index);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.back_button){
            finish();
        }else{
            Intent i=new Intent(GalleryImage.this,HomeScreenActivity.class);
            startActivity(i);
        }
    }
}
