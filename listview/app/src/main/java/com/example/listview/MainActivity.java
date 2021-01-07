package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mylistview;
     String[]  arraynames;
     int[] flags={R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,R.drawable.scot,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview=findViewById(R.id.lists);


        arraynames=getResources().getStringArray(R.array.array_technology);

        CustomAdapter adapter=new CustomAdapter(this,arraynames,flags);
       mylistview.setAdapter(adapter);















       /*final String[]  arraynames=getResources().getStringArray(R.array.array_technology);
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.textview,arraynames);
        mylistview.setAdapter(adapter);
       mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String value=arraynames[position];
               Toast.makeText(MainActivity.this,value, Toast.LENGTH_SHORT).show();
           }
       });*/
    }
}
