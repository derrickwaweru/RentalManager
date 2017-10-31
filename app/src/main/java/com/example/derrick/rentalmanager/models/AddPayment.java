package com.example.derrick.rentalmanager.models;

/**
 * Created by root on 10/21/17.
 */

public class AddPayment {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String receiptNo;

    public AddPayment() {
    }

    public AddPayment(String firstName, String lastName, String email, String phone, String receiptNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.receiptNo = receiptNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getReceiptNo() {
        return receiptNo;
    }
}
