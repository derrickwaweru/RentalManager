package com.example.derrick.rentalmanager.retrieving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddTenant;
import com.example.derrick.rentalmanager.saving.AddTenantActivity;
import com.example.derrick.rentalmanager.classes.TenantList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TenantActivity extends AppCompatActivity {
    DatabaseReference databaseTenants;
    @Bind(R.id.ListViewTenants)
    ListView mListViewTenants;
    List<AddTenant> tenants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        tenants = new ArrayList<>();
        databaseTenants = FirebaseDatabase.getInstance().getReference("tenants");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseTenants.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                tenants.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    AddTenant tenant = postSnapshot.getValue(AddTenant.class);
                    //adding artist to the list
                    tenants.add(tenant);
                }

                //creating adapter
                TenantList tenantsAdapter = new TenantList(TenantActivity.this, tenants);
                //attaching adapter to the listview
                mListViewTenants.setAdapter(tenantsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_tenants_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_addTenants) {
            addTenants();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addTenants(){
        Intent intent = new Intent(TenantActivity.this, AddTenantActivity.class);
        getIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
