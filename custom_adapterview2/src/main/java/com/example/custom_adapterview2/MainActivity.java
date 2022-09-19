package com.example.custom_adapterview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listview);
        person_det p1=new person_det("Kumar","Colombo",8493744);
        person_det p2=new person_det("Susi","Narammala",4329843);
        person_det p3=new person_det("wasanth","Kandy",3762363);
        person_det p4=new person_det("Hiruni","Dhambulla",3672332);
        person_det p5=new person_det("Jayathilaka","Jaffna",84362246);
        person_det p6=new person_det("kavi","Badulla",94374224);
        person_det p7=new person_det("Pubudhu","Wariyapola",437585847);
        person_det p8=new person_det("Madhush","Kuliyapitiya",6457564);

        ArrayList<person_det> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);

        CustomArray_adapter adapter=new CustomArray_adapter(MainActivity.this,R.layout.custom_layout,list);
        lv.setAdapter(adapter);

    }
}