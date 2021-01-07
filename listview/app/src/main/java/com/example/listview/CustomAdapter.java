package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    int[] flags;
    String[] arraynames;
    Context contex;
    private Object inflater;

    CustomAdapter(MainActivity mainActivity, String[] arraynames, int[] flags){
        this.contex=contex;
        this.arraynames= this.arraynames;
        this.flags= this.flags;
    }


    @Override
    public int getCount() {
        return 0;
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
   /* public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            inflater = contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = (View) inflater.inflate(R.layout.sample_view,parent,null,true);

            ImageView imageView=convertView.findViewById(R.id.img1);
            TextView textView=convertView.findViewsWithText(R.id.arraynames);
            imageView.setImageResource(flags[position]);
            textView.setText((arraynames[position]));*/


    public View getView() {
        return getView(, , );
    }

    @Override
   /* public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            inflater = contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = (View) inflater.inflate(R.layout.sample_view,parent,null,true);

            ImageView imageView=convertView.findViewById(R.id.img1);
            TextView textView=convertView.findViewsWithText(R.id.arraynames);
            imageView.setImageResource(flags[position]);
            textView.setText((arraynames[position]));*/


    public View getView(int position, View view, ViewGroup parent) {
        Activity context;
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.sample_view, null, true);

        TextView fruitTV =  rowView.findViewById(R.id.arays);
        ImageView imageTV =  rowView.findViewById(R.id.flags);

        fruitTV.setText(arraynames[position]);
        imageTV.setImageResource(flags[position]);

        return rowView;

    }



}
