package com.example.sqlite_module;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText name,age;
    Switch isactive;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.but_add);
        b2=findViewById(R.id.but_view);
        name=findViewById(R.id.txt_name);
        age=findViewById(R.id.txt_age);
        isactive=findViewById(R.id.sw_isactive);
        listView=findViewById(R.id.listview);

        Dtabasehelper dh=new Dtabasehelper(MainActivity.this);
        Setlistview(dh);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer_Model customer;
                try {
                    customer=new Customer_Model(-1,name.getText().toString(),Integer.parseInt(age.getText().toString()),isactive.isChecked());
                    //Toast.makeText(MainActivity.this, customer.toString(), Toast.LENGTH_SHORT).show();
                }

                catch (Exception e)
                {
                    customer=new Customer_Model(-1,"error",0,false);
                }
                dh.addone(customer);
                Setlistview(dh);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Setlistview(dh);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Customer_Model customerModel =(Customer_Model)adapterView.getItemAtPosition(i);
                dh.deleteone(customerModel);
                Setlistview(dh);
            }
        });
    }

    private void Setlistview(Dtabasehelper dh) {
        Customadapter adapter=new Customadapter(MainActivity.this,dh.viewdata());
        listView.setAdapter(adapter);
    }
}