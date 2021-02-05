package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorCaloriesActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_calories);



        Intent intent = getIntent();
        double calories = 0;
        String name = intent.getStringExtra("NAME_EXTRA");
        String email = intent.getStringExtra("EMAIL_EXTRA");
        String gender = intent.getStringExtra("GENDER_EXTRA");
        String age = intent.getStringExtra("AGE_EXTRA");
        String height = intent.getStringExtra("HEIGHT_EXTRA");
        String weight = intent.getStringExtra("WEIGHT_EXTRA");
        if (gender.equals("Male") || gender.equals("male")){
            int weightForMan = Integer.parseInt(weight);
            int heightForMan = Integer.parseInt(height);
            int ageForMan = Integer.parseInt(age);
            calories = weightForMan * 10 + 6.25 * heightForMan - 5 * ageForMan + 5;

        }
        else if (gender.equals("Female") || gender.equals("female")) {
            int weightForWoman = Integer.parseInt(weight);
            int heightForWoman = Integer.parseInt(height);
            int ageForWoman = Integer.parseInt(age);
            calories = 10 * weightForWoman + 6.25 * heightForWoman - 5 * ageForWoman - 161;
        }

        CharSequence s = "Daily norm of calories are " + calories;
        Context context = getApplicationContext();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();




    }


}