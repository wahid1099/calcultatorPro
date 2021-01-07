package com.example.myapplicationwrwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   Button animation;
   ImageView catanimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation=findViewById(R.id.btn);
        catanimation=findViewById(R.id.catimg);
        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // catanimation.animate().alpha(0f).setDuration(5000);
              //  catanimation.animate().alpha(1f).setDuration(5000);
               // catanimation.animate().translationX(-1000f).setDuration(5000);
              //  catanimation.animate().translationY(1000f).setDuration(5000);
                catanimation.animate().rotation(360f).setDuration(5000);

            }
        });




    }

    
}
