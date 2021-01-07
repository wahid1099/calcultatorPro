package com.mahi.sqlitecrudetutorialwithproject.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mahi.sqlitecrudetutorialwithproject.R;
import com.mahi.sqlitecrudetutorialwithproject.adapter.DBAdapter;
import com.mahi.sqlitecrudetutorialwithproject.adapter.DisplayAdapter;
import com.mahi.sqlitecrudetutorialwithproject.model.Student;

import java.util.List;

public class ShowActivity extends AppCompatActivity {
    ListView listView;
    DBAdapter dbAdapter;
    DisplayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        listView = findViewById(R.id.listview);
        dbAdapter = new DBAdapter(this);

        final List<Student> studentList = dbAdapter.getAllData();
        adapter = new DisplayAdapter(this,studentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(ShowActivity.this);
                dialog.setTitle("Student Details").setMessage(studentList.get(position).toString());
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                Toast.makeText(ShowActivity.this, "Item clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
