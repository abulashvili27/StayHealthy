package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.jar.Attributes;

public class CalculatorCaloriesActivity extends AppCompatActivity {

    public static final String CALORIES = "CALORIES";
    public static final String CALORIESW = "CALORIESW";
    private double caloriesForMan;
    private double caloriesForWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_calories);

        TextView textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        caloriesForMan = getIntent().getDoubleExtra("KeyForMan", 0);
        textView.setText("Daily calories for you are " + caloriesForMan);




    }
}