package com.example.sqlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Mydatabaasehelper mydatabaasehelper;
    Button addbotton;
    EditText nameedittxt,ageedit,genderedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabaasehelper=new Mydatabaasehelper(this);
        SQLiteDatabase sqLiteDatabase=mydatabaasehelper.getWritableDatabase();
        nameedittxt=findViewById(R.id.nmet);
        ageedit=findViewById(R.id.aget);
        genderedit=findViewById(R.id.gndet);
        addbotton=findViewById(R.id.addbtn);
        addbotton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name=nameedittxt.getText().toString();
        String age=ageedit.getText().toString();
        String gender=genderedit.getText().toString();
        if(v.getId()==R.id.addbtn){
          long rowID= mydatabaasehelper.insertdata(name,age,gender);


          if(rowID==-1){
              Toast.makeText(this, "unsuccessfull", Toast.LENGTH_SHORT).show();
          }else{
              Toast.makeText(this, "Row" +rowID+ " Succesfully  created", Toast.LENGTH_SHORT).show();

          }
        }

    }
}