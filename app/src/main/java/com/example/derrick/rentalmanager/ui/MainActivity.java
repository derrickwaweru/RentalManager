package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.registration.LoginActivity;
import com.example.derrick.rentalmanager.retrieving.PropertyActivity;
import com.example.derrick.rentalmanager.retrieving.ReportsActivity;
import com.example.derrick.rentalmanager.retrieving.TenantActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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



        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

        mOwnerImageView.setOnClickListener(this);
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

