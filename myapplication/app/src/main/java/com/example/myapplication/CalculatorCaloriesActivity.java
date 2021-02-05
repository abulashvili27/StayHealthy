package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorCaloriesActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//
//    String foodnamess[], descriptionss[];
//    int images[] = {R.drawable.apple, R.drawable.banana, R.drawable.beef_meat, R.drawable.bread, R.drawable.burger,
//            R.drawable.carrot, R.drawable.cucumber, R.drawable.orange_juice, R.drawable.pizza, R.drawable.tomato};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_calories);

//
//        recyclerView = findViewById(R.id.recyclervieww);
//
//        foodnamess = getResources().getStringArray(R.array.food_names);
//        descriptionss = getResources().getStringArray(R.array.Descritpions);
//
//
//        MYAdapter myAdapter = new MYAdapter(this, foodnamess, descriptionss, images);
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));


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

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Daily norm of calories " + calories);



    }


}