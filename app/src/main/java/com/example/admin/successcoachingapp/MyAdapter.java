package com.example.admin.successcoachingapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin on 6/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.OurStaffViewHolder>{
   String[] names;
    private static final String TAG = MyAdapter.class.getSimpleName();
    private ListItemClickListener listItemClickListener;
    private static int viewHolderCount;

    public MyAdapter(String[] names, ListItemClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
        this.names = names;
        // to keep count of the number of view holders created.
        viewHolderCount = 0;
    }


    @Override
    public MyAdapter.OurStaffViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.our_staff_item_layout, parent,false);
        OurStaffViewHolder viewHolder = new OurStaffViewHolder(v);
        int backgroundColorForViewHolder = ColorUtils.getBackgroundColor(parent.getContext(),viewHolderCount);
        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);
        viewHolderCount++;
        Log.d(TAG,"Number of view holders created "+ viewHolderCount);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.OurStaffViewHolder holder, int position) {
        holder.stafftv.setText(names[position]);
        holder.stafftv.setTextSize(24);
        holder.stafftv.setTextColor(Color.WHITE);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }


    class OurStaffViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView stafftv;
        public OurStaffViewHolder(View itemView) {
            super(itemView);
            stafftv = (TextView)itemView.findViewById(R.id.staff_name_tv);
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
