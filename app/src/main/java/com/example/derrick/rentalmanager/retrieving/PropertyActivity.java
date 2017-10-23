package com.example.derrick.rentalmanager.retrieving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;

import com.example.derrick.rentalmanager.classes.PropertyList;
import com.example.derrick.rentalmanager.models.AddProperty;
import com.example.derrick.rentalmanager.saving.AddPropertyActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PropertyActivity extends AppCompatActivity {
    DatabaseReference databaseProperties;
    @Bind(R.id.ListViewProperties)
    ListView mListViewProperties;
    List<AddProperty> properties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        properties = new ArrayList<>();
        databaseProperties = FirebaseDatabase.getInstance().getReference("properties");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseProperties.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                properties.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    AddProperty property = postSnapshot.getValue(AddProperty.class);
                    //adding artist to the list
                    properties.add(property);
                }

                //creating adapter
                PropertyList propertiesAdapter = new PropertyList(PropertyActivity.this, properties);
                //attaching adapter to the listview
                mListViewProperties.setAdapter(propertiesAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_properties_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_addProperty) {
            addProperties();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addProperties(){
        Intent intent = new Intent(PropertyActivity.this, AddPropertyActivity.class);
        getIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}
