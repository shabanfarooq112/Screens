package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView forgot_password_TV;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponent();
        initListener();
    }

    private void initComponent() {
        forgot_password_TV = findViewById(R.id.forgot_password_TV);
        loginBtn = findViewById(R.id.login_btn);
    }

    private void initListener() {
        forgot_password_TV.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forgot_password_TV:{
                Intent intent = new Intent(LoginActivity.this , ForgotPasswordActivity.class);
                startActivity(intent);
                break;
            } case R.id.login_btn:{
                Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                startActivity(intent);
            }
        }
    }
}