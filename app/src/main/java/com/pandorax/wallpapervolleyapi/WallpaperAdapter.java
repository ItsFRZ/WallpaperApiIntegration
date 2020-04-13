package com.pandorax.wallpapervolleyapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperItemViewHolder>{

    private Context context;
    private ArrayList<WallpaperItem> arrayList;

    public WallpaperAdapter(Context context, ArrayList<WallpaperItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public WallpaperItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.customdesign,parent,false);

        return new WallpaperItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperItemViewHolder holder, int position) {

        WallpaperItem item = arrayList.get(position);
        String url = item.getWebformatURL();
        String likes = item.getLikes();
        String download = item.getDownloads();

        holder.likes.setText("Likes:\t"+likes);
        holder.downlaod.setText("Downloads:\t"+download);
        Glide.with(context).load(url).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class WallpaperItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView likes,downlaod;

        public WallpaperItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image123);
            likes = (TextView) itemView.findViewById(R.id.likes);
            downlaod = (TextView) itemView.findViewById(R.id.downloads);

        }
    }

}
