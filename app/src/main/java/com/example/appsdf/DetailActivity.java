package com.example.appsdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    String name, author, picture, title;
    TextView txt_name, txt_author, txt_title;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = getIntent().getStringExtra("NAME");
        picture = getIntent().getStringExtra("PICTURE");
        author = getIntent().getStringExtra("AUTHOR");
        title = getIntent().getStringExtra("TITLE");

        txt_name = findViewById(R.id.detail_name);
        txt_author = findViewById(R.id.detail_author);
        txt_title = findViewById(R.id.detail_title);
        img = findViewById(R.id.detail_img);

        txt_name.setText(name);
        txt_author.setText(author);
        txt_title.setText(title);

        Glide.with(this).load(picture).into(img);

    }
}