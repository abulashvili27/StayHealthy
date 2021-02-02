package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void onWelcomeClick(View view){
        Intent changeActivity = new Intent(this, registrationActivity.class);
        startActivity(changeActivity);
        overridePendingTransition(R.anim.slide_down, R.anim.slide_up);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}