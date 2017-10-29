package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.retrieving.PropertyActivity;
import com.example.derrick.rentalmanager.retrieving.ReportsActivity;
import com.example.derrick.rentalmanager.retrieving.TenantActivity;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.ownerImageView) ImageView mOwnerImageView;
    @Bind(R.id.managerImageView) ImageView mManagerImageView;
    @Bind(R.id.tenantsImageView) ImageView mTenantsImageView;
    @Bind(R.id.reportsImageView) ImageView mReportsImageView;
    @Bind(R.id.propertyImageView) ImageView mPropertyImageView;
//    private TextView mAppNameTextView;

//    @Bind(R.id.addTenantBtn) Button mAddTenantBtn;
//    @Bind(R.id.nameEditText) EditText mNameEditText;
//    @Bind(R.id.tenantEmailEditText) EditText mTenantEmailEditText;
//    @Bind(R.id.tenantFirstNameEditText) EditText mFirstNameEditText;
//    @Bind(R.id.tenantPhoneEditText) EditText mTenantPhoneEditText;
//    @Bind(R.id.tenantRoomNumberEditText) EditText mtenantRoomNumberEditText;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOwnerImageView.setOnClickListener(this);
        mManagerImageView.setOnClickListener(this);
        mTenantsImageView.setOnClickListener(this);
        mReportsImageView.setOnClickListener(this);
        mPropertyImageView.setOnClickListener(this);

//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
//        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/ostrich-regular.ttf");
//        mAppNameTextView.setTypeface(ostrichFont);
    }

    @Override
    public void onClick(View v) {

        if (v == mOwnerImageView) {
            Intent intent = new Intent(MainActivity.this, OwnerActivity.class);
            startActivity(intent);
        }
        if (v == mManagerImageView) {
            Intent intent = new Intent(MainActivity.this, ManagerActivity.class);
            startActivity(intent);
        }
        if (v == mTenantsImageView) {
            Intent intent = new Intent(MainActivity.this, TenantActivity.class);

            startActivity(intent);
        }
        if(v == mReportsImageView) {
            Intent intent = new Intent(MainActivity.this, ReportsActivity.class);
            startActivity(intent);
        }
        if(v == mPropertyImageView) {
            Intent intent = new Intent(MainActivity.this, PropertyActivity.class);
            startActivity(intent);
        }
    }
}

