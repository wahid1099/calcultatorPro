package com.example.colour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linearlayoutid);
        if(loadcolour()!=getResources().getColor(R.color.colorPrimary)){
            linearLayout.setBackgroundColor(loadcolour());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.redcolour){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.redcolour));
            storecolor(getResources().getColor(R.color.redcolour));

        }
        if(item.getItemId()==R.id.green){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.Greencolour));
            storecolor(getResources().getColor(R.color.Greencolour));

        }
        if(item.getItemId()==R.id.pink){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.Pinkcolour));
            storecolor(getResources().getColor(R.color.Pinkcolour));

        }

        return super.onOptionsItemSelected(item);
    }

    private void storecolor(int color) {
        SharedPreferences sharedPreferences=getSharedPreferences("selecteddcolour", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("mycolur",color);
        editor.commit();
    }
    private  int loadcolour()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("selecteddcolour", Context.MODE_PRIVATE);
        int selectedcolour=sharedPreferences.getInt("mycolur",getResources().getColor(R.color.colorPrimary));
        return selectedcolour;
    }
}