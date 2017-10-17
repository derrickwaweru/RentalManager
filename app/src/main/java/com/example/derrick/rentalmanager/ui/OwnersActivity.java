package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddOwner;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OwnersActivity extends AppCompatActivity {
    @Bind(R.id.ownersListView) ListView mOwnersListView;
    private List<AddOwner> owners;
    DatabaseReference databaseOwners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owners);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        databaseOwners = FirebaseDatabase.getInstance().getReference("owners");

        owners = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseOwners.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                owners.clear();

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    AddOwner owner = postSnapshot.getValue(AddOwner.class);
                    owners.add(owner);
                }

                OwnersList ownersAdapter = new OwnersList(OwnersActivity.this, owners);
                mOwnersListView.setAdapter(ownersAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
