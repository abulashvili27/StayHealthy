package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class registrationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextGender;
    private EditText editTextAge;
    private EditText editTextHeight;
    private EditText editTextWeight;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.nameText);
        editTextEmail = findViewById(R.id.emailText);
        editTextGender = findViewById(R.id.gender);
        editTextAge = findViewById(R.id.ageEditText);
        editTextHeight = findViewById(R.id.height);
        editTextWeight = findViewById(R.id.weight);
        findViewById(R.id.saveBtn).setOnClickListener(this);

    }

    private boolean validateInputs(String name, String email, String gender, String age,
                                   String  height, String weight){
        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return true;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email required");
            editTextEmail.requestFocus();
            return true;
        }

        if (gender.isEmpty()) {
            editTextGender.setError("Gender required");
            editTextGender.requestFocus();
            return true;
        }

        if (age.isEmpty()) {
            editTextAge.setError("Age required");
            editTextAge.requestFocus();
            return true;
        }

        if (weight.isEmpty()) {
            editTextWeight.setError("Weight required");
            editTextWeight.requestFocus();
            return true;
        }
        if (height.isEmpty()){
            editTextHeight.setError("Height required");
            editTextHeight.requestFocus();
            return true;
        }
        return false;
    }


    @Override
    public void onClick(View v){
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String gender = editTextGender.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String height = editTextHeight.getText().toString().trim();
        String weight = editTextWeight.getText().toString().trim();
        Intent intent = new Intent(this, CalculatorCaloriesActivity.class);



        intent.putExtra("NAME_EXTRA", name);
        intent.putExtra("EMAIL_EXTRA", email);
        intent.putExtra("GENDER_EXTRA", gender);
        intent.putExtra("AGE_EXTRA", age);
        intent.putExtra("HEIGHT_EXTRA", height);
        intent.putExtra("WEIGHT_EXTRA", weight);

        if(!validateInputs(name, email, gender, age, height, weight)){

            CollectionReference dbProducts = db.collection("products");
            Product product = new Product(
                    name,
                    email,
                    gender,
                    Integer.parseInt(age),
                    Integer.parseInt(height),
                    Integer.parseInt(weight)

            );


            dbProducts.add(product)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {


                            startActivity(intent);
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }

    }


}