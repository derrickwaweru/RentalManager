package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD:app/src/main/java/com/example/derrick/rentalmanager/ui/MainActivity.java
=======
import android.os.Bundle;
import android.text.TextUtils;
>>>>>>> db0f98a59b63ba5b126333e327db826bf5b180de:app/src/main/java/com/example/derrick/rentalmanager/MainActivity.java
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.derrick.rentalmanager.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

<<<<<<< HEAD:app/src/main/java/com/example/derrick/rentalmanager/ui/MainActivity.java
=======
import butterknife.ButterKnife;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

>>>>>>> db0f98a59b63ba5b126333e327db826bf5b180de:app/src/main/java/com/example/derrick/rentalmanager/MainActivity.java
import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.derrick.rentalmanager.R.id.nameEditText;
import static com.example.derrick.rentalmanager.R.id.tenantEmailEditText;
import static com.example.derrick.rentalmanager.R.id.tenantFirstNameEditText;
import static com.example.derrick.rentalmanager.R.id.tenantLastNameEditText;
import static com.example.derrick.rentalmanager.R.id.tenantPhoneEditText;
import static com.example.derrick.rentalmanager.R.id.tenantRoomNumberEditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.ownerImageView) ImageView mOwnerImageView;
<<<<<<< HEAD:app/src/main/java/com/example/derrick/rentalmanager/ui/MainActivity.java
    @Bind(R.id.managerImageView) ImageView mManagerImageView;
=======
    @Bind(R.id.tenantsImageView) ImageView mTenantsImageView;
//    @Bind(R.id.addTenantBtn) Button mAddTenantBtn;
//    @Bind(R.id.nameEditText) EditText mNameEditText;
//    @Bind(R.id.tenantEmailEditText) EditText mTenantEmailEditText;
//    @Bind(R.id.tenantFirstNameEditText) EditText mFirstNameEditText;
//    @Bind(R.id.tenantPhoneEditText) EditText mTenantPhoneEditText;
//    @Bind(R.id.tenantRoomNumberEditText) EditText mtenantRoomNumberEditText;
>>>>>>> db0f98a59b63ba5b126333e327db826bf5b180de:app/src/main/java/com/example/derrick/rentalmanager/MainActivity.java
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOwnerImageView.setOnClickListener(this);
<<<<<<< HEAD:app/src/main/java/com/example/derrick/rentalmanager/ui/MainActivity.java
        mManagerImageView.setOnClickListener(this);
=======
        mTenantsImageView.setOnClickListener(this);

>>>>>>> db0f98a59b63ba5b126333e327db826bf5b180de:app/src/main/java/com/example/derrick/rentalmanager/MainActivity.java

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome, " + user.getDisplayName() + "!");
                } else {

                }
            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();

        mOwnerImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == mOwnerImageView) {
            Intent intent = new Intent(MainActivity.this, AddOwnerActivity.class);
            startActivity(intent);
        }
<<<<<<< HEAD:app/src/main/java/com/example/derrick/rentalmanager/ui/MainActivity.java
        if(v == mManagerImageView) {
            Intent intent = new Intent(MainActivity.this, AddManagerActivity.class);
=======
        if(v == mTenantsImageView){
            Intent intent = new Intent(MainActivity.this, AddTenantActivity.class);
>>>>>>> db0f98a59b63ba5b126333e327db826bf5b180de:app/src/main/java/com/example/derrick/rentalmanager/MainActivity.java
            startActivity(intent);
        }
    }


}