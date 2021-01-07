package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] programminglg;
    int[] flags;
    private LayoutInflater inflater;
    CustomAdapter(Context context,String[] programminglg,int[] flags){
        this.context=context;
        this.programminglg=programminglg;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return programminglg.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.sample_view,parent,false);
            ImageView image=convertView.findViewById(R.id.imgview);
            TextView textView=convertView.findViewById(R.id.txtview);

            image.setImageResource(flags[position]);
            textView.setText((programminglg[position]));

        }
        return convertView;
    }
}
