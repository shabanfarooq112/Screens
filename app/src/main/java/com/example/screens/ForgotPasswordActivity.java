package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initComponent();
        setListener();
    }

    private void setListener() {
        backToLogin.setOnClickListener(this);
    }

    private void initComponent() {
        backToLogin = findViewById(R.id.back_to_login);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_to_login: {
                Intent intent = new Intent(ForgotPasswordActivity.this , LoginActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}