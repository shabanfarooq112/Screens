package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

TextView signInTV;
Button goTapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        setListener();
    }

    private void setListener() {
        signInTV.setOnClickListener(this);
        goTapBtn.setOnClickListener(this);
    }

    private void initComponent() {
        signInTV = findViewById(R.id.sign_in_TV);
        goTapBtn = findViewById(R.id.button1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_TV:{
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.button1:{
                Intent intent = new Intent(MainActivity.this , SetGoTapActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}