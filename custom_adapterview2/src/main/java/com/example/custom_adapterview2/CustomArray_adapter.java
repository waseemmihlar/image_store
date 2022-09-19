package com.example.custom_adapterview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomArray_adapter extends ArrayAdapter<person_det> {

    Context mcontext;
    int mresources;
    public CustomArray_adapter(@NonNull Context context, int resource, @NonNull ArrayList<person_det> objects) {
        super(context, resource, objects);
        this.mcontext=context;
        this.mresources=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

if(convertView==null) {
    LayoutInflater inflator = LayoutInflater.from(mcontext);
    convertView = inflator.inflate(mresources, parent, false);

    TextView t1 = convertView.findViewById(R.id.textname);
    TextView t2 = convertView.findViewById(R.id.textaddress);
    TextView t3 = convertView.findViewById(R.id.texttelno);

    String name = getItem(position).getName();
    String address = getItem(position).getAddress();
    int no = getItem(position).getTelno();

    t1.setText(name);
    t2.setText(address);
    t3.setText(String.valueOf(no));
}
        //convert to string Integer.tostring(variable name)
        //or String.valueof(variable name)
        //or String.format("%d",variable name)
        return convertView;
    }

}
