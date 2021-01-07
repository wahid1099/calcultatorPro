package com.eshikhon.worldcupcricket2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {
    WebView myWebView;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
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
