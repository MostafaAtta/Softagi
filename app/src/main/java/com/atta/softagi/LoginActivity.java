package com.atta.softagi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText emailEditText, passwordEditText;

    Button loginBtn;

    String email, password;

    TextView goToRegester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);



        loginBtn = findViewById(R.id.login);
        goToRegester = findViewById(R.id.sign_up_tv);

        loginBtn.setOnClickListener(this);
        goToRegester.setOnClickListener(view -> {

        });


    }


    @Override
    public void onClick(View view) {

        if (view == loginBtn) {
            email = emailEditText.getText().toString().trim();
            password = passwordEditText.getText().toString().trim();

            if (email.equals("admin") && password.equals("admin")){

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(LoginActivity.this, "Check you email or password", Toast.LENGTH_SHORT);
            }


        }else if (view == goToRegester){

            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}