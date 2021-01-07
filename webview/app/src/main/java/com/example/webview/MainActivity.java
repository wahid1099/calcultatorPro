package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button wcup,livescore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wcup=findViewById(R.id.btn1);
        livescore=findViewById(R.id.btn7);

        wcup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this,Webview.class);
                go.putExtra("URL1","https://www.youtube.com");
                startActivity(go);
            }
        });
        livescore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this,Webview.class);
                go.putExtra("URL2","https://www.worldometers.info/coronavirus/?utm_campaign=homeAdvegas1?");
                startActivity(go);
            }
        });
    }
}
