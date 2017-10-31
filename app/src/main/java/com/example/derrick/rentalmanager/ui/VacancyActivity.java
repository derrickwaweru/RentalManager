package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddVacancy;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VacancyActivity extends AppCompatActivity {

    DatabaseReference databaseVacancies;
    @Bind(R.id.ListViewVacancy)
    ListView mListViewVacancy;
    List<AddVacancy> vacancies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        vacancies = new ArrayList<>();
        databaseVacancies = FirebaseDatabase.getInstance().getReference("vacancies");
    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseVacancies.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                vacancies.clear();

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    AddVacancy vacancy = postSnapshot.getValue(AddVacancy.class);
                    vacancies.add(vacancy);
                }

                VacancyList vacanciesAdapter = new VacancyList(VacancyActivity.this, vacancies);
                mListViewVacancy.setAdapter(vacanciesAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
