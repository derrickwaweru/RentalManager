package com.example.derrick.rentalmanager.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.saving.AddReportsActivity;
import com.example.derrick.rentalmanager.saving.AgentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.managerButton)
    Button mManagerButton;
    @Bind(R.id.tenantButton)
    Button mTenantButton;
    @Bind(R.id.ownerButton)
    Button mOwnerButton;
    @Bind(R.id.agentButton)
    Button mAgentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mManagerButton.setOnClickListener(this);
        mTenantButton.setOnClickListener(this);
        mOwnerButton.setOnClickListener(this);
        mAgentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mManagerButton) {
            Intent intent = new Intent(HomeActivity.this, ManagerActivity.class);
            startActivity(intent);

        }
        if (v == mOwnerButton) {
            Intent intent = new Intent(HomeActivity.this, OwnerActivity.class);
            startActivity(intent);

        }
        if (v == mTenantButton) {
            Intent intent = new Intent(HomeActivity.this, AddReportsActivity.class);
            startActivity(intent);

        }
        if (v == mAgentButton) {
            Intent intent = new Intent(HomeActivity.this, AgentActivity.class);
            startActivity(intent);
        }
    }
}

