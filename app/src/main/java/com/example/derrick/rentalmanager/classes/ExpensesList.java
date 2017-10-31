package com.example.derrick.rentalmanager.classes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.derrick.rentalmanager.R;
import com.example.derrick.rentalmanager.models.AddExpenses;

import java.util.List;

/**
 * Created by root on 10/31/17.
 */

public class ExpensesList extends ArrayAdapter<AddExpenses> {
    private Activity context;
    List<AddExpenses> expenses;

    public ExpensesList(Activity context,List<AddExpenses> expenses){
        super(context, R.layout.expenses_list,expenses);
        this.context = context;
        this.expenses = expenses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.expenses_list,null,true);

        TextView dateTextView = (TextView) listViewItem.findViewById(R.id.dateTextView);
        TextView expenseTypeTextView = (TextView) listViewItem.findViewById(R.id.expenseTypeTextView);
        TextView expenseDescriptionTextView = (TextView) listViewItem.findViewById(R.id.expenseDescriptionTextView);
        TextView expenseCost = (TextView) listViewItem.findViewById(R.id.expenseCostTextview);


        AddExpenses expense = expenses.get(position);
        dateTextView.setText("Date: " + expense.getDate());
        expenseTypeTextView.setText("Expense Type: " + expense.getExpenseType());
        expenseDescriptionTextView.setText("Expense Description: " + expense.getExpenseDescription());
        expenseCost.setText("Cost: " + expense.getExpenseCost());


        return listViewItem;
    }

}



