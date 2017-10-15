package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OwnerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.ownerReportsImageView) ImageView mOwnerReports;
    @Bind(R.id.ownerTenantsImageView) ImageView mOwnerTenants;
    @Bind(R.id.ownerPropertyImageView) ImageView mOwnerProperty;
    @Bind(R.id.ownerPaymentsImageView) ImageView mOwnerPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mOwnerReports.setOnClickListener(this);
        mOwnerTenants.setOnClickListener(this);
        mOwnerProperty.setOnClickListener(this);
        mOwnerPayments.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mOwnerReports) {
            Intent intent = new Intent(OwnerActivity.this, ReportsActivity.class);
            startActivity(intent);
        }
    }
}
