package com.example.firebase_realtime_data;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Details_acityvity extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView listview;
    private List<student> studentList;
    private Custom_adapter custom_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_acityvity);
        databaseReference= FirebaseDatabase.getInstance().getReference("student");
        studentList=new ArrayList<>();
        custom_adapter=new Custom_adapter(Details_acityvity.this,studentList);
        listview=findViewById(R.id.listview_id);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    student student=dataSnapshot1.getValue(student.class);
                    studentList.add(student);
                }
                listview.setAdapter(custom_adapter );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}