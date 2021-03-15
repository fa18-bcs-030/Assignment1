package com.example.activitylab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected TextView tvOnCreate,tvOnStart,tvOnResume,tvOnRestart;
    protected Button btnStartActivityTwo;
    static protected int countOnCreate,countOnStart,countOnResume,countOnRestart;
    protected String key="Log Start";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countOnCreate++;
        tvOnCreate = findViewById(R.id.tvOnCreate);
        tvOnStart = findViewById(R.id.tvOnStart);
        tvOnResume = findViewById(R.id.tvOnResume);
        tvOnRestart = findViewById(R.id.tvOnRestart);
        btnStartActivityTwo = findViewById(R.id.btnStartActivityTwo);
        Log.i(key,"onCreate()");
        tvOnCreate.setText("onCreate() Method Calls:  "+ countOnCreate);
        tvOnStart.setText("onStart() Method Calls: " +countOnStart);
        tvOnResume.setText("onReseme() Method Calls: " +countOnResume);
        tvOnRestart.setText("onRestart() Method Calls:  " +countOnRestart);
        btnStartActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActivityTwo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        countOnStart++;
        Log.i(key,"onStart()");
        tvOnStart.setText("onStart() Method Calls: " + countOnStart);
    }

    @Override
    protected void onResume() {
        super.onResume();
        countOnResume++;
        Log.i(key,"onResume()");
        tvOnResume.setText("onResume() Method Calls: " + countOnResume);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countOnRestart++;
        Log.i(key,"onRestart()");
        tvOnRestart.setText("onRestart() Method Calls: " + countOnRestart);
    }
}