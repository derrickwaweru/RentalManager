package com.example.derrick.rentalmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

    DatabaseReference databaseOwners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);
        ButterKnife.bind(this);

        mAddOwnerBtn.setOnClickListener(this);

        //getting the reference of owners node
        databaseOwners = FirebaseDatabase.getInstance().getReference("owners");

    }

    @Override
    public void onClick(View v) {
        if(v == mAddOwnerBtn) {
            addOwner();
        }
    }

    private void addOwner() {
        //getting the values to save
        String firstName = mOwnerFirstName.getText().toString().trim();
        String lastName = mOwnerLastName.getText().toString().trim();
        String email = mOwnerEmail.getText().toString().trim();
        String phone = mOwnerPhone.getText().toString().trim();

        //checking if the value is provided
        if(!TextUtils.isEmpty(firstName)) {


            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our owner
            String id = databaseOwners.push().getKey();

            //creating owner Object
            AddOwner addOwner = new AddOwner(firstName, lastName, email, phone);

            //Saving the owner
            databaseOwners.child(id).setValue(addOwner);

            //setting edittexts to blank again
            mOwnerFirstName.setText("");
            mOwnerLastName.setText("");
            mOwnerEmail.setText("");
            mOwnerPhone.setText("");

            //displaying a success toast
            Toast.makeText(this, "Owner Added!", Toast.LENGTH_SHORT).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the form!", Toast.LENGTH_SHORT).show();
        }
    }

}
