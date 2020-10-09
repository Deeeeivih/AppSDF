package com.example.appsdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.appsdf.adapter.AdapterNews;
import com.example.appsdf.model.News;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class PrincipalActivity extends AppCompatActivity {

    private static final String URL="https://newsapi.org/v2/top-headlines?country=co&apiKey=8bd54e1cbb854cfab117eab3eab1d8ee";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processHttp();

    }

    public void processHttp(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO", data);
                processNews(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void processNews(String data){
        try {
            JSONObject root = new JSONObject(data);
            JSONArray articles = root.getJSONArray("articles");

            List<News> list = new ArrayList<>();

            for (int i = 0; i<articles.length();i++){
                JSONObject news1 = articles.getJSONObject(i);

                String author = news1.getString("author");
                String title = news1.getString("title");
                String urlToImage = news1.getString("urlToImage");

                JSONObject source = news1.getJSONObject("source");
                String name = source.getString("name");



                News news = new News(name, author, title, urlToImage);
                list.add(news);



            }




            RecyclerView rc = findViewById(R.id.recycler_view);
            AdapterNews ad = new AdapterNews(this,list ,R.layout.item_news);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);


        }catch (JSONException e){
            e.printStackTrace();

        }
    }


}