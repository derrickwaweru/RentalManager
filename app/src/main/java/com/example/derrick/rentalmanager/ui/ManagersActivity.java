package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ManagersActivity extends AppCompatActivity {
    @Bind(R.id.managersListView) ListView mManagersListView;
    private List<AddManager> managers;
    DatabaseReference databaseManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managers);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        databaseManagers = FirebaseDatabase.getInstance().getReference("managers");

        managers = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseManagers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                managers.clear();

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AddManager manager = postSnapshot.getValue(AddManager.class);
                    managers.add(manager);
                }

                ManagersList managersAdapter = new ManagersList(ManagersActivity.this, managers);
                mManagersListView.setAdapter(managersAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
