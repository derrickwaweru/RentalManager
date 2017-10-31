package com.example.derrick.rentalmanager.saving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddExpenses;
import com.example.derrick.rentalmanager.retrieving.ExpensesActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddExpensesActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.dateEditText) EditText mDateEditText;
    @Bind(R.id.expenseTypeEditText) EditText mExpenseTypeEditText;
    @Bind(R.id.expenseDescriptionEditText) EditText mExpenseDescriptionEditText;
    @Bind(R.id.expenseCostEditText) EditText mExpenseCostEditText;
    @Bind(R.id.submitExpensetBtn) Button mSubmitExpenseBtn;


    List<AddExpenses> expenses;
    DatabaseReference databaseExpenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mSubmitExpenseBtn.setOnClickListener(this);

        databaseExpenses = FirebaseDatabase.getInstance().getReference("expenses");

        expenses = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitExpenseBtn) {
            addExpenses();
        }
    }

    private void addExpenses() {
        String date = mDateEditText.getText().toString().trim();
        String expenseType = mExpenseTypeEditText.getText().toString().trim();
        String expenseDescription = mExpenseDescriptionEditText.getText().toString().trim();
        String expenseCost = mExpenseCostEditText.getText().toString().trim();


        if(!TextUtils.isEmpty(date)) {
            String id = databaseExpenses.push().getKey();

            AddExpenses addExpenses = new AddExpenses(date, expenseType, expenseDescription, expenseCost, id);


            databaseExpenses.child(id).setValue(addExpenses);

            Toast.makeText(this, "Expense Submitted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill out the form!", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(AddExpensesActivity.this, ExpensesActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
