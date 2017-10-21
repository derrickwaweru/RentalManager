package com.example.derrick.rentalmanager.retrieving;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddOwner;
import com.example.derrick.rentalmanager.saving.AddOwnerActivity;
import com.example.derrick.rentalmanager.classes.OwnersList;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_owner_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_owner) {
            Intent intent = new Intent(OwnersActivity.this, AddOwnerActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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
