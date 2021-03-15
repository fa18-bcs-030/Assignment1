package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected EditText etFirstValue,etSecondValue,etResult;
    protected Button btnCalculate;
    protected int firstValue,secondValue,operater=0;
    protected String result;
    protected Spinner spinnerOperaters;
    protected Logic logic=new Logic();
    protected ArrayList<String> operators;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstValue = findViewById(R.id.etFirstValue);
        etSecondValue = findViewById(R.id.etSecondValue);
        etResult = findViewById(R.id.etResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        spinnerOperaters = (Spinner) findViewById(R.id.spinnerOperaters);

        operators=new ArrayList<>();
        operators.add("Select ");
        operators.add("Addition");
        operators.add("Subtraction");
        operators.add("Multilication");
        operators.add("Division");


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,operators);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOperaters.setAdapter(arrayAdapter);
        spinnerOperaters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerOperaters.setSelection(position);
                operater=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstValue = Integer.parseInt(etFirstValue.getText().toString());
                secondValue = Integer.parseInt(etSecondValue.getText().toString());
                result = logic.process(firstValue,secondValue,operater);
                etResult.setText(result);
            }
        });
    }

    public void toast(String exception){
        Toast.makeText(MainActivity.this,exception,Toast.LENGTH_LONG).show();
    }
}