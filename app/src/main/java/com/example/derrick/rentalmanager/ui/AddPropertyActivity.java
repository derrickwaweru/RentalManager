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
import com.example.derrick.rentalmanager.models.AddProperty;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddPropertyActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.propertyNameEditText) EditText mPropertyName;
    @Bind(R.id.propertyLocationEditText) EditText mPropertyLocation;
    @Bind(R.id.propertyCategoryEditText) EditText mPropertyCategory;
    @Bind(R.id.propertyEmailEditText) EditText mPropertyEmail;
    @Bind(R.id.propertyTextView) TextView mPropertyTextView;
    @Bind(R.id.addPropertyBtn) Button mAddPropertyBtn;

    DatabaseReference databaseProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        ButterKnife.bind(this);

        mAddPropertyBtn.setOnClickListener(this);
        mPropertyTextView.setOnClickListener(this);
        databaseProperties = FirebaseDatabase.getInstance().getReference("properties");
    }

    @Override
    public void onClick(View v) {
        if(v == mAddPropertyBtn) {
            addProperty();
        }
        if(v == mPropertyTextView) {
            Intent intent = new Intent(AddPropertyActivity.this, PropertyActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
    private void addProperty() {
        //getting the values to save
        String name = mPropertyName.getText().toString().trim();
        String location = mPropertyLocation.getText().toString().trim();
        String category = mPropertyCategory.getText().toString().trim();
        String email= mPropertyEmail.getText().toString().trim();

        //checking if the value is provided
        if(!TextUtils.isEmpty(name)) {


            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our owner
            String id = databaseProperties.push().getKey();

            //creating owner Object
            AddProperty addProperty= new AddProperty(name, location, category, email, id);


            //Saving the owner
            databaseProperties.child(id).setValue(addProperty);

            //setting edittexts to blank again
            mPropertyName.setText("");
            mPropertyLocation.setText("");
            mPropertyCategory.setText("");
            mPropertyEmail.setText("");

            //displaying a success toast
            Toast.makeText(this, "Property Added!", Toast.LENGTH_SHORT).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill the form!", Toast.LENGTH_SHORT).show();
        }

        //Once the form is filled, a new activity is started
        Intent intent = new Intent(AddPropertyActivity.this, PropertyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
