package com.example.admin.successcoachingapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {
    private String[] mCoursesnames;
    private ListItemClickListener listItemClickListener;
    private static final String BULLET_SYMBOL = "&#8594";

    public CoursesAdapter(String[] myDataset, ListItemClickListener listItemClickListener) {
        mCoursesnames = myDataset;
        this.listItemClickListener=listItemClickListener;
    }

    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.courses_item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setText(Html.fromHtml(BULLET_SYMBOL + mCoursesnames[position]));
        holder.itemView.setTextSize(25);
        holder.itemView.setTextColor(Color.WHITE);
        if((position==0) || (position==3) || (position==6) || (position==9)){
            holder.itemView.setBackgroundColor(Color.rgb(249,138,85));
        }
        else if((position==1) || (position==4) || (position==7) || (position==10)) {
            holder.itemView.setBackgroundColor(Color.rgb(30,191,26));
        }
        else {
            holder.itemView.setBackgroundColor(Color.rgb(88,116,24));
        }
    }

    @Override
    public int getItemCount() {
        return mCoursesnames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemView;
        public ViewHolder(TextView v) {
            super(v);
            itemView=v;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listItemClickListener.onListItemClicked(getAdapterPosition());
        }
    }

    public interface ListItemClickListener{
        void onListItemClicked(int index);
    }
}