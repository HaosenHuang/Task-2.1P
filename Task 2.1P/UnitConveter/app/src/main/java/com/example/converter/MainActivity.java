package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String selection;
    String noValue = "Please enter a value to convert.";
    String msg = "Please select the correct conversion icon.";

    Integer iconSelection;

    EditText inputValue;

    TextView label1, label2, label3;
    TextView result1, result2, result3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);

        label1 = findViewById(R.id.label1);
        label2 = findViewById(R.id.label2);
        label3 = findViewById(R.id.label3);

        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);

        Spinner spinner = findViewById(R.id.measureSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.measurements, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        selection = adapterView.getItemAtPosition(i).toString();
        inputValue.setText(R.string.default_value);
        iconSelection = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void measureButton(View view) {

        if (iconSelection != 0) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else if (!TextUtils.isEmpty(inputValue.getText().toString())) {
            Double input = Double.parseDouble(inputValue.getText().toString());

            label1.setText(R.string.centimetre_label);
            label2.setText(R.string.foot_label);
            label3.setText(R.string.inch_label);

            Double cm = input * 100;
            result1.setText(String.format("%.0f", cm));

            Double foot = input * 3.28;
            result2.setText(String.format("%.2f", foot));

            Double inch = input * 39.37;
            result3.setText(String.format("%.2f", inch));
        } else {
            Toast.makeText(getApplicationContext(), noValue, Toast.LENGTH_LONG).show();
        }
    }

    public void tempButton(View view) {

        if (iconSelection != 1) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else if (!TextUtils.isEmpty(inputValue.getText().toString())) {
            Double input = Double.parseDouble(inputValue.getText().toString());

            label1.setText(R.string.gram_label);
            label2.setText(R.string.ounce_label);
            label3.setText(R.string.default_value);

            Double fahrenheit = (input * 1.8000) + 32;
            result1.setText(String.format("%.2f", fahrenheit));

            Double kelvin = input + 273.15;
            result2.setText(String.format("%.2f", kelvin));

            result3.setText(R.string.default_value);
        } else {
            Toast.makeText(getApplicationContext(), noValue, Toast.LENGTH_LONG).show();
        }
    }

    public void weightButton(View view) {

        if (iconSelection != 2) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else if (!TextUtils.isEmpty(inputValue.getText().toString())) {
            Double input = Double.parseDouble(inputValue.getText().toString());

            label1.setText(R.string.gram_label);
            label2.setText(R.string.ounce_label);
            label3.setText(R.string.pound_label);

            Double gram = input * 1000;
            result1.setText(String.format("%.0f", gram));

            Double ounce = input / 0.03;
            result2.setText(String.format("%.2f", ounce));

            Double pound = input / 0.45;
            result3.setText(String.format("%.2f", pound));
        } else {
            Toast.makeText(getApplicationContext(), noValue, Toast.LENGTH_LONG).show();
        }
    }
}