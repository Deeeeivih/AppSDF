package com.example.appsdf.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appsdf.R;

public class AdapterNews {

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
