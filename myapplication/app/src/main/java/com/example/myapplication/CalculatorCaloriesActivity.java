package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorCaloriesActivity extends AppCompatActivity {

    ListView listView;
    String Title[] = {"apple", "banana", "beef", "bread", "burger", "carrot", "cucumber", "orange juice", "pizza", "tomato",};
    String subTitle[] = {"Contains 52 Calories", "Contains 89 Calories", "Contains 150 Calories", "Contains 265 Calories",
            "Contains 295 Calories", "Contains 41 Calories", "Contains 10 Calories", "Contains 45 Calories", "Contains 266 Calories",
            "Contains 22 Calories"};
    int images[] = {R.drawable.apple, R.drawable.banana, R.drawable.beef_meat, R.drawable.bread, R.drawable.burger,
            R.drawable.carrot, R.drawable.cucumber, R.drawable.orange_juice, R.drawable.pizza, R.drawable.tomato};


    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_calories);

        listView = findViewById(R.id.listvieww);

        MyADapter adapter = new MyADapter(this, Title, subTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    sum = sum + 52;
                    String lol = "+ 52cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    sum = sum + 89;
                    String lol = "+ 89cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 2){
                    sum = sum + 150;
                    String lol = "+ 150cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    sum = sum + 265;
                    String lol = "+ 265cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    sum = sum + 295;
                    String lol = "+ 295cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 5){
                    sum = sum + 41;
                    String lol = "+ 41cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 6){
                    sum = sum + 10;
                    String lol = "+ 10cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 7){
                    sum = sum + 45;
                    String lol = "+ 45cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 8){
                    sum = sum + 266;
                    String lol = "+ 266cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
                if (position == 9){
                    sum = sum + 22;
                    String lol = "+ 22cal " + "sum = " + String.valueOf(sum) + "cal";
                    Toast.makeText(CalculatorCaloriesActivity.this, lol, Toast.LENGTH_SHORT).show();
                }
            }
        });



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

        CharSequence s = "Daily norm of calories is " + calories;
        Context context = getApplicationContext();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();



    }


    class MyADapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rSubtitle[];
        int rimage[];

        MyADapter(Context c, String title[], String subtitle[], int img[]){
            super(c, R.layout.row, R.id.titles, title);
            this.context = c;
            this.rTitle = title;
            this.rSubtitle = subtitle;
            this.rimage = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.imaget);
            TextView titletext = row.findViewById(R.id.titles);
            TextView subtitletext = row.findViewById(R.id.subtitle);

            images.setImageResource(rimage[position]);
            titletext.setText(rTitle[position]);
            subtitletext.setText(rSubtitle[position]);

            return row;
        }
    }


}