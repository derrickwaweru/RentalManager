package com.example.derrick.rentalmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddOwnerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.ownerFirstNameEditText) EditText mOwnerFirstName;
    @Bind(R.id.ownerLastNameEditText) EditText mOwnerLastName;
    @Bind(R.id.ownerEmailEditText) EditText mOwnerEmail;
    @Bind(R.id.ownerPhoneEditText) EditText mOwnerPhone;
    @Bind(R.id.addOwnerBtn) Button mAddOwnerBtn;

    DatabaseReference rootRef, ownerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);
        ButterKnife.bind(this);

        mAddOwnerBtn.setOnClickListener(this);

        rootRef = FirebaseDatabase.getInstance().getReference();
        ownerRef = rootRef.child("owners");

    }

    @Override
    public void onClick(View v) {
        if(v == mAddOwnerBtn) {
            String firstName = mOwnerFirstName.getText().toString();
            ownerRef.push().setValue(firstName);
            String lastName = mOwnerLastName.getText().toString();
            ownerRef.push().setValue(lastName);
            String email = mOwnerEmail.getText().toString();
            ownerRef.push().setValue(email);
            String phone = mOwnerPhone.getText().toString();
            ownerRef.push().setValue(phone);
            Toast.makeText(this, "Owner Added!", Toast.LENGTH_SHORT).show();
        }
    }

}
