package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ScanCodeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        initComponent();
        initListener();
    }

    private void initListener() {
        backBtn.setOnClickListener(this);
    }

    private void initComponent() {
        backBtn  = findViewById(R.id.backBtn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn:{
                finish();
                break;
            }
        }
    }
}