package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddReports;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddReportsActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.fromEditText) EditText mFromEditText;
    @Bind(R.id.toEditText) EditText mToEditText;
    @Bind(R.id.reportTypeEditText) EditText mReportTypeEditText;
    @Bind(R.id.reportDescription) EditText mReportDescription;
    @Bind(R.id.buildingReport) EditText mBuildingReport;
    @Bind(R.id.roomNumberEditText) EditText mRoomNumber;
    @Bind(R.id.sumbitReportBtn) Button mSubmitReportBtn;

    List<AddReports> reports;
    DatabaseReference databaseReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reports);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mSubmitReportBtn.setOnClickListener(this);

        databaseReports = FirebaseDatabase.getInstance().getReference("reports");

        reports = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitReportBtn) {
            addReports();
        }
    }

    private void addReports() {
        String from = mFromEditText.getText().toString().trim();
        String to = mToEditText.getText().toString().trim();
        String reportType = mReportTypeEditText.getText().toString().trim();
        String reportDescription = mReportDescription.getText().toString().trim();
        String propertyName = mBuildingReport.getText().toString().trim();
        String roomNumber = mRoomNumber.getText().toString().trim();

        if(!TextUtils.isEmpty(from)) {
            String id = databaseReports.push().getKey();

            AddReports addReports = new AddReports(from, to, reportType, reportDescription, propertyName, roomNumber, id);

            databaseReports.child(id).setValue(addReports);

            Toast.makeText(this, "Report Submitted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill out the form!", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(AddReportsActivity.this, ReportsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
