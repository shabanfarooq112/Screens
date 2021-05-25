package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

public class SetGoTapActivity extends AppCompatActivity implements View.OnClickListener {

    CountryCodePicker ccp;
    EditText edtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_go_tap);

        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        edtPhoneNumber = findViewById(R.id.phone_number_edt);


        ccp.registerPhoneNumberTextView(edtPhoneNumber);

        initComponent();
        initListener();
    }

    private void initComponent() {
    }

    private void initListener() {

    }

    @Override
    public void onClick(View view) {

    }
}