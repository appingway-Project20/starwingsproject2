package com.example.admin.starwingsLearningDestination;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Lalit on 09-07-2017.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private ArrayList<CreateList> galleryList;
    private ListItemClickListener listItemClickListener;
    private Context context;

    public GalleryAdapter(Context context, ArrayList<CreateList> galleryList, ListItemClickListener listener) {
        this.galleryList = galleryList;
        this.context = context;
        this.listItemClickListener=listener;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder viewHolder, int i) {
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.img.setImageResource((galleryList.get(i).getImage_ID()));
        //viewHolder.img.setBackgroundDrawable(drawables.get(i));
        //imgID=viewHolder.img.getId();
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        View v;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.img);
            v=view;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listItemClickListener.onListItemClicked(getAdapterPosition());
                }
            });
        }
    }
    public interface ListItemClickListener{
        void onListItemClicked(int index);
    }
}
