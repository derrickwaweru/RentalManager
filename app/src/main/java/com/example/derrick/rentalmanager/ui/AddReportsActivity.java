package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.derrick.rentalmanager.R;

public class AddReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reports);

        Intent intent = getIntent();
    }
}
