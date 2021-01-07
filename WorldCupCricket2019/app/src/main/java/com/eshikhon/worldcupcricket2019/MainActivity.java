package com.eshikhon.worldcupcricket2019;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button wCup,liveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wCup=findViewById(R.id.btn1);
        liveScore=findViewById(R.id.btn7);

        wCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this,WebviewActivity.class);
                go.putExtra("URL1","https://www.espncricinfo.com");
                startActivity(go);

            }
        });
        liveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this,WebviewActivity.class);
                go.putExtra("URL2","http://www.espncricinfo.com/scores");
                startActivity(go);

            }
        });
    }
}
