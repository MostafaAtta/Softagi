package com.atta.softagi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText nameEditText, phoneEditText, emailEditText, passwordEditText;

    Spinner citySpinner;

    RadioGroup radioGroup;

    Button signUpBtn;

    String name, phone, email, password, city, sex;

    TextView loginText;

    ArrayList<String> citiesEn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.editTextTextPersonName);
        phoneEditText = findViewById(R.id.editTextPhone);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        citySpinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup);
        citySpinner = findViewById(R.id.spinner);

        signUpBtn = findViewById(R.id.sign_up);

        signUpBtn.setOnClickListener(this);

        loginText = findViewById(R.id.login_tv);

        loginText.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.maleRadioButton:
                        sex = "Male";
                        break;
                    case R.id.femaleRadioButton:
                        sex = "Female";
                        break;
                    default:
                        sex = "Male";
                }
            }
        });


        citiesEn = new ArrayList<>();
        citiesEn.add("Cairo");
        citiesEn.add("Alex");
        citiesEn.add("Giza");
        citiesEn.add("Luxor");
        citiesEn.add("Tanta");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                citiesEn);
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view == signUpBtn) {
            name = nameEditText.getText().toString().trim();
            phone = phoneEditText.getText().toString().trim();
            email = emailEditText.getText().toString().trim();
            password = passwordEditText.getText().toString().trim();


            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);

            User user = new User(name, phone, email, password, city, sex);
            intent.putExtra("user", user);
            startActivity(intent);
            finish();

        }else if (view == loginText){

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        city = citiesEn.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}