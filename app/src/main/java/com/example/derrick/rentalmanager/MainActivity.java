package com.example.derrick.rentalmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.ownerImageView) ImageView mOwnerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOwnerImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mOwnerImageView) {
            Intent intent = new Intent(MainActivity.this, AddOwnerActivity.class);
            startActivity(intent);
        }
    }
}
