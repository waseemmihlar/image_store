package com.example.custom_adapterview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class customadapter extends ArrayAdapter {

    int resources;
    Context context;
    int[] image;
    String[] name;

    public customadapter(@NonNull Context context, int resource,String[] name,int[] image) {
        super(context, resource,name);
        this.resources=resource;
        this.context=context;
        this.image=image;
        this.name=name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resources, null, false);

            ImageView img = convertView.findViewById(R.id.imageView);
            TextView text = convertView.findViewById(R.id.textView);

            img.setImageResource(image[position]);
            text.setText(name[position]);
        }
        return convertView;
    }
}
