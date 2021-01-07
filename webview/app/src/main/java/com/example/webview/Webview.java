package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Webview extends AppCompatActivity {
    WebView myWebView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview3);
        myWebView=findViewById(R.id.webView);

        Bundle data =getIntent().getExtras();
        if(data.containsKey("URL1"))
        {
            url =data.getString("URL1");
        }
        if(data.containsKey("URL2"))
        {
            url =data.getString("URL2");
        }
        myWebView.loadUrl(url);
    }
}
