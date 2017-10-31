package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.retrieving.ExpensesActivity;
import com.example.derrick.rentalmanager.registration.Users;
import com.example.derrick.rentalmanager.retrieving.OwnersActivity;
import com.example.derrick.rentalmanager.retrieving.ReportsActivity;
import com.example.derrick.rentalmanager.retrieving.TenantActivity;
import com.example.derrick.rentalmanager.retrieving.WorkersActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.managerReportsImageView) ImageView mManagerReports;
    @Bind(R.id.managerTenants) ImageView mManagerTenants;
    @Bind(R.id.workersImageView) ImageView mWorkersImageView;
    @Bind(R.id.managerOwnersImageView) ImageView mManagerOwners;
    @Bind(R.id.managerExpensesImageView) ImageView mManagerExpensesImageView;
    @Bind(R.id.chatImageView) ImageView mChatImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mManagerReports.setOnClickListener(this);
        mWorkersImageView.setOnClickListener(this);
        mManagerOwners.setOnClickListener(this);
        mManagerTenants.setOnClickListener(this);
        mManagerExpensesImageView.setOnClickListener(this);
        mChatImageView.setOnClickListener(this);
    }

    @Override
    public void  onClick(View v) {
        if(v == mManagerReports) {
            Intent intent = new Intent(ManagerActivity.this, ReportsActivity.class);
            startActivity(intent);
        }
        if(v == mWorkersImageView) {
           Intent intent = new Intent(ManagerActivity.this, WorkersActivity.class);
            startActivity(intent);
        }
        if(v == mManagerOwners) {
            Intent intent = new Intent(ManagerActivity.this, OwnersActivity.class);
            startActivity(intent);
        }
        if(v == mManagerTenants) {
            Intent intent = new Intent(ManagerActivity.this, TenantActivity.class);
            startActivity(intent);
        }

        if(v == mManagerExpensesImageView) {
            Intent intent = new Intent(ManagerActivity.this, ExpensesActivity.class);
            startActivity(intent);
        }

        if(v == mChatImageView) {
            Intent intent = new Intent(ManagerActivity.this, Users.class);
            startActivity(intent);
        }
    }
}
