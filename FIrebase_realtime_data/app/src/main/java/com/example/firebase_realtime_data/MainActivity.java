package com.example.firebase_realtime_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
 private EditText nameditText,ageeditext;
 Button submitbtn,loadbtn;
 DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameditText=findViewById(R.id.nameeidtid);
        ageeditext=findViewById(R.id.ageditid);
        submitbtn=findViewById(R.id.submitButtonid);
        loadbtn=findViewById(R.id.loadButtonid);
        databaseReference= FirebaseDatabase.getInstance().getReference("student");
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }
        });
        loadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Details_acityvity.class);
                startActivity(intent);
            }
        });
    }


    private void savedata() {
        String name=nameditText.getText().toString().trim();
        String age=ageeditext.getText().toString().trim();
        String key=databaseReference.push().getKey();
        student student1=new student(name,age);
        databaseReference.child(key).setValue(student1);
        Toast.makeText(this, "Succesfully Saved", Toast.LENGTH_SHORT).show();
        nameditText.setText("");
        ageeditext.setText("");
    }
}