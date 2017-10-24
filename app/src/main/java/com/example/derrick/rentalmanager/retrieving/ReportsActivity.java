package com.example.derrick.rentalmanager.retrieving;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddReports;
import com.example.derrick.rentalmanager.saving.AddReportsActivity;
import com.example.derrick.rentalmanager.classes.ReportsList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReportsActivity extends AppCompatActivity {
    @Bind(R.id.listViewReports)
    ListView mListViewReports;

    DatabaseReference databaseReports;
    List<AddReports> reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        reports = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("reports");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_reports, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_report) {
            Intent intent = new Intent(ReportsActivity.this, AddReportsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReports.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reports.clear();

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AddReports report = postSnapshot.getValue(AddReports.class);
                    reports.add(report);
                }

                ReportsList reportsAdapter = new ReportsList(ReportsActivity.this, reports);
                mListViewReports.setAdapter(reportsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
