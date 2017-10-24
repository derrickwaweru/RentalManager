package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.registration.Users;
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_chat) {
            Intent intent = new Intent(OwnerActivity.this, Users.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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
    }
}
