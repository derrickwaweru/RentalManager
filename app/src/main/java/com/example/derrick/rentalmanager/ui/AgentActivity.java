package com.example.derrick.rentalmanager.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddVacancy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AgentActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.agentName) EditText mAgentName;
    @Bind(R.id.agentPhone) EditText mAgentPhone;
    @Bind(R.id.propertyName) EditText mPropertyName;
    @Bind(R.id.location) EditText mLocation;
    @Bind(R.id.vacancies) EditText mVacancies;
    @Bind(R.id.rent) EditText mRent;
    @Bind(R.id.addVacancyBtn) Button mAddVacancyBtn;

    DatabaseReference databaseVacancies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);
        ButterKnife.bind(this);

        databaseVacancies = FirebaseDatabase.getInstance().getReference("vacancies");

        mAddVacancyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        addVacancy();
    }

    private void addVacancy() {
        String name = mAgentName.getText().toString().trim();
        String phone = mAgentPhone.getText().toString().trim();
        String propertyName = mPropertyName.getText().toString().trim();
        String address = mLocation.getText().toString().trim();
        String vacancies = mVacancies.getText().toString().trim();
        String rent = mRent.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {
            String id = databaseVacancies.push().getKey();

            AddVacancy addVacancy = new AddVacancy(id, name, phone, propertyName, address, vacancies, rent);
            databaseVacancies.child(id).setValue(addVacancy);

            mAgentName.setText("");
            mAgentPhone.setText("");
            mPropertyName.setText("");
            mLocation.setText("");
            mVacancies.setText("");
            mRent.setText("");

            Toast.makeText(this, "Vacancy Saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill out the form!", Toast.LENGTH_SHORT).show();
        }
    }
}
