package com.example.derrick.rentalmanager.models;

/**
 * Created by root on 10/31/17.
 */

public class AddExpenses {
    private String date;
    private String expenseType;
    private String expenseDescription;
    private String expenseCost;
    private  String expenseId;


    public AddExpenses() {
    }

    public AddExpenses(String date, String expenseType, String expenseDescription, String expenseCost, String expenseId) {
        this.date = date;
        this.expenseType = expenseType;
        this.expenseDescription = expenseDescription;
        this.expenseCost = expenseCost;
        this.expenseId = expenseId;
    }

    public String getDate() {
        return date;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public String getExpenseCost() {
        return expenseCost;
    }

    public String getExpenseId() {
        return expenseId;
    }
}
