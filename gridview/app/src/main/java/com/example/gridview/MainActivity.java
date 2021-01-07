package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    int[] flags={R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,};
    String[]  programminglg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridviewId);
        programminglg=getResources().getStringArray(R.array.array_technology);
        CustomAdapter adapter=new CustomAdapter(this,programminglg,flags);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String values=programminglg[position];
                Toast.makeText(MainActivity.this,values, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
