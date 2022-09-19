package com.example.custom_adapterview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listview);
        String[] name=getResources().getStringArray(R.array.track_name);
        int[] img={R.drawable.toyota_tundra,R.drawable.ford_f_150,R.drawable.jeep_gladiator,
                R.drawable.nissan_titan,R.drawable.honda_ridgeline,R.drawable.ford_ranger,
                R.drawable.toyota_hilux,R.drawable.nissan_frontier};

        customadapter adapter=new customadapter(MainActivity.this,R.layout.created_layout,name,img);
        lv.setAdapter(adapter);
    }
}