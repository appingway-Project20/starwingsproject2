package com.example.admin.successcoachingapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class VariousCourses extends AppCompatActivity{
    Toolbar toolbar;
    TextView coursesInfo,titleView;
    ImageView coursesImage;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_various_courses);

        coursesInfo = (TextView) findViewById(R.id.tvVariousCourses);
        coursesImage = (ImageView) findViewById(R.id.ivVariousCourses);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        switch (getIntent().getIntExtra("index", 0)){
            case 0:
                coursesImage.setImageResource(R.drawable.english);
                coursesInfo.setText("some text");
                title="General English";
                break;
            case 1:
                coursesImage.setImageResource(R.drawable.ielts);
                coursesInfo.setText("some text");
                title="IELTS";
                break;
            case 2:
                coursesImage.setImageResource(R.drawable.business);
                coursesInfo.setText("some text");
                title="Business English";
                break;
            case 3:
                coursesImage.setImageResource(R.drawable.bulats);
                coursesInfo.setText("some text");
                title="BULATS";
                break;
            case 4:
                coursesImage.setImageResource(R.drawable.toefl);
                coursesInfo.setText("some text");
                title="TOEFL";
                break;
            case 5:
                coursesImage.setImageResource(R.drawable.toeic);
                coursesInfo.setText("some text");
                title="TOEIC";
                break;
            case 6:
                coursesImage.setImageResource(R.drawable.ged);
                coursesInfo.setText("some text");
                title="GED";
                break;
            case 7:
                coursesImage.setImageResource(R.drawable.sat);
                coursesInfo.setText("some text");
                title="SAT";
                break;
            case 8:
                coursesImage.setImageResource(R.drawable.igcse);
                coursesInfo.setText("some text");
                title="IGCSE";
                break;
            case 9:
                coursesImage.setImageResource(R.drawable.gmat);
                coursesInfo.setText("some text");
                title="GMAT";
                break;
            case 10:
                coursesImage.setImageResource(R.drawable.gre);
                coursesInfo.setText("some text");
                title="GRE";
                break;
            default:
                break;

        }
        titleView=toolbar.findViewById(R.id.title);
        titleView.setText(title);
        setSupportActionBar(toolbar);

    }
}
