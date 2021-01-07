package com.mahi.sqlitecrudetutorialwithproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mahi.sqlitecrudetutorialwithproject.R;
import com.mahi.sqlitecrudetutorialwithproject.adapter.DBAdapter;
import com.mahi.sqlitecrudetutorialwithproject.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText eTName, eTPhoneNo,etEmail, eTCGPA;
    String image = "https://avatars0.githubusercontent.com/u/10908427?s=460&v=4";
    //helper
    DBAdapter dbAdapter;
    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTName = findViewById(R.id.editTextName);
        eTPhoneNo = findViewById(R.id.editTextPhone);
        etEmail = findViewById(R.id.editTextEmail);
        eTCGPA = findViewById(R.id.editTextCGPA);

        dbAdapter = new DBAdapter(this);

    }

    public void saveData(View view) {
        boolean error = false;

        String name =eTName.getText().toString().trim();
        if (name.isEmpty()){
            eTName.setError("Name is missing!");
            error = true;
        }else if (name.length()<6){
            eTName.setError("Name is too short");
            error = true;
        }else {
            error = false;
        }

        String phoneNo = eTPhoneNo.getText().toString().trim();
        if (phoneNo.isEmpty()) {
            eTPhoneNo.setError("Phone No is missing!");
            error = true;
        } else if (phoneNo.length() == 11) {
            if (phoneNo.startsWith("017") || phoneNo.startsWith("018") || phoneNo.startsWith("019") || phoneNo.startsWith("015") || phoneNo.startsWith("016")) {
                error = false;
            } else {
                eTPhoneNo.setError("Phone no is not valid!");
                error = true;
            }
        } else {
            eTPhoneNo.setError("Phone No should be 11 digit!");
            error = true;
        }

        String email =etEmail.getText().toString().trim();
        if (email.isEmpty()){
            etEmail.setError("Email is missing!");
            error = true;
        }else {
            error = false;
        }

        String cgpaStr = eTCGPA.getText().toString();
        Float cgpa = null;
        if (cgpaStr.isEmpty()) {
            eTCGPA.setError("CGPA is missing!");
            error = true;
        } else {
            cgpa = Float.parseFloat(cgpaStr);
            if (cgpa > 4.0) {
                eTCGPA.setError("CGPA should be less than 4!");
                error = true;
            }
        }

        if (error){
            Toast.makeText(this, "Data is not correct!", Toast.LENGTH_SHORT).show();
        }else {
            clearData();
            Student student = new Student(name,image,phoneNo, email, cgpa);
            Log.e("student", name +image+phoneNo+email+cgpa);
            dbAdapter.insertIntoDB(student);
            studentList.clear();
            Toast.makeText(this, "Data is inserted successfully.", Toast.LENGTH_SHORT).show();

        }
    }

    public void clearData(){
        eTName.setText(null);
        etEmail.setText(null);
        eTPhoneNo.setText(null);
        eTCGPA.setText(null);
    }

    public void showData(View view) {
        startActivity(new Intent(MainActivity.this,ShowActivity.class));
    }
}
