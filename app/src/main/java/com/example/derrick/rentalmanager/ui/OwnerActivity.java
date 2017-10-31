package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.retrieving.ExpensesActivity;
import com.example.derrick.rentalmanager.retrieving.ManagersActivity;
import com.example.derrick.rentalmanager.retrieving.PropertyActivity;
import com.example.derrick.rentalmanager.retrieving.ReportsActivity;
import com.example.derrick.rentalmanager.retrieving.TenantActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OwnerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.ownerReportsImageView) ImageView mOwnerReports;
    @Bind(R.id.ownerTenantsImageView) ImageView mOwnerTenants;
    @Bind(R.id.ownerPropertyImageView) ImageView mOwnerProperty;
    @Bind(R.id.ownerPaymentsImageView) ImageView mOwnerPayments;
    @Bind(R.id.ownerManagersImageView) ImageView mOwnerManagers;
    @Bind(R.id.ownerExpensesImageView) ImageView mOwnerExpensesImageView;

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
        mOwnerManagers.setOnClickListener(this);
        mOwnerExpensesImageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mOwnerReports) {
            Intent intent = new Intent(OwnerActivity.this, ReportsActivity.class);
            startActivity(intent);
        }
        if(v == mOwnerManagers) {
            Intent intent = new Intent(OwnerActivity.this, ManagersActivity.class);
            startActivity(intent);
        }
        if(v == mOwnerTenants) {
            Intent intent = new Intent(OwnerActivity.this, TenantActivity.class);
            startActivity(intent);
        }
        if(v == mOwnerProperty) {
            Intent intent = new Intent(OwnerActivity.this, PropertyActivity.class);
            startActivity(intent);
        }

        if(v == mOwnerExpensesImageView) {
            Intent intent = new Intent(OwnerActivity.this, ExpensesActivity.class);
            startActivity(intent);
        }
        
    }
}
