package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivateActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);

        initComponent();
        initListener();
    }

    private void initComponent() {
        backBtn = findViewById(R.id.activate_backBtn);
    }

    private void initListener() {
        backBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activate_backBtn:{
                finish();
                break;
            }
        }
    }
}