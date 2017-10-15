package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.managerReportsImageView) ImageView mManagerReports;
    @Bind(R.id.managerTenants) ImageView mManagerTenants;
    @Bind(R.id.workersImageView) ImageView mWorkersImageView;
    @Bind(R.id.managerPayments) ImageView mManagerPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mManagerReports.setOnClickListener(this);
    }

    @Override
    public void  onClick(View v) {
        if(v == mManagerReports) {
            Intent intent = new Intent(ManagerActivity.this, ReportsActivity.class);
            startActivity(intent);
        }
    }
}
