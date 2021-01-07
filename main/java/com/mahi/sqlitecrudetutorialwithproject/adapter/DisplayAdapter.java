package com.mahi.sqlitecrudetutorialwithproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mahi.sqlitecrudetutorialwithproject.R;
import com.mahi.sqlitecrudetutorialwithproject.model.Student;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DisplayAdapter extends BaseAdapter {
    Context context;
    List<Student> studentList;

    public DisplayAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_layout,null);

        RelativeLayout relativeL = customView.findViewById(R.id.relativeL);
       /* String image = studentList.get(position).getImage();

        if (image != null && !image.isEmpty() && !image.equals(" "))
            Picasso.get().load(image)
                    .placeholder(R.drawable.user)
                    .error(R.drawable.user)
                    .into();*/

        TextView tVUserName = customView.findViewById(R.id.textViewUsername);
        TextView tVCGPA = customView.findViewById(R.id.textViewCGPA);
        ImageView callIcon = customView.findViewById(R.id.imageViewPhone);

        Button edit = customView.findViewById(R.id.editbtn);
        Button delete = customView.findViewById(R.id.deletbtn);

        tVUserName.setText(studentList.get(position).getName());
        tVCGPA.setText(studentList.get(position).getCgpa()+"");

        if(position%2==1)
        {
            relativeL.setBackgroundColor(context.getResources().getColor(R.color.green));
        }else{
            relativeL.setBackgroundColor(context.getResources().getColor(R.color.blue));
        }
        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Call icon is clicked!", Toast.LENGTH_SHORT).show();
                String phoneNo = studentList.get(position).getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNo));
                context.startActivity(intent);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* int id = studentList.get(position).getId();
                String name = studentList.get(position).getName();
                String image = studentList.get(position).getImage();
                String phone = studentList.get(position).getPhone();
                String email = studentList.get(position).getEmail();
                Float cgpa = studentList.get(position).getCgpa();

                studentList.get(position).set

                DBAdapter dbAdapter = new DBAdapter(context);
                dbAdapter.updateFromDB(studentList);*/

                Toast.makeText(context, "Updated!", Toast.LENGTH_SHORT).show();


            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = studentList.get(position).getId();
                DBAdapter dbAdapter = new DBAdapter(context);
                dbAdapter.deleteFromDB(new Student(id)); //constructor needed
                studentList.remove(position);
                studentList.clear();
                Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        return customView;
    }
}
