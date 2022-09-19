package com.example.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button show;
    ProgressDialog mprogressbar;
    Handler mhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show=findViewById(R.id.progress);
        show.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.progress:
                notificationDialog();
                break;
        }

    }

    private void notificationDialog()
    {
        mhandler=new Handler();
        mprogressbar=new ProgressDialog(MainActivity.this);
        mprogressbar.setMax(100);
        mprogressbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mprogressbar.show();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                    for(int i=0;i<=100;i++)
                    {
                       final int progresscount=i;
                       try {
                           Thread.sleep(50);
                       }
                       catch (InterruptedException e)
                       {
                           e.printStackTrace();
                       }

                       mhandler.post(new Runnable() {
                           @Override
                           public void run() {
                               mprogressbar.setProgress(progresscount);
                           }
                       });
                    }
            }
        });

        t1.start();
    }
}