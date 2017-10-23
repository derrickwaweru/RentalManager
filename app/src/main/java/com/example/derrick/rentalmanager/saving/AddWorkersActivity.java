package com.example.derrick.rentalmanager.saving;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddWorkers;
import com.example.derrick.rentalmanager.retrieving.WorkersActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddWorkersActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.workersFirstNameEditText) EditText mWorkersFirstName;
    @Bind(R.id.workersLastNameEditText) EditText mWorkersLastName;
    @Bind(R.id.workersProfession) EditText mProfession;
    @Bind(R.id.workersPhoneEditText) EditText mWorkersPhone;
    @Bind(R.id.workersSalaryEditText) EditText mWorkersSalary;
    @Bind(R.id.workersProperty) EditText mWorkersProperty;
    @Bind(R.id.addWorkers) Button mAddWorkersBtn;

    DatabaseReference databaseWorkers;
    List<AddWorkers> workers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workers);
        ButterKnife.bind(this);

        databaseWorkers = FirebaseDatabase.getInstance().getReference("workers");

        Intent intent = getIntent();

        mAddWorkersBtn.setOnClickListener(this);

        workers = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if(v == mAddWorkersBtn) {
            addWorker();
        }
    }

    private void addWorker() {
        String firstName = mWorkersFirstName.getText().toString().trim();
        String lastName = mWorkersLastName.getText().toString().trim();
        String profession = mProfession.getText().toString().trim();
        String phone = mWorkersPhone.getText().toString().trim();
        String salary = mWorkersSalary.getText().toString().trim();
        String worksAt = mWorkersProperty.getText().toString().trim();

        if(!TextUtils.isEmpty(firstName)) {
            String id = databaseWorkers.push().getKey();


            AddWorkers addWorkers = new AddWorkers(firstName, lastName, profession, phone, salary, worksAt, id);


            databaseWorkers.child(id).setValue(addWorkers);

            Toast.makeText(this, "Worker Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill out the form!", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(AddWorkersActivity.this, WorkersActivity.class);
        startActivity(intent);
    }

    /*
    private boolean fireWorker(String id) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("workers").child(id);
        dR.removeValue();
        Toast.makeText(getApplicationContext(), "Worker Fired!", Toast.LENGTH_SHORT).show();
        return true;
    }
    */
}
