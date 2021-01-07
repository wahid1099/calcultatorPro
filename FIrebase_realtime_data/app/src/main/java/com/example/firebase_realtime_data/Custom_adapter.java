package com.example.firebase_realtime_data;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Custom_adapter extends ArrayAdapter<student> {
    private Activity context;
    private List<student> studentList;

    public Custom_adapter(@NonNull Activity context,  List<student> studentList) {
        super(context, R.layout.sample_layout,studentList);
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);
        student student1=studentList.get(position);
        TextView t1=view.findViewById(R.id.nametextidd);
        TextView t2=view.findViewById(R.id.agetextsamle);
        t1.setText("Name "+student1.getName());
        t2.setText("Age "+student1.getAge());

        return view;
    }
}
