package com.example.derrick.rentalmanager.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.derrick.rentalmanager.models.AddTenant;
import com.example.derrick.rentalmanager.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;


public class AddTenantActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.tenantFirstNameEditText) EditText mTenantFirstName;
    @Bind(R.id.tenantLastNameEditText) EditText mTenantLastName;
    @Bind(R.id.tenantRoomNumberEditText) EditText mTenantRoomNumber;
    @Bind(R.id.tenantEmailEditText) EditText mTenantEmail;
    @Bind(R.id.tenantPhoneEditText) EditText mTenantPhone;
    @Bind(R.id.addTenantBtn) Button mAddTenantBtn;
    @Bind(R.id.tenantTextView) TextView mTenantTextView;

    DatabaseReference databaseTenants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tenant);
        ButterKnife.bind(this);
        mAddTenantBtn.setOnClickListener(this);
        mTenantTextView.setOnClickListener(this);

        databaseTenants = FirebaseDatabase.getInstance().getReference("tenants");
    }

    @Override
    public void onClick(View v) {
        if (v == mAddTenantBtn) {
            addTenant();
        }
//        if (v == mTenantTextView) {
//            Intent intent = new Intent(AddTenantActivity.this, TenantActivity.class);
//
//        }
    }


    private void addTenant(){
        String firstName = mTenantFirstName.getText().toString().trim();
        String lastName = mTenantLastName.getText().toString().trim();
        String roomNumber = mTenantRoomNumber.getText().toString().trim();
        String email = mTenantEmail.getText().toString().trim();
        String phone = mTenantPhone.getText().toString().trim();

        if(!TextUtils.isEmpty(firstName)){
            String id = databaseTenants.push().getKey();
            AddTenant addTenant = new AddTenant(firstName,lastName, roomNumber, email, phone, id);

            databaseTenants.child(id).setValue(addTenant);

            mTenantFirstName.setText("");
            mTenantLastName.setText("");
            mTenantRoomNumber.setText("");
            mTenantEmail.setText("");
            mTenantPhone.setText("");

            //displaying a success toast
            Toast.makeText(this, "Tenant added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
}
