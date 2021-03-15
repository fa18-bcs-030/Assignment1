package com.example.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {
    protected TextView tvOnCreate1,tvOnStart1,tvOnResume1,tvOnRestart1;
    protected Button btnStartActivityOne;
    static protected int countOnCreate1,countOnStart1,countOnResume1,countOnRestart1;
    protected String key="Start Log";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        countOnCreate1++;
        tvOnCreate1 = findViewById(R.id.tvOnCreate1);
        tvOnStart1 = findViewById(R.id.tvOnStart1);
        tvOnResume1 = findViewById(R.id.tvOnResume1);
        tvOnRestart1 = findViewById(R.id.tvOnRestart1);
        btnStartActivityOne = findViewById(R.id.btnStartActivityOne);
        Log.i(key,"onCreate() ");
        tvOnCreate1.setText("onCreate() Method Calls: " + countOnCreate1);
        tvOnStart1.setText("onStart() Method Calls: " +countOnStart1);
        tvOnResume1.setText("onReseme() Method Calls: " +countOnResume1);
        tvOnRestart1.setText("onRestart() Method Calls:  " +countOnRestart1);
        btnStartActivityOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityTwo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        countOnStart1++;
        Log.i(key,"onStart()");
        tvOnStart1.setText("onStart() Method Calls: " +countOnStart1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        countOnResume1++;
        Log.i(key,"onResume()");
        tvOnResume1.setText("onReseme() Method Calls: " +countOnResume1);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countOnRestart1++;
        Log.i(key,"onRestart()");
        tvOnRestart1.setText("onRestart() Method Calls:  " +countOnRestart1);
    }
}