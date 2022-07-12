package com.example.newsapp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.Models.NewsHeadlines;
import com.example.newsapp.R;

public class Details extends AppCompatActivity {

    NewsHeadlines headlines;
   
    WebView webview;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        headlines= (NewsHeadlines) getIntent().getSerializableExtra("data");

        url=headlines.getUrl();
        WebView myWebView = (WebView) findViewById(R.id.wb);
        myWebView.loadUrl(url);
    }
}
