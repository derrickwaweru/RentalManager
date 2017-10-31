package com.example.derrick.rentalmanager.retrieving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.classes.ExpensesList;
import com.example.derrick.rentalmanager.models.AddExpenses;
import com.example.derrick.rentalmanager.saving.AddExpensesActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExpensesActivity extends AppCompatActivity {
    @Bind(R.id.listViewExpenses)
    ListView mListViewExpenses;

    DatabaseReference databaseExpenses;
    List<AddExpenses> expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        expenses = new ArrayList<>();
        databaseExpenses = FirebaseDatabase.getInstance().getReference("expenses");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_expenses, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_expense) {
            Intent intent = new Intent(ExpensesActivity.this, AddExpensesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseExpenses.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                expenses.clear();

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    AddExpenses expense = postSnapshot.getValue(AddExpenses.class);
                    expenses.add(expense);
                }

                ExpensesList expensesAdapter = new ExpensesList(ExpensesActivity.this, expenses);
                mListViewExpenses.setAdapter(expensesAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
