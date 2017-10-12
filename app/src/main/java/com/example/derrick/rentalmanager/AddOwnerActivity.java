package com.example.derrick.rentalmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddOwnerActivity extends AppCompatActivity {
    @Bind(R.id.ownerFirstNameEditText) EditText mOwnerFirstName;
    @Bind(R.id.ownerLastNameEditText) EditText mOwnerLastName;
    @Bind(R.id.ownerEmailEditText) EditText mOwnerEmail;
    @Bind(R.id.ownerPhoneEditText) EditText mOwnerPhone;
    @Bind(R.id.addOwnerBtn) Button mAddOwnerBtn;

    //DatabaseReference databaseOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);
        ButterKnife.bind(this);
    }
}
