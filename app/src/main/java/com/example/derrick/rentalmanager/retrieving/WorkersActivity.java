package com.example.derrick.rentalmanager.retrieving;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.classes.WorkersList;
import com.example.derrick.rentalmanager.models.AddWorkers;
import com.example.derrick.rentalmanager.saving.AddWorkersActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorkersActivity extends AppCompatActivity {
    @Bind(R.id.workersListView) ListView mWorkersListView;
    List<AddWorkers> workers;

    DatabaseReference databaseWorkers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);
        ButterKnife.bind(this);

        databaseWorkers = FirebaseDatabase.getInstance().getReference("workers");

        Intent intent = getIntent();

        workers = new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_worker_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_worker) {
            Intent intent = new Intent(WorkersActivity.this, AddWorkersActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //attaching value event listener
        databaseWorkers.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //clearing the previous workers list
                workers.clear();

                //iterating through all the nodes
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting worker
                    AddWorkers worker = postSnapshot.getValue(AddWorkers.class);
                    //adding worker to the list
                    workers.add(worker);
                }

                //creating adapter
                WorkersList workersListAdapter = new WorkersList(WorkersActivity.this, workers);
                //attaching adapter to the listview
                mWorkersListView.setAdapter(workersListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}