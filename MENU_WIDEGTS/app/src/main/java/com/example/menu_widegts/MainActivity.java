package com.example.menu_widegts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mylistview;
    String[]  arraynames;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylistview=findViewById(R.id.lists);
        arraynames=getResources().getStringArray(R.array.array_technology);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.textview,arraynames);
        mylistview.setAdapter(adapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = arraynames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
            });

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        MenuItem menuItem=menu.findItem(R.id.search);



        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String  newText){
                  adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
            if (item.getItemId() == R.id.setting_id) {
                Toast.makeText(MainActivity.this, "Setting Is selected", Toast.LENGTH_SHORT).show();
                return true;
            }

            if (item.getItemId() == R.id.aboutus_id) {
                Toast.makeText(MainActivity.this, "About us Is selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (item.getItemId() == R.id.Contact_id) {
                Toast.makeText(MainActivity.this, "Contact us Is selected", Toast.LENGTH_SHORT).show();
                return true;
            }
            return super.onOptionsItemSelected(item);





    }
}
