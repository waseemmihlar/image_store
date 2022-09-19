package com.example.sqlite_module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Customadapter extends ArrayAdapter<Customer_Model>{

    Context context;
    int res=R.layout.custom_layout;
    public Customadapter(@NonNull Context context, @NonNull List<Customer_Model> objects) {
        super(context,R.layout.custom_layout, objects);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(res,null,false);

        String name=getItem(position).getName();
        int id=getItem(position).getId();
        int age=getItem(position).getAge();
        boolean active=getItem(position).isActive();

        TextView txt_name=view.findViewById(R.id.name_txt);
        TextView txt_id=view.findViewById(R.id.id_txt);
        TextView txt_age=view.findViewById(R.id.age_txt);
        TextView txt_active=view.findViewById(R.id.active_txt);

        txt_name.setText("Name : "+name);
        txt_id.setText("Id : "+String.valueOf(id));
        txt_age.setText("Age : "+Integer.toString(age));
        txt_active.setText("IsActive : "+String.valueOf(active));
        return view;
    }
}
