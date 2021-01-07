package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Showbtn,savebtn;
    EditText nameEt,Emailet,Cgpaet,phoneEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Showbtn=findViewById(R.id.Showbtn);
        savebtn=findViewById(R.id.savebtn);
        nameEt=findViewById(R.id.namet);
       Emailet=findViewById(R.id.emailet);
        Cgpaet=findViewById(R.id.cgpaet);
        phoneEt=findViewById(R.id.phnet);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String name = nameEt.getText().toString().trim();
                if (name.isEmpty()) {

                    nameEt.setError("Enter your name");
                }else if(name.length()<6){
                    nameEt.setError("name is too short");

                }else{
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }
                String email=Emailet.getText().toString().trim();
                if(email.isEmpty()){

                    Emailet.setError("Email can't be Empty");
                }else{
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}