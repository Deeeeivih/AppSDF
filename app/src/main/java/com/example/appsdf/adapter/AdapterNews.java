package com.example.appsdf.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appsdf.R;
import com.example.appsdf.model.News;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewsHolder> {

    public Activity activity;
    public List<News> list;
    public int item_news;

    public AdapterNews(Activity activity, List<News> list, int item_news) {
        this.activity = activity;
        this.list = list;
        this.item_news = item_news;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_news,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news = list.get(position);
        holder.item_name.setText(news.name);
        holder.item_author.setText(news.author);
        holder.item_title.setText(news.title);
        Glide.with(activity).load(news.urlToImage).into(holder.item_img);
        holder.urlImage = news.urlToImage;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class NewsHolder extends RecyclerView.ViewHolder {
        TextView item_name, item_author, item_title;
        ImageView item_img;
        RelativeLayout item_card;

        String urlImage;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_author = itemView.findViewById(R.id.item_author);
            item_title = itemView.findViewById(R.id.item_title);
            item_card = itemView.findViewById(R.id.item_card);
            item_img = itemView.findViewById(R.id.item_img);
        }
    }
}
