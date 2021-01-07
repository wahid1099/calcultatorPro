package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView Detailtextview;
    Button savebtn,showbtn;
    EditText Username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Detailtextview=findViewById(R.id.textview);
        savebtn=findViewById(R.id.svebtn);
        showbtn=findViewById(R.id.showbtn);
        Username=findViewById(R.id.name);
        password=findViewById(R.id.password);
        savebtn.setOnClickListener(this);
        showbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.svebtn){
            String username=Username.getText().toString();
            String Password=password.getText().toString();
            //writing data
            if(username.equals("") && Password.equals(""))
            {
                Toast.makeText(this, "PLease entern name and password", Toast.LENGTH_SHORT).show();
            }else{
                SharedPreferences sharedPreferences=getSharedPreferences("userdetails",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("usernamekey",username);
                editor.putString("passwordkey",Password);
                editor.commit();
                Username.setText("");
                password.setText("");
                Toast.makeText(this, "Data is stored sucesfully", Toast.LENGTH_SHORT).show();
            }

        }else if(view.getId()==R.id.showbtn){
            SharedPreferences sharedPreferences=getSharedPreferences("userdetails",Context.MODE_PRIVATE);
            if (sharedPreferences.contains("usernamekey") && sharedPreferences.contains("passwordkey")){
                String uername=sharedPreferences.getString("usernamekey","Data not found");
                String password=sharedPreferences.getString("passwordkey","Data not found");
                Detailtextview.setText(uername+"\n"+password);
            }
        }

    }
}