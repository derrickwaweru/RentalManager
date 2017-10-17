package com.example.derrick.rentalmanager.models;


public class AddOwner {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String ownerId;

    public AddOwner() { }

    public AddOwner(String firstName, String lastName, String email, String phone, String ownerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.ownerId = ownerId;
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

    public String getOwnerId () {
        return ownerId;
    }
}
