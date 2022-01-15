package com.example.newsapp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.Models.NewsHeadlines;
import com.example.newsapp.R;

public class Details extends AppCompatActivity {

    NewsHeadlines headlines;
    //TextView txt_title,txt_author,txt_time,txt_content;
    //TextView txt_detail;
    //ImageView img_news;
    WebView webview;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        headlines= (NewsHeadlines) getIntent().getSerializableExtra("data");

        /*txt_title=findViewById(R.id.text_detail_title);
        txt_author=findViewById(R.id.text_detail_author);
        txt_detail=findViewById(R.id.text_detail_detail);
        txt_time=findViewById(R.id.text_details_time);
        txt_content=findViewById(R.id.text_detail_content);
        img_news=findViewById(R.id.img_detail_news);



        txt_title.setText(headlines.getTitle());
         txt_author.setText(headlines.getAuthor());
         txt_time.setText(headlines.getPublishedAt());
         txt_detail.setText(headlines.getDescription());
         txt_content.setText(headlines.getContent());

        Picasso.get().load(headlines.getUrlToImage()).into(img_news);*/

        url=headlines.getUrl();
        WebView myWebView = (WebView) findViewById(R.id.wb);
        myWebView.loadUrl(url);
    }
}