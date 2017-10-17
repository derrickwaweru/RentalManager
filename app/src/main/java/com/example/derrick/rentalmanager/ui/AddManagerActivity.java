package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddManagerActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.managerFirstName) EditText mManagerFirstName;
    @Bind(R.id.managerLastName) EditText mManagerLastName;
    @Bind(R.id.managerEmail) EditText mManagerEmail;
    @Bind(R.id.managerPhone) EditText mManagerPhone;
    @Bind(R.id.propertyManaged) EditText mPropertyManaged;
    @Bind(R.id.propertyManagedOwner) EditText mPropertyManagedOwner;
    @Bind(R.id.propertyManagedAddress) EditText mPropertyManagedAddress;
    @Bind(R.id.managerTextView) TextView mManagerTextView;
    @Bind(R.id.addManagerBtn) Button mAddManagerBtn;

    DatabaseReference databaseManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_manager);
        ButterKnife.bind(this);

        databaseManagers = FirebaseDatabase.getInstance().getReference("managers");

        mAddManagerBtn.setOnClickListener(this);
        mManagerTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAddManagerBtn) {
            addManager();
        }
        if(v == mManagerTextView) {
            Intent intent = new Intent(AddManagerActivity.this, ManagerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    private void addManager() {
        String firstName = mManagerFirstName.getText().toString().trim();
        String lastName = mManagerLastName.getText().toString().trim();
        String email = mManagerEmail.getText().toString().trim();
        String phone = mManagerPhone.getText().toString().trim();
        String propertyManaged = mPropertyManaged.getText().toString().trim();
        String propertyOwner = mPropertyManagedOwner.getText().toString().trim();
        String propertyAddress = mPropertyManagedAddress.getText().toString().trim();

        if(!TextUtils.isEmpty(firstName)) {
            String id = databaseManagers.push().getKey();

            AddManager addManager = new AddManager(id, firstName, lastName, email, phone, propertyManaged, propertyOwner, propertyAddress);

            databaseManagers.child(id).setValue(addManager);

            mManagerFirstName.setText("");
            mManagerLastName.setText("");
            mManagerEmail.setText("");
            mManagerPhone.setText("");
            mPropertyManaged.setText("");
            mPropertyManagedOwner.setText("");
            mPropertyManagedAddress.setText("");

            Toast.makeText(this, "Manager Added!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill the form!", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(AddManagerActivity.this, ManagerActivity.class);
        startActivity(intent);
    }
}
